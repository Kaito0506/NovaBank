package PROGRAM;
import java.sql.Date;
import java.util.*;
import java.time.*;
public class test {
	//static Connection conn = Connect.getConnect("project");
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		//Connection conn = Connect.getConnect("project");
		String d = "2002-01-01";
		String d1 = "2002-05-30";
		Date x = Date.valueOf(d);
		Date y = Date.valueOf(d1);
	//	LocalDate.
		LocalDate m = LocalDate.now();
		System.out.println(x.toString());
		
		//System.out.println(m);
	}

}
