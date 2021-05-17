import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.ActiveEvent;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Python_Q3 extends JFrame implements ActionListener,ItemListener {

	private JPanel contentPane;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
    private ButtonGroup bb;
    private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Python_Q3 frame = new Python_Q3();
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
	public Python_Q3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 3 - Select the option for following code \u2212");
		lblNewLabel.setBounds(116, 47, 419, 31);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(204, 88, 153, 132);
		contentPane.add(textArea);
		String str[]= {"s = 0\r\n" + 
				"for d in range(0, 5, 0.1):\r\n" + 
				"… s += d\r\n" + 
				"… print(s)"};
		for(int i=0;i<str.length;i++)
			textArea.setText(str[i]);
		textArea.setEditable(false);
		
		
		
		button = new JButton("Next");
		button.setBounds(252, 420, 85, 29);
		contentPane.add(button);
		radio1 = new JRadioButton("A)Syntax Error");
		radio1.setBounds(116, 246, 132, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) Type Error");
		radio2.setBounds(116, 289, 132, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) Runtime Error");
		radio3.setBounds(116, 327, 132, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) Both B & C");
		radio4.setBounds(116, 371, 132, 21);
		contentPane.add(radio4);
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
		new Python_Q4().main();
		dispose();
		}
	}
}
