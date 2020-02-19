package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Add / Remove Class");
		btnNewButton.setBounds(42, 98, 141, 39);
		
		JLabel lblNewLabel = new JLabel("Teacher Assistant");
		lblNewLabel.setBounds(201, 32, 152, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton button = new JButton("Add / Remove Student");
		button.setBounds(201, 98, 141, 39);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setBounds(360, 98, 141, 39);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnNewButton);
		contentPane.add(button);
		contentPane.add(btnAttendance);
		
		JButton btnGrades = new JButton("Grades");
		btnGrades.setBounds(42, 167, 141, 39);
		contentPane.add(btnGrades);
		
		JButton btnSeatingChart = new JButton("Seating Chart");
		btnSeatingChart.setBounds(201, 167, 141, 39);
		contentPane.add(btnSeatingChart);
		
		JButton btnLogBehavior = new JButton("Log Behavior");
		btnLogBehavior.setBounds(360, 167, 141, 39);
		contentPane.add(btnLogBehavior);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(201, 232, 141, 39);
		contentPane.add(btnLogout);
	}
}
