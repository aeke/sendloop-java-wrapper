package com.sendloop.exceptions;

/**
 * Java Wrapper for Sendloop API
 *
 * @author Abdullah EKE <abdheke@gmail.com>
 * @version 1.0
 */
public class SendloopException extends Exception {

    private static String message = "";

    public SendloopException(String m, int type) {
        if (type == 1) {
            message = m + " cannot empty!";
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}
