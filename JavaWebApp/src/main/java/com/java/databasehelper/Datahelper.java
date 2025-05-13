package com.java.databasehelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datahelper {
   static Connection conn;
   static Statement st;
   public static void connect() throws Exception
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","");
	   st = conn.createStatement();
   }
   public static ResultSet verifyLogin(String username,String password) throws SQLException
   {
	   ResultSet data = st.executeQuery("select * from admin where username='"+username+"' and password='"+password+"'");
	   return data;
   }
   public static void closeConn() throws SQLException
   {
	   conn.close();
   }
}
