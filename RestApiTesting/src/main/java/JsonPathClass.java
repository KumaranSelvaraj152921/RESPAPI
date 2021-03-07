import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class JsonPathClass extends BaseClass{

    @Test
    public void jsonPathTest(){

        String responseString = RestAssured.given().accept(ContentType.JSON)
                .when().get("find/1")
                .thenReturn().asString();
        JsonPath jsonPath = new JsonPath(responseString);
        Assert.assertEquals("Alienware", jsonPath.getString("BrandName"));
        Assert.assertEquals(1,jsonPath.getInt("Id"));
        Assert.assertTrue(jsonPath.getList("Features.Feature").contains("NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6"));
    }

    @Test
    public void xmlPathTest(){

        String responseString = RestAssured.given().accept(ContentType.XML)
                .when().get("find/1")
                .thenReturn().asString();
        XmlPath jsonPath = new XmlPath(responseString);
        Assert.assertEquals("Alienware", jsonPath.getString("Laptop.BrandName"));
        Assert.assertEquals(1,jsonPath.getInt("Laptop.Id"));
        Assert.assertTrue(jsonPath.getList("Laptop.Features.Feature").contains("NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6"));
    }
}
