import java.lang.Math;
import java.util.Scanner;

public class NumberGame {

	Scanner sc=new Scanner(System.in);

	public void guessRandom() {
		char ch1;
		do
		{
			System.out.println("Enter the range for generating random numbers : ");
			int min=sc.nextInt();
			int max=sc.nextInt();
			int arr[]=new int[500];
			for(int i=min;i<=max;i++)
			{
				arr[i]=i;
			}
			int n=(int)(Math.random()*(max-min+1)+min);
			
			System.out.println("You will get 5 attempt to guess number...\n");

			int i=1;
			int temp=0;
			do {
				System.out.println("\n\nAttempt "+(i)+"\n");
				System.out.println("Guess the number : ");
				int n1=sc.nextInt();

				if(n1==n) {
					System.out.println("Congratulations !! Your guess is right..!!!");
					break;
				}
				else if(n1<n) {
					temp=n-n1;
					if(temp<=10)
							System.out.println("You are near to answer..Answer is higher than current guess");
					else
						System.out.println("Too low");
				}
				else if(n1>n) {
					temp=n1-n;
				
					if(temp<=10)
						System.out.println("You are near to answer..Answer is lower than current guess");
					else
						System.out.println("Too high");
				}
				
				if(n1!=n && i<5)
					System.out.println("\nNow only "+(5-i)+" attempts are remaining...Guess Smartly");
				i++;
				 if(i>5) {
					System.out.println("\nGame Over..You lost..Try again !!!");
				}
			}while(i<=5);
			System.out.println("______________________________________________");
			System.out.println("Do you want to play again ? [Y/N] : ");
			ch1=sc.next().charAt(0);
		}while(ch1=='Y'||ch1=='y');
	}

	public static void main(String[] args) {
		NumberGame ng=new NumberGame();
		ng.guessRandom();
	}
}
