package pizza;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/*
 * Object
 * 	- customerName: String
 * 	- numbersItems: Int
 * 	- address: String
 *  - 
 */

public class DatabaseConnection {


		private String url = "jdbc:mysql://@localhost:3306/pizza";
		private String username = "root";
		private String password = "";
		
		public Connection getConnection(){
			    
				Connection con = null;
			    try {
			    	Class.forName("com.mysql.cj.jdbc.Driver");
			        con = DriverManager.getConnection(url, username, password);
			    }catch(NullPointerException e){
			      	JOptionPane.showMessageDialog(null, e.getMessage());
			    }catch (Exception ex) {
			      	JOptionPane.showMessageDialog(null, ex.getMessage());
			    }	      	    
			    return con;	    
		   	}
		
		public ResultSet getAccount(String username) {
			String query = "SELECT * FROM `login` WHERE Username =?";
			
			PreparedStatement st;
		    ResultSet rs = null;
			try {
				st = getConnection().prepareStatement(query);
				st.setString(1, username);
			    rs= st.executeQuery();
			} catch (SQLException e) {			
			  	JOptionPane.showMessageDialog(null, e.getMessage());		
			}finally {		
				try {			
					if(getConnection() != null) {				
						getConnection().close();				
					}		
				} catch (SQLException e) {		
				  	JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}    
		    return rs;
		}
	
	
	
}
