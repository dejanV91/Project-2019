package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.WebDriver;

import testDashboard.TestDeletePosts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class GuiDeleteSomePosts extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void GuiDeleteSomePosts(WebDriver dr, int noPost, int postIndex) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDeleteSomePosts frame = new GuiDeleteSomePosts(dr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiDeleteSomePosts(WebDriver dr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete Posts");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(78, 11, 149, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("How much you want delete?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 75, 198, 19);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(20, 105, 188, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblWhatPostYou = new JLabel("What post you want (insert number):");
		lblWhatPostYou.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWhatPostYou.setBounds(10, 151, 271, 19);
		contentPane.add(lblWhatPostYou);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 181, 188, 26);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int much = Integer.parseInt(textField.getText());
				int index = Integer.parseInt(textField_1.getText());
				
				for (int i = 0; i < much; i++) {
					
					TestDeletePosts.deleteSomePost(dr, index);
					JOptionPane.showMessageDialog(GuiRegistration.frame, "Delete post "+(i+1));
					
					
				}
				NumberPost number=new NumberPost(dr);
				number.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(114, 239, 78, 35);
		contentPane.add(btnNewButton);
	}

}
