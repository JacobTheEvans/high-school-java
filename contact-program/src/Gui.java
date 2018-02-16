import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Gui {
	private JFrame main;
	private JMenuBar bar;
	private JButton add;
	private JButton save;
	private JList contactPane;
	private JPanel contactArea;
	private ContactInfo infoArea;
	private JScrollPane scroll;
	private ContactList contacts;
	private ContactFileHandler dataHandler = new ContactFileHandler();
	private JTextField searchKey;
	private JButton searchButton;
	private DefaultListModel<String> choices;
	public Gui(){
		loadContacts();
		choices = new DefaultListModel();
		// Gui objects
		main = new JFrame("Contacts");
		main.setLayout(new BorderLayout());
		bar = new JMenuBar();
		add = new JButton("Add contact");
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				String name = JOptionPane.showInputDialog("Name");
				String number = JOptionPane.showInputDialog("Number");
				String email = JOptionPane.showInputDialog("Email");
				update(name,number,email);
				contactPane.clearSelection();
			}
		});
		bar.add(add);
		searchKey =  new JTextField();
		bar.add(searchKey);
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				search(searchKey.getText());
			}
		});
		bar.add(searchButton);
		save = new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dataHandler.saveContacts(contacts);
				load();
			}
		});
		bar.add(save);
		contactPane = new JList(choices);
		scroll = new JScrollPane(contactPane);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contactArea = new JPanel(new BorderLayout());
		contactArea.add(scroll, BorderLayout.CENTER);
		infoArea = new ContactInfo();
		main.add(infoArea, BorderLayout.CENTER);
		main.add(contactArea, BorderLayout.WEST);
		main.setJMenuBar(bar);
		main.setVisible(true);
		main.setSize(400,400);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		load();
		
	}
	public void loadContacts(){
		if(dataHandler.loadContacts() != null){
			contacts = dataHandler.loadContacts();
		}else{
			contacts = new ContactList();
		}
	}
	public void update(String name, String number, String email){
		choices.removeAllElements();
		contacts.insertSorted(name, number, email);
		if(!contacts.isEmpty()){
		ContactLink theNewLink = contacts.firstLink;
		choices.removeAllElements();
		for(int i = 0; theNewLink != null;i++){
			choices.addElement(theNewLink.toString());
			theNewLink = theNewLink.next;
			}
		}
	}
	public void load(){
		if(!contacts.isEmpty()){
			ContactLink theNewLink = contacts.firstLink;
			choices.removeAllElements();
			for(int i = 0; theNewLink != null;i++){
				choices.addElement(theNewLink.toString());
				theNewLink = theNewLink.next;
				}
			}
	}
	public void displayInfo(){
		String name = (String) contactPane.getSelectedValue();
		if(! contactPane.isSelectionEmpty()){
		if(name != null){
			ContactLink infoLink = contacts.find(name);
			infoArea.update(
					infoLink.name, 
					infoLink.number, 
					infoLink.email);
			}
		}
	}
	public void search(String key){
		
	}

}
