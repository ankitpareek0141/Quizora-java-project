import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instruct extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton button;
	static String str; 
	public static void main(String str) {
		Instruct.str = str;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instruct frame = new Instruct();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Instruct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(200,230,201));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("* Instructions *");
		lblNewLabel.setForeground(new Color(27,94,32));
		lblNewLabel.setFont(new Font("Broadway",Font.BOLD,30));
		lblNewLabel.setBounds(304, 39, 252, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("* 1. The Quiz contains 5 questions. ");
		lblNewLabel_1.setForeground(new Color(27,94,32));
		lblNewLabel_1.setBounds(221, 118, 357, 35);
		lblNewLabel_1.setFont(new Font("Century",Font.PLAIN,20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("* 2. Each question contains 5 marks.");
		lblNewLabel_2.setForeground(new Color(27,94,32));
		lblNewLabel_2.setBounds(221, 163, 357, 35);
		lblNewLabel_2.setFont(new Font("Century",Font.PLAIN,20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>* 4. If you score more than 50% then <br/>you'll Pass or Fail if score less then 50%</html>");
		lblNewLabel_3.setForeground(new Color(27,94,32));
		lblNewLabel_3.setBounds(221, 344, 417, 50);
		lblNewLabel_3.setFont(new Font("Century",Font.PLAIN,20));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html>* 5. Press on 'Got it' button if you are <br/>satisfied with the instructions</html>");
		lblNewLabel_4.setForeground(new Color(27,94,32));
		lblNewLabel_4.setBounds(222, 418, 416, 50);
		lblNewLabel_4.setFont(new Font("Century",Font.PLAIN,20));
		contentPane.add(lblNewLabel_4);
		
		button = new JButton("Got it");
		button.addActionListener(this);
		button.setBackground(new Color(56,142,60));
		button.setForeground(new Color(165,214,167));
		button.setBounds(378, 544, 94, 29);
		contentPane.add(button);
		
		JLabel lblNewLabel_5 = new JLabel("<html>* 3. For each quietion you will be given 30 seconds to <br/>select the answer, if you haven't click on \"Submit\" button then the answer will be auto submitted weather <br/>the option will be selected or not</html>");
		lblNewLabel_5.setBounds(221, 214, 521, 111);
		lblNewLabel_5.setFont(new Font("Century",Font.PLAIN,20));
		lblNewLabel_5.setForeground(new Color(27,94,32));
		contentPane.add(lblNewLabel_5);
	}
		public void actionPerformed(ActionEvent e) {
			if(Instruct.str.equals("C")) {
				new Question1().main();
				dispose();
			}
			else if(Instruct.str.equals("CPP")) {
				new CPP_Q1().main();
				dispose();
			}
			else if(Instruct.str.equals("Java")) {
				new Java_Q1().main();
				dispose();
			}
			else if(Instruct.str.equals("Python")) {
				new Python_Q1().main();
				dispose();
			}
		}
}
