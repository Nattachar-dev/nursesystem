package login.model;
import java.io.Serializable;

public class Nurse implements Serializable {
	private static final long serialVersionUID=1L;
	private String username;
	private String Dept;
	private String Pos;
	private String name,Image,sex,Email,Tel;
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public String getPos() {
		return Pos;
	}
	public void setPos(String pos) {
		Pos = pos;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		this.Tel = tel;
	}
	public Nurse() {
		
	}
	public Nurse(String username,String name,String sex,String email,String tel,String dept) {
		this.username = username;
		this.name = name ;
		this.sex = sex;
		this.Email = email;
		this.Tel = tel;
		this.Dept = dept;
		
	} 

}
