package com.bl.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class RestAssuredTest {
    @Test
    public void getTest() {
        RestAssured.given().when().get("https://reqres.in/api/users?page=2");
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }

    @Test
    public void postTest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "98");
        jsonObject.put("title", "Bridgelabz QA Learning");
        jsonObject.put("author", "Prakash");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void putTest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "99");
        jsonObject.put("title", "QA Learning is a part of autiml;cn");
        jsonObject.put("author", "Sachin");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/99");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }

    @Test
    public void deleteTest() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/99");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 404);
        response.prettyPrint();
    }

    /* For Comments Section */


    @Test
    public void getTest1() {
        RestAssured.given().when().get("https://reqres.in/api/users?page=2");
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }

    @Test
    public void postTest1() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("body", "Royal Challengers Banglore");
        jsonObject.put("postId", 10);
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void putTest1() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 3);
        jsonObject.put("body", "QA Learning Automation put/Update");
        jsonObject.put("postId", 3);
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/comments/3");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void deleteTest1() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/comments/1");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 404);
        response.prettyPrint();
    }


    /*   For Profile Section  */

    @Test
    public void getTest2() {
        RequestSpecification request = RestAssured.given();
        Response response = request.get("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
        response.prettyPrint();
    }

    @Test
    public void postTest2() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Sham");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void putTest2() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Vaibhav");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/profile/Swapnil");
        System.out.println(response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void deleteTest2() {
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/profile/Ajay");
        System.out.println(response.getStatusCode());
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 404);
        response.prettyPrint();
    }

}


