import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
	public void testStatusCodeForResults(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_resultsnotfound";
		
		given().
			get(path).
		then().
			assertThat().
			statusCode(404);
		System.out.println("Could Not Found " + path);
	}
	
	@Test
	public void testStatusCodeForId(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results/notfound";
		
		given().
			get(path).
		then().
			assertThat().
			statusCode(404);
		System.out.println("Could Not Found " + path);
	}
	
	@Test
	public void generateAndgetAdmissions(){
		File getAdmissions = new File("get admissions.txt");
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results";
		Response response = 
				given().header("Pragma", "admin").
				when().
				        get(path).
				then().
				        contentType(ContentType.JSON).
				        extract().	
				        response();
		assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
		writeInFile.writeInFile(response, getAdmissions); // write response into file
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
		assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
		writeInFile.writeInFile(response, getAdmissions); // write response into file
	}
	
	@Test
	public void getAdmissionByCandidateId() throws IOException{
		File idString = new File("get candidate id to modify.txt");
		File getAdmissionById = new File("get admission by ID.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results/" + id;
		
		
		Response response = given().
				when().
		        get(path).
		then().
		        contentType(ContentType.JSON).
		        extract().	
		        response();
		
		assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals(id, jsp.get("candidateId"));
		
		writeInFile.writeInFile(response, getAdmissionById); //write response into file
	}
	 
//	 @Test
//		public void getAdmissionFinalGrades(){
//			File getAdmissions = new File("get admissions.txt");
//			RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
//			String path = "/admission_results";
//			Response response = 
//					given().
//					when().
//					        get(path).
//					then().
//					        contentType(ContentType.JSON).
//					        extract().	
//					        response();
//			assertThat(response.statusLine(), equalTo("HTTP/1.1 200 OK"));
//			writeInFile.writeInFile(response, getAdmissions); // write response into file
//		}
//		
	}
	
