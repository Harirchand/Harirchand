package metro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class metrodao extends ConnectionObje{
	public void saveuser(Metroobj m){
		try {
			Connection c =ConnectionObje.getTheConnection();
			
			PreparedStatement p =c.prepareStatement("insert into metro values(?,?,?,?,?)");
			p.setString(1, m.getFirstname());
			p.setString(2, m.getLastname());
			p.setString(3, m.getUserid());
			p.setString(4, m.getPassword());
			p.setLong(5, m.getMobilenumber());
			
				p.executeUpdate();
			
			System.out.println("Account created Successfully\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
