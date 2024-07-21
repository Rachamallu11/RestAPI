package com.learning.demorest;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

//this class is for the fetching the data from the database.
public class AlienRepository {
	
	//List<Alien> aliens;
	
	Connection con = null;
	
	public AlienRepository(){       //we have to create one constructor for the initialise the variable
		
		String url = "jdbc:mysql://localhost:3306/servicedb";
		String username = "root";
		String password = "123456";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//aliens = new ArrayList<>();
		
//		Alien a1 =new Alien();
//		a1.setId(101);
//		a1.setName("Satya");
//		a1.setPoints(5);
//		
//		Alien a2 =new Alien();
//		a2.setId(102);
//		a1.setName("Rana");
//		a1.setPoints(10);
		
//		aliens.add(a1);
//		aliens.add(a2);
		
	}
	
	
	public List<Alien> getAliens(){   //for returning the o/p 
		
		
		List<Alien> aliens = new ArrayList<>();
		
		String sql = "select * from alien";
		try {
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return aliens;
		
	}
	 
	public Alien getAlien(int id) {  //for to get the alien for the particular one based on their id
		
		
//		
//		for(Alien a : aliens) {
//			
//			if(a.getId()==id)
//				return a;
//		}
//		
//		return new alien();
		
		//here we fetching not all the aliens now  we are fetching only particular one or single  
		
		String sql = "select * from alien where id ="+id;
		Alien a = new Alien();
		try {
		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				
			}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return a;
	}


	public void create(Alien a1) {
		
		String sql = "insert into alien values (?, ?,?) ";
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			//ResultSet rs = st.executeQuery();
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
			

	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//aliens.add(a1);   //it will add to the database 
		
	}
	
	
	
	

}
