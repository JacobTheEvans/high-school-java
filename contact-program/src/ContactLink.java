
public class ContactLink {
	public String name,number,email;
	public ContactLink next;
	
	public ContactLink(String name, String number, String email){
		this.name = name;
		this.number = number;
		this.email = email;
	}
	public void display(){
		System.out.println(name + "\nNumber: " + number + " Email: " + email);
	}
	public String toString(){
		return name;
	}

}
