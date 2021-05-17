import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;

public class Question4 extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	JRadioButton radio1,radio2,radio3,radio4;
	JButton button;
	ButtonGroup bb;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question4 frame = new Question4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Question4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 4 - Which of the following is used in mode string to open the file in binary mode?");
		lblNewLabel.setBounds(42, 87, 716, 25);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("a");
		radio1.setBounds(308, 153, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("b");
		radio2.setBounds(308, 193, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("B");
		radio3.setBounds(308, 231, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("bin");
		radio4.setBounds(308, 271, 103, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		bb = new ButtonGroup();
		button.setBounds(286, 341, 103, 31);
		contentPane.add(button);
		
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
			new Question5().main();
			dispose();
		}
	}
}
