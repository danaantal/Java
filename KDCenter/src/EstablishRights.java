import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;


public class EstablishRights {
	
	private static HashMap<String, SecurityLevels> servicesList = new HashMap<String, SecurityLevels>();
	private static HashMap<String, SecurityLevels> usersList = new HashMap<String, SecurityLevels>();
	private HashMap<String, Key> kST = new HashMap<String, Key>();
	private HashMap<String, Key> kUT = new HashMap<String, Key>();
	
	public void initialize(){
	loadServicesFromFile("services.txt");
	loadUsersFromFile("users.txt");
	loadKST();
	loadKUT();
	}
	
	private static void loadServicesFromFile(String filePath) {//read services and their security levels from file
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] service = line.split(" ");
				SecurityLevels level = null;
				if (service[1].equals("TS"))
					level = SecurityLevels.TOPSECRET;
				if (service[1].equals("S"))
					level = SecurityLevels.SECRET;
				if (service[1].equals("C"))
					level = SecurityLevels.CONFIDENTIAL;
				if (service[1].equals("U"))
					level = SecurityLevels.UNCLASSIFIED;
				servicesList.put(service[0], level);
			}
		} catch (IOException e) {

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void loadUsersFromFile(String filePath) {//read users and their security levels from file
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] user = line.split(" ");
				SecurityLevels level = null;
				if (user[1].equals("TS"))
					level = SecurityLevels.TOPSECRET;
				if (user[1].equals("S"))
					level = SecurityLevels.SECRET;
				if (user[1].equals("C"))
					level = SecurityLevels.CONFIDENTIAL;
				if (user[1].equals("U"))
					level = SecurityLevels.UNCLASSIFIED;
				usersList.put(user[0], level);
			}
		} catch (IOException e) {

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private static void loadKST(){
		
	}
	
	private static void loadKUT(){
		
	}
	
	private String responseGenerator(){
		String response = "";
		return response;
	}
	
	public HashMap<String, SecurityLevels> getUsersList() {
		return usersList;
	}

	public HashMap<String, SecurityLevels> getServicesList() {
		return servicesList;
	}

	public HashMap<String, Key> getkST() {
		return kST;
	}
	public void setkST(HashMap<String, Key> kST) {
		this.kST = kST;
	}
	public HashMap<String, Key> getkUT() {
		return kUT;
	}
	public void setkUT(HashMap<String, Key> kUT) {
		this.kUT = kUT;
	}
	
	
}
