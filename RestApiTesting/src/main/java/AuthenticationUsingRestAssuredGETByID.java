import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class AuthenticationUsingRestAssuredGETByID extends BaseClassAuthentication{

    //Authentication value username and password are coming BaseClassAuthentication
    //Base uri coming from BaseClassAuthentication
    @Test
    public void getAuthentication(){
        //fetching
        given().accept(ContentType.JSON)
                .when().get("find/43")
                .then().assertThat().statusCode(HttpStatus.SC_OK);
        //deleting
        given().delete("delete/43").then().assertThat().statusCode(HttpStatus.SC_OK);
        //fetching the delete item
        given().accept(ContentType.JSON)
                .when().get("find/43")
                .then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
