package com.aswini.Ecommerce.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectDB 
{
	public void ConnectDataBase(String username,String password,String email,String mobileNo)
	{
	try
	{
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","aswini","aswini");
    PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(?,?,?,?)");
	preparedStatement.setString(1, username  );
	preparedStatement.setString(2, password );
	preparedStatement.setString(3, email );
	preparedStatement.setString(4, mobileNo );
    preparedStatement.executeUpdate();
	}
	catch(SQLException sqe)
	{
		System.out.println("error occured");
		sqe.printStackTrace();
	}
}
}
