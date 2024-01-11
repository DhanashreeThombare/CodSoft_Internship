
public class Contact {
	
	String name;
	long phoneNo;
	String email;
	String addr;
	
	public Contact(String name, long phoneNo, String email, String addr) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
