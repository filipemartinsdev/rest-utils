<br>

<div align="center">
<img src="images/java.png" alt="Logo" width="160pt">

<h3 align="center">REST Utils</h3>

<p>

Utility tools for Java REST applications.

</p>

</div>


## About

A simple library to create responses for REST APIs, following [JSend](https://github.com/omniti-labs/jsend) standard.

## Requirements 

- Java 17+
- Apache Maven

## Install

Includes on `pom.xml`:

````xml
<dependencies>
    <dependency>
        <groupId>io.github.filipemartinsdev</groupId>
        <artifactId>rest-utils</artifactId>
        <version>1.0.2</version>
    </dependency>
</dependencies>
````

## Examples

### StandardResponse

1. Default success

    ````java
    public StandardResponse<Void> get() {
        return StandardResponse
                .success()
                .build();
    }
    ````
    
    This produces:
    
    ````json
    {
        "status": "success"
    }
    ````
<br>

2. Success with message/data

    ````java
    public StandardResponse<Map<String, Object>> get() {
        var data = Map.of("id", 1);
   
        return StandardResponse
                .success(data)
                .message("Data retrieved!")
                .build();
    }
    ````
    
    This produces:
    
    ````json
    {
        "status": "success",
        "message": "Data retrieved!",
        "data": {
            "id": 1
        }
    }
    ````







