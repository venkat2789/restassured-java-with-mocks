package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class GPathTests {
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(9876);
	
	private RequestSpecification requestSpec;

	@Before
	public void createRequestSpecification() {
		
		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://localhost").
			setPort(9876).
			build();
	}
	
	@Test
	public void checkName_withGpath() {
				
		given().
			spec(requestSpec).
		when().
			get("/customer/101").
		then().
			assertThat().
			body("firstName", equalTo("John"));
	}
	
	@Test
	public void checkCity_withGpath() {

		given().
		    spec(requestSpec).
		when().
			get("/customer/101").
		then().
			assertThat().
			body("address.city", equalTo("Beverly Hills"));
	}
	
	@Test
	public void checkContainsAndSize_withGpath() {
		
		given().
			spec(requestSpec).
		when().
			get("/customer/101/accounts").
		then().
			assertThat().
			body("accounts.id", hasItem(12345)).
			body("accounts.id", hasSize(3));
	}

}
