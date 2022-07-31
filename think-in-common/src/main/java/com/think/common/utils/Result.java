package com.think.common.utils;

/**
 * @author nanshoudabaojian
 * @date 2022-07-11 14:42
 */
public class Result {
        private Object data;
        private String errorMessage;
        private boolean hasErrors;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
}
