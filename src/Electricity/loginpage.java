package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
public class loginpage extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField t1;
	JButton b1,b2;
	JPanel p1,p2,p3,p4;
	JPasswordField t2;
	public loginpage()
	{
	    setSize(400,250);
       
		setLocation(300,300);
	
		l1=new JLabel("username");
		l2=new JLabel("password");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/login page.png"));
		Image img=i1.getImage().getScaledInstance(120,140,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(img);
		l3=new JLabel(i2);
		t1=new JTextField(15);
		t2=new JPasswordField(15);
		ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/login 1.png"));
		Image img2=i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
                b1=new JButton("Login", new ImageIcon(img2));
		
                ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/cancel.jpg"));
		Image img3=i4.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
		b2=new JButton("Cancel", new ImageIcon(img3));
		
               
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		setLayout(new BorderLayout());
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		add(p2,BorderLayout.CENTER);
		p1.add(l3);
		add(p1,BorderLayout.WEST);
		p3.add(b1);
		p3.add(b2);
		add(p3,BorderLayout.SOUTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ev)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","ektak1985");
			
			
			if(ev.getSource()==b1)
			{
				String name=t1.getText();
				String pass=t2.getText();
				String q="select * from logindata where username='"+name+"' and password='"+pass+"'";
				Statement stm=cn.createStatement();
				ResultSet set=stm.executeQuery(q);	
				if(set.next())
				{
					homepage anuj = new homepage();
					anuj.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid login");
					setVisible(false);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"sorry you pressed cancle button.....!");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error ...........!"+e);
		}
	}
	public static void main(String args[])
	{
		loginpage moni = new loginpage();
		moni.setVisible(true);
	}	
}
