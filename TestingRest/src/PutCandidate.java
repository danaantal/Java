import static com.jayway.restassured.RestAssured.given;
import integrationTesting.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


public class PutCandidate {
	ReadFile readMyFile = new ReadFile();
	@Test
	public void putCandidate() throws IOException {
		File idString = new File("get candidate id to modify.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";	
		String path = "/candidates/" + id;
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
	
	@Test
	public void testStatusCodeInternalServerError() throws IOException {
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";	
		String path = "/candidates/" + "notfound";
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
		then().assertThat().statusCode(500);
	}
	
	@Test
	public void testStatusCodeNotFound() throws IOException {
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";	
		String path = "/candidatesnotfound";
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
		then().assertThat().statusCode(404);
	}

}
