package com.bl.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TwitterAPITest {
                 // APi key, API secret, AccessToken, Access Token Secret
    @Test
    public void postTweet() {
        Response response = RestAssured.given().auth().
                oauth("DKt2mIrSJObaVkKF7cOTFoiHV",
                        "a9g4C0TXq5aZ0WRU89TwaPU4sN4tiXxtbWPludVWxdfAnYem6O",
                        "1300426552379752450-Ovy3rWQDBrZia1JMCrmVzcVHjar7AT",
                        "1T24xP9Tumlfw8LyCl1CpqgPVYZGaVAtqNX8bZxkt3we8").
                post("https://api.twitter.com/1.1/statuses/update.json?status= EveryDay is a New Day");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
        response.getBody().jsonPath().prettify();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID: " + jsonPath.get("id_str"));
    }

    @Test
    public void reTweet() {
        Response response = RestAssured.given().auth().
                oauth("DKt2mIrSJObaVkKF7cOTFoiHV",
                        "a9g4C0TXq5aZ0WRU89TwaPU4sN4tiXxtbWPludVWxdfAnYem6O",
                        "1300426552379752450-Ovy3rWQDBrZia1JMCrmVzcVHjar7AT",
                        "1T24xP9Tumlfw8LyCl1CpqgPVYZGaVAtqNX8bZxkt3we8").
                post("https://api.twitter.com/1.1/statuses/retweet/1527676792634769409.json");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
        response.getBody().jsonPath().prettify();
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID: " + jsonPath.get("id_str"));
    }

    @Test
    public void deleteTweet() {
        Response response = RestAssured.given().auth().
                oauth("DKt2mIrSJObaVkKF7cOTFoiHV",
                        "a9g4C0TXq5aZ0WRU89TwaPU4sN4tiXxtbWPludVWxdfAnYem6O",
                        "1300426552379752450-Ovy3rWQDBrZia1JMCrmVzcVHjar7AT",
                        "1T24xP9Tumlfw8LyCl1CpqgPVYZGaVAtqNX8bZxkt3we8").
                delete("https://api.twitter.com/2/tweets/1528570178279440384");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Code: " + response.prettyPrint());
    }
}
