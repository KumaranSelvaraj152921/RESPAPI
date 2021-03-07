import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import static io.restassured.RestAssured.*;
public class SSLCertificateClass{

    @Test
    public void SSLRelatedHTTPSValidation(){
        given().relaxedHTTPSValidation().accept(ContentType.XML)
                .when()
                .get("http://localhost:8080/laptop-bag/webapi/sslres/all")
                .thenReturn().prettyPrint();
    }

    @Test
    public void SSLValidationAuthCertificate(){
        given().accept(ContentType.XML)
                .auth().certificate("C:\\Users\\HP\\Desktop\\API Testing\\Resource\\mykey.keystore","password")
                .when()
                .get("http://localhost:8080/laptop-bag/webapi/sslres/all")
                .thenReturn().prettyPrint();
    }
}
