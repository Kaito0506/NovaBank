package PROGRAM;
import java.sql.*;
public class saving {
	String id;
	int amount;
	float rate;
	int r_amount;
	Date Saving_date;
	
	public saving()
	{
		id = "";
		amount =0;
		rate = 0;
		r_amount = 0;
	}
	
	public saving(String sid, int a, float r, int ra)
	{
		id = sid;
		amount = a ;
		rate = r;
		r_amount = ra;
	}
}
