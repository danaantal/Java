import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class DeleteAdmission {

	@Test
	public void deleteAdmission() {
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		
//		given().
//		when().
//			delete("/admission_results").
//		then().assertThat().statusCode(204);
//		given().
//		when().
//			get("/admission_results").
//		then().assertThat().statusCode(404);
			}
	}


