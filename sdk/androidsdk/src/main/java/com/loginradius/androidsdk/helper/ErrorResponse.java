package com.loginradius.androidsdk.helper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by loginradius on 9/26/2016.
 */
public class ErrorResponse {

    private String description;

    private String message;

    private Boolean isProviderError;

    private Object providerErrorResponse;

    private Integer errorCode;


    private String Description;

    private String Message;

    private Boolean IsProviderError;

    private Object ProviderErrorResponse;

    private Integer ErrorCode;

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return  description == null ? Description : description;
    }

    /**
     *
     * @param description
     * The Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return  message == null ? Message : message;
    }

    /**
     *
     * @param message
     * The Message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The isProviderError
     */
    public Boolean getIsProviderError() {
        return isProviderError ==null ? IsProviderError :isProviderError;
    }

    /**
     *
     * @param isProviderError
     * The IsProviderError
     */
    public void setIsProviderError(Boolean isProviderError) {
        this.isProviderError = isProviderError;
    }

    /**
     *
     * @return
     * The providerErrorResponse
     */
    public Object getProviderErrorResponse() {
        return providerErrorResponse ==null ? ProviderErrorResponse :providerErrorResponse;
    }

    /**
     *
     * @param providerErrorResponse
     * The ProviderErrorResponse
     */
    public void setProviderErrorResponse(Object providerErrorResponse) {
        this.providerErrorResponse = providerErrorResponse;
    }

    /**
     *
     * @return
     * The errorCode
     */
    public Integer getErrorCode() {
        return errorCode ==null ? ErrorCode :errorCode;
    }

    /**
     *
     * @param errorCode
     * The ErrorCode
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    }





