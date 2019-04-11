package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.WebDriver;

import testDashboard.TestEditPost;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NumberPost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public static void NumberPost(WebDriver dr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberPost frame = new NumberPost(dr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public NumberPost(WebDriver dr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What number of posts you want to edit?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 47, 302, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(125, 97, 164, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=Integer.parseInt(textField.getText());
				TestEditPost.brPosta=n;
				GuiEdit edit= new GuiEdit(dr);
				edit.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(161, 147, 82, 44);
		contentPane.add(btnNewButton);
	}
}
