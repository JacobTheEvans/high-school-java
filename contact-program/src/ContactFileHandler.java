
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class ContactFileHandler {
	public ContactList loadContacts(){
		ContactList contacts = new ContactList();
		File file = new File("contacts.txt");
		if(file.exists()){
		try{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";
		while((line = reader.readLine()) != null){
			System.out.println("New contacted called");
			String[] contactData = line.split("-");
			contacts.insertSorted(contactData[0], contactData[1], contactData[2]);
		}
		reader.close();
		
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Cannot load file");
		}
		contacts.display();
		System.out.println("Returning contacts");
		return contacts;
		}else{
			System.out.println("Returning null");
			return null;
		}
	}
	public void saveContacts(ContactList contacts){
		BufferedWriter writer = null;
		File file = new File("contacts.txt");
		String str = "";
		try{
			PrintWriter clear = new PrintWriter(file);
			clear.close();
			writer = new BufferedWriter(new FileWriter(file));
			str = "";
			while(!contacts.isEmpty()){
				ContactLink theLink = contacts.removeFirst();
				str += theLink.name + "-" + theLink.number + "-" + theLink.email + "\n";
			}
			writer.write(str);
			writer.close();
		}catch(Exception ex){
			System.out.println("Error cannot save file");
		}
		
	}

}
