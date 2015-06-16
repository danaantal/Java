import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import integrationTesting.ReadFile;
import integrationTesting.WriteFile;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetCandidates {
	WriteFile writeInFile = new WriteFile();
	ReadFile readMyFile = new ReadFile();

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
		assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
		writeInFile.writeInFile(response, candidatesList); //write response into file
	}

	@Test
	public void getCandidateById() throws IOException{
		File candidateById = new File("get candidate by id.txt");
		File idString = new File("get candidate id to modify.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/" + id;
		
		Response response = get(path);
		assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals("OQV9", jsp.get("id"));
//		assertEquals("Matei", jsp.get("lastName"));
//		assertEquals("8.34", jsp.get("gpaGrade").toString());
//		assertEquals("7.46", jsp.get("ATestGrade").toString());
//		assertEquals("1910614333577", jsp.get("socialId"));
//		assertEquals("Romeo", jsp.get("firstName"));
		writeInFile.writeInFile(response, candidateById); // write response into file
		
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

