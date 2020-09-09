package Electricity;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class homepage extends JFrame implements ActionListener
{
    JLabel l1;
    homepage()
    {
		setSize(1600,690);
		   
          ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/homepage.jpg"));
          Image i3=i2.getImage().getScaledInstance(1600,690,Image.SCALE_DEFAULT);
           ImageIcon icc=new ImageIcon(i3);
            l1=new JLabel(icc);
            add(l1);
		
			JMenuBar mb=new JMenuBar();
			JMenu master=new JMenu("Master");
			JMenuItem mi1=new JMenuItem("New Customer");
			JMenuItem mi2=new JMenuItem("Customer Details");
		
			master.setForeground(Color.BLUE);

			ImageIcon img_mi1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/menu.jpg"));
			Image image_mi1=img_mi1.getImage().getScaledInstance(16,20,Image.SCALE_DEFAULT);
			mi1.setIcon(new ImageIcon(image_mi1));
			
			ImageIcon img_mi2=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/homepage.jpg"));
			Image image_mi2=img_mi2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			mi2.setIcon(new ImageIcon(image_mi2));
			
			mi1.addActionListener(this);
			mi2.addActionListener(this);
			
			JMenu user=new JMenu("User");
			JMenuItem ui1=new JMenuItem("Pay Bill");


			ImageIcon img_ui1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/details.jpg"));
			Image image_ui1=img_ui1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			ui1.setIcon(new ImageIcon(image_ui1));
			
			ui1.setBackground(Color.WHITE);


			ui1.addActionListener(this);

			JMenu report=new JMenu("Report");
			JMenuItem r1=new JMenuItem("Generate Bill");
			
			ImageIcon img_r1=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/generate.jpg"));
			Image image_r1=img_r1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			r1.setIcon(new ImageIcon(image_r1));
			
			r1.setBackground(Color.WHITE);

			r1.addActionListener(this);

			
			JMenu exit=new JMenu("Exit");
			JMenuItem ex=new JMenuItem("Exit");

			ImageIcon img_ex=new ImageIcon(ClassLoader.getSystemResource("Electricity/icons/cancel.jpg"));
			Image image_ex=img_ex.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
			ex.setIcon(new ImageIcon(image_ex));
			
			ex.setBackground(Color.WHITE);

			ex.addActionListener(this);

			master.add(mi1);
			master.add(mi2);
			

			user.add(ui1);


			report.add(r1);

			exit.add(ex);

			mb.add(master);
			mb.add(user);
			mb.add(report);
		
			mb.add(exit);

			setJMenuBar(mb);

    }
	public void actionPerformed(ActionEvent ev)
	{
		String msg=ev.getActionCommand();
		if(msg.equals("New Customer"))
		{
			new_customer moni = new new_customer();
			moni.setVisible(true);
		}
		else if(msg.equals("Customer Details"))
		{
			customer_details ka = new customer_details();
			ka.setVisible(true);
		}


		else if(msg.equals("Pay Bill"))
  		{
			pay_bill ya = new pay_bill();
			ya.setVisible(true);
		}

		else if(msg.equals("Generate Bill"))
		{
			generate_bill dav =new generate_bill();
			dav.setVisible(true);
		}
		else if(msg.equals("Exit"))
		{
			System.exit(0);
		}
		else
		{
			System.out.println("wrong");
		}
	}
	public static void main(String args[])
	{
            homepage anuj = new homepage();
            anuj.setVisible(true);
            
	}
}
 