package Electricity;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class customer_details extends JFrame
{
    int i=0,j=0;
    JTable t1;
    String x[]={"name","meter_number","address","state","city","email","phone"};
    String y[][]=new String[20][7];
    customer_details()
    {
      
        setSize(1200,650);
        setLocation(100,100);
        try
        {
            connection obj=new connection();
            String q="select * from customer_info";
            ResultSet res=obj.stm.executeQuery(q);
            while(res.next())
            {
                y[i][j++]=res.getString("name");
                y[i][j++]=res.getString("meter_number");
                y[i][j++]=res.getString("address");
                y[i][j++]=res.getString("state");
                y[i][j++]=res.getString("city");
                y[i][j++]=res.getString("email");
                y[i][j++]=res.getString("phone");
                i++;
                j=0;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        t1=new JTable(y,x);
       
      JPanel  p1=new JPanel();
      setLayout(new BorderLayout());
    
       add(p1,BorderLayout.SOUTH);
        JScrollPane sp=new JScrollPane(t1);
        add(sp);
        
    }
   
    public static void main(String args[])
    {
        customer_details moni = new customer_details();
        moni.setVisible(true);
    }
}
