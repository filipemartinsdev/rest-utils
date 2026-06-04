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

- Default _success_

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

- _Success_ with message/data

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

<br>

### PagedResponse

- Default pagination

    ````java
    public PagedResponse<String> get(){
        return PagedResponse.builder()
                .page(0)
                .size(20)
                .isLast(true)
                .totalElements(2)
                .totalPages(1)
                .content(List.of("element1", "element2"))
                .build();
    }
    ````
   
    This produces:

    ````json
    {
        "page": 0,
        "size": 20,
        "isLast": true,
        "totalElements": 2,
        "totalPages": 1,
        "content": ["element1", "element2"]
    }
    ````

<br>

### StandardResponse + PagedResponse

- Full response with pagination

    ````java
    public StandardResponse<PagedResponse<String>> get(){
        return StandardResponse
                .success(getPage())
                .build();
    }
    
    public PagedResponse<String> getPage(){
        return PagedResponse.builder()
                .page(0)
                .size(20)
                .isLast(true)
                .totalElements(2)
                .totalPages(1)
                .content(List.of("element1", "element2"))
                .build();
    }
    ````
    
    This produces:
    
    ````json
    {
        "status": "success",
        "message": "Data retrieved!",
        "data": {
            "page": 0,
            "size": 20,
            "isLast": true,
            "totalElements": 2,
            "totalPages": 1,
            "content": [
                "element1", 
                "element2"
            ]
        }
    }
    ````







