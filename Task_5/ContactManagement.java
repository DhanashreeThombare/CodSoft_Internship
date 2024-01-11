import java.sql.*;	
import java.util.Scanner;

public class ContactManagement {
	
	public Connection con;
	public PreparedStatement stmt;
	public String sql;
	
	Scanner sc=new Scanner(System.in);
	
	public Connection connectToDB() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook","root","23102003");
		} 
		catch (SQLException e) {}
		return con;
	}
	
	public void createAddrBook(Connection con) {
		System.out.println("How many records do you want ? ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter details for Contact "+(i+1)+" : ");
			System.out.println("\nEnter Name : ");
			String name=sc.next();
			System.out.println("Enter Phone number : ");
			long phoneNo=sc.nextLong();
			System.out.println("Enter Email ID : ");
			String email=sc.next();
			System.out.println("Enter Address : ");
			String addr=sc.next();
			System.out.println("-------------------------------------");
			try
			{
				sql="insert into ContactData values(?,?,?,?);";
				stmt=con.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setLong(2, phoneNo);
				stmt.setString(3, email);
				stmt.setString(4, addr);
				stmt.executeUpdate();
			}catch(Exception e) {}
		}
		System.out.println("Address book created successfully..");
	}
	
	public void displayContacts(Connection con)
	{
		System.out.println("----------------ALL CONTACTS----------------\n");
		System.out.println("__________________________________________________________");
		System.out.println("Name \t\t Phone No. \t Email ID \t Address ");
		System.out.println("__________________________________________________________");
		try
		{
			sql="select * from ContactData;";
			stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getLong(2)+" \t "+rs.getString(3)+" \t "+rs.getString(4));
			}
		}catch(Exception e) {}
	}
	
	public void searchContact(Connection con) {
		System.out.println("Enter Contact Number to search : ");
		long phoneNo=sc.nextLong();
		boolean b=false;
		try
		{
			sql="select * from ContactData where phoneno=?;";
			stmt=con.prepareStatement(sql);
			stmt.setLong(1,phoneNo);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				b=true;
				System.out.println("__________________________________________________________");
				System.out.println("Name \t\t Phone No. \t Email ID \t Address ");
				System.out.println("__________________________________________________________");
				System.out.println(rs.getString(1)+"\t\t"+rs.getLong(2)+" \t "+rs.getString(3)+" \t "+rs.getString(4));
				break;
			}
		}catch(Exception e) {}
		if(b=false)
			System.out.println("Contact does not exists...");
	}

	public void insertContact(Connection con) {
		
		System.out.println("\nEnter Name : ");
		String name=sc.next();
		System.out.println("Enter Phone number : ");
		long phoneNo=sc.nextLong();
		System.out.println("Enter Email ID : ");
		String email=sc.next();
		System.out.println("Enter Address : ");
		String addr=sc.next();
		System.out.println("-------------------------------------");
		try
		{
			sql="insert into ContactData values(?,?,?,?);";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setLong(2, phoneNo);
			stmt.setString(3, email);
			stmt.setString(4, addr);
			stmt.executeUpdate();
		}catch(Exception e) {}
		System.out.println("Contact inserted successfully..");
	}

	public void deleteContact(Connection con) {
		System.out.println("Enter Contact Number to delete : ");
		long phoneNo=sc.nextLong();
		boolean b=false;
		try
		{
			sql="select * from ContactData where phoneno=?;";
			stmt=con.prepareStatement(sql);
			stmt.setLong(1,phoneNo);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				b=true;
				sql="delete from ContactData where phoneno=?;";
				stmt=con.prepareStatement(sql);
				stmt.setLong(1,phoneNo);
				stmt.executeUpdate();
				System.out.println("Contact deleted successfully..");
				break;
			}
			if(b==false)
				System.out.println("Contact does not exists..");
		}catch(Exception e) {}
	}
}
