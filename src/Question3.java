import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.ActiveEvent;
public class Question3 extends JFrame implements ItemListener,ActionListener{

	private JPanel contentPane;
	ButtonGroup bb;
	JButton button;
	JRadioButton radio1,radio2,radio3,radio4;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question3 frame = new Question3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Question3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 3 - Identify the C compiler of UNIX.");
		lblNewLabel.setBounds(209, 92, 375, 25);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("gcc");
		radio1.setBounds(319, 150, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("cc");
		radio2.setBounds(319, 184, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("Borland");
		radio3.setBounds(319, 219, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("vc++");
		radio4.setBounds(319, 251, 103, 21);
		contentPane.add(radio4);
		
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		radio3.addItemListener(this);
		radio4.addItemListener(this);
		
		button = new JButton("Next");
		button.addActionListener(this);
		button.setBounds(300, 322, 103, 32);
		contentPane.add(button);
	}
	
public void itemStateChanged(ItemEvent e) {
		
		if(radio2.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio1.isSelected() || radio3.isSelected() || radio4.isSelected()){
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
			new Question4().main();
			dispose();
		}
	}
 }
