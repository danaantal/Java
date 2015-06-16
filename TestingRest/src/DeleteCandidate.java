import static com.jayway.restassured.RestAssured.given;
import integrationTesting.ReadFile;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class DeleteCandidate {
	ReadFile readMyFile = new ReadFile();
	@Test
	public void deleteCandidate() throws IOException {
		File idString = new File("candidate to delete.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/" + id;
		
		given().
		when().
			delete(path).
		then().assertThat().statusCode(204);
		
		given().
		when().get(path).
		then().assertThat().statusCode(404);
			}
	
	@Test
	public void deleteCandidateTwice() throws IOException {
		File idString = new File("candidate to delete.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/" + id;
		
		given().
		when().
			delete(path).
		then().assertThat().statusCode(204);
		
		given().
		when().
			delete(path).
		then().assertThat().statusCode(404);
		
	}
	
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/notfound";
		given().
		when().
			delete(path).
		then().
			assertThat().
			statusCode(404);
		
		System.out.println("Could Not Found " + path);
	}

}
