package in.blogspot.vijmani;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CharacterCounter extends JFrame implements ActionListener{
	JFrame jFrame;
	JTextArea textArea;
	JLabel words, characters;
	JButton count,clear, bgColor,textColor;
	private int cWords, cCharacters = 0;
	
	CharacterCounter(){
		textArea = new JTextArea("Input the characters and click count");
		JScrollPane textAreaScroll = new JScrollPane(textArea);
		textAreaScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		textAreaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textAreaScroll.setBounds(10,30,460,280);
		
		words = new JLabel("Words: "+cWords);
		words.setBounds(30, 300, 100, 50);
		
		characters = new JLabel("Characters: "+cCharacters);
		characters.setBounds(350, 300, 100, 50);
		
		count = new JButton("Count");
		count.addActionListener(this);
		count.setBounds(200,350,100,40);
		
		clear = new JButton("Clear");
		clear.addActionListener(this);
		clear.setBounds(320,350,100,40);
		
		String pathB = (System.getProperty("user.dir")+"//res//backgroundcolor.png");
		bgColor = new JButton(new ImageIcon(pathB));
		bgColor.addActionListener(this);
		bgColor.setBounds(30,380,40,40);
		
		String pathT = (System.getProperty("user.dir")+"//res//textColor.png");
		textColor = new JButton(new ImageIcon(pathT));
		textColor.addActionListener(this);
		textColor.setBounds(80,380,40,40);
		
		add(textAreaScroll);
		add(words);
		add(characters);
		add(count);
		add(clear);
		add(bgColor);
		add(textColor);
		
		setSize(500, 500);
		setTitle("Av Characters counter");
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == count) {
		String inputString = textArea.getText();
		if(!inputString.equals("")) {
		String cWords[] = inputString.split("\\s");
		words.setText("Words: " +cWords.length);
		characters.setText("Characters: "+inputString.length());
		}else {
			words.setText("Words: " +cWords);
			characters.setText("Characters: "+cCharacters);
		}
		}else if(e.getSource() == clear) {
			textArea.setText("");
		}else if(e.getSource() == bgColor){
			Color chColor = JColorChooser.showDialog(this, "Text backgound color", Color.BLACK);
			textArea.setBackground(chColor);
		}else if(e.getSource() == textColor) {
			Color chColor = JColorChooser.showDialog(this,"Choose Color",Color.BLACK);  
            textArea.setForeground(chColor);  
		}else {
			System.out.println("Ajit's Program");
		}
		
	}
	
	public static void main(String args[]) {
		new CharacterCounter();
	}
}
