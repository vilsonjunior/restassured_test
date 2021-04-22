import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class ReqResApiTest {
    private String uriReqRes = "https://reqres.in/api/";

    @Test
    public void listaDadosUsuario() {
        when()
                .get(uriReqRes + "users?page=2")
        .then()
                .statusCode(200)
                .body("data", is(notNullValue()));
    }
}
