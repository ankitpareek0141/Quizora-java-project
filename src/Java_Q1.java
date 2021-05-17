import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Java_Q1 extends JFrame implements ActionListener,ItemListener{

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
					Java_Q1 frame = new Java_Q1();
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
	public Java_Q1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 1 - What of the following is the default value of a local variable?");
		lblNewLabel.setBounds(71, 74, 590, 28);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) null");
		radio1.setBounds(259, 146, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) 0");
		radio2.setBounds(259, 180, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) Depends upon the types of variable");
		radio3.setBounds(259, 215, 293, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) Not assigned");
		radio4.setBounds(259, 250, 134, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(308, 335, 85, 36);
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
		else if(radio1.isSelected() || radio2.isSelected() || radio3.isSelected()){
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
		new Java_Q2().main();
		dispose();
		}
	}
}
