package hrmanagementsystem ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils;
public class attendance extends JFrame
{
    private JFrame frame ;
    private JTextField myField ;
    private JButton button, allpresent, somepresent ;
    private JTable table ;
    private int first, second, id ;
    private PreparedStatement psmt3,psmt4 ;
    public static void main(String[]args)
    {
     attendance sc = new attendance() ;
    }
    public attendance()
    {
        frame() ;
        other() ;
    }
    public void frame()
    {
        frame = new JFrame() ;
        setLayout(null) ;
        setSize(600,600) ;
        setBackground(Color.yellow) ;
        setDefaultCloseOperation(frame.EXIT_ON_CLOSE) ; 
        setVisible(true) ;
    }
    public void other()
    { 
        allpresent = new JButton("Click to Attend All") ;
        allpresent.setBounds(200,100,200,30);
        allpresent.setBackground(Color.white) ;
        allpresent.setForeground(Color.black) ;
        add(allpresent) ;
        allpresent.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {   conn sc = new conn() ;
                try
                {
                        String query = "update employee set attendance=attendance+1 " ;
                        PreparedStatement psmt = sc.c.prepareStatement(query) ;
                        psmt.executeUpdate() ;
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                        JOptionPane.showMessageDialog(null,"Successfully Attendance") ;
                        dispose() ;
                        attendance scc = new attendance() ;
            }
        }) ;
        
        somepresent = new JButton("For Some Employ") ;
        somepresent.setBounds(200,150,200,30);
        somepresent.setBackground(Color.white) ;
        somepresent.setForeground(Color.black) ;
        add(somepresent) ;
        somepresent.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
             somepresent.setVisible(false) ;
             myField.setVisible(true) ;
            }
        }) ;
        
        myField = new JTextField("Mention Absent ID") ;
        myField.setBounds(200,150,200,30) ;
        add(myField) ;
        myField.setVisible(false) ;
        myField.addKeyListener(new KeyAdapter()
        {
         @Override
         public void keyPressed (KeyEvent ae)
         {
             if(ae.getKeyCode() == KeyEvent.VK_ENTER)
             {
                  conn scc = new conn() ;
                try
                {       int myFieldd = Integer.parseInt(myField.getText()) ;
                        String query2 = "update employee set attendance=attendance-1 where empId="+myFieldd+" " ;
                        PreparedStatement psmt2 = scc.c.prepareStatement(query2) ;
                        psmt2.executeUpdate() ;
                }
                catch(Exception ee)
                {
                    System.out.println(ee);
                }
                
                dispose() ;
                attendance atten = new attendance() ;
             }
             
         }
        }) ;
        
        
        table = new JTable() ;
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(40, 200, 500, 200);
        add(jsp);
        try
    {
        conn sc = new conn() ;
        String query = "select * from employee" ;
        PreparedStatement stmt = sc.c.prepareStatement(query) ;
        ResultSet rs = stmt.executeQuery() ;
        table.setModel(DbUtils.resultSetToTableModel(rs)) ;
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
        
        
        
    }
}
