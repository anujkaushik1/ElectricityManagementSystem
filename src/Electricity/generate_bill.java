package Electricity;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class generate_bill extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton b1,b2;
    JTextArea t1;
    Choice c1,c2;
    JPanel p,p1;
    
    generate_bill()
    {
    	
        setSize(450,700);
        setLocation(20,20);
        p=new JPanel();
  
        p1=new JPanel();
        l1=new JLabel("meter no");
        l2=new JLabel("month");
      
        c1=new Choice();
        c1.add("1001");
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
       
        
        c2=new Choice();
        c2.add("january");
        c2.add("fabruary");
        c2.add("march");
        c2.add("april");
        c2.add("may");
        c2.add("june");
        c2.add("july");
        c2.add("august");
        c2.add("september");
        c2.add("octuber");
        c2.add("nubmber");
        c2.add("december");
        
        
        t1=new JTextArea(50,15);
       
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/show.png"));
        Image img2=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(img2);
        b2=new JButton("show",i4);
      
        setLayout(new BorderLayout());
        p.add(l1);
        p.add(c1);
        p.add(l2);
        
        p.add(c2);
        
        add(p,"North");
 
        p1.add(b2);
        add(p1,"South");
        add(t1);
       JScrollPane sp=new JScrollPane(t1);
       add(sp);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource()==b2)
        {
            String meterno=c1.getSelectedItem();
            String month=c2.getSelectedItem();
            t1.setText("\tReliance Power limited\nELRCTRICITY BILL FOR THE MONTH OF "+month+",2020\n\n");
            try
            {
                connection con=new connection();
                String q1="select * from customer_info where meter_number = '"+meterno+"'";
                ResultSet rset2=con.stm.executeQuery(q1);
                while(rset2.next())
                {
                    t1.append("\nname : "+rset2.getString("name"));
                    t1.append("\nmeter number : "+rset2.getString("meter_number"));
                    t1.append("\naddress : "+rset2.getString("address"));
                    t1.append("\nstate : "+rset2.getString("state"));
                    t1.append("\ncity : "+rset2.getString("city"));
                    t1.append("\nemail : "+rset2.getString("email"));
                    t1.append("\nphone : "+rset2.getString("phone"));
                }
                t1.append("\n---------------------------------------");
                String q2="select * from tax";
                ResultSet rset3=con.stm.executeQuery(q2);
                while(rset3.next())
                {
                    t1.append("\nmeter location : "+rset3.getString("meter_location"));
                    t1.append("\nmeter type : "+rset3.getString("meter_type"));
                    t1.append("\nphase code : "+rset3.getString("phase_code"));
                    t1.append("\nbill type : "+rset3.getString("bill_type"));
                    t1.append("\nday : "+rset3.getString("days"));
                    
                    t1.append("\n\n---------------------------------------");
                    t1.append("\nmeter rent : "+rset3.getString("meter_rent"));
                    t1.append("\nservice rent : "+rset3.getString("service_rent"));
                    t1.append("\ngst : "+rset3.getString("gst"));
                    t1.append("\nmcb rent : "+rset3.getString("mcb_rent"));
                }
                t1.append("\n");
                String q="select * from bill where meter_no = '"+meterno+"' and month='"+month+"'";
                ResultSet rset4=con.stm.executeQuery(q);
                while(rset4.next())
                {
                    t1.append("\nmeter no : "+rset4.getString("meter_no"));
                    t1.append("\nCurrent month : "+rset4.getString("month"));
                    t1.append("\nunits consumed : "+rset4.getString("units"));
                    t1.append("\nTotal charges : "+rset4.getString("amount"));
                    t1.append("\n\n---------------------------------------");
                    t1.append("\nTotal PAYBILL : "+rset4.getString("amount"));   
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
    }
    public static void main(String args[])
    {
    	generate_bill moni = new generate_bill();
    	moni.setVisible(true);
    }
}
