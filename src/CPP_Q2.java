import java.awt.BorderLayout;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CPP_Q2 extends JFrame implements ItemListener,ActionListener {

	private JPanel contentPane;
	private ButtonGroup bb;
	private JRadioButton radio1,radio2,radio3,radio4;
	private JButton button;
	private JLabel lblNewLabel_1;
	private Timer t;
	private int time = 30;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPP_Q2 frame = new CPP_Q2();
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
	public CPP_Q2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Q 2 - Which operator is required to be overloaded as member function only?");
		lblNewLabel.setBounds(123, 86, 513, 25);
		lblNewLabel.setFont(new Font("Calibri",Font.BOLD,20));
		contentPane.add(lblNewLabel);
		
		radio1 = new JRadioButton("A) _");
		radio1.setBounds(279, 136, 103, 21);
		contentPane.add(radio1);
		
		radio2 = new JRadioButton("B) _ _");
		radio2.setBounds(279, 178, 103, 21);
		contentPane.add(radio2);
		
		radio3 = new JRadioButton("C) ++ (Postfix version)");
		radio3.setBounds(279, 222, 129, 21);
		contentPane.add(radio3);
		
		radio4 = new JRadioButton("D) =");
		radio4.setBounds(279, 264, 103, 21);
		contentPane.add(radio4);
		
		JButton button = new JButton("Submit");
		button.setBounds(297, 337, 85, 21);
		contentPane.add(button);
		bb = new ButtonGroup();
		bb.add(radio1);
		bb.add(radio2);
		bb.add(radio3);
		bb.add(radio4);
		
		lblNewLabel_1 = new JLabel(Integer.toString(time));
		lblNewLabel_1.setFont(new Font("Broadway", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(666, 341, 69, 78);
		contentPane.add(lblNewLabel_1);
		t = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time--;
				lblNewLabel_1.setText(Integer.toString(time));
				if(time==0) {					
					t.stop();
					if(!(radio1.isSelected()||radio2.isSelected()||radio3.isSelected()||radio4.isSelected()))
						Index.marks+=0;
					CPP_Q3.main();
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
		if(radio2.isSelected() || radio3.isSelected() || radio1.isSelected()){
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
		CPP_Q3.main();
		dispose();
		}
	}
}
