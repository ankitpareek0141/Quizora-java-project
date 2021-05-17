import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
public class Question2 extends JFrame implements ItemListener,ActionListener{

	ButtonGroup bb = new ButtonGroup();
	JRadioButton radio1,radio2,radio3,radio4;
	JButton button;
	String str[]= {"include<stdio.h>\r\n" + 
			"\r\n" + 
			"main()\r\n" + 
			"{\r\n" + 
			"   int x = 1;\r\n" + 
			"   \r\n" + 
			"   float y = x>>2;\r\n" + 
			"   \r\n" + 
			"   printf( \"%f\", y );\r\n" + 
			"}"};
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question2 frame = new Question2();
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
	public Question2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 2 - What is the value of \u2018y\u2019 for the following code snippet?");
		lblNewLabel.setBounds(139, 91, 509, 25);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(189, 126, 154, 150);
		for(int i=0;i<str.length;i++)
			textArea.setText(str[i]);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		radio1 = new JRadioButton("4");
		radio1.setBounds(142, 351, 103, 21);
		contentPane.add(radio1);
		
		radio3 = new JRadioButton("0");
		radio3.setBounds(418, 351, 103, 21);
		contentPane.add(radio3);
		
		radio2 = new JRadioButton("0.5");
		radio2.setBounds(283, 351, 103, 21);
		contentPane.add(radio2);
		
		radio4 = new JRadioButton("1");
		radio4.setBounds(563, 351, 103, 21);
		contentPane.add(radio4);
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(354, 434, 91, 33);
		contentPane.add(button);
		button.addActionListener(this);
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
		new Question3().main();
		dispose();
		}
	}
}
