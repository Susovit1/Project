package hrmanagementsystem;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.sql.* ;

public class UpdateEmployee extends JFrame
{
    private JFrame frame ;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9 ;
    private JTextField field1, field2, field3,field4,field5,field6,field7,field8,field9 ;
    private JButton button, button2 ;
    
public static void main(String[]args)
{
UpdateEmployee obj = new UpdateEmployee() ;
 }
public UpdateEmployee()
{
    frame= new JFrame() ;
    setLayout(null) ;
    setSize(700,900) ;
    
    // Font Code
    Font font = new Font("serif", Font.PLAIN, 20);
    
    label1 = new JLabel("User ID") ;
    label1.setBounds(50,30,100,50) ;
    label1.setFont(font) ;
    add(label1) ;
    
    field1 = new JTextField() ;
    field1.setBounds(170,45,140,25) ;
    add(field1) ;
    
    label2 = new JLabel("Name") ;
    label2.setBounds(50,80,100,50) ;
    label2.setFont(font) ;
    add(label2) ;
    
    field2 = new JTextField() ;
    field2.setBounds(170,90,140,25) ;
    add(field2) ;
    
    label3 = new JLabel("First Name") ;
    label3.setBounds(50,130,100,50) ;
    label3.setFont(font) ;
    add(label3) ;
    
    field3 = new JTextField() ;
    field3.setBounds(170,140,140,25) ;
    add(field3) ;
    
    label4 = new JLabel("Salary") ;
    label4.setBounds(50,180,100,50) ;
    label4.setFont(font) ;
    add(label4) ;
    
    field4 = new JTextField() ;
    field4.setBounds(170,190,140,25) ;
    add(field4) ;
    
    label5 = new JLabel("Address") ;
    label5.setBounds(50,230,100,50) ;
    label5.setFont(font) ;
    add(label5) ;
    
    field5 = new JTextField() ;
    field5.setBounds(170,240,140,25) ;
    add(field5) ;
    
    label6 = new JLabel("Phone") ;
    label6.setBounds(50,280,100,50) ;
    label6.setFont(font) ;
    add(label6) ;
    
    field6 = new JTextField() ;
    field6.setBounds(170,290,140,25) ;
    add(field6) ;
    
    label7 = new JLabel("Email") ;
    label7.setBounds(50,330,100,50) ;
    label7.setFont(font) ;
    add(label7) ;
    
    field7 = new JTextField() ;
    field7.setBounds(170,340,140,25) ;
    add(field7) ;
    
    label8 = new JLabel("Education") ;
    label8.setBounds(50,380,100,50) ;
    label8.setFont(font) ;
    add(label8) ;
    
    field8 = new JTextField() ;
    field8.setBounds(170,390,140,25) ;
    add(field8) ;
    
    label9 = new JLabel("Designation") ;
    label9.setBounds(50,430,100,50) ;
    label9.setFont(font) ;
    add(label9) ;
    
    field9 = new JTextField() ;
    field9.setBounds(170,440,140,25) ;
    add(field9) ;
    
    button = new JButton("Click Here") ;
    button.setBounds(110,490,100,30) ;
    add(button) ;
    
    button2 = new JButton("Back") ;
    button2.setBounds(110,540,100,30);
    add(button2);
    button.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
           // JOptionPane.showMessageDialog(frame,"You pressed") ;
            try{
    conn obj = new conn() ;
    String query = "update employee set name=?,salary=?,address=?,phone=?,email=?,education=?,designation=? where empId=? " ;
    PreparedStatement stmt = obj.c.prepareStatement(query) ;
    stmt.setString(1,field2.getText()) ;
    stmt.setString(2,field3.getText()) ;
    stmt.setString(3,field4.getText()) ;
    stmt.setString(4,field5.getText()) ;
    stmt.setString(5,field6.getText()) ;
    stmt.setString(6,field7.getText()) ;
    stmt.setString(7,field8.getText()) ;
    stmt.setString(8,field1.getText()) ;
    
    
    int i = stmt.executeUpdate() ;
    if(i>0)
    {
        JOptionPane.showMessageDialog(frame,"Successfully Updated") ;
        
    }
    else
    {
        JOptionPane.showMessageDialog(frame,"Fail to Update") ;
    }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
        }
    }) ;
    button2.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
           Home sc = new Home() ;
           dispose() ;
            
        }
    }) ;
    
    
    setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    setVisible(true) ;
}
}