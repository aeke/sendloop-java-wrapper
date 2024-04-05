[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg?maxAge=2592000)](https://github.com/aeke/sendloop-java-wrapper/blob/master/LICENSE)
## **Unofficial Java Wrapper for Sendloop API v3**

This repository provides an unofficial Java wrapper for interacting with the Sendloop API version 3. It simplifies making API calls and handling responses.

**Prerequisites**

-   Java Development Kit (JDK) installed ([https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))

**Installation**

1.  Download the  `sendloop-java-wrapper-1.1.jar`  file (or the latest version) from the project's releases section (if applicable).
2.  Include the JAR file in your project's classpath. This can be done by adding it to your IDE's project dependencies or by placing it in the appropriate directory for your build system (e.g.,  `lib`  folder).

**Usage**

1.  **Import the library:**
    
    Java
    
    ```
    import com.example.sendloop.Sendloop; // Replace with the actual package name
    
    ```
    
2.  **Create a `Sendloop` object:**
    
    Java
    
    ```
    Sendloop sendloop = new Sendloop()
        .ApiKey("YOUR_API_KEY")
        .Subdomain("http://your-subdomain.sendloop.com")
        .Command("List.GetList") // Replace with desired command
        .ResponseFormat("json"); // Optional: Specify response format (default is JSON)
    
    ```
 
    
    -   Replace  `"YOUR_API_KEY"`  with your actual Sendloop API key.
    -   Replace  `"http://your-subdomain.sendloop.com"`  with your Sendloop subdomain.
    -   Set the  `Command`  parameter based on the API call you want to make. Refer to the Sendloop API documentation for available commands.
3.  **(Optional) Add parameters for specific commands:**
    
    Java
    
    ```
    Map<String, String> parameters = new HashMap<>();
    parameters.put("ListID", "1");
    parameters.put("EmailAddress", "email@test.com");
    
    sendloop.setParameters(parameters);
    
    ```
    

    This is only necessary for commands that require additional parameters. Refer to the API documentation for details on required and optional parameters for each command.
    
4.  **Execute the API call:**
    
    Java
    
    ```
    try {
        String response = sendloop.call();
        System.out.println(response);
    } catch (SendloopException e) {
        e.printStackTrace();
    }
    
    ```
    

    The `call()` method returns the API response as a string in the specified format (JSON by default).
    

**Error Handling**

The `call()` method throws a `SendloopException` if any errors occur during the API call. Catch this exception and handle it appropriately in your code.

**Additional Notes**

-   Consult the official Sendloop API documentation for a comprehensive list of available commands, parameters, and response structures.
-   Consider using a dependency management tool like Maven or Gradle to simplify library inclusion in your project.

**Getting Help**

-   For questions or issues related to this wrapper library, feel free to create an issue on this repository's GitHub page.
-   For general Sendloop API questions, refer to the Sendloop developer resources or support channels.

I hope this refined Readme.md provides a clearer, more organized, and informative guide for users of the unofficial Sendloop Java wrapper.
