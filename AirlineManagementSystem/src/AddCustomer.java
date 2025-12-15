package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// AddCustomer class handles adding new customer details
// GUI for customer registration with Swing components
public class AddCustomer extends JFrame implements ActionListener {

    // Text fields for input
    JTextField nameField, phoneField, aadharField, nationalityField, addressField;
    
    // Gender radio buttons
    JRadioButton maleRadio, femaleRadio;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Name
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 80, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);

        nameField = new JTextField();
        nameField.setBounds(220, 80, 150, 25);
        add(nameField);

        // Nationality
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 130, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);

        nationalityField = new JTextField();
        nationalityField.setBounds(220, 130, 150, 25);
        add(nationalityField);

        // Aadhar
        JLabel lblAadhar = new JLabel("Aadhar Number");
        lblAadhar.setBounds(60, 180, 150, 25);
        lblAadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAadhar);

        aadharField = new JTextField();
        aadharField.setBounds(220, 180, 150, 25);
        add(aadharField);

        // Address
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);

        addressField = new JTextField();
        addressField.setBounds(220, 230, 150, 25);
        add(addressField);

        // Gender
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);

        ButtonGroup genderGroup = new ButtonGroup();

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(220, 280, 70, 25);
        maleRadio.setBackground(Color.WHITE);
        add(maleRadio);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(300, 280, 70, 25);
        femaleRadio.setBackground(Color.WHITE);
        add(femaleRadio);

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Phone
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(60, 330, 150, 25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        phoneField = new JTextField();
        phoneField.setBounds(220, 330, 150, 25);
        add(phoneField);

        // Save button
        JButton saveButton = new JButton("SAVE");
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
        saveButton.setBounds(220, 380, 150, 30);
        saveButton.addActionListener(this);
        add(saveButton);

        // Image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(450, 80, 280, 400);
        add(lblImage);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String nationality = nationalityField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String aadhar = aadharField.getText();
        String gender = maleRadio.isSelected() ? "Male" : "Female";

        try {
            Conn conn = new Conn();
            String query = "INSERT INTO passenger VALUES('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}