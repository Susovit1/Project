package hrmanagementsystem;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;

public class forgetPassword extends JFrame
{
    private JFrame frame ;
    private JTextField field ;
    private JButton button ;
    
    public static void main(String[]args)
    {
        forgetPassword sc = new forgetPassword() ;
    }
    public forgetPassword()
    {
        frame = new JFrame() ;
        setLayout(null) ;
        setSize(600,300) ;
        
        field = new JTextField("Enter Your Number Here") ;
        field.setBounds(220,50,150,40) ;
        add(field) ;
        
        button = new JButton("Click") ;
        button.setBounds(245,100,100,20) ;
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button) ;
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///hrmanagementsystem", "root", "");
            String query = "select * from login" ;
            PreparedStatement psmt = c.prepareStatement(query) ;
            ResultSet rs = psmt.executeQuery() ;
            int num = Integer.parseInt(field.getText()) ;
            while(rs.next())
            {
                int value = Integer.parseInt(rs.getString(3)) ;
                String value2 = rs.getString(2) ;
                
                if(num == value)
                {
                    JOptionPane.showMessageDialog(frame,"Your Password Is "+value2) ;
                    field.setText("") ;
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Sorry, Incorrect Number") ;
                    field.setText("") ;
                }
            }
                }
                catch(Exception e)
                {
                   System.out.println(e) ; 
                }
            }
        }) ;
        
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE) ;
        setVisible(true) ;
        
        
    }
}
