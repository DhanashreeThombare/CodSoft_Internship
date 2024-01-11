import java.sql.Connection;
import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentManagementSystem s=new StudentManagementSystem();
		
		Scanner sc=new Scanner(System.in);
		int ch;
		char ch1;
		
		Connection con=s.connectToDB();
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~: STUDENT MANAGEMENT SYSTEM :~~~~~~~~~~~~~~~~~~~~~~");
		
		do
		{
			System.out.println("\n_________________________________________");
			System.out.println("\t[1] Insert Records\n\t[2] Display All Records\n\t[3] Search Record\n\t[4] Delete Record\n\t[5] Update Record \n\t[6] Exit");
			System.out.println("\n_________________________________________");
			System.out.println("\nEnter your choice : ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:		s.addNewStudent(con);		break;
				case 2:		s.displayData(con);			break;
				case 3:		s.searchRecord();			break;
				case 4:		s.deleteRecord();			break;
				case 5:		s.updateRecord();			break;
				case 6:		System.exit(0);	
					System.out.println("\n\n----------------THANK YOU------------------");
				break;
			}
			System.out.println("\n_________________________________________");
			System.out.println("\nDo you want to continue with Menu ?(Y/N) : ");
			ch1=sc.next().charAt(0);
		}while(ch1=='Y'||ch1=='y');
		System.out.println("\n\n----------------THANK YOU------------------");
		
	}
}
