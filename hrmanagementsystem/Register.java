package hrmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword, number ;
    private JButton button,button2, update ;
    private JFrame frame ;
    
    public Register() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JLabel num = new JLabel("Number");
        num.setBounds(40, 120, 100, 30);
        add(num);
        
        number = new JTextField();
        number.setBounds(150, 120, 150, 30);
        add(number);
        
        update = new JButton("UPDATE");
        update.setBounds(150, 160, 150, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this) ;
        add(update);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == update)
        {
          try
          {
          conn sc = new conn() ;
          String query = "update login set username=?,password=?,number=?" ;
          PreparedStatement stmt = sc.c.prepareStatement(query) ;
          stmt.setString(1,String.valueOf(tfusername.getText()));
          stmt.setString(2,String.valueOf(tfpassword.getText())) ;
          stmt.setInt(3,Integer.parseInt(number.getText())) ;
          int i = stmt.executeUpdate() ;
          if(i>0)
          {
              JOptionPane.showMessageDialog(frame,"Updated Successfully");
              tfusername.setText("");
              tfpassword.setText("") ;
              number.setText("") ;
              
              
          }
          else
          {
             JOptionPane.showMessageDialog(frame,"Fail to Update"); 
             tfusername.setText("");
             tfpassword.setText("") ;
             number.setText("") ;
              
          }
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
        }
        
    }
    public static void main(String[] args) {
        Register sc = new Register();
    }
}
