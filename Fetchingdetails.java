package metro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fetchingdetails {
	static long mobilenumber;
	public static Metroobj getTheDetailsByEmail(String email) {
		
		try {
			Connection c = ConnectionObje.getTheConnection();
			PreparedStatement p = c.prepareStatement("select * from metro where userid=?");
			p.setString(1, email);
			ResultSet r=p.executeQuery();
			while(r.next()) {
			String firstname=r.getString(1);
			String lastname=r.getString(2);
			String userid=r.getString(3);
			String password=r.getString(4);
			mobilenumber=r.getLong(5);
			Metroobj m=new Metroobj();
			m.setUserid(userid);
			m.setPassword(password);
			m.setFirstname(firstname);
			m.setLastname(lastname);
			m.setMobilenumber(mobilenumber);
			return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}return null;
	}
public static Metroobj getTheDetailsBymobile(String mobile) {
		try {
			Connection c = ConnectionObje.getTheConnection();
			PreparedStatement p = c.prepareStatement("select * from metro where mobilenumber=?");
			p.setString(1, mobile);
			ResultSet r=p.executeQuery();
			while(r.next()) {
			String firstname=r.getString(1);
			String lastname=r.getString(2);
			String userid=r.getString(3);
			String password=r.getString(4);
			mobilenumber=r.getLong(5);
			Metroobj m=new Metroobj();
			m.setUserid(userid);
			m.setPassword(password);
			m.setFirstname(firstname);
			m.setLastname(lastname);
			m.setMobilenumber(mobilenumber);
			return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}return null;
	}
}
