import java.sql.Connection;	
import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		
		ContactManagement cm=new ContactManagement();
		Connection con=cm.connectToDB();
		
		Scanner sc=new Scanner(System.in);
		char ch1;
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~: ADDRESS BOOK SYSTEM:~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		do
		{
			System.out.println("[1] Create Address Book\n[2] Display All Contacts\n[3] Search Contact\n[4] Insert new Contact\n[5] Delete Contact\n[6] Exit");
			System.out.println("__________________________________________________________");
			System.out.println("\nEnter choice : ");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					cm.createAddrBook(con);
				break;
				
				case 2:
					cm.displayContacts(con);
				break;
				
				case 3:
					cm.searchContact(con);
				break;
				
				case 4:
					cm.insertContact(con);
				break;
				
				case 5:
					cm.deleteContact(con);
				break;
				
				case 6:
					System.out.println("\n------------THANK YOU-----------------");
					System.exit(0);
				break;
			}
			System.out.println("__________________________________________________________");
			System.out.println("Want to continue with menu [Y/N] : ");
			ch1=sc.next().charAt(0);
		}while(ch1=='y'||ch1=='Y');
		System.out.println("\n------------THANK YOU-----------------");
	}
}
