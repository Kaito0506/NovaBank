package PROGRAM;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.mysql.cj.protocol.Resultset;
public class Customer {
	int Balance;
	String C_Name, C_CCCD, C_Address, C_Tel, C_Pass, C_Dob;
	//Date C_Dob;
	
	
	public Customer()
	{
		Balance = 0;
		C_Name = "";
		C_CCCD = "";
		C_Dob = "2022-01-01";
		C_Address = "";
		C_Tel = "";
		C_Pass = "";
	}
	

	public Customer(String na, String cccd, String d, String add, String tel, String pass, int b)
	{
		C_Name = na;
		C_CCCD = cccd;
		C_Dob = d;
		C_Address = add;
		C_Tel = tel;
		C_Pass = pass;
		Balance = b;
		
	}
	 public void insert() throws SQLException
	 {
		 Connection conn = Connect.getConnect("project");
		 CallableStatement st = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 String sql = "call insert_cus(?,?,?,?,?,?,?)";
		 st = conn.prepareCall(sql);
		 st.setString(1, C_Name);
		 st.setString(2, C_CCCD);
		 st.setString(3, C_Dob);
		 st.setString(4, C_Address);
		 st.setString(5, C_Tel);
		 st.setString(6, C_Pass);
		 st.setInt(7, Balance);
		 rs = st.executeQuery();
		  
	 }
	 
	 public Customer search(String tel) throws SQLException
	 {
		 Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql = "select * from customer join accounts on customer.c_tel = accounts.a_id where customer.c_tel = '"+tel+"'";
		 //st = conn.createStatement();
		// st.setString(1, tel);
		 st = conn.prepareStatement(sql);
		 rs = st.executeQuery();
		 if(rs.next())
		 {
			 Customer c = new Customer(rs.getString("c_name"), rs.getString("c_cccd"), 
					 rs.getString("c_dob"), rs.getString("c_address"), rs.getString("c_tel"),
					 rs.getString("pass"), rs.getInt("A_Balance"));
			 System.out.println(c.C_Dob);
			 return c;
		 }
		 else return null;
		 
	 }
	 
	 public void delete(String tel)
	 {
		 Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql = "call DELETE_CUS(?)";
		 try {
			st = conn.prepareStatement(sql);
			st.setString(1, tel);
			rs = st.executeQuery();
			conn.close();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 public void update(String name, String cccd, String dob, String add, String tel, String pass, int bal)
	 {
		 Connection conn = Connect.getConnect("project");
		 PreparedStatement st2 = null;
		 PreparedStatement st3 = null;
		 ResultSet rs = null;
		 try {
				String sql2 = "update customer set "
						+ "c_name = ?, c_cccd = ?, c_dob = ?, c_address = ?, c_tel = ? "
						+ "where c_tel = '"+tel+"'";
				st2 = conn.prepareStatement(sql2);
				st2.setString(1, name);
				st2.setString(2, cccd);
				st2.setString(3, dob);
				st2.setString(4, add);
				st2.setString(5, tel);
				int count = st2.executeUpdate();
				System.out.println(count);
				///////////////////////////////////////
				String sql3 = "update accounts set "
						+ "A_Id=?, Pass=?, A_Balance=? "
						+ "where A_Id = '"+tel+"'";
				st3 = conn.prepareStatement(sql3);
				st3.setString(1, tel);
				st3.setString(2, pass);
				st3.setInt(3, bal);
				
				int count2 = st3.executeUpdate();
				System.out.println(count2);
				conn.close();
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 public static void main(String[] args) throws SQLException {
		
		/* Connection conn = Connect.getConnect("project");
		 PreparedStatement st3 = null;
		 String tel = "0783939975";
		 String sql = "update accounts set a_id = '0783939975', pass='123456', a_balance=200000444 where a_id='0783939975'";
		 try {
			String sql3 = "update customer set "
					+ "c_name = ?, c_address = ?"
					+ " where c_tel = ?";
			st3 = conn.prepareStatement(sql3);
			st3.setString(1, "KAITO HO");
			st3.setString(2, "VL");
			st3.setString(3, "0783939975");
			int count = st3.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
