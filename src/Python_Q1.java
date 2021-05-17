import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Python_Q1 extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
    private ButtonGroup bb;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Python_Q1 frame = new Python_Q1();
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
	public Python_Q1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String str="<html>Q 1 - What is output of \u2212 <br>33 == 33.0</html>";
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setBounds(176, 59, 226, 43);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.setBackground(new Color(200,230,201));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) False");
		radio1.setBounds(233, 137, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) True");
		radio2.setBounds(233, 182, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) 33");
		radio3.setBounds(233, 227, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) None of the above");
		radio4.setBounds(233, 278, 146, 21);
		contentPane.add(radio4);
		
		button = new JButton("New button");
		button.setBounds(251, 348, 85, 29);
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
		
		if(radio2.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio1.isSelected() || radio4.isSelected() || radio3.isSelected()){
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
		new Python_Q2().main();
		dispose();
		}
	}
}
