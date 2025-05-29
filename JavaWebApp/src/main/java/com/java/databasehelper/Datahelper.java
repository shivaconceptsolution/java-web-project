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
   public static int UploadFile(String fname) throws SQLException
   {
	   int data = st.executeUpdate("insert into dataupload(path) values('"+fname+"')");
	   return data;
   }
   public static ResultSet ShowFile() throws SQLException
   {
	   ResultSet data = st.executeQuery("select * from dataupload");
	   return data;
   }
   public static int UserReg(String username,String password,String email,String mobile) throws SQLException
   {
	   
	   String salt = "SCS123";
       String hashedPassword = PasswordGenerator.hashPassword(password, salt);
	   int data = st.executeUpdate("insert into registration(username,password,email,mobile) values('"+username+"','"+hashedPassword+"','"+email+"','"+mobile+"')");
	   return data;
   }
   public static ResultSet verifyLogin(String username,String password) throws SQLException
   {
	   ResultSet data = st.executeQuery("select * from admin where username='"+username+"' and password='"+password+"'");
	   return data;
   }
   
   public static ResultSet verifyEmail(String email) throws SQLException
   {
	   ResultSet data = st.executeQuery("select * from registration where email='"+email+"'");
	   return data;
   }
   public static ResultSet verifyUser(String username,String password) throws SQLException
   {
	   String salt = "SCS123";
       String hashedPassword = PasswordGenerator.hashPassword(password, salt);
	   ResultSet data = st.executeQuery("select * from registration where username='"+username+"' and password='"+hashedPassword+"'");
	   return data;
   }
   public static ResultSet getAdminData(String username) throws SQLException
   {
	   ResultSet data = st.executeQuery("select * from admin where username='"+username+"'");
	   return data;
   }
   public static int changePassword(String username,String password) throws SQLException
   {
	   int data = st.executeUpdate("update admin set password='"+password+"' where username='"+username+"'");
	   return data;
   }
   public static int addProfile(String username,String password) throws SQLException
   {
	   int data = st.executeUpdate("insert into admin(username,password) values('"+username+"','"+password+"')");
	   return data;
   }
   public static int deleteProfile(String username) throws SQLException
   {
	   int data = st.executeUpdate("delete from admin where username='"+username+"'");
	   return data;
   }
   public static void closeConn() throws SQLException
   {
	   conn.close();
   }
}
