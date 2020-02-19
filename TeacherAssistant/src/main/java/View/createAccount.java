package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class createAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAccount frame = new createAccount();
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
	public createAccount() {
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(91, 53, 53, 14);
		
		textField = new JTextField();
		textField.setBounds(172, 50, 169, 20);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(172, 188, 107, 23);
		contentPane.setLayout(null);
		contentPane.add(lblFirstName);
		contentPane.add(textField);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 78, 169, 20);
		contentPane.add(textField_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(91, 81, 53, 14);
		contentPane.add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 137, 169, 20);
		contentPane.add(textField_2);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(91, 140, 53, 14);
		contentPane.add(lblPassword);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(91, 112, 53, 14);
		contentPane.add(lblUsername);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 109, 169, 20);
		contentPane.add(textField_3);
	}
}
