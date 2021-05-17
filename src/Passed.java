import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class Passed extends JFrame {

	private JPanel contentPane;
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passed frame = new Passed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Passed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200,230,201));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Congratulations");
		label1.setForeground(new Color(39,174,96));
		label1.setFont(new Font("Snap ITC",Font.BOLD,50));
		label1.setBounds(117, 87, 573, 63);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("you passed....Hurray");
		label1.setForeground(new Color(46,204,113));
		label2.setFont(new Font("Snap ITC",Font.BOLD,35));
		label2.setBounds(210, 160, 480, 63);
		contentPane.add(label2);
		
		if(Index.marks<15) {
			label1.setText("Oops...you Failed");
			label1.setForeground(new Color(192,57,43));
			label2.setText("Better luck next time");
			label2.setForeground(new Color(231,76,60));
		}
		
		JLabel lblNewLabel_1 = new JLabel("Your Score");                     // score label
		lblNewLabel_1.setFont(new Font("Broadway",Font.BOLD,30));
		lblNewLabel_1.setBounds(506, 353, 184, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel(""+Index.marks);                           // marks label
		label.setBounds(582, 402, 57, 63);
		label.setFont(new Font("Broadway",Font.BOLD,40));
		contentPane.add(label);
		
		JButton button = new JButton("HOME");
		button.setBounds(309, 353, 85, 39);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
					// Home button event
			}
		});
	}
}
