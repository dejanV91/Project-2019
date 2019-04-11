package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constant;
import pageObjects.HomePageObjects;
import testHomePage.TestLogIn;
import testHomePage.TestRegistration;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class GuiRegistration {

	public static JFrame frame;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	

	public static void GuiReg(WebDriver dr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegistration window = new GuiRegistration(dr);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiRegistration(WebDriver dr) {
		initialize(dr);
	}

	private void initialize(WebDriver dr) {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUserRegistration = new JLabel("User Registration");
		lblUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserRegistration.setBounds(128, 28, 164, 35);
		frame.getContentPane().add(lblUserRegistration);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(25, 95, 78, 28);
		frame.getContentPane().add(lblFirstName);

		textField = new JTextField();
		textField.setBounds(124, 94, 255, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(30);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(25, 143, 78, 28);
		frame.getContentPane().add(lblLastName);

		textField_1 = new JTextField();
		textField_1.setColumns(30);
		textField_1.setBounds(124, 142, 255, 33);
		frame.getContentPane().add(textField_1);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setBounds(25, 191, 78, 28);
		frame.getContentPane().add(lblUserName);

		textField_2 = new JTextField();
		textField_2.setColumns(30);
		textField_2.setBounds(124, 190, 255, 33);
		frame.getContentPane().add(textField_2);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(25, 248, 78, 28);
		frame.getContentPane().add(lblEmail);

		textField_3 = new JTextField();
		textField_3.setColumns(30);
		textField_3.setBounds(124, 243, 255, 33);
		frame.getContentPane().add(textField_3);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(25, 295, 78, 28);
		frame.getContentPane().add(lblPassword);

		textField_4 = new JTextField();
		textField_4.setColumns(30);
		textField_4.setBounds(124, 287, 255, 33);
		frame.getContentPane().add(textField_4);

		JButton btnNewButton = new JButton("Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first, last, user, email, pass;

				first = textField.getText();
				last = textField_1.getText();
				user = textField_2.getText();
				email = textField_3.getText();
				pass = textField_4.getText();

				TestRegistration.insertOneReg(dr, first, last, user, email, pass);

				// If the email is not a specific form, delete all datas from all fields
				Pattern sablon = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+(.+)[a-zA-Z]{2,6}$");
				Matcher m = sablon.matcher(email);
				if (!m.find()) {
					JOptionPane.showMessageDialog(frame, "Registraion incorrect", "WARNING",
							JOptionPane.WARNING_MESSAGE);
					HomePageObjects.getFrstName(dr).clear();
					HomePageObjects.getLastName(dr).clear();
					HomePageObjects.getUserName(dr).clear();
					HomePageObjects.getEmail(dr).clear();
					HomePageObjects.getPassword(dr).clear();
				} else {
					JOptionPane.showMessageDialog(frame, "Registration is correct");
					frame.dispose();
					GuiLogIn guiLog=new GuiLogIn(dr);
					guiLog.setVisible(true);
					
				}
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(128, 344, 151, 41);
		frame.getContentPane().add(btnNewButton);
	}
}
