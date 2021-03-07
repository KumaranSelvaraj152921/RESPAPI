import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class QueryParamTestClass extends BaseClass{

    @Test
    public void queryParamTest(){

        RestAssured.given().accept(ContentType.JSON)
                .param("Id","1")
                .param("BrandName","Alienware")
                .param("Features.Feature","Windows 10 Home 64-bit English")
                .when().get("find/1")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().body("BrandName", Matchers.equalToIgnoringCase("Alienware"),
                "Id",Matchers.equalTo(1),"Features.Feature",Matchers.hasItem("Windows 10 Home 64-bit English"));
    }
}
