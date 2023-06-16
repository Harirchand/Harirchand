package metro;

public class Metroobj{
	String userid;
	String password;
	String firstname;
	String lastname;
	long mobilenumber;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	@Override
	public String toString() {
		return "Metroobj [userid=" + userid + ", password=" + password + ", Firstname=" + firstname
				+ ", lastname=" + lastname + ", Mobile number=" + mobilenumber ;
	}

}