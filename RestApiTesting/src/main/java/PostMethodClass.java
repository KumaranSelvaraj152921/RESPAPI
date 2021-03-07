import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class PostMethodClass extends BaseClass{

    @Test
    public void testPost(){

        String id = (int)(1000*(Math.random()))+"";
        String jsonBody = "{" +
                "\"BrandName\": \"Dell\"," +
                "\"Features\": {" +
                "\"Feature\": [" +
                "\"8th Generation Intel® Core™ i5-8300H\"," +
                "\"Windows 10 Home 64-bit English\"," +
                "\"NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6\"," +
                "\"8GB, 2x4GB, DDR4, 2666MHz\"\n" + "]" +
                "}," +
                "\"Id\":"+id+"," +
                "\"LaptopName\": \"Dell S Series\"" +
                "}";
        RestAssured.given().accept(ContentType.XML)
                .with().contentType(ContentType.JSON).and()
                .body(jsonBody)
                .when().post("add")
                .then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testPostWithoutBody(){

        String id = (int)(1000*(Math.random()))+"";
//        String jsonBody = "{" +
//                "\"BrandName\": \"Dell\"," +
//                "\"Features\": {" +
//                "\"Feature\": [" +
//                "\"8th Generation Intel® Core™ i5-8300H\"," +
//                "\"Windows 10 Home 64-bit English\"," +
//                "\"NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6\"," +
//                "\"8GB, 2x4GB, DDR4, 2666MHz\"\n" + "]" +
//                "}," +
//                "\"Id\":"+id+"," +
//                "\"LaptopName\": \"Dell S Series\"" +
//                "}";
        RestAssured.given().accept(ContentType.XML)
                .with().contentType(ContentType.JSON).and()
                .body("")
                .when().post("add")
                .then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
