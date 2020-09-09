package Electricity;

import java.sql.*;
public class connection {
    Connection cn;
    Statement stm;
    public connection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","ektak1985");
			stm=cn.createStatement();
			if(cn.isClosed() )
			{
				System.out.println("closed");
			}
			else
			{
				System.out.println("open");
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String s[])
	{
		connection anuj = new connection();
	}
}
