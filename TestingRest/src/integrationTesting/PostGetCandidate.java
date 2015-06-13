package integrationTesting;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostGetCandidate {
	WriteFile writeInFile = new WriteFile();
	ReadFile readMyFile = new ReadFile();

	@Test
	public void postThenGetCandidateDetails() throws Exception{
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates";

		File candidatesFile = new File("candidates details.txt");
		File postGetCandidates = new File("post then get candidates.txt");
		ArrayList<String> field = readMyFile.readCandidate(candidatesFile);
		//				System.out.println("my field from test "+ field);

		Map<String, Object> jsonAsMap = new HashMap<>();
		if  (field.size() == 0) {
			System.out.println("Error: No elements in the arraylist");
		}
		else{
			for(int i = 0; i<field.size()-1;i+=2){	
				jsonAsMap.put(field.get(i), field.get(i+1));					
			}
		}
		given(). //post
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			post(path).
		then().assertThat().statusCode(201);

		//		System.out.println(testValue);
		Response response = get(path);
		assertEquals(200, response.getStatusCode());

		writeInFile.writeInFile(response, postGetCandidates);

	}

}
