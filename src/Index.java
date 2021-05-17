import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JButton button1;
	public static int marks=0;
	public static int flag=0;
	private String str=null;
	Instruct obj;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200,230,201));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(67,160,71));
		comboBox.setForeground(new Color(200,230,201));
		comboBox.addItem("C Language");
		comboBox.addItem("C++");
		comboBox.addItem("Java");
		comboBox.addItem("Python");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(314, 239, 115, 34);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox)e.getSource();
				str = (String)box.getSelectedItem();
			}
		});
		panel.add(comboBox);
		
		JLabel label1 = new JLabel("Select the Programming language for quiz from the below combobox and press 'Start Quiz' button");
		label1.setForeground(new Color(27,94,32));
		label1.setFont(new Font("Arial",Font.BOLD,15));
		label1.setBounds(21, 186, 739, 43);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Quizora");
		label2.setForeground(new Color(27,94,32));
		label2.setBounds(261, 36, 250, 50);
		label2.setFont(new Font("Broadway",Font.PLAIN,50));
		panel.add(label2);
		
		JLabel label3 = new JLabel("a prgramming Quiz desktop application");
		label3.setForeground(new Color(46,125,50));
		label3.setFont(new Font("Calibri",Font.PLAIN,12));
		label3.setBounds(303, 96, 227, 20);
		panel.add(label3);
		
	    button1 = new JButton("Start Quiz");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(str=="C Language") {
					new Instruct().main("C");
					dispose();
				}
				else if(str=="C++") {
					new Instruct().main("CPP");
					dispose();
				}
				else if(str=="Java") {
					new Instruct().main("Java");
					dispose();
				}
				else if(str=="Python") {
					new Instruct().main("Python");
					dispose();
				}
				else if(str==null) {
					JOptionPane.showMessageDialog(panel, "Make sure to select a programming language for starting the quiz","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button1.setBounds(477, 341, 115, 34);
		button1.setBackground(new Color(56,142,60));
		button1.setForeground(new Color(165,214,167));
		button1.setFont(new Font("Arial",Font.BOLD,15));
		panel.add(button1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
