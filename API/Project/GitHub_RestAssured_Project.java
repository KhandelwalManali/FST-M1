package LiveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHub_RestAssured_Project {

    // Declare request Specification
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    // Declare variables
    String sshKey = "ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGs7RkW4FUFneQsXiNEn1ehH/nNxSBpbjic90rT7vHZP";
    int sshId;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", "token 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")
                .addHeader("Content-Type", "application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(4000L))
                .expectBody("key", equalTo(sshKey))
                .expectBody("title", equalTo("TestAPIKey"))
                .build();

    }

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        Response response = given().spec(requestSpec).
                body(reqBody).when().post();

        sshId = response.then().extract().path("id");

        response.then().statusCode(201).spec(responseSpec);

    }

    @Test(priority = 2)
    public void getRequestTest() {
        given().log().all().spec(requestSpec).pathParam("keyId", sshId)
                .when().get("{keyId}")
                .then().statusCode(200).spec(responseSpec);

    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        given().log().all().spec(requestSpec).pathParam("keyId", sshId)
                .when().delete("{keyId}")
                .then().statusCode(204).time(lessThan(3000L));
    }
}
