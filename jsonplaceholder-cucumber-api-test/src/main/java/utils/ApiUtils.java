package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;

import java.util.List;
import java.util.Random;

public class ApiUtils {

    public static User getRandomUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = RestAssured.get("/users");

        List<Integer> ids = response.jsonPath().getList("id");
        List<String> emails = response.jsonPath().getList("email");

        int index = new Random().nextInt(ids.size());
        return new User(ids.get(index), emails.get(index));
    }

    public static List<Integer> getUserPostIds(int userId) {
        Response response = RestAssured.get("/posts?userId=" + userId);
        return response.jsonPath().getList("id");
    }

    public static Response createPost(int userId, String title, String body) {
        return RestAssured.given()
                .header("Content-type", "application/json")
                .body("{\"userId\": " + userId + ", \"title\": \"" + title + "\", \"body\": \"" + body + "\"}")
                .post("/posts");
    }
}
