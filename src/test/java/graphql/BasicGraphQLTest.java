package graphql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.restassured.http.ContentType;

public class BasicGraphQLTest {
	
    @Test
    public void getCompanyData_checkCeo_shouldBeElonMusk() {

        String queryString = "{ company { name ceo coo } }";

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(queryString);

        given().
            contentType(ContentType.JSON).
            body(query).
        when().
            post("https://api.spacex.land/graphql/").
        then().
            assertThat().
            statusCode(200).
        and().
            body("data.company.ceo", equalTo("Elon Musk"));
    }

}
