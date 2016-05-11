package com.sendloop;

import com.sendloop.exceptions.SendloopException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Wrapper for Sendloop API
 *
 * @author Abdullah EKE <abdheke@gmail.com>
 * @version 1.0
 */
public class Sendloop implements SendloopInterface {

    public static String API_KEY = "";
    public static String API_COMMAND = "";
    public static String SUBDOMAIN = "";
    public static String RESPONSE_FORMAT = "json";
    public static String API_BASEURL = "/api/v3/";
    public static String RESULT = "";

    private static Document doc;
    private static Map<String, String> parameters = new HashMap<String, String>();

    public Sendloop ApiKey(String apiKey) {
        API_KEY = apiKey;
        return this;
    }

    public Sendloop Command(String command) {
        API_COMMAND = command.toLowerCase();
        return this;
    }

    public Sendloop Subdomain(String Subdomain) {
        SUBDOMAIN = Subdomain;
        return this;
    }

    public Sendloop ResponseFormat(String responseFormat) {
        RESPONSE_FORMAT = responseFormat;
        return this;
    }

    private static String getApiURL() {
        return SUBDOMAIN + '/' + API_BASEURL + API_COMMAND + '/' + RESPONSE_FORMAT;
    }

    public String call(Map<String, String> params) throws SendloopException {

        parameters.put("APIKey", API_KEY);
        params.forEach((k, v) -> parameters.put(k, v));
        checkReqParams();

        try {
            doc = Jsoup.connect(getApiURL())
                    .ignoreContentType(true)
                    .data(parameters)
                    .post();
        } catch (IOException e) {
            e.getMessage();
        }
        RESULT = doc.text();

        return RESULT;
    }

    public String call() throws SendloopException {

        parameters.put("APIKey", API_KEY);
        checkReqParams();
        try {
            doc = Jsoup.connect(getApiURL())
                    .ignoreContentType(true)
                    .data(parameters)
                    .post();
        } catch (IOException e) {
            e.getMessage();
        }
        RESULT = doc.toString();

        return RESULT;
    }


    private void checkReqParams() throws SendloopException {
        if (API_KEY.isEmpty()) {
            throw new SendloopException("ApiKey", 1);
        } else if (API_COMMAND.isEmpty()) {
            throw new SendloopException("Command", 1);
        } else if (RESPONSE_FORMAT.isEmpty()) {
            throw new SendloopException("ResponseFormat", 1);
        } else if (SUBDOMAIN.isEmpty()) {
            throw new SendloopException("Subdomain", 1);
        }
    }

}
