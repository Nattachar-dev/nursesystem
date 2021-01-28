package login.model;
import java.io.Serializable;

public class Schedule implements Serializable {
	private static final long serialVersionUID=1L;
	private String name_id;
	private String dep_id;
	private String dur;
	private String date;
	private String role;
	private String year,month,day;
	private int id;

	public String getName_id() {
		return name_id;
	}
	public void setName_id(String name_id) {
		this.name_id = name_id;
	}
	
	public String getdep_id() {
		return dep_id;
	}
	public void setdep_id(String dep_id) {
		this.dep_id = dep_id;
	}
	
	public String getDur() {
		return dur;
	}
	public void setDur(String dur) {
		this.dur = dur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public Schedule(){
		
	}

	public Schedule(String name_id,String dep_id,String year,String month,String day,String date,String dur,String role) {
		this.name_id = name_id;
		this.dep_id = dep_id;
		this.dur = dur;
		this.date = date;
		this.role = role;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public Schedule(String year,String month) {
		this.year = year;
		this.month = month;
		
	}

}
