package com.javacodes.usersystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javacodes.usersystem.bean.User;

public class UserDao {
	
	private String jdbcUrl="jdbc:mysql://localhost:3306/usersystem?useSSL=false";
	private String username="root";
	private String userpassword="root";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_USERS = 
			"INSERT INTO users" + " (name,email,country,state,city,pincode,phoneNo) VALUES " + "(?,?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = 
			"select id,name,email,country,state,city,pincode,phoneNo from users where id=?";
	
	private static final String SELECT_ALL_USERS = "select * from users";
	
	private static final String DELETE_USERS = "delete  from users where id=?;";
	
	private static final String UPDATE_USERS = 
			"update users set  name = ?, email=?,country=?,state=?,city=?,pincode=?,phoneNo=?;";
	
	
	public UserDao() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
		Class.forName(jdbcDriver);
		connection=DriverManager.getConnection(jdbcUrl,username,userpassword);
		}catch (SQLException e) {
	      e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
     //create user
	  public void insertUser(User user) {
		  System.out.println("INSERT_USERS");
		  Connection connection = getConnection();
		  try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.setString(4, user.getState());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getPincode());
			preparedStatement.setString(7, user.getPhoneNo());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		  
	  }
	  //select user by id
	  public User selectUser(int id) {
		  User user = null;
		  
		  Connection connection = getConnection();
		  try {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String state = rs.getString("state");
				String city = rs.getString("city");
				String pincode = rs.getString("pincode");
				String phoneNo = rs.getString("phoneNo");
				user = new User(name, email, country, state, city, pincode, phoneNo);
			}
		} catch (SQLException e) {
			
			printSQLException(e);
		}
		return user;
		  
		  
	  }
	  //select all users
	  public List<User> selectAllUsers(){
		  
		  List<User> users = new ArrayList<>();
		  
		  try (Connection connetion = getConnection();
		  PreparedStatement preparedStatement = connetion.prepareStatement(SELECT_ALL_USERS);){
			  System.out.println(preparedStatement);
			  
			  ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String country = rs.getString("country");
					String state = rs.getString("state");
					String city = rs.getString("city");
					String pincode = rs.getString("pincode");
					String phoneNo = rs.getString("phoneNo");
					users.add(new User(id, name, email, country, state, city, pincode, phoneNo));
				}
			  
		  }catch (SQLException e) {
			printSQLException(e);
		}
		  
		return users; 
	  }
	  // update users
	  public boolean updateUser(User user) throws SQLException{
		  boolean rowUpdated;
		  try (Connection connection = getConnection();
		  PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);){
		  System.out.println("Updates User: " +statement);
		  
		  statement.setString(1, user.getName());
		  statement.setString(2, user.getEmail());
		  statement.setString(3, user.getCountry());
		  statement.setString(4, user.getState());
		  statement.setString(5, user.getCity());
		  statement.setString(6, user.getPincode());
		  statement.setString(7, user.getPhoneNo());
		  statement.setInt(8, user.getId());
		  
		  
		  rowUpdated = statement.executeUpdate() > 0;
			  
		  }
		  return rowUpdated;
		}
		  // delete users
		public boolean deleteUser(int id) throws SQLException {
			boolean rowDeleted;
			try(Connection connection = getConnection();
					PreparedStatement deleteStaement = connection.prepareStatement(DELETE_USERS);){
				deleteStaement.setInt(1, id);
				rowDeleted = deleteStaement.executeUpdate() > 0;
			}
			return rowDeleted;
			
		}
		 
	private void printSQLException(SQLException ex) {
		for(Throwable e : ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLSate: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = e.getCause();
				while(t != null) {
					System.out.println("Cause: " + t);
					t=t.getCause();
				}
			}
		}
		
		
	}
}
