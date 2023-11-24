package PROGRAM;
import java.sql.*;
import java.util.Calendar;
//import java.util.*;
public class Debt {
	 public  String Tel;
	 public int Debt_Amount, Debt_Interest;
	 public  float Rates;
	 public  Date Debt_date;

	public Debt ()
	{
		Tel = "";
		Debt_Interest = 0;
		Debt_Amount = 0;
		Rates = 0f;
	}
	
	public Debt (String t, int pDA )
	{
		Tel = t;
		Debt_Amount = pDA;
		//Debt_Interest = pDI;
		//Rates = pRates;
		//Debt_date = Date.valueOf(d);
	}
	
	public Debt (String t, int pDA, String d )
	{
		Tel = t;
		Debt_Amount = pDA;
		//Debt_Interest = pDI;
		//Rates = pRates;
		Debt_date = Date.valueOf(d);
	}
	
	public void insert( ) throws SQLException
	{
		Connection conn = Connect.getConnect("project");
		 CallableStatement st = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 String sql = "call insert_debt(?,?,?)";
		
			st = conn.prepareCall(sql);
			 st.setString(1, Tel);
			 st.setInt(2, Debt_Amount);
			 st.setDate(3,  Debt_date);
			 st.execute();
		
	}
	
	public static double date_cal(Date payDate, Date debt)
	{
		int d, m, y;
		double total=0.0f;
		Calendar c = Calendar.getInstance();
		d = payDate.getDate() - debt.getDate();
		m = payDate.getMonth() - debt.getMonth();
		y = payDate.getYear() - debt.getYear();
		total = y*12 + m + (float)d/30;
		total = Math.ceil(total*100)/100;
		return total;
		
	}
	
	
	public Debt search(String tel) throws SQLException
	{
		 Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		
		 String sql = "select * from Debt where debt_id = '"+tel+"'";
		 st = conn.prepareStatement(sql);
			 rs = st.executeQuery();
			 if(rs.next())
			 {
				 Debt b = new Debt(rs.getString("debt_id"), rs.getInt("debt_amount"),
						 rs.getString("debt_date"));
				 return b;
				 
			 }
			 else return null;
		
	}
	
	public static void main(String[] args) {
		int d;
		Date d1 = Date.valueOf("2022-12-01");
		Date d2 = Date.valueOf("2023-01-15");
		Calendar c = Calendar.getInstance();
	
		Debt de = new Debt("0379831003", 100000, "2022-12-01"); 
	//	de.insert();//insert("0379831003", 500000);
		try {
			Debt x = de.search("0783939975");
			System.out.println(x.Tel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
