import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Python_Q5 extends JFrame implements ActionListener,ItemListener{

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
					Python_Q5 frame = new Python_Q5();
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
	public Python_Q5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 5 - Find the output of the code?");
		lblNewLabel.setBounds(163, 48, 346, 24);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(212, 96, 194, 92);
		String str[]= {"def f(a, b = 1, c = 2):\r\n" + 
				"   print('a is: ',a, 'b is: ', b, 'c is: ', c)\r\n" + 
				"f(2, c = 2)\r\n" + 
				"f(c = 100, a = 110)"};
		for(int i=0;i<str.length;i++)
			textArea.setText(str[i]);
		textArea.setEditable(false);	
		
		contentPane.add(textArea);
		
		radio1 = new JRadioButton("<html> a is: 2 b is: 1 c is: 2 <br>a is: 110 b is: 1 c is: 100</html>");
		radio1.setBounds(163, 259, 184, 41);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("<html>a is: 2 b is: 2 c is: 2<br>a is: 110 b is: 2 c is: 100</html>");
		radio2.setBounds(163, 319, 184, 41);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("<html>a is: 0 b is: 2 c is: 2<br> a is: 110 b is: 0 c is: 100</html>");
		radio3.setBounds(163, 376, 184, 41);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("<html>a is: 110 b is: 0 c is: 100<br>a is: 110 b is: 0 c is: 100</html>");
		radio4.setBounds(163, 432, 184, 41);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(262, 507, 85, 29);
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
		if(radio4.isSelected() || radio2.isSelected() || radio3.isSelected()){
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
