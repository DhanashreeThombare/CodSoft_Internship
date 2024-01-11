import java.util.Scanner;	
import java.sql.*;

public class StudentManagementSystem {

	Scanner sc=new Scanner(System.in);
	int n;
	
	int rollno;
	String name,branch,grade;
	long mobno;
	
	//for connectivity
	public Connection con;
	public PreparedStatement stmt;
	public String sql;
	public Statement s;
	
	public Connection connectToDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","23102003");
			System.out.println("Connected to MySQL..");
			return con;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	public void addNewStudent(Connection con)
	{		
		System.out.println("How many students do you want : ");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("\n_________________________________________");
			System.out.println("Enter details for Student "+(i+1)+" : \n");
			System.out.println("Enter Roll number : ");
			rollno=sc.nextInt();
			System.out.println("Enter name : ");
			name=sc.next();
			System.out.println("Enter Grade : ");
			grade=sc.next();
			System.out.println("Enter Branch : ");
			branch=sc.next();
			System.out.println("Enter Mobile Number : ");
			mobno=sc.nextLong();
			
			sql="insert into StudentData (rollno,name,grade,branch,mobno) values(?,?,?,?,?);";
			try {
				stmt=con.prepareStatement(sql);
				stmt.setInt(1, rollno);
				stmt.setString(2, name);
				stmt.setString(3, grade);
				stmt.setString(4, branch);
				stmt.setLong(5, mobno);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Records inserted successfully...");
	}
	
	public void displayData(Connection con)
	{
		sql="select *  from studentData;";
		try {
			s = con.prepareStatement(sql);
			ResultSet resultSet=s.executeQuery(sql);
			System.out.println("Details of Students are : \n");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Roll No.\t Name \t Grade \t Branch \t Mobile No.");
			System.out.println("------------------------------------------------------------------");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t\t "+resultSet.getString(2)+"\t"+resultSet.getString(3)+" \t "+resultSet.getString(4)+" \t\t"+resultSet.getLong(5));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchRecord() 
	{	
		System.out.println("Enter Roll number to search : ");
		rollno=sc.nextInt();
		boolean b=false;
		sql="select * from StudentData where rollno='"+(int)rollno+"';";
	
		try {
			stmt=con.prepareStatement(sql);
			ResultSet resultSet=stmt.executeQuery(sql);
			while(resultSet.next()) {
				b=true;
				System.out.println("-------------------------------------------------------------------");
				System.out.println("Roll No.\t Name \t Grade \t Branch \t Mobile No.");
				System.out.println("------------------------------------------------------------------");
				System.out.println(resultSet.getInt(1)+"\t\t "+resultSet.getString(2)+"\t"+resultSet.getString(3)+" \t "+resultSet.getString(4)+" \t\t"+resultSet.getLong(5));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(b==false)
		{
			System.out.println("Student's record does not exist..");
		}
	}
	
	public void deleteRecord()
	{
		System.out.println("Enter Roll number to delete record : ");
		rollno=sc.nextInt();
		boolean b=false;
		sql="delete from StudentData where rollno='"+(int)rollno+"';";
		try {
			stmt=con.prepareStatement(sql);
			stmt.execute();
			b=true;
			System.out.println("Record deleted");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(b==false)
		{
			System.out.println("Student's record does not exist..");
		}
	}

	public void updateRecord() 
	{
		boolean b=false;
		int i;
		System.out.println("Enter Roll number to update record : ");
		rollno=sc.nextInt();
		sql="select * from StudentData where rollno='"+(int)rollno+"';";
		try {
			stmt=con.prepareStatement(sql);
			ResultSet resultSet=stmt.executeQuery();
			while(resultSet.next())
			{
				b=true;
				break;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(b)
		{
			char ch1;
			do
			{
				System.out.println("What do you want to update ? ");
				System.out.println("1) Name\n2) Branch \n3) Grade\n4) Mobile No.");
				int ch=sc.nextInt();
				switch(ch) 
				{
					case 1:
						System.out.println("Enter new name for roll no. "+rollno+" : ");
						String nm=sc.next();
						sql="update StudentData set name=? where rollno=?;";
						try {
							stmt=con.prepareStatement(sql);
							stmt.setString(1, nm);
							stmt.setInt(2, rollno);
							stmt.executeUpdate();
						} 
						catch (SQLException e) {}
						
						System.out.println("Record updated successfully...");
					break;

					case 2:
						System.out.println("Enter new branch for roll no. "+rollno+" : ");
						String br=sc.next();
						sql="update StudentData set branch=? where rollno=?;";
						try {
							stmt=con.prepareStatement(sql);
							stmt.setString(1, br);
							stmt.setInt(2, rollno);
							stmt.executeUpdate();
						}catch(Exception e) {}
						System.out.println("Record updated successfully...");
					break;

					case 3:
						System.out.println("Enter new grade for roll no. "+rollno+" : ");
						String gr=sc.next();
						sql="update StudentData set grade=? where rollno=?;";
						try
						{
							stmt=con.prepareStatement(sql);
							stmt.setString(1, gr);
							stmt.setInt(2, rollno);
							stmt.executeUpdate();
						}catch(Exception e) {}
						System.out.println("Record updated successfully...");
					break;

					case 4:
						System.out.println("Enter new mobile no. for roll no. "+rollno+" : ");
						long mob=sc.nextLong();
						sql="update StudentData set mobno=? where rollno=?;";
						try {
							stmt=con.prepareStatement(sql);
							stmt.setLong(1, mob);
							stmt.setInt(2, rollno);
							stmt.executeUpdate();
						}catch(Exception e) {}
						System.out.println("Record updated successfully...");
					break;
				}
				System.out.println("Do you want to update any other fields of Roll no. "+rollno+" ? (Y/N) ");
				ch1=sc.next().charAt(0);
			}while(ch1=='Y'|| ch1=='y');
			if(ch1=='N'||ch1=='n') {
				return;
			}
		}
		else
		{	
			System.out.println("Student's record does not exist..");
		}
	}
}
