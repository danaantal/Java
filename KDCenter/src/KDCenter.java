import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class KDCenter {

	public static void main(String[] args) throws Exception {
		
		EstablishRights establisher = new EstablishRights("U2");
		
		try(BufferedReader br = new BufferedReader(new FileReader("services.txt"))) {
	        StringBuilder servicesBuilder = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	servicesBuilder.append(line);
	        	servicesBuilder.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = servicesBuilder.toString();
	        System.out.println("Available Services: " + everything);
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try(BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
	        StringBuilder usersBuilder = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	usersBuilder.append(line);
	        	usersBuilder.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = usersBuilder.toString();
	        System.out.println("Available Users: " + everything);
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		establisher.initialize();
		establisher.sendRequest();
		
	}

}
