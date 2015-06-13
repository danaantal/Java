package integrationTesting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.jayway.restassured.response.Response;

public class WriteFile {
	
	public void writeInFile(Response response, File f){
	try{
		PrintWriter out = new PrintWriter(f);
		out.print(response.asString());
		out.close();
		}catch(Exception e){
			System.out.println("Nothing to write into file");
		}
	}
	
	public void appendToFile(String response, File f){
		try{
			PrintWriter out = new PrintWriter(new FileWriter(f.getName(),true));
			out.println(response);
			out.close();
			}catch(Exception e){
				System.out.println("Nothing to write into file");
			}
		}
}
