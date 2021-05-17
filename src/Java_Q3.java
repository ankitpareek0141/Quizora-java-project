import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Java_Q3 extends JFrame implements ItemListener,ActionListener{

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
					Java_Q3 frame = new Java_Q3();
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
	public Java_Q3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q3 - What is instance variable?");
		lblNewLabel.setBounds(234, 64, 311, 27);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) Instance variables are static variables within a class but outside any method.");
		radio1.setBounds(204, 155, 482, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) Instance variables are variables defined inside methods, constructors or blocks.");
		radio2.setBounds(204, 199, 507, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) Instance variables are variables within a class but outside any method.");
		radio3.setBounds(204, 241, 461, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) None of the above.");
		radio4.setBounds(204, 282, 291, 21);
		contentPane.add(radio4);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(320, 381, 85, 32);
		contentPane.add(button);
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
		else if(radio1.isSelected() || radio2.isSelected() || radio4.isSelected()){
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
		new Java_Q4().main();
		dispose();
		}
	}
}
