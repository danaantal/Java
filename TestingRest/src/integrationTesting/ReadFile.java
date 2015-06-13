package integrationTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	public ArrayList<String> readFile(File f) throws Exception{	//read from file what to post as payload
		BufferedReader reader = new BufferedReader( new FileReader( f ) ); //Setup the reader	
		ArrayList<String> myfields = new ArrayList<>();

		while (reader.ready()) { //While there are content left to read
			String line = reader.readLine(); //Read the next line from the file

			String[] tokens = line.split( "\\{" ); //Split the string at every { character. Place the results in an array.			
			for (String token : tokens){ //Iterate through all of the found results
				String[] fields = token.split(","); //Split the string at every , character. Place the results in an array.
				for (String field : fields){
					String[] keys = field.split(" "); //Split the string at every " " character. Place the results in an array.
					for(String k : keys){
						myfields.add(k);
					}
				}
			}
		}
		reader.close(); //Stop using the resource
		return myfields;
	}
	
	public ArrayList<String> readCandidate(File f) throws Exception{	
		BufferedReader reader = new BufferedReader( new FileReader( f ) ); //Setup the reader	
		ArrayList<String> myCandidate = new ArrayList<>();

		while (reader.ready()) { //While there are content left to read
			String line = reader.readLine(); //Read the next line from the file

			String[] tokens = line.split( "," ); //Split the string at every , character. Place the results in an array.			
			for (String token : tokens){ //Iterate through all of the found results
				String[] fields = token.split(" ");
				for (String field : fields){
					myCandidate.add(field);		
				}
			}
		}
		reader.close(); //Stop using the resource
		return myCandidate;
	}
	
	public String readString(File f) throws IOException{
	BufferedReader reader = new BufferedReader( new FileReader(f) ); //Setup the reader	
	String id = null;
	while (reader.ready()) { //While there are content left to read
		id = reader.readLine(); //Read the next line from the file
	}
	reader.close();
	return id;
	}
}
