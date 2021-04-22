import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class RestAssuredTest {

    private String urlStarWars = "https://swapi.dev/api/";

    @Test
    public void listaInfoLukeStarWars() {
        when().
                get(urlStarWars + "people/1/")
        .then()
                .statusCode(200)
                .body("name", is("Luke Skywalker"))
                .body("height", is("172"))
                .body("gender", is("male"))
                .body("birth_year", is("19BBY"));
    }
}
