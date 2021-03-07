import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import static io.restassured.http.ContentType.ANY;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjectMappingPostClass extends BaseClass{

    @Test
    public void objectMappingPostTest(){

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
                .when().post("add")
//                .thenReturn().prettyPrint();
//        System.out.println(str);
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .and().assertThat().body("Laptop.Features.Feature", Matchers.hasItem("8th Generation Intel® Core™ i7-8300H"));
//                .and().assertThat()
//        .body("Id",Matchers.equalTo(Integer.parseInt(id)));
//                .and().assertThat().body("Id", Matchers.equalTo(Integer.parseInt(request.getId())),"LaptopName",Matchers.equalToIgnoringCase(request.getLaptopName()),
//                        "Features.Feature",Matchers.hasItem(request.getFeaturesRequest().getFeature().contains("8th Generation Intel® Core™ i7-8300H")));
    }
}
