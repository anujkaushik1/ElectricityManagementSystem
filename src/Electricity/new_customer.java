package Electricity;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class new_customer extends JFrame implements ActionListener
{
	JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9;
        JButton b1,b2;
        JTextField t1,t2,t3,t4,t5,t6,t7,t8;
        JPanel p1,p2;
    
	new_customer()
	{
		
		setSize(1000,400);
        setLocation(40,40);
        
		p1=new JPanel();
		p1.setLayout(new GridLayout(9,2,10,10));

		j1=new JLabel("Name");
		t1=new JTextField(15);

		p1.add(j1);
		p1.add(t1);

		j2=new JLabel("Meter number");
		t2=new JTextField(15);
                
		p1.add(j2);
		p1.add(t2);

		j3=new JLabel("Address");
		t3=new JTextField(15);
               
		p1.add(j3);
		p1.add(t3);

		j4=new JLabel("State");
		t4=new JTextField(15);
              
		p1.add(j4);
		p1.add(t4);

		j5=new JLabel("City");
		t5=new JTextField(15);
                
		p1.add(j5);
		p1.add(t5);

		j6=new JLabel("Email");
		t6=new JTextField(15);
                
		p1.add(j6);
		p1.add(t6);

		j7=new JLabel("Phone no");
		t7=new JTextField(15);
                
		p1.add(j7);
		p1.add(t7);
                
                j9=new JLabel("New Customer Details");
                
                j9.setHorizontalAlignment(JLabel.CENTER);
		b1=new JButton("Submit");
		b2=new JButton("Cancel");
              
		p1.add(b1);
		p1.add(b2);

		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		p2=new JPanel();
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/new customer.png"));
		Image image=img.getImage().getScaledInstance(270,270,Image.SCALE_DEFAULT);
		ImageIcon img2=new ImageIcon(image);
		j8=new JLabel(img2);
		p2.add(j8);

		setLayout(new BorderLayout());
                
                add(j9,"North");
		add(p1,"Center");
		add(p2,"West");

		b1.addActionListener(this);
		b2.addActionListener(this); 
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource()==b1)
		{ 
			String name =t1.getText();
			String meterno=t2.getText();
			String address=t3.getText();
			String state=t4.getText();
			String city=t5.getText();
			String email=t6.getText();
			String phone=t7.getText();
			try
			{
				connection ob=new connection();
				String q="insert into customer_info values('"+name+"','"+meterno+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
				ob.stm.executeUpdate(q);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null," data inserted......");
                        setVisible(false);
		}
		if(ev.getSource()==b2)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		new_customer moni = new new_customer();
		moni.setVisible(true);
	}
}
