package com.bl.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BddStyle {
    @Test
    public void getTest() {
        Response response = RestAssured.get("http://localhost:3000/posts");
        response.prettyPrint();
        given().when().get("http://localhost:3000/posts").then().statusCode(200);
    }

    @Test
    public void postTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("title", "Bridgelabz QA Learning");
        jsonObject.put("author", "Swapnil");
        given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString()).when()
                .post("http://localhost:3000/posts").then()
                .statusCode(201);
    }

    @Test()
    public void putTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "json-server");
        jsonObject.put("author", "John");
        given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).when().
                put("http://localhost:3000/posts/1").then().
                statusCode(200);
    }

    @Test()
    public void deleteTest() {
        given().header("Content-Type", "application/json").
                when().delete("http://localhost:3000/posts/1").
                then().statusCode(200);
    }

    /* For Comments Section */

    @Test
    public void getTest1() {
        Response response = RestAssured.get("http://localhost:3000/comments");
        response.prettyPrint();
        given().when().get("http://localhost:3000/comments").then().statusCode(200);
    }

    @Test
    public void postTest1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 4);
        jsonObject.put("postId", "Bridgelabz QA Learning");
        jsonObject.put("body", "QA Learning Automation");
        given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString()).when()
                .post("http://localhost:3000/comments").then()
                .statusCode(201);
    }

    @Test()
    public void putTest1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 1);
        jsonObject.put("postId", "Bridgelabz QA Learning");
        jsonObject.put("body", "QA Learning Automation Updated one");
        given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).when().
                put("http://localhost:3000/comments/1").then().
                statusCode(200);
    }

    @Test()
    public void deleteTest1() {
        given().header("Content-Type", "application/json").
                when().delete("http://localhost:3000/comments/3").
                then().statusCode(200);
    }

    /* For Profile Section */

    @Test
    public void getTest2() {
        Response response = RestAssured.get("http://localhost:3000/profile");
        response.prettyPrint();
        given().when().get("http://localhost:3000/profile").then().statusCode(200);
    }

    @Test
    public void postTest2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Swapnil");
        given()
                .header("Content-Type", "application/json")
                .body(jsonObject.toJSONString()).when()
                .post("http://localhost:3000/Profile").then()
                .statusCode(201);
    }

    @Test()
    public void putTest2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Vaibhav");
        given().header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).when().
                put("http://localhost:3000/Profile").then().
                statusCode(200);
    }

}
