package login.model;
import java.io.Serializable;

public class Loginbean implements Serializable {
	private static final long serialVersionUID=1L;
	private String username;
	private String password;
	private String pos;
	
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getpos() {
		return pos;
	}
	public void setpos(String pos) {
		this.pos = pos;
	}
	
	
}