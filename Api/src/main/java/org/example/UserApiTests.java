package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(AllureJunit5.class)
@Epic("API Tests")
@Feature("User Management")
public class UserApiTests {

    private String baseUrl = "https://petstore.swagger.io/#/";
    private String username = "testuser";

    @BeforeEach
    public void setUp() {

    }

    @Test
    @Description("Create user")
    public void createUser() {
        assertEquals(201, createUserRequest().getStatusCode());
    }

    @Test
    @Description("Update user")
    public void updateUser() {
        assertEquals(200, updateUserRequest().getStatusCode());
    }

    @Test
    @Description("Get user by username")
    public void getUserByUsername() {
        assertEquals(200, getUserByUsernameRequest(username).getStatusCode());

    }

    @Test
    @Description("Delete user")
    public void deleteUser() {
        assertEquals(204, deleteUserRequest(username).getStatusCode());
    }

    @AfterEach
    public void tearDown() {

    }


    private Response createUserRequest() {
        String requestBody = "{ " +
                "\"username\": \"testuser\", " +
                "\"email\": \"testuser@example.com\", " +
                "\"password\": \"password123\" " +
                "}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .post("/api/users");
        return response;
    }

    private Response updateUserRequest() {
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ " +
                        "\"username\": \"testuser\", " +
                        "\"email\": \"testuser@example.com\", " +
                        "\"password\": \"password123\" " +
                        "}")
                .put("/api/users/{username}", username);
        return response;
    }

    private Response getUserByUsernameRequest(String username) {
        Response response = RestAssured
                .given()
                .param("username", username)
                .get("/api/users/{username}", username);
        return response;
    }

    private Response deleteUserRequest(String username) {
        Response response = RestAssured
                .given()
                .pathParam("username", username)
                .delete("/api/users/{username}");
        return response;
    }
}
