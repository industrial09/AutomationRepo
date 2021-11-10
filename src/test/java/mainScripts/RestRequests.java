package mainScripts;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.log4j.*;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RestRequests {
	Logger log = Logger.getLogger(RestRequests.class);
	
	@BeforeTest
	public void setUp() {
		log.info("Checking Log4J implementation");
		baseURI = "https://reqres.in";
		basePath = "/api";
		
		requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
		log.info("Log4J implementation succesful");
	}
	
	@Test
	public void getResquest() {
		given()
		.get("users?page=2")
		.then()
		.body("data[0].id", equalTo(7));
	}
	
	@Test
	public void postRequest() {
		JSONObject body = new JSONObject();
		body.put("name", "Christian");
		body.put("name", "Alejandra");
		
		System.out.println(body);
		
		given().
		body(body.toJSONString())
		.when()
		.post("users")
		.then()
		.statusCode(201);
	}
	
	@Test
	public void postRequest2() {
		String value = given()
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.post("users")
		.then()
		.extract()
		.asString();
		System.out.println(value);
	}
	
	@Test
	public void getDataUsingJsonPath() {
		Response response = given()
		.get("users?page=2");
		
		JsonPath js = response.jsonPath();
		int pageNumber = js.get("page");
		System.out.println(pageNumber);
	}
}
