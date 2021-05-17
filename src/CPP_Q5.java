import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CPP_Q5 extends JFrame implements ActionListener,ItemListener{

	private Timer t;
	private int time = 30;
	private JPanel contentPane;
	private ButtonGroup bb;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
	private JLabel lblNewLabel_1;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPP_Q5 frame = new CPP_Q5();
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
	public CPP_Q5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 5 - What is the output of the following program?");
		lblNewLabel.setBounds(135, 53, 366, 27);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(194, 90, 148, 166);
		String str[]= {"#include<iostream>\r\n" + 
				"\r\n" + 
				"using namespace std;\r\n" + 
				"main() { \r\n" + 
				"   int *p = new int; \r\n" + 
				"   delete p; \r\n" + 
				"   delete p; \r\n" + 
				"   cout<<\"Done\";\r\n" + 
				"}"};
	    for(int i=0;i<str.length;i++)
	    	textArea.setText(str[i]);
	    textArea.setEditable(false);
		contentPane.add(textArea);
		
		radio1 = new JRadioButton("A) Done");
		radio1.setBounds(135, 283, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) Compiletime Error");
		radio2.setBounds(135, 317, 124, 21);
		contentPane.add(radio2);
		
	    radio3 = new JRadioButton("C) Runtime Error");
		radio3.setBounds(135, 350, 103, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) None of the above");
		radio4.setBounds(135, 384, 109, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(278, 440, 85, 27);
		contentPane.add(button);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		lblNewLabel_1 = new JLabel(Integer.toString(time));
		lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(601, 447, 63, 78);
		contentPane.add(lblNewLabel_1);
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time--;
				lblNewLabel_1.setText(Integer.toString(time));
				if(time==0) {					
					t.stop();
					if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected()))
						Index.marks+=0;
					new Passed().main();
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
		new Passed().main();
		dispose();
		}
	}	
}
