package hrmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999);
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton add, back;
    private final String dateandtime ;
    
    public AddEmployee() {
        // DATE
       LocalDate date = LocalDate.now() ;
       dateandtime = String.valueOf(date) ;
       // LocalTime time = LocalTime.now() ;
       // System.out.println(date) ;
       // System.out.println(time) ;
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Username");
        labelname.setBounds(50, 250, 150, 30) ;
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 250, 150, 30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Age ");
        labelfname.setBounds(400, 250, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 250, 150, 30);
        add(tffname);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 300, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 300, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 400, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 400, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 350, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 350, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 400, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 400, 150, 30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation) ;
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 200, 150, 30) ;
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 200, 150, 30) ;
        lblempId.setFont(new Font("impact", Font.BOLD, 20));
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            // JOptionPane.showMessageDialog(null,"dada") ;
            String name = tfname.getText();
            int salary = Integer.parseInt(tfsalary.getText());
            String address = tfaddress.getText();
            int phone = Integer.parseInt(tfphone.getText());
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            int empId = Integer.parseInt(lblempId.getText());
            int attendance = 1 ;
            
            try {
                conn conn = new conn();
                String query = "insert into employee values('"+attendance+"','"+name+"','"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+empId+"','"+dateandtime+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                
                //
                Calendar cal = Calendar.getInstance() ;
                int date = cal.get(Calendar.HOUR_OF_DAY) ;
                int month = cal.get(Calendar.MINUTE) ;
                int day = cal.get(Calendar.SECOND) ;
                System.out.println(date);
                
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
