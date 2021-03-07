import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class GetMethodTest extends BaseClass{

    @Test
    public void getTest() throws URISyntaxException {
//        URI uri = new URI("http://localhost:8080/laptop-bag/webapi/api/all");
//         RestAssured.given().accept(ContentType.JSON)
//                .when()
//                .get(uri)
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK);
        //When declared RestAssured package as static
//        System.out.println(baseURI+port+basePath);
//        Map<String,String> headers = new HashMap<String, String>();
//        headers.put("Accept","application/json");
//        String response = given().headers(headers)
//                .when()
//                .get(new URI("all"))
//                .thenReturn()
//                .body().asString();
//        System.out.println(response);
//        Assert.assertTrue(response.contains("Alienware M17"));

        //When declared Resassured package as static
//        String response = given().accept(ContentType.JSON)
//                .when()
//                .get(uri)
//                .thenReturn()
//                .body().asString();
//        System.out.println(response);
    }

//    @Test
//    public void basePathTest() throws URISyntaxException {
//        System.out.println(baseURI+port+basePath);
//        int code = given().accept(ContentType.JSON)
//                .when().get(new URI("find/1"))
//                .thenReturn().statusCode();
//        Assert.assertEquals(code,200);
//    }

    @Test
    public void jsonContentValidation() throws URISyntaxException {
        System.out.println(baseURI+port+basePath);
        given().accept(ContentType.JSON)
                .when().get("find/1")
                .then().assertThat()
                .body("BrandName", Matchers.equalToIgnoringCase("Alienware"),
                        "Features.Feature", Matchers.hasItems("8th Generation Intel® Core™ i5-8300H","Windows 10 Home 64-bit English"),
                        "Id",Matchers.equalTo(1),"LaptopName",
                        Matchers.equalToIgnoringCase("Alienware M17"))
        .and().assertThat().body("Features.Feature",Matchers.hasSize(4));
    }

    @Test
    public void xmlContentValidation() throws URISyntaxException {
        System.out.println(baseURI+port+basePath);
//        Response response = given().accept(ContentType.XML)
//                .when().get(new URI("find/1")).prettyPeek();
//        System.out.println(response);
        given().accept(ContentType.XML)
                .when().get(new URI("find/1"))
                .then().assertThat()
                .body("Laptop.BrandName", Matchers.equalToIgnoringCase("Alienware"),
                        "Laptop.Features.Feature", Matchers.hasItems("8th Generation Intel® Core™ i5-8300H","Windows 10 Home 64-bit English","8GB, 2x4GB, DDR4, 2666MHz"),
                        "Laptop.Id",Matchers.equalTo("1"),"Laptop.LaptopName",
                        Matchers.equalToIgnoringCase("Alienware M17"));
    }

}
