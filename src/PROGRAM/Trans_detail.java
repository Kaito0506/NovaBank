package PROGRAM;
import java.sql.*;
public class Trans_detail {
	private String Id, Id_Type, Sender, Receiver, Id_Employee;
	private int Amounts;
	private Date Trans_Date;
	
	public Trans_detail()
	{
		Id="";
		Id_Type="";
		Sender="";
		Receiver="";
		Amounts=0;
	//	Trans_Date= new Date();
		Id_Employee="";
	}
	
	public Trans_detail(String pId, String pId_Type, String pSender, String pReceiver, int pAmounts,
			String date, String pId_Employee)
	{
		Id=pId;
		Id_Type=pId_Type;
		Sender=pSender;
		Receiver=pReceiver;
		Amounts=pAmounts;
		Trans_Date = Date.valueOf(date);
		Id_Employee=pId_Employee;
	}
	
	public void  deposit(String id, int amount)
	{
		Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql = "call DEPOSIT(?, ?)";
		 try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setInt(2, amount);
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void  withdraw(String id, int amount)
	{
		Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql = "call withdraw(?, ?)";
		 try {
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setInt(2, amount);
			st.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void  transfer(String sender,String receiver, int amount)
	{
		Connection conn = Connect.getConnect("project");
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql = "call transfer(?, ?, ?)";
		 try {
			st = conn.prepareStatement(sql);
			st.setString(1, sender);
			st.setString(2, receiver);
			st.setInt(3, amount);
			st.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		Trans_detail t = new Trans_detail();
		t.deposit("0783939975", 22222);
	}
}
