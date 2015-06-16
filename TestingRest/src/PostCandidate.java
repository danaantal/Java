import static com.jayway.restassured.RestAssured.given;
import integrationTesting.ReadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


public class PostCandidate {
	ReadFile readMyFile = new ReadFile();
	
	@Test
	public void postCandidate(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates";
		Map<String, Object> jsonAsMap = new HashMap<>();

		jsonAsMap.put("lastName","Jolie");
		jsonAsMap.put("gpaGrade", 9.3);
		jsonAsMap.put("ATestGrade", 8.9);
		jsonAsMap.put("socialId","347389523255435");
		jsonAsMap.put("firstName", "Angelina");
		System.out.println(jsonAsMap);
		given().
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			post(path).
		then().assertThat().statusCode(201);
	}

	@Test
	public void postCandidates() throws Exception{ //bulk post of candidates
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates";

		File candidatesFile = new File("candidates to post.json");//set the file from which to read candidates
		ArrayList<String> field = readMyFile.readFile(candidatesFile);//create the arraylist of candidates
		Map<String, Object> jsonAsMap = new HashMap<>();//create hashmap to send payload to server

		if  (field.size() == 0) {
			System.out.println("Error: No elements in the arraylist");
		}
		else{
			for(int i = 0; i<field.size()-1;i+=2){	//foreach array element, the even positions are the keys and the even positions are the values
				if(i!=0 && i%10==0){//if jsonasmap does not contain 5 elements keep adding, else post to server
					//					System.out.println(jsonAsMap.toString());
					given().
						contentType(ContentType.JSON).
						body(jsonAsMap).
					when().
						post(path).
					then().assertThat().statusCode(201);
				}//endif
				jsonAsMap.put(field.get(i), field.get(i+1));
			}
		}
	}	
	
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidatesnotFound";
		Map<String, Object> jsonAsMap = new HashMap<>();

		jsonAsMap.put("lastName","Jolie");
		jsonAsMap.put("gpaGrade", 9.3);
		jsonAsMap.put("ATestGrade", 8.9);
		jsonAsMap.put("socialId","347389523255435");
		jsonAsMap.put("firstName", "Angelina");
		System.out.println(jsonAsMap);
		given().
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			post(path).
		then().assertThat().statusCode(404);;
		
		System.out.println("Could Not Found " + path);
	}
}
