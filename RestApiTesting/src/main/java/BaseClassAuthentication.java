import org.junit.BeforeClass;

import static io.restassured.RestAssured.*;

public class BaseClassAuthentication {

    @BeforeClass
    public static void setUpPath(){
        baseURI = "http://localhost";
        port = 8080;
        basePath = "/laptop-bag/webapi/secure/";
        authentication = preemptive().basic("admin","welcome");
    }
}
