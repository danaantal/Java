import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class DeleteCandidate {

	@Test
	public void deleteCandidate() {
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/2OGp";
		
		given().
		when().
			delete(path).
		then().assertThat().statusCode(204);
		
		given().
		when().get(path).
		then().assertThat().statusCode(404);
			}

}
