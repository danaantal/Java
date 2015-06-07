import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class EstablishRights {
	
	private static HashMap<String, SecurityLevels> servicesList = new HashMap<String, SecurityLevels>();
	private static HashMap<String, SecurityLevels> usersList = new HashMap<String, SecurityLevels>();
	private static HashMap<String, Key> kST = new HashMap<String, Key>();
	private static HashMap<String, Key> kUT = new HashMap<String, Key>();
	
	private String userID;
	private char access;
	private int secondMessageLength;
	private String secondMessage;
	private String firstMessage;
	private int n1;

	public EstablishRights(String ID) {
		this.setUserID(ID);
	}
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
	
	public void sendRequest() throws Exception {
		n1 = 10 + (int) (Math.random() * ((5000 - 10) + 1));
		StringBuffer instr = new StringBuffer();
		System.out.println("User[" + userID + "] " + "initialized");
		InputStreamReader isr = null;	
			/** Instantiate a BufferedOutputStream object */		
		BufferedWriter	bos = new BufferedWriter(new FileWriter("file.txt"));		
			String serviceWanted = getServiceName();
			String process = this.userID + "|";
			if (serviceWanted != null) {
				process = process.concat(serviceWanted + "|" + n1 + "|"
						+ access + '\t');
			}

			bos.write(process);
			
			BufferedReader bis = new BufferedReader(new FileReader("file.txt"));


			/** Read the 1st key length or status key */
			int c;
			int nr = 2;
			while (nr != 0) {
				c = bis.read();
				nr--;
				instr.append((char) c);
			}
			String possibleErrorValue = StatusCode.INCOMPLETE_REQUEST
					.getValue(Integer.parseInt(instr.toString()));

			if (possibleErrorValue != null) {
				System.out.println(possibleErrorValue);
				System.exit(0);
			} else {
				int firstMessageLength = Integer.parseInt(instr.toString());
				instr.delete(0, instr.length());
				while (firstMessageLength != 0) {
					c = bis.read();
					firstMessageLength--;
					instr.append((char) c);
				}
				firstMessage = instr.toString();
				nr = 2;
				instr.delete(0, instr.length());
				while (nr != 0) {
					c = bis.read();
					nr--;
					instr.append((char) c);
				}
				secondMessageLength = Integer.parseInt(instr.toString());
				instr.delete(0, instr.length());
				nr = secondMessageLength;
				while (nr != 0) {
					c = bis.read();
					nr--;
					instr.append((char) c);
				}

				secondMessage = instr.toString();
				Key key = TripleDes
						.readKey(new File("Keys/" + userID + ".txt"));
				TripleDes.setUp();
				BASE64Decoder decoder = new BASE64Decoder();
				String firstMessageDecrypted = new String(TripleDes.decrypt(
						decoder.decodeBuffer(firstMessage), key));
				System.out.println("First Part:" + firstMessage);
				System.out.println("Second Part:" + secondMessage);
				System.out.println("First Part Decrypted:"
						+ firstMessageDecrypted);

				if (messageIsValid(firstMessageDecrypted)) {
					String[] elements = firstMessageDecrypted.split("\\|");
					SecretKey K = processFirstPartOfMessageAndFindK(firstMessageDecrypted);
					// create timeStamp;
					Calendar cal = Calendar.getInstance();
					long currentTimeStamp = cal.getTimeInMillis();
					String messageForService = userID + "|" + currentTimeStamp
							+ "|" + elements[2];
					System.out.println("Message For Service:"
							+ messageForService);
					String messageForServiceEncrypted = TripleDes.encrypt(
							messageForService, K);
					String entireMessage = secondMessage.length()
							+ secondMessage
							+ messageForServiceEncrypted.length()
							+ messageForServiceEncrypted;
					System.out.println("Message For Service Encrypted:"
							+ entireMessage);
					sendRequestToService(elements[3], entireMessage);

				}
			}

		
	}
	
	private String getServiceName() {
		String serviceName = null;
		System.out.print("Service name:");		
		Scanner scanner = new Scanner(System.in);
		serviceName = scanner.nextLine();
		return serviceName;
	}
	
	private boolean messageIsValid(String message) {
		String[] elements = message.split("\\|");
		if (elements.length != 4)
			return false;
		if (Integer.parseInt(elements[1]) == n1)
			return true;
		return false;
	}
	
	private SecretKey processFirstPartOfMessageAndFindK(String message)
			throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException, IOException {
		String[] elements = message.split("\\|");
		BASE64Decoder decoder = new BASE64Decoder();
		DESedeKeySpec keyspec = new DESedeKeySpec(
				decoder.decodeBuffer(elements[0]));
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}
	
	private void sendRequestToService(String serviceName, String message) throws IOException {
		StringBuffer buffer = new StringBuffer();
		String request = "";
			request = serviceName.length() + serviceName + message;
			int c;
			BufferedReader bis = new BufferedReader(new FileReader("file.txt"));
			StringBuffer serviceResponse = new StringBuffer();
			while((c=bis.read())!='\n') {
				serviceResponse.append((char)c);
			}
			System.out.println(serviceResponse);
		
}
	
	private static void loadKST(){
		for (Map.Entry<String, SecurityLevels> service : servicesList.entrySet()) {
			try {
				Key key = TripleDes.readKey(new File("Keys/" + service.getKey()
						+ ".txt"));
				kST.put(service.getKey(), key);
			} catch (NoSuchAlgorithmException | InvalidKeyException
					| InvalidKeySpecException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	private static void loadKUT(){
		for (Map.Entry<String, SecurityLevels> user : usersList.entrySet()) {
			try {
				Key key = TripleDes.readKey(new File(user.getKey()
						+ ".txt"));
				kUT.put(user.getKey(), key);
			} catch (NoSuchAlgorithmException | InvalidKeyException
					| InvalidKeySpecException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	private String responseGenerator(String userRequest){
		String serverResponse = "";
		String[] pieceOfRequest = userRequest.split("\\|");
		if (pieceOfRequest.length == 4) {
			String userID = pieceOfRequest[0];
			String serviceWanted = pieceOfRequest[1];
			String n1 = pieceOfRequest[2];

			String access = pieceOfRequest[3];
			if (!usersList.containsKey(userID.toUpperCase()))
				return (String.valueOf(StatusCode.USER_NOT_FOUND.getNumVal()));
			if (!servicesList.containsKey(serviceWanted.toUpperCase()))
				return (String
						.valueOf(StatusCode.SERVICE_NOT_FOUND.getNumVal()));
			SecurityLevels userLevel = usersList.get(userID);
			SecurityLevels serviceLevel = servicesList.get(serviceWanted);
			if (access.toUpperCase().equals("R")) {
				if (userLevel.ordinal() > serviceLevel.ordinal()) {
					try {
						Key k = TripleDes.generateKey();
						double L = 3600;
						SecretKeyFactory keyfactory = SecretKeyFactory
								.getInstance("DESede");
						DESedeKeySpec keyspec = (DESedeKeySpec) keyfactory
								.getKeySpec((SecretKey) k, DESedeKeySpec.class);
						byte[] rawkey = keyspec.getKey();
						for (int i = 0; i < 7; i++) {
							rawkey[rawkey.length - i - 1] = rawkey[i];
						}
						
						BASE64Encoder encoder = new BASE64Encoder();
						String encodedKey = encoder.encode(rawkey);
						String plaintext1 = encodedKey + "|" + n1 + "|"
								+ String.valueOf(L) + "|" + serviceWanted;
						System.out.println(plaintext1);
						String cryptoText1 = TripleDes.encrypt(plaintext1,
								kUT.get(userID)); // first Part of message
						String plaintext2 = encodedKey + "|" + userID + "|"
								+ String.valueOf(L);
						System.out.println(plaintext2);
						String cryptoText2 = TripleDes.encrypt(plaintext2,
								kST.get(serviceWanted));
						return cryptoText1.length() + cryptoText1
								+ cryptoText2.length() + cryptoText2;
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					return (String.valueOf(StatusCode.NOT_ALLOWED.getNumVal()));
				}
			} else if (access.toUpperCase().equals("W")) {
				if (userLevel.ordinal() < serviceLevel.ordinal()) {
					try {
						Key k = TripleDes.generateKey();
						double L = 3600;
						SecretKeyFactory keyfactory = SecretKeyFactory
								.getInstance("DESede");
						DESedeKeySpec keyspec = (DESedeKeySpec) keyfactory
								.getKeySpec((SecretKey) k, DESedeKeySpec.class);
						byte[] rawkey = keyspec.getKey();
						for (int i = 0; i < 7; i++) {
							rawkey[rawkey.length - i - 1] = rawkey[i];
						}
						BASE64Encoder encoder = new BASE64Encoder();
						String encodedKey = encoder.encode(rawkey);
						String plaintext1 = encodedKey + "|" + n1 + "|"
								+ String.valueOf(L) + "|" + serviceWanted;
						String cryptoText1 = TripleDes.encrypt(plaintext1,
								kUT.get(userID)); // first Part of message
						String plaintext2 = encodedKey + "|" + userID + "|"
								+ String.valueOf(L);
						String cryptoText2 = TripleDes.encrypt(plaintext2,
								kST.get(serviceWanted));
						return cryptoText1.length() + cryptoText1
								+ cryptoText2.length() + cryptoText2;
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BadPaddingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalBlockSizeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					return (String.valueOf(StatusCode.NOT_ALLOWED.getNumVal()));
				}
			}

		} else {
			serverResponse = String.valueOf(StatusCode.INCOMPLETE_REQUEST
					.getNumVal());
		}

		return serverResponse;
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
	public char getAccess() {
		return access;
	}
	public void setAccess(char access) {
		this.access = access;
	}
	public int getSecondMessageLength() {
		return secondMessageLength;
	}
	public void setSecondMessageLength(int secondMessageLength) {
		this.secondMessageLength = secondMessageLength;
	}
	public String getSecondMessage() {
		return secondMessage;
	}
	public void setSecondMessage(String secondMessage) {
		this.secondMessage = secondMessage;
	}
	public String getFirstMessage() {
		return firstMessage;
	}
	public void setFirstMessage(String firstMessage) {
		this.firstMessage = firstMessage;
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
}
