package com.loginradius.androidsdk.api;

import com.loginradius.androidsdk.handler.ApiInterface;
import com.loginradius.androidsdk.handler.AsyncHandler;
import com.loginradius.androidsdk.handler.RestRequest;
import com.loginradius.androidsdk.resource.Endpoint;
import com.loginradius.androidsdk.response.lrAccessToken;
import com.loginradius.androidsdk.response.status.LoginRadiusStatus;

import java.util.Arrays;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Retrieve the status messages from the user's social account.
 * Data will be normalized into LoginRadius standard data format.
 */
public class StatusAPI 
{
	private static final String[] providers = {"facebook", "twitter", "linkedin", "vk", "renren"};
	/**
	 * Gives user's status on social providers
	 * @param token Authentication token from LoginRadius
	 * @param handler Used to handle the success and failure events
	 */
	public void getResponse(lrAccessToken token,final AsyncHandler<LoginRadiusStatus[]> handler)
	{
		if (!Arrays.asList(providers).contains(token.provider.toLowerCase())) {
			handler.onFailure(new Throwable(), "lr_API_NOT_SUPPORTED");
			return;
		}

		ApiInterface apiService = RestRequest.getClient().create(ApiInterface.class);
		apiService.getStatus(Endpoint.API_V2_STATUS,token.access_token).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(new DisposableObserver<LoginRadiusStatus[]>() {
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
					public void onNext(LoginRadiusStatus[] response) {
						handler.onSuccess(response);
					}

				});
	}

}