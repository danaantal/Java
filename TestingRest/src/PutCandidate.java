import static com.jayway.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


public class PutCandidate {

	@Test
	public void putCandidate() {
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		
		String path = "/candidates/sH3H";
		Map<String, Object>  jsonAsMap = new HashMap<>();
		
		jsonAsMap.put("lastName","Antal");
		jsonAsMap.put("gpaGrade", 9.3);
		jsonAsMap.put("ATestGrade", 8.9);
		jsonAsMap.put("socialId","347389523255248");
		jsonAsMap.put("firstName", "Dana");
		
		given().
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			put(path).
		then().assertThat().statusCode(204);
		
	}

}
