package login.model;

import java.io.Serializable;

public class Leave implements Serializable {
	private static final long serialVersionUID=1L;
	private String name;
	private String Pos;
	private String date;
	private String dur;
	private String Des;
	private String Status;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPos() {
		return Pos;
	}
	public void setPos(String pos) {
		Pos = pos;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDur() {
		return dur;
	}
	public void setDur(String dur) {
		this.dur = dur;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

}
