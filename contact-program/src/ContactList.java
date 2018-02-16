
public class ContactList {
	public ContactLink firstLink;
	public int amountOfContacts;
	
	public boolean isEmpty(){
		return(firstLink == null);
	}
	public void insertFirstLink(String name,String number,String email){
		if(!name.equals(" ") && !name.equals("null")){
		System.out.println("Insert link called ");
		amountOfContacts++;
		ContactLink newLink  = new ContactLink(name,number,email);
		newLink.next = firstLink;
		firstLink = newLink;
		System.out.println(firstLink.toString());
		}
	}
	public void insertSorted(String name, String number, String email){
		System.out.println("Inserted sort");
		getStringValue value = new getStringValue();
		ContactLink newLink = new ContactLink(name,number,email);
		ContactLink previousLink = null;
		ContactLink currentLink = firstLink;
		while((currentLink != null) && (value.getValue(name.toLowerCase()) > value.getValue(currentLink.name.toLowerCase()))){
			System.out.println("In loop");
			previousLink = currentLink;
			currentLink = currentLink.next;
		}
		if(previousLink == null){
			firstLink = newLink;
		}else{
			previousLink.next = newLink;
		}
		newLink.next = currentLink;
		display();
		amountOfContacts++;
	}
	
	public void display(){
		ContactLink theLink = firstLink;
		while(theLink != null){
			theLink.display();
			theLink = theLink.next;
			System.out.println("----------------------");
		}
	}
	public ContactLink find(String name){
		ContactLink theLink = firstLink;
		if(!isEmpty()){
			while(theLink.toString() != name){
				if(theLink.next == null){
					return null;
				}else{
					theLink = theLink.next;
				}
			}
		}
		return theLink;
	}
	public ContactLink removeLink(String name){
		ContactLink currentLink = firstLink;
		ContactLink previousLink = firstLink;
		while(currentLink.toString() != name){
			if(currentLink.next == null){
				return null;
			}else{
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		if(currentLink == firstLink){
			firstLink = firstLink.next;
		}else{
			previousLink.next = currentLink.next;
		}
		return currentLink;
	}
	public ContactLink removeFirst(){
		ContactLink linkReference = firstLink;
		if(!isEmpty()){
			firstLink = firstLink.next;
		}else{
			System.out.println("Your contact book is empty");
		}
		return linkReference;
	}
	
	

}
