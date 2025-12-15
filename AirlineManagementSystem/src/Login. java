package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    // Buttons
    JButton submitButton, resetButton, closeButton;
    
    // Text fields
    JTextField userField;
    JPasswordField passField;
    
    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Username label and text field
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20, 20, 100, 20);
        add(lblUsername);
        
        userField = new JTextField();
        userField.setBounds(130, 20, 200, 20);
        add(userField);
        
        // Password label and password field
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(20, 60, 100, 20);
        add(lblPassword);
        
        passField = new JPasswordField();
        passField.setBounds(130, 60, 200, 20);
        add(passField);
        
        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(40, 120, 120, 20);
        resetButton.addActionListener(this);
        add(resetButton);
        
        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(190, 120, 120, 20);
        submitButton.addActionListener(this);
        add(submitButton);
        
        // Close button
        closeButton = new JButton("Close");
        closeButton.setBounds(120, 160, 120, 20);
        closeButton.addActionListener(this);
        add(closeButton);
        
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username='"+username+"' AND password='"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == closeButton) {
            setVisible(false);
        } else if (ae.getSource() == resetButton) {
            userField.setText("");
            passField.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}