import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Java_Q2 extends JFrame implements ItemListener,ActionListener{

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
					Java_Q2 frame = new Java_Q2();
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
	public Java_Q2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q2 - What is the default value of int variable?");
		lblNewLabel.setBounds(116, 81, 437, 27);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) 0");
		radio1.setBounds(246, 164, 118, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) 0.0");
		radio2.setBounds(246, 202, 118, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) null");
		radio3.setBounds(246, 239, 118, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) Not defined");
		radio4.setBounds(246, 276, 118, 21);
		contentPane.add(radio4);
		
		button = new JButton("Next");
		button.setBounds(264, 364, 85, 33);
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
		else if(radio2.isSelected() || radio3.isSelected() || radio4.isSelected()){
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
		new Java_Q3().main();
		dispose();
		}
	}
}
