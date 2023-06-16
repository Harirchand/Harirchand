package metro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Metromain {
	static Scanner s = new Scanner(System.in);
	static String userid;
	static long mobilenum;
	static int i=0;
	static Fetchingdetails f=new Fetchingdetails();
	public boolean login()throws Exception {
		long mobilenum1= 0;	
		boolean z=true;
		do{System.out.println("Enter your Email-id or Mobilenumber");
			String email=s.next();
			Metroobj m = null;
			if(true) {
				try {
					mobilenum1=Long.parseLong(email);
					m= Fetchingdetails.getTheDetailsBymobile(email);
				}catch(NumberFormatException e) {
					m= Fetchingdetails.getTheDetailsByEmail(email);
				}
			}
			if(m!=null) {
				System.out.println("Enter your password");
				String pass=s.next();
				if (email.equals(m.userid)||mobilenum1==Fetchingdetails.mobilenumber) {
					if (pass.equals(m.password)) {
						Thread.sleep(700);
						System.out.println("login successful");
						z=false;
						return true;
					}else {
						System.out.println("Please enter correct password");
					}
				}
			}else {
					System.out.println("Please enter correct Email-Id or password\n");
//					z=true;
				}
		}while(z);
			return false;
		}
		
	public boolean deleteById(long mobilenum) {
		try {
			Connection c= ConnectionObje.getTheConnection();
			PreparedStatement p = c.prepareStatement("delete from metro where mobilenumber=?");
			p.setLong(1, mobilenum);
			p.executeUpdate();
			System.out.println("deleted");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean signup() throws Exception {
		Metroobj m =new Metroobj();
		metrodao n=new metrodao();
		Mobilevalidation mv= new Mobilevalidation();
		boolean b=true;
		Connection c= ConnectionObje.getTheConnection();
		PreparedStatement p = c.prepareStatement("select * from metro");
		p.executeQuery();
		System.out.println("Enter your First name");
		m.setFirstname(s.next());
		System.out.println("Enter your Last name");
		m.setLastname(s.next());
		do{
			System.out.println("Enter your Email-ID");
		String email=s.next();
//		for (int j = 0; j < i; j++) {
//			if(userid[j]!=null) {
//			while(userid[j].equalsIgnoreCase(email)) {
//				System.out.println("User Id is already exist\nPlease Login");
//				return false;
//			}
//			}
//		}
		if(Fetchingdetails.getTheDetailsByEmail(email)!=null) {
			System.out.println("Email-id already exists\nPlease check your email-id");
			b=true;
		}else {
			m.setUserid(email);
			b=false;
		}
		}while(b);
		System.out.println("Enter your password");
		m.setPassword(s.next());
		do{
		System.out.println("Enter your Mobile number");
		long mobile=s.nextLong();
		if(mv.mobilevalidate(mobile)) {
		m.setMobilenumber(mobile);
		b=false;
		}else {
			System.out.println("Enter mobile number is not valid");
		}
		}while(b);
		n.saveuser(m);
		return true;
	}
	public void existing() throws Exception {
		Connection c= ConnectionObje.getTheConnection();
		PreparedStatement p=c.prepareStatement("select * from metro");
		ResultSet r=p.executeQuery();
		while(r.next()) {
			userid=r.getString("userid");
			mobilenum=r.getLong("mobilenumber");
			
			}
}
	public void forgetpassword() throws Exception {
		System.out.println("Enter your Email-Id");
		String forget=s.next();
		boolean b=true;
		String password="";
		long mobile=0;
		Metroobj m=new Metroobj();
		Connection c =ConnectionObje.getTheConnection();
		PreparedStatement p=c.prepareStatement("select * from metro where userid=?");
		p.setString(1, forget);
		ResultSet r=p.executeQuery();
		while(r.next()) {
			String email1=r.getString(3);
			password=r.getString(4);
			mobile=r.getLong(5);
		}
		do {
		Metro.verification(mobile);
		System.out.println("Enter your new Password");
		String newpass=s.next();
		System.out.println("Re-enter youe new password");
		String newpass1=s.next();
		if (newpass.equals(newpass1)) {
			String query="update metro set password=? where userid=?";
			p=c.prepareStatement(query);
			p.setString(1, newpass);
			p.setString(2, forget);
			p.executeUpdate();
			System.out.println("Password changed successfully");
			b=false;
		}else {
			System.out.println("Please check your new password");
		}
		}while(b);
	}
}