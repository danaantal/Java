package integrationTesting;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class GetPutGetCandidate {
	ReadFile readMyFile = new ReadFile();
	WriteFile writeInFile = new WriteFile();
	
	@Test
	public void getCandidateThenModifyIt() throws IOException{
		
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		Map<String, Object>  jsonAsMap = new HashMap<>();
		File idString = new File("get candidate id to modify.txt"); 
		File progressFile = new File("getPutgetResult.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		
		String path = "/candidates/" + id;
		
		Response response = get(path);
		assertEquals(200, response.getStatusCode());
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals(id, jsp.get("id"));
		writeInFile.writeInFile(response, progressFile); // write response into file
		
		jsonAsMap.put("lastName","Antal");
		jsonAsMap.put("gpaGrade", 9.3);
		jsonAsMap.put("ATestGrade", 8.9);
		jsonAsMap.put("socialId","1288811275444");
		jsonAsMap.put("firstName", "Dana-Elena");
		
		given().
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			put(path).
		then().assertThat().statusCode(204);
		
		response = get(path);
		assertEquals(200, response.getStatusCode());
		
		json = response.asString();
		jsp = new JsonPath(json);
		
		assertEquals(id, jsp.get("id"));
		writeInFile.appendToFile(json, progressFile);//write response into file
	}

}
