import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class DeleteMethodClass extends BaseClass {

    @Test
    public void objectMappingDeleteTest(){

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

        expect().statusCode(HttpStatus.SC_OK).when().delete("delete/"+id);
//        given().when().delete("delete/"+id)
//                .then().assertThat().statusCode(HttpStatus.SC_OK);

        expect().statusCode(HttpStatus.SC_NOT_FOUND).when().delete("delete/"+id);
//        given().when().delete("delete/"+id)
//                .then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
