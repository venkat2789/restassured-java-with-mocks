package tests;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import data.Account;
import data.Accounts;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SerializeDeserializeTests {
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
    public void postAccount_withSerializedBody() {

        Account account = new Account("savings");

        given().
            spec(requestSpec).
        and().
            body(account).
        when().
            post("/customer/101/accounts").
        then().
            assertThat().
            statusCode(201);
    }
    
    @Test
    public void getAccounts_intoDeserializedClass() {

        Accounts accounts =

            given().
                spec(requestSpec).
            when().
                get("/customer/101/accounts").
                as(Accounts.class);

        assertEquals(3, accounts.getAccounts().size());
    }

}
