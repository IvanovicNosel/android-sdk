package com.loginradius.androidsdk.api;

import com.loginradius.androidsdk.handler.ApiInterface;
import com.loginradius.androidsdk.handler.AsyncHandler;
import com.loginradius.androidsdk.handler.RestRequest;
import com.loginradius.androidsdk.resource.Endpoint;
import com.loginradius.androidsdk.response.following.LoginRadiusFollowing;
import com.loginradius.androidsdk.response.lrAccessToken;

import java.util.Arrays;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
The Following API is used to get the followers' information from the user's social account. 
The data will be normalized into LoginRadius data format.
 */

public class FollowingAPI 
{
	private static final String[] providers = {"twitter"};
	/**
	 * Gives user's followers on social providers
	 * @param token Authentication token from LoginRadius
	 * @param handler Used to handle the success and failure events
	 */
	public void getResponse(lrAccessToken token,final AsyncHandler<LoginRadiusFollowing[]> handler) {
		if (!Arrays.asList(providers).contains(token.provider.toLowerCase())) {
			handler.onFailure(new Throwable(), "lr_API_NOT_SUPPORTED");
			return;
		}

		ApiInterface apiService = RestRequest.getClient().create(ApiInterface.class);
		apiService.getFollowing(Endpoint.API_V2_FOLLOWING,token.access_token).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new DisposableObserver<LoginRadiusFollowing[]>() {
					@Override
					public void onComplete() {}

					@Override
					public void onError(Throwable e) {
						if (e instanceof HttpException) {
							try {
								Throwable t = new Throwable(((HttpException) e).response().errorBody().string(), e);
								handler.onFailure(t, "lr_SERVER");
							} catch (Exception t) {
								t.printStackTrace();
							}

						}

					}

					@Override
					public void onNext(LoginRadiusFollowing[] response) {
						handler.onSuccess(response);
					}

				});
	}
}
