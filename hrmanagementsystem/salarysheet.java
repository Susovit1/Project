package hrmanagementsystem ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;

public class salarysheet extends JFrame implements ActionListener
{
    private JFrame frame ;
    private JLabel  label1, label2, label3, label4, label5, total ;
    private JTextField field, field2, field3, field4 ;
    private JButton button, button2 ;
    private Font font ;
    private String name, empId, field22 ;
    private int salary ;
    
    public static void main(String[]args)
    {
        salarysheet sc = new salarysheet() ;
    }
    public salarysheet()
    {
        myFrame() ;
    }
    public void myFrame()
    {
       frame = new JFrame() ;
        setLayout(null) ;
        setSize(600,600) ;
        font = new Font("timesnewroman",Font.BOLD,35) ;
         
         label1 = new JLabel("Salary Sheet") ;
         label1.setBounds(180,50,250,60) ;
         label1.setFont(font) ;
         add(label1) ;
         
         field2 = new JTextField("Enter User Employ ID") ;
         field2.setBounds(205,150,150,30) ;
         add(field2) ;
         
         button = new JButton("Click") ;
         button.setBounds(205,200,150,30);
         button.setBackground(Color.black) ;
         button.setForeground(Color.white) ;
         add(button) ;
         button.addActionListener(this) ;
         
         field3 = new JTextField("Add Bonus") ;
         field3.setBounds(205,300,150,30) ;
         add(field3) ;
         
         field4 = new JTextField("Deduct Deduction") ;
         field4.setBounds(205,350,150,30) ;
         add(field4) ;
         
         button2 = new JButton("Result") ;
         button2.setBounds(205,400,150,30) ;
         button2.setBackground(Color.black) ;
         button2.setForeground(Color.white) ;
         add(button2) ;
         button2.addActionListener(this) ;
         
         // Hidden
         
         label2 = new JLabel("Name:") ;
         label2.setBounds(205,200,150,30) ;
         label2.setVisible(false) ;
         add(label2) ;
         
         label3 = new JLabel() ;
         label3.setBounds(300,200,150,30) ;
         label3.setVisible(false) ;
         add(label3) ;
         
         label4 = new JLabel("Salary") ;
         label4.setBounds(205,220,150,30) ;
         label4.setVisible(false) ;
         add(label4) ;
         
         label5 = new JLabel() ;
         label5.setBounds(300,220,150,30) ;
         label5.setVisible(false) ;
         add(label5) ;
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE) ;
        setVisible(true) ; 
        
        // Total
        
        total = new JLabel() ;
        total.setBounds(205,400,150,30) ;
        total.setVisible(false) ;
        add(total) ;
    }
    public void actionPerformed(ActionEvent ae)
    { conn sc = new conn() ;
        if(ae.getSource()==button)
        {
          try
          {   
              field22 = field2.getText() ;
              String query = "select * from employee where empId="+field22+"" ;
              PreparedStatement psmt = sc.c.prepareStatement(query) ;
              ResultSet rs = psmt.executeQuery() ;
              while(rs.next())
              {
                  name = rs.getString(2) ;
                  salary = rs.getInt(3) ;
              }
              button.setVisible(false) ;
              label2.setVisible(true) ;
              label3.setVisible(true) ;
              label4.setVisible(true) ;
              label5.setVisible(true) ;
              label3.setText(name) ;
              label5.setText(String.valueOf(salary)) ;
              
          }
          
          catch(Exception e)
          {
              System.out.println(e) ;
          }
        }
        if(ae.getSource()==button2)
        {
         int aaa = Integer.parseInt(field2.getText()) ;
         int bonus = Integer.parseInt(field3.getText()) ;
         int deduction = Integer.parseInt(field4.getText()) ;
         int netProfit = bonus - deduction ;
         int totals = salary + (netProfit) ;
         String totalss = String.valueOf(totals) ;
         total.setText(totalss) ;
         button2.setVisible(false) ;
         total.setVisible(true) ;
         try
         {
            String query2 = "update employee set salary="+totals+" where empId="+field22+"" ;
            PreparedStatement stmt2 = sc.c.prepareStatement(query2) ;
            long r = stmt2.executeUpdate() ;
            if(r>-1)
            {
                JOptionPane.showMessageDialog(null,"Succssfully Updated") ;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Fail To Update") ;
            }
         }
         catch(Exception e)
         {
             
         }
         
        }
    }
  
}