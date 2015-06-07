import static org.junit.Assert.*;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetCandidates {

//	private static final String JSON =  "application/JSON";

	@Test
	public void getCandidates() {
		
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/candidates";
		
		Response response = 
				given().
				when().
				        get(path).
				then().
				        contentType(ContentType.JSON).
				extract().
				        response();
		response.prettyPrint();		
	}

	@Test
	public void getCandidateById(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		
		String path = "/candidates/Fitl";
		Response response = get(path);
		
		assertEquals(200, response.getStatusCode());
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals("Fitl", jsp.get("id"));
//		assertEquals("Matei", jsp.get("lastName"));
//		assertEquals("8.34", jsp.get("gpaGrade").toString());
//		assertEquals("7.46", jsp.get("ATestGrade").toString());
//		assertEquals("1910614333577", jsp.get("socialId"));
//		assertEquals("Romeo", jsp.get("firstName"));
		
		response.prettyPrint();
	}
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/candidates/notfound";
		
		get(path).
		then().
		assertThat().
		statusCode(404);
		
		System.out.println("Could Not Found " + path);
	}
}
