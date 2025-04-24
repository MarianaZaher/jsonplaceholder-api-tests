package stepdefinitions;

import io.restassured.response.Response;
import io.cucumber.java.en.*;
import model.User;
import utils.ApiUtils;
import org.testng.Assert;

import java.util.List;

public class ApiStepDefinitions {

    private User user;

    @Given("I retrieve a random user")
    public void i_retrieve_a_random_user() {
        user = ApiUtils.getRandomUser();
    }

    @Then("I print the user's email")
    public void i_print_the_user_email() {
        System.out.println("User Email: " + user.getEmail());
        Assert.assertNotNull(user.getEmail());
    }

    @Then("I get posts for that user and validate Post IDs")
    public void i_get_posts_for_that_user_and_validate_post_ids() {
        List<Integer> postIds = ApiUtils.getUserPostIds(user.getId());
        for (Integer postId : postIds) {
            Assert.assertTrue(postId >= 1 && postId <= 100, "Post ID should be between 1 and 100");
        }
    }

    @Then("I create a new post for that user")
    public void i_create_a_new_post_for_that_user() {
        String title = "Sample Title";
        String body = "Sample Body";

        Response response = ApiUtils.createPost(user.getId(), title, body);
        Assert.assertEquals(response.getStatusCode(), 201);

        int returnedUserId = response.jsonPath().getInt("userId");
        Assert.assertEquals(returnedUserId, user.getId());
    }
}
