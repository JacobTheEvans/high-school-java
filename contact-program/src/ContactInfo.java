import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ContactInfo extends JPanel {
	private JLabel nameLabel;
	private JPanel info;
	private JLabel numberLabel;
	private JLabel emailLabel;
	public ContactInfo(){
		setLayout(new BorderLayout());
		setForeground(Color.BLUE);
		Font font = new Font("Serrif", Font.PLAIN, 21);
		nameLabel = new JLabel("Name");
		nameLabel.setFont(font);
		info = new JPanel(new GridLayout(2,1));
		numberLabel = new JLabel("Number:");
		numberLabel.setFont(font);
		emailLabel = new JLabel("Email:");
		emailLabel.setFont(font);
		info.add(numberLabel);
		info.add(emailLabel);
		add(nameLabel, BorderLayout.NORTH);
		add(info, BorderLayout.CENTER);
	}
	public void update(String name, String number, String email){
		nameLabel.setText(name);
		numberLabel.setText("Number: " + number);
		emailLabel.setText("Email: " + email);
	}

}
