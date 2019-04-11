package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestsDocumentImpl.TestsImpl;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObjects;
import testHomePage.TestLogIn;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiLogIn extends JFrame {
	private JTextField textField;
	private JPasswordField textField_1;

	public static void GuiLog(WebDriver dr){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogIn frame = new GuiLogIn(dr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GuiLogIn(WebDriver dr) {
	
		
		setBounds(100, 100, 450, 457);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User LogIn");
		lblUserLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserLogin.setBounds(150, 46, 110, 35);
		getContentPane().add(lblUserLogin);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 118, 119, 35);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(134, 113, 274, 48);
		getContentPane().add(textField);
		textField.setColumns(30);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(34, 202, 119, 35);
		getContentPane().add(lblPassword);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(30);
		textField_1.setBounds(134, 197, 274, 48);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName,pass;
				userName=textField.getText();
				pass=textField_1.getText();
				TestLogIn.insertOneDataLog(dr, userName, pass);
				if (dr.getCurrentUrl().equals(TestLogIn.URL_NO_LOG)) {
					JOptionPane.showMessageDialog(GuiRegistration.frame,"Unsuccessful log in","FAILD LOG IN", JOptionPane.WARNING_MESSAGE);
					HomePageObjects.navigateHome(dr);
				} else {
					JOptionPane.showMessageDialog(GuiRegistration.frame,"Successful log in" );
					dispose();
					GuiMakePost guiPost=new GuiMakePost(dr);
					guiPost.setVisible(true);
					
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(134, 304, 154, 57);
		getContentPane().add(btnNewButton);

	}

}
