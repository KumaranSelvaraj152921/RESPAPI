import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static  io.restassured.RestAssured.*;
public class PostMethodDeserializationClass extends BaseClass{

    @Test
    public void deserializationClassPostMethod(){

        String id = ((int) (1000*Math.random()))+"";
        LaptopBagRequest request = new LaptopBagRequest();
        request.setLaptopName("HP Pavilion DM4");
        request.setId(id);
        request.setBrandName("Helwett Packard");
        FeaturesRequest feature = new FeaturesRequest();
        feature.setFeature(new ArrayList<String>(Arrays.asList("16 GB RAM","512 SSD","Intel Grphaics card")));
        request.setFeaturesRequest(feature);

        LaptopBagRequest add = given().accept(ContentType.JSON)
                .with().contentType(ContentType.XML)
                .body(request)
                .post("add")
                .thenReturn().as(LaptopBagRequest.class);
        System.out.println(add.getBrandName());
//        System.out.println(response.getId());
//        System.out.println(response.getLaptopName());
//        System.out.println(response.getFeaturesRequest().getFeature().get(0));
    }
}
