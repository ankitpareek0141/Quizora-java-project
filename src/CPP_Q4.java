import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CPP_Q4 extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private Timer t;
	private int time = 30; 
	private ButtonGroup bb;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPP_Q4 frame = new CPP_Q4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CPP_Q4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 4 - Designer of C++ programming language.");
		lblNewLabel.setBounds(96, 74, 495, 27);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) Charles Babbage");
		radio1.setBounds(243, 124, 152, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) Dennis Richie");
		radio2.setBounds(243, 164, 152, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) Brain Karnighan");
		radio3.setBounds(243, 202, 152, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) Bjarne Stroustrup");
		radio4.setBounds(243, 245, 152, 21);
		contentPane.add(radio4);
		
		button = new JButton("Submit");
		button.setBounds(279, 323, 85, 21);
		contentPane.add(button);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(time));
		lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(579, 323, 71, 101);
		contentPane.add(lblNewLabel_1);
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time--;
				lblNewLabel_1.setText(Integer.toString(time));
				if(time==0) {					
					t.stop();
					if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected()))
						Index.marks+=0;
					CPP_Q5.main();
					dispose();
				}
			}
		});
		t.start();
		
		radio1.addItemListener(this);
		radio2.addItemListener(this);
		radio3.addItemListener(this);
		radio4.addItemListener(this);
		button.addActionListener(this);
	}
	
public void itemStateChanged(ItemEvent e) {
		
		if(radio4.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio1.isSelected() || radio2.isSelected() || radio3.isSelected()){
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
		t.stop();
		CPP_Q5.main();
		dispose();
		}
	}
}
