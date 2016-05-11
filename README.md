# Unofficial Java wrapper for Sendloop API v3

[![Build Status](https://travis-ci.org/aeke/sendloop-java-wrapper.svg?branch=master)](https://travis-ci.org/aeke/sendloop-java-wrapper)
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)](https://github.com/aeke/sendloop-java-wrapper/blob/master/LICENSE)

For more details about Sendloop API v3, please visit our help section at https://sendloop.com/help/api-001/getting-started

## Usage
Add **sendloop-java-wrapper-1.1.jar** file to project library


####Example (without parameters):
```java
Sendloop sendloop = new Sendloop()
                .ApiKey("YOUR_API_KEY")
                .Subdomain("http://your-subdomain.sendloop.com")
                .Command("List.GetList")
                .ResponseFormat("json");
        try {
            System.out.println(sendloop.call());
        } catch (SendloopException e) {
            e.printStackTrace();
        }
```

####Example (with parameters):
```java
Map<String, String> parameters = new HashMap<>();
        parameters.put("ListID","1");
        parameters.put("EmailAddress","email@test.com");
        
Sendloop sendloop = new Sendloop()
                .ApiKey("YOUR_API_KEY")
                .Subdomain("http://your-subdomain.sendloop.com")
                .Command("Subscriber.Get")
                .ResponseFormat("json");
        try {
            System.out.println(sendloop.call());
        } catch (SendloopException e) {
            e.printStackTrace();
        }
```
