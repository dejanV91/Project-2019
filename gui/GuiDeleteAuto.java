package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.WebDriver;

import testDashboard.TestDeletePosts;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiDeleteAuto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static void GuiDeleteAuto(WebDriver dr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDeleteAuto frame = new GuiDeleteAuto(dr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiDeleteAuto(WebDriver dr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete posts");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 23, 146, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("How much you want delete?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 82, 195, 25);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(10, 118, 159, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(textField.getText());
				TestDeletePosts.deletePost(dr, a);
				dispose();
			}
		});
		btnNewButton.setBounds(192, 118, 73, 30);
		contentPane.add(btnNewButton);
	}
}
