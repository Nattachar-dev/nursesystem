package login.model;
import java.io.Serializable;

public class Exchange implements Serializable{
	private static final long serialVersionUID=1L;
	private String name1;
	private String name2;
	private String dur_id1;
	private String dur_id2;
	private String date1;
	private String date2;
	private String status;
	
	
	public Exchange() {
		
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getDur_id1() {
		return dur_id1;
	}
	public void setDur_id1(String dur_id1) {
		this.dur_id1 = dur_id1;
	}
	public String getDur_id2() {
		return dur_id2;
	}
	public void setDur_id2(String dur_id2) {
		this.dur_id2 = dur_id2;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public Exchange(String name1, String name2, String dur_id1, String dur_id2, String date1, String date2,String status) {
		
		this.name1 = name1;
		this.name2 = name2;
		this.dur_id1 = dur_id1;
		this.dur_id2 = dur_id2;
		this.date1 = date1;
		this.date2 = date2;
		this.status = status;
	}
	
	

}
