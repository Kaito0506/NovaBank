package PROGRAM;
import java.sql.*;
public class Employment {
	private String e_id, p_id, e_name, e_cccd, e_address, e_tel;
	private Date e_dob;
	
	
	public Employment()
	{
		e_id = "";
		p_id = "";
		e_name = "";
		//e_dob = ;
		e_cccd = "";
		e_address = "";
		e_tel = "";
	
	}
	
	public Employment(String eid, String pid, String ename, String d, String cccd, String add, String tel)
	{
		e_id = eid;
		p_id = pid;
		e_name = ename;
		e_dob = Date.valueOf(d);
		e_cccd = cccd;
		e_address = add;
		e_tel = tel;
	
	}
	
	
}
