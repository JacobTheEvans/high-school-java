import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Gui {
	private JFrame main;
	private JPanel screen;
	private JMenuBar menu;
	private JMenu fileM;
	private JMenuItem save;
	private JMenuItem load;
	private JMenu Crypt;
	private JMenuItem encrypt;
	private JMenuItem decrypt;
	private JMenu text;
	private JMenu font;
	private JMenuItem style;
	private JMenuItem italic;
	private JMenuItem bold;
	private JTextArea input;
	private JScrollPane scroll;
	private boolean isBold;
	private boolean isItalic;
	private JTextField sizeInput;
	private JButton setSize;
	
	public Gui(){
		main = new JFrame("EncrpytPad");
		main.setSize(400,600);
		main.setLayout(new BorderLayout());
		main.setResizable(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new JMenuBar();
		fileM = new JMenu("File");
		save = new JMenuItem("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JFileChooser fileSave = new JFileChooser();
				fileSave.showSaveDialog(main);
				saveFile(fileSave.getSelectedFile());
			}
		}
				);
		load = new JMenuItem("Load");
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
					JFileChooser fileOpen = new JFileChooser();
					fileOpen.showOpenDialog(main);
					loadFile(fileOpen.getSelectedFile());
				
			}
		}
		);
		fileM.add(save);
		fileM.add(load);
		menu.add(fileM);
		Crypt = new JMenu("Encryption");
		encrypt = new JMenuItem("Encrypt");
		encrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Encrypt dataEncrypt = new Encrypt();
				input.setText(dataEncrypt.EncrpytString(input.getText()));
			}
		}
		);
		decrypt = new JMenuItem("Decrypt");
		decrypt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Encrypt dataDecrypt = new Encrypt();
				input.setText(dataDecrypt.DecryptString(input.getText()));
			}
		}
		);
		Crypt.add(encrypt);
		Crypt.add(decrypt);
		menu.add(Crypt);
		text = new JMenu("Text");
		font = new JMenu("Font");
		JMenuItem  Serif = new JMenuItem("Serif");
		Serif.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				input.setFont(new Font("Serif", input.getFont().getStyle(),input.getFont().getSize()));
			}
		}
		);
		JMenuItem Arial = new JMenuItem("Arial");
		Arial.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				input.setFont(new Font("Arial", input.getFont().getStyle(), input.getFont().getSize()));
			}
		}
				);
		font.add(Serif);
		font.add(Arial);
		text.add(font);
		JMenu style = new JMenu("Style");
		bold = new JMenuItem("Bold");
		bold.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(! isBold){
				input.setFont(new Font(input.getFont().getName(), Font.BOLD,input.getFont().getSize()));
				isBold = true;
				isItalic = true;
				}else{
					isBold = false;
					isItalic = false;
					input.setFont(new Font(input.getFont().getName(),Font.PLAIN,input.getFont().getSize()));
				}
			}
		});
		italic = new JMenuItem("Italic");
		italic.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(! isItalic){
					input.setFont(new Font(input.getFont().getName(), Font.ITALIC,input.getFont().getSize()));
					isBold = true;
					isItalic = true;
				}else{
					isBold = false;
					isItalic = false;
					input.setFont(new Font(input.getFont().getName(),Font.PLAIN, input.getFont().getSize()));
				}
			}
		});
		style.add(bold);
		style.add(italic);
		text.add(style);
		menu.add(text, BorderLayout.CENTER);
		sizeInput = new JTextField("24");
		menu.add(sizeInput);
		setSize = new JButton("Set Size");
		setSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evnet){
				input.setFont(new Font(input.getFont().getName(),input.getFont().getStyle(),Integer.parseInt(sizeInput.getText())));
			}
		});
		menu.add(setSize);
		input = new JTextArea();
		input.setFont(new Font("Serrif", Font.PLAIN, 24));
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		scroll = new JScrollPane(input);
		scroll.setBounds(main.getBounds());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		main.setJMenuBar(menu);
		main.add(scroll);
		main.setVisible(true);
		
	}
	public void saveFile(File file){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(input.getText());
			writer.flush();
			writer.close();
		}catch(IOException ex ){
			ex.printStackTrace();
		}
	}
	public void loadFile(File file){
		String fileText = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				if(fileText == null){
					fileText = line;
				}else{
				fileText += line;
				}
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
		input.setText(fileText);
	}

}
