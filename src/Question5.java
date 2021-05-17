import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

public class Question5 extends JFrame implements ActionListener,ItemListener {

	String str1[]= {"float x = 3.6;\r\n" + 
			"\r\n" + 
			"     int y = (int)(x + 0.5);\r\n" + 
			"\r\n" + 
			"     printf (\"Result = %d\\n\", y );"};
	String str2[]= {"float x = 3.6;\r\n" + 
			"\r\n" + 
			"     int y = int(x + 0.5);\r\n" + 
			"\r\n" + 
			"     printf (\"Result = %d\\n\", y );"};
	String str3[]= {"float x = 3.6;\r\n" + 
			"\r\n" + 
			"     int y = (int)x + 0.5;\r\n" + 
			"\r\n" + 
			"     printf (\"Result = %d\\n\", y );"};
	String str4[]= {"float x = 3.6;\r\n" + 
			"\r\n" + 
			"     int y = (int)(int)x + 0.5);\r\n" + 
			"\r\n" + 
			"     printf (\"Result = %d\\n\", y );"};
	private JPanel contentPane;
	ButtonGroup bb;
	JButton button;
	JRadioButton radio1,radio2,radio3,radio4;
	int i;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question5 frame = new Question5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Question5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("<html>Q 6 - Choose the correct program that round off x value (a float value) to an int value to </br>return the output value 4,<html>");
		label1.setBounds(54, 40, 745, 50);
		label1.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(label1);
		
		radio1 = new JRadioButton("A)");
		radio1.setBounds(113, 130, 43, 21);
		contentPane.add(radio1);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(166, 128, 134, 124);
		contentPane.add(textArea1);
		
		radio2 = new JRadioButton("B)");
		radio2.setBounds(386, 130, 43, 21);
		contentPane.add(radio2);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(442, 130, 134, 124);
		contentPane.add(textArea2);
		
		radio3 = new JRadioButton("C)");
		radio3.setBounds(113, 281, 43, 21);
		contentPane.add(radio3);
		
		JTextArea textArea3 = new JTextArea();
		textArea3.setBounds(166, 279, 134, 124);
		contentPane.add(textArea3);
		
		radio4 = new JRadioButton("D)");
		radio4.setBounds(386, 281, 43, 21);
		contentPane.add(radio4);
		
		JTextArea textArea4 = new JTextArea();
		textArea4.setBounds(442, 279, 134, 124);
		contentPane.add(textArea4);
		for(i=0;i<str1.length;i++) {
		textArea1.setText(str1[i]);
		}
		for(i=0;i<str2.length;i++) {
			textArea2.setText(str2[i]);
			}
		for(i=0;i<str3.length;i++) {
			textArea3.setText(str3[i]);
			}
		for(i=0;i<str4.length;i++) {
			textArea4.setText(str4[i]);
			}
		textArea1.setEditable(false);
		textArea2.setEditable(false);
		textArea3.setEditable(false);
		textArea4.setEditable(false);
	    button = new JButton("Next");
	    bb = new ButtonGroup();
	    bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		radio3.addItemListener(this);
		radio4.addItemListener(this);
		button.addActionListener(this);
		button.setBounds(328, 433, 88, 34);
		contentPane.add(button);
	}
	
public void itemStateChanged(ItemEvent e) {
		
		if(radio1.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio2.isSelected() || radio3.isSelected() || radio4.isSelected()){
			if(Index.flag==1) {
				Index.marks-=5;
				Index.flag=0;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected())) 
			JOptionPane.showMessageDialog(null,"Please select any option to continue further","Choose an option",JOptionPane.WARNING_MESSAGE);
		else {
			Index.flag=0;
			new Passed().main();
			dispose();
		}
	}
}
