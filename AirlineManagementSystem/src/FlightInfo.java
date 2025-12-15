package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookFlight extends JFrame implements ActionListener {

    // Labels and text fields
    JLabel lblFlightNo, lblName, lblSeats;
    JTextField tfFlightNo, tfName, tfSeats;

    // Buttons
    JButton bookButton, cancelButton;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(250, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 28));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Flight Number
        lblFlightNo = new JLabel("Flight Number");
        lblFlightNo.setBounds(50, 100, 150, 25);
        add(lblFlightNo);

        tfFlightNo = new JTextField();
        tfFlightNo.setBounds(220, 100, 150, 25);
        add(tfFlightNo);

        // Passenger Name
        lblName = new JLabel("Passenger Name");
        lblName.setBounds(50, 150, 150, 25);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220, 150, 150, 25);
        add(tfName);

        // Number of Seats
        lblSeats = new JLabel("Seats");
        lblSeats.setBounds(50, 200, 150, 25);
        add(lblSeats);

        tfSeats = new JTextField();
        tfSeats.setBounds(220, 200, 150, 25);
        add(tfSeats);

        // Book Button
        bookButton = new JButton("BOOK");
        bookButton.setBounds(100, 300, 120, 30);
        bookButton.setBackground(Color.BLACK);
        bookButton.setForeground(Color.WHITE);
        bookButton.addActionListener(this);
        add(bookButton);

        // Cancel Button
        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(250, 300, 120, 30);
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(600, 450);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bookButton) {
            String flightNo = tfFlightNo.getText();
            String name = tfName.getText();
            String seats = tfSeats.getText();

            try {
                Conn conn = new Conn();

                // Check if flight exists
                String checkQuery = "SELECT * FROM flight WHERE flightno='" + flightNo + "'";
                ResultSet rs = conn.s.executeQuery(checkQuery);

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Invalid Flight Number!");
                    return;
                }

                // Insert booking details
                String insertQuery = "INSERT INTO bookings(flightno, passenger_name, seats) VALUES('" +
                        flightNo + "', '" + name + "', '" + seats + "')";
                conn.s.executeUpdate(insertQuery);

                JOptionPane.showMessageDialog(null, "Flight booked successfully!");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }
}