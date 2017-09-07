package com.logicturtle.hackathon.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Error {
    private String message;
    private HashMap<String, String[]> errors;

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    private static final int ERROR_CODE_UNIDENTIFIED = -10;
    private static final int ERROR_CODE_NETWORK_ERROR = -11;

    public Error() {
        this("Some error occured", ERROR_CODE_UNIDENTIFIED);
    }

    public Error(String message) {
        this(message, ERROR_CODE_UNIDENTIFIED);
    }

    public Error(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    /*TODO: Modify this acc. to need later*/
    public String getReason() {
        String reason = getMessage();
        if (statusCode == ERROR_CODE_NETWORK_ERROR) {
            reason = "You Seems To Be Offline";
        }
        if (errors != null)
            for (Map.Entry<String, String[]> entry : errors.entrySet()) {
                String[] value = entry.getValue();
                reason = value[0];
            }
        return reason;
    }

    private HashMap<String, String[]> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String[]> errors) {
        this.errors = errors;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
