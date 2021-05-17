import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Python_Q4 extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private JRadioButton radio1,radio2,radio3,radio4;
	private ButtonGroup bb;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Python_Q4 frame = new Python_Q4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Python_Q4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 8 - Which event among them is fired when the right mouse button is released?");
		lblNewLabel.setBounds(28, 66, 723, 32);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) <ButtonReleased>");
		radio1.setBounds(280, 146, 155, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) <ButtonPressed>");
		radio2.setBounds(280, 193, 155, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) <ButtonReleased-3>");
		radio3.setBounds(280, 238, 167, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) <ButtonPressed-3>");
		radio4.setBounds(280, 285, 167, 21);
		contentPane.add(radio4);
		
		JButton button = new JButton("Next");
		button.setBounds(298, 367, 85, 32);
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
		if(radio3.isSelected()) {
			if(Index.flag==0) {
			Index.marks+=5;
			Index.flag=1;
			}
		}	
		if(radio1.isSelected() || radio2.isSelected() || radio4.isSelected()){
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
		new Python_Q5().main();
		dispose();
		}
	}
}