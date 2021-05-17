import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CPP_Q1 extends JFrame implements ItemListener,ActionListener {

	private JPanel contentPane;
	private ButtonGroup bb;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
	private JLabel btnlabel;
	private Timer t;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPP_Q1 frame = new CPP_Q1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CPP_Q1() {
		setTitle("C++ Question 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 1 - The default access specifer for the class members is");
		lblNewLabel.setBounds(115, 64, 494, 25);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("public");
		radio1.setBounds(229, 134, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("private");
		radio2.setBounds(229, 168, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("protected");
		radio3.setBounds(229, 202, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("None of the above");
		radio4.setBounds(229, 235, 116, 21);
		contentPane.add(radio4);
		
		button = new JButton("Submit");
		button.setBounds(303, 317, 85, 21);
		contentPane.add(button);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		JLabel btnlabel = new JLabel(Integer.toString(time));
		btnlabel.setFont(new Font("Broadway", Font.BOLD, 25));
		btnlabel.setBounds(640, 342, 72, 80);
		contentPane.add(btnlabel);
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time--;
				btnlabel.setText(Integer.toString(time));
				if(time==0) {					
					t.stop();
					if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected()))
							Index.marks+=0;
					CPP_Q2.main();
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
	private int time=30;
	
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
		t.stop();
		CPP_Q2.main();
		dispose();
		}
	}
}
