import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import integrationTesting.WriteFile;

import java.io.File;
import java.io.PrintWriter;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetCandidates {

//	private static final String JSON =  "application/JSON";
	WriteFile writeInFile = new WriteFile();

	@Test
	public void getCandidates() {
		File candidatesList = new File("get candidates - simple.txt");
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates";
		
		Response response = 
				given().
				when().
				        get(path).
				then().
				        contentType(ContentType.JSON).
				extract().
				        response();
		writeInFile.writeInFile(response, candidatesList);
	}

	@Test
	public void getCandidateById(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/OQV9"; //read the id from file!!!!!!!!!!!!!!!!!
		File candidateById = new File("get candidate by id.txt");
		
		Response response = get(path);
		assertEquals(200, response.getStatusCode());
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals("OQV9", jsp.get("id"));
//		assertEquals("Matei", jsp.get("lastName"));
//		assertEquals("8.34", jsp.get("gpaGrade").toString());
//		assertEquals("7.46", jsp.get("ATestGrade").toString());
//		assertEquals("1910614333577", jsp.get("socialId"));
//		assertEquals("Romeo", jsp.get("firstName"));
		writeInFile.writeInFile(response, candidateById);
		
	}
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/notfound";
		
		get(path).
		then().
		assertThat().
		statusCode(404);
		
		System.out.println("Could Not Found " + path);
	}
}
