package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.WebDriver;

import testDashboard.TestDashboard;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;

public class GuiMakePost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void GuiMakePost(WebDriver dr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMakePost frame = new GuiMakePost(dr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GuiMakePost(WebDriver dr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMakeAPost = new JLabel("Make a Post");
		lblMakeAPost.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMakeAPost.setBounds(132, 23, 173, 32);
		contentPane.add(lblMakeAPost);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(10, 85, 75, 26);
		contentPane.add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(98, 84, 251, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocation.setBounds(10, 132, 75, 26);
		contentPane.add(lblLocation);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 127, 251, 32);
		contentPane.add(textField_1);
		
		JLabel lblTransport = new JLabel("Transport");
		lblTransport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransport.setBounds(10, 184, 75, 26);
		contentPane.add(lblTransport);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Walk");
		comboBox.addItem("Car");
		comboBox.addItem("Motorbike");
		comboBox.addItem("Bicycle");
		comboBox.addItem("Bus");
		comboBox.setBounds(98, 189, 216, 20);
		contentPane.add(comboBox);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(10, 243, 92, 26);
		contentPane.add(lblDescription);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(98, 249, 307, 111);
		contentPane.add(editorPane);
		
		JButton btnNewButton = new JButton("POST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String location = textField_1.getText();
				String trens=comboBox.getSelectedItem().toString();
				String descrip = editorPane.getText();
				
				TestDashboard.insertOneDataInPost(dr, title, location, trens, descrip);
				dispose();
				GuiDeleteSomePosts del=new GuiDeleteSomePosts(dr);
				del.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(132, 381, 133, 53);
		contentPane.add(btnNewButton);
		
	}
}
