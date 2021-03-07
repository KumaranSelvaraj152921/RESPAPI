import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class PutMethodClass extends BaseClass {

    @Test
    public void objectMappingPutTest(){

        String id =(int) (1000*Math.random()) +"";
        LaptopBagRequest request = new LaptopBagRequest();
        request.setBrandName("Dell");
        request.setId(id);
        request.setLaptopName("Dell Inspiron");
        FeaturesRequest featureReq = new FeaturesRequest();
        featureReq.setFeature(new ArrayList<String>(Arrays.asList("8th Generation Intel® Core™ i7-8300H",
                "8GB RAM")));
        request.setFeaturesRequest(featureReq);

        given().accept(ContentType.XML)
                .with().contentType(ContentType.XML)
                .body(request)
                .when().post("add");
//        List<String> l = new ArrayList<String>();
//        l.add("8th Generation Intel® Core™ i7-8300H");
//        l.add("8GB RAM");
//        l.add("Updating feature for PUT method");
//        featureReq.setFeature(l);
        featureReq.setFeature(new ArrayList<String>(Arrays.asList("8th Generation Intel® Core™ i7-8300H",
                "8GB RAM","Updating feature for PUT method")));
        request.setFeaturesRequest(featureReq);

        given().log().body().accept(ContentType.XML)
                .with().contentType(ContentType.XML)
                .body(request)
                .when().put("update")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().body("Laptop.Features.Feature",Matchers.hasItem("Updating feature for PUT method"));
    }
}
