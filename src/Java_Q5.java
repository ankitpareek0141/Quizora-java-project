import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Java_Q5 extends JFrame implements ItemListener,ActionListener{

	private JPanel contentPane;
	private JRadioButton radio1,radio2,radio3,radio4;
	private ButtonGroup bb;
	private JButton button;
	private JButton btnNewButton;

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Java_Q5 frame = new Java_Q5();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Java_Q5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q5 - What is currentThread()?");
		lblNewLabel.setBounds(190, 62, 311, 26);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) It is a Thread public static method used to obtain a reference to the current thread.");
		radio1.setBounds(115, 144, 520, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) It is a thread's instance method used to get thread count.");
		radio2.setBounds(115, 188, 476, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) It is a object's public static method used obtain a reference to the current thread.");
		radio3.setBounds(115, 232, 520, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) It is a object's instance method used to get thread count.");
		radio4.setBounds(115, 276, 476, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(305, 354, 85, 31);
		contentPane.add(button);
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
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(radio1.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		else if(radio2.isSelected() || radio3.isSelected() || radio4.isSelected()){
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
