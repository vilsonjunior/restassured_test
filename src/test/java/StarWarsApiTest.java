import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class StarWarsApiTest {

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

    @Test
    public void buscaPeloPersonagemR2D2() {
        when().
                get(urlStarWars + "people/?search=r2")
        .then()
                .statusCode(200)
                .body("count", equalTo(1))
                .body("results[0].name", is("R2-D2"));
    }
}
