import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class AuthenticationUsingAuthBasicClass extends BaseClass{

    @Test
    public void authenticAuthBasicPreemptiveTest(){
        String id =(int) (1000*Math.random()) +"";
        LaptopBagRequest request = new LaptopBagRequest();
        request.setBrandName("Dell");
        request.setId(id);
        request.setLaptopName("Dell Inspiron");
        FeaturesRequest featureReq = new FeaturesRequest();
        featureReq.setFeature(new ArrayList<String>(Arrays.asList("8th Generation Intel",
                "8GB RAM")));
        request.setFeaturesRequest(featureReq);

        //Expected Unauthorized message 401
        given().accept(ContentType.JSON).with().contentType(ContentType.XML)
                .body(request)
                .when().post("http://localhost:8080/laptop-bag/webapi/secure/add")
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);

        //Expected Unauthorized message 401 with Auth Basic
        given().accept(ContentType.JSON).with().contentType(ContentType.XML)
                .auth().basic("admin","welcome")
                .body(request)
                .when().post("http://localhost:8080/laptop-bag/webapi/secure/add")
                .then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);

        //Expected success message 200 with Auth Preemptive Basic
        given().accept(ContentType.JSON).with().contentType(ContentType.XML)
                .auth().preemptive().basic("admin","welcome")
                .body(request)
                .when().post("http://localhost:8080/laptop-bag/webapi/secure/add")
                .then().assertThat().statusCode(HttpStatus.SC_OK);

    }
}
