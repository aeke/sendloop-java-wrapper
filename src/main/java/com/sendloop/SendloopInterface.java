package com.sendloop;

/**
 * @author Abdullah EKE <abdheke@gmail.com>
 */
public interface SendloopInterface {
    Sendloop ApiKey(String apikey);

    Sendloop Command(String command);

    Sendloop Subdomain(String subdomain);

    Sendloop ResponseFormat(String responseformat);
}
