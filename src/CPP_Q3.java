import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CPP_Q3 extends JFrame implements ActionListener,ItemListener{

	private JPanel contentPane;
	private ButtonGroup bb;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
	private JTextArea textarea;
	private Timer t;
	private int time = 30;
	private String[] str= {"#include<iostream>\r\n" + 
			"\r\n" + 
			"using namespace std;\r\n" + 
			"main() { \r\n" + 
			"\r\n" + 
			"   int i = 1, j = 2, k = 3, r; \r\n" + 
			"\r\n" + 
			"   r = (i, j, k);\r\n" + 
			"\r\n" + 
			"   cout<<r<<endl;\r\n" + 
			"\r\n" + 
			"}"};
	private JLabel lblNewLabel_1;
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPP_Q3 frame = new CPP_Q3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CPP_Q3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 3 - What is the output of the following program?");
		lblNewLabel.setBounds(153, 58, 436, 23);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) 1");
		radio1.setBounds(228, 300, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) 2");
		radio2.setBounds(228, 332, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) 3");
		radio3.setBounds(228, 365, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) Compiler Error");
		radio4.setBounds(228, 396, 116, 21);
		contentPane.add(radio4);
		
		button = new JButton("Submit");
		button.setBounds(356, 507, 85, 21);
		contentPane.add(button);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(228, 91, 189, 191);
		for(int i=0;i<str.length;i++)
			textArea.setText(str[i]);
		textArea.setEditable(false);
		contentPane.add(textArea);
		
		lblNewLabel_1 = new JLabel(Integer.toString(time));
		lblNewLabel_1.setFont(new Font("Broadway", Font.BOLD, 25));
		lblNewLabel_1.setBounds(722, 480, 66, 72);
		contentPane.add(lblNewLabel_1);
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time--;
				lblNewLabel_1.setText(Integer.toString(time));
				if(time==0) {					
					t.stop();
					if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected()))
						Index.marks+=0;
					CPP_Q4.main();
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
		t.stop();
		CPP_Q4.main();
		dispose();
		}
	}
}
