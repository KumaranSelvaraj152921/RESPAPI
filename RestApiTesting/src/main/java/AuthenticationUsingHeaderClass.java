import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class AuthenticationUsingHeaderClass extends BaseClass{

    @Test
    public void authenticHeaderTest(){
        String id =(int) (1000*Math.random()) +"";
        LaptopBagRequest request = new LaptopBagRequest();
        request.setBrandName("Dell");
        request.setId(id);
        request.setLaptopName("Dell Inspiron");
        FeaturesRequest featureReq = new FeaturesRequest();
        featureReq.setFeature(new ArrayList<String>(Arrays.asList("8th Generation Intel",
                "8GB RAM")));
        request.setFeaturesRequest(featureReq);

        given().accept(ContentType.JSON).with().contentType(ContentType.XML)
                .headers("Authorization","Basic YWRtaW46d2VsY29tZQ==")
                .body(request)
                .when().post("http://localhost:8080/laptop-bag/webapi/secure/add")
                .then().assertThat().statusCode(HttpStatus.SC_OK);

    }
}
