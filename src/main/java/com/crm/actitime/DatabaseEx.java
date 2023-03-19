package com.crm.actitime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseEx {

	public static void main(String[] args) throws SQLException {
		//step1: create object of the driver and register
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//step 2: establish connection
		//
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weekend","root","root");
		//step3: create environment
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from employee");
	   while (result.next()) {
		System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getInt(3));
	}
	  int res = statement.executeUpdate("insert into employee values('roopesh',13,80000);");
	  if(res==1)
		  System.out.println("new record is inserted");
	  else
		  System.out.println("new record is not inserted");
	}

}
