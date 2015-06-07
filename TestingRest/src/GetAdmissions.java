import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;


public class GetAdmissions {
//	private static final String JSON =  "application/JSON";
	
	@Test
	public void testStatusCode(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/admission_results/notfound";
		
		get(path).
		then().
		assertThat().
		statusCode(404);
		System.out.println("Could Not Found " + path);
	}
	
	@Test
	public void getAdmissions(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/admission_results";
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
	public void getAdmissionByCandidateId(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/admission_results/MZOp";
		
		Response response = get(path);
		
		assertEquals(200, response.getStatusCode());
		
		String json = response.asString();
		JsonPath jsp = new JsonPath(json);
		
		assertEquals("6OZV", jsp.get("id"));
		assertEquals("9.77", jsp.get("finalGrade").toString());
		assertEquals("MZOp", jsp.get("candidateId"));
		assertEquals("tax_free", jsp.get("admissionStatus.statusString"));
		assertEquals("0", jsp.get("admissionStatus.statusInt").toString());
		
		response.prettyPrint();
	}
	}
	
