package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ReqSpecTests {
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
	public void checkContentType_withReqSpec() {
				
		given().
			spec(requestSpec).
		when().
			get("/customer/101").
		then().
			assertThat().
			contentType(equalTo("application/json"));
	}

}
