public class Student {

	public int rollno;
	public String name;
	public String grade;
	public String branch;
	public long mobno;
	
	Student(){}
	
	public Student(int rollno, String name, String grade, String branch, long mobno) 
	{
		super();
		this.rollno = rollno;
		this.name = name;
		this.grade = grade;
		this.branch = branch;
		this.mobno = mobno;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public long getMobno() {
		return mobno;
	}
	
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
}
