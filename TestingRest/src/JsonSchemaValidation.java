import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import integrationTesting.ReadFile;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jayway.restassured.RestAssured;


public class JsonSchemaValidation {
	ReadFile readMyFile = new ReadFile();

	@Test
	public void jsonSchemaValidatorCandidates() throws IOException{ //candidates json schema validation
		File idString = new File("get candidate id to modify.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file

		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/candidates/" + id;
		given().
			param("firstName", "Dana-Elena").
			param("lastName", "Antal").
		when().
			get(path).
		then().
			body(matchesJsonSchemaInClasspath("schema_validator_candidates.json")). // (1)
			body("firstName", equalTo("Dana-Elena")). // (2)
			body("lastName", equalTo("Antal"));   // (3)
	}

	@Test
	public void jsonSchemaValidatorAdmission() throws IOException{ //admission json schema validation
		File idString = new File("get candidate id to modify.txt");
		String id = readMyFile.readString(idString); //read the id of the candidate from file
		RestAssured.baseURI = "http://localhost:8080/fiiadmis-service/api";
		String path = "/admission_results/" + id;

		given().
			param("finalGrade", 9.1).
			param("candidateId", "OQV9").
		when().
			get(path).
		then().
			body(matchesJsonSchemaInClasspath("schema_validator_admission.json")). // (1)
			body("finalGrade", equalTo((float)9.1)). // (2)
			body("candidateId", equalTo("OQV9"));   // (3)


	}

}