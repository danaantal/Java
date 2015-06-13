import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import integrationTesting.ReadFile;
import integrationTesting.WriteFile;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetAdmissions {
	WriteFile writeInFile = new WriteFile();
	ReadFile readMyFile = new ReadFile();
	
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results/notfound";
		
		get(path).
		then().
		assertThat().
		statusCode(404);
		System.out.println("Could Not Found " + path);
	}
	
	@Test
	public void getAdmissions(){
		File getAdmissions = new File("get admissions.txt");
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results";
		Response response = 
				given().
				when().
				        get(path).
				then().
				        contentType(ContentType.JSON).
				        extract().	
				        response();
		writeInFile.writeInFile(response, getAdmissions);	
	}
	
	@Test
	public void getAdmissionByCandidateId() throws IOException{
		File idString = new File("get candidate id to modify.txt");
		File getAdmissionById = new File("get admission by ID.txt");
		String id = readMyFile.readString(idString);
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results/" + id;
		
		
		Response response = get(path);
		
		assertEquals(200, response.getStatusCode());
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals(id, jsp.get("candidateId"));
		
		writeInFile.writeInFile(response, getAdmissionById);	
	}
	}
	
