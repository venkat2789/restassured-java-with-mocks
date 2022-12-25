package tests;

import static io.restassured.RestAssured.given;

import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class BasicTests {
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(9876);

	@Test
	public void basic_get_with200response() {

		given().
			baseUri("http://localhost").
			port(9876).
		when().
			get("/customer/101").
		then().
			assertThat().
			statusCode(200);
	}
	
	@Test
	public void basic_get_with404response() {
				
		given().
			baseUri("http://localhost").
			port(9876).
		when().
			get("/customer/999").
		then().
			assertThat().
			statusCode(404);
	}

}
