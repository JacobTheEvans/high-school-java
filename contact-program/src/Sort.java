
public class Sort {
	public ContactList sort(ContactList contacts){
		ContactLink[] linkArray = new ContactLink[contacts.amountOfContacts];
		ContactList result = new ContactList();
		boolean flag = true;
		getStringValue value = new getStringValue();
		ContactLink temp;
		for(int index = 0; !contacts.isEmpty(); index++){
			linkArray[index] = contacts.removeFirst();
		}
		while(flag){
			flag = false;
			for(int i =0; i < linkArray.length -1; i++){
				System.out.println(linkArray[i].toString());
				if(value.getValue(linkArray[i].toString()) < value.getValue(linkArray[i + 1].toString())){
					temp = linkArray[i];
					linkArray[i] = linkArray[i + 1];
					linkArray[i + 1] = temp;
					flag = true;
				}
			}
		}
		for(int i = 0; i < linkArray.length -1; i++){
			result.insertFirstLink(linkArray[i].name, linkArray[i].number, linkArray[i].email);
		}
		return result;
	}

}
