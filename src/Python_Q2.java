import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Python_Q2 extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
    private ButtonGroup bb;
    private JTextField txtabFor;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Python_Q2 frame = new Python_Q2();
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
	public Python_Q2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 2 - What is the output of following code \u2212");
		lblNewLabel.setBounds(87, 61, 385, 26);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		txtabFor = new JTextField();
		txtabFor.setText("[ (a,b) for a in range(3) for b in range(a) ]");
		txtabFor.setBounds(132, 97, 222, 26);
		txtabFor.setEditable(false);
		contentPane.add(txtabFor);
		txtabFor.setColumns(10);
		
		radio1 = new JRadioButton("A) [(1,0),(2,1),(3,2)]");
		radio1.setBounds(233, 137, 146, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) [(0,0),(1,1),(2,2)]");
		radio2.setBounds(233, 182, 146, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) [(1,0),(2,1),(2,1)]");
		radio3.setBounds(233, 227, 146, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) [(1,0),(2,0),(2,1)]");
		radio4.setBounds(233, 278, 146, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
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
		new Python_Q3().main();
		dispose();
		}
	}
}
