import javax.swing.*;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.*;
public class Question1 extends JFrame implements ItemListener,ActionListener{

	ButtonGroup bb;
	JButton btnNewButton;
	private JPanel contentPane;
	JRadioButton radio1,radio2,radio3,radio4;
	String []str = {"#include<stdio.h>\r\n" + 
			"\r\n" + 
			"main()\r\n" + 
			"{ \r\n" + 
			"   int *p = 15; \r\n" + 
			"   printf(\"%d\",*p);\r\n" + 
			"}"};

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question1 frame = new Question1();
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
	public Question1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(200,230,201));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 1 - What is the output of the following code snippet?");
		lblNewLabel.setBounds(148, 56, 506, 20);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(196, 86, 187, 155);
		for(int i=0;i<str.length;i++){	
			textArea.setText(str[i]);
			}
		textArea.setEditable(false);
		contentPane.add(textArea);
		bb = new ButtonGroup();
		
		radio1 = new JRadioButton("15");
		radio1.setBounds(121, 288, 83, 21);
		contentPane.add(radio1);
		
		 radio2 = new JRadioButton("Garbage Value");
		radio2.setBounds(206, 288, 129, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("Runtime Error");
		radio3.setBounds(349, 288, 129, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("Compiletime Error");
		radio4.setBounds(503, 288, 164, 21);
		contentPane.add(radio4);
		
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		btnNewButton = new JButton("Next");
		btnNewButton.setBounds(298, 405, 85, 31);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		radio3.addItemListener(this);
		radio4.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		if(radio3.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio1.isSelected() || radio1.isSelected() || radio1.isSelected()){
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
			new Question2().main();
			dispose();
		}
	}
}