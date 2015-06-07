import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


public class PostCandidate {
	
	public ArrayList<String> readFile(File f) throws Exception{	
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader( new FileReader( f ) ); //Setup the reader	
		ArrayList<String> myfields = new ArrayList<>();
		
		while (reader.ready()) { //While there are content left to read
			String line = reader.readLine(); //Read the next line from the file
			
			String[] tokens = line.split( "\\{" ); //Split the string at every { character. Place the results in an array.			
			for (String token : tokens){ //Iterate through all of the found results
				String[] fields = token.split(",");
				for (String field : fields){
//					System.out.println(field);
					myfields.add(field);									
				}
//				System.out.println(token);
			}
		}
		reader.close(); //Stop using the resource
		return myfields;
	}

	
	@Test
	public void postCandidate(){
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/candidates";
		Map<String, Object> jsonAsMap = new HashMap<>();
		
		jsonAsMap.put("lastName","Jolie");
		jsonAsMap.put("gpaGrade", 9.3);
		jsonAsMap.put("ATestGrade", 8.9);
		jsonAsMap.put("socialId","347389523255435");
		jsonAsMap.put("firstName", "Angelina");
		
		given().
			contentType(ContentType.JSON).
			body(jsonAsMap).
		when().
			post(path).
		then().assertThat().statusCode(201);
	}
	
	@Test
	public void postCandidates() throws Exception{
		RestAssured.baseURI = "http://fii-admis-restservice-dt5dd3kc2v.elasticbeanstalk.com/api";
		String path = "/candidates";
		File candidatesFile = new File("candidates to post.json");
		ArrayList<String> field = readFile(candidatesFile);
		System.out.println(field);
		
	}

}
