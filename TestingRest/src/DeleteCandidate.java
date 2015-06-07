import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class DeleteCandidate {

	@Test
	public void deleteCandidate() {
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
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
