package hrmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername ;
    private JPasswordField tfpassword;
    private JButton button,button2, login ;
    private JFrame frame ;
    
    public Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Font font = new Font("timesnewroman",Font.BOLD,20) ;
        
        JLabel label =  new JLabel("HR MANAGEMENT SYSTEM") ;
        label.setBounds(150,30,300,30) ;
        label.setBackground(Color.black);
        label.setFont(font) ;
        add(label) ;
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 160, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 160, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 200, 100, 30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 200, 150, 30);
        add(tfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(40, 250, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this) ;
        add(login);
        
        button = new JButton("Forget Password") ;
        button.setBounds(180,250,120,30) ;
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this) ;
        add(button) ;
        
        button2 = new JButton("Register") ;
        button2.setBounds(360,250,150,30) ;
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this) ;
        add(button2);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 90, 200, 200);
        add(image);
        
        JButton button = new JButton("Design and developed by Susovit Bidari") ;
        button.setBackground(Color.white) ;
        button.setBounds(310,340,270,20) ;
        add(button) ;
        button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                {
                    try
                {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/susovit.bidari")) ;
                }
                catch(Exception e)
                {
                    System.out.println(e) ;
                }
                }
                }) ;
        
        setSize(600, 400);
        setLocation(450, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == button)
        {
          forgetPassword sc = new forgetPassword() ;  
        }
        if(ae.getSource() == login)
        {
         try
         {
             conn scc = new conn() ;
             String queryy = "select * from login" ;
             PreparedStatement stmts = scc.c.prepareStatement(queryy) ;
             ResultSet rss = stmts.executeQuery() ;
             while(rss.next())
             {
                 String check = tfusername.getText() ;
                 String check2 = String.valueOf(tfpassword.getText()) ;
                 String username = rss.getString(1) ;
                 String password = rss.getString(2) ;
                 if((username.equals(check)) && (password.equals(check2)))
                 {
                     System.out.println(username);
                     Home sccc = new Home() ;
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(frame,"Wrong username and password") ;
                     tfusername.setText("");
                     tfpassword.setText("") ;
                 }
             }
         }
         catch(Exception e)
         {
             System.out.println(e) ;
         }
        }
        if(ae.getSource() == button2)
        {
            Register reg = new Register() ;
        }
    }
    public static void main(String[] args) {
        Login sc = new Login();
    }
}
