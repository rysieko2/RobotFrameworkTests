import java.util.Scanner;
public class fibonacci_sequence
{
	public static void main(String[] args)
	{
		System.out.print("How many Fibonacci numbers:"); 	//wyswietla napis
		Scanner key = new Scanner(System.in);				
		int x = key.nextInt();  							//pobiera dane z klawiatury dla x
		System.out.println(x);
		
		if (x < 1){ 
			System.out.println("The number entered is incorrect!!!");
		}
		else {
			long fib[] = new long[x];   						//deklaracja dlugosci tablicy
			if (x>0){
				fib[0]=0; 										// dodanie do tablicy 1 elementu wartosci 1
			}
			if (x > 1){
				fib[1]=1;
			}													// dodanie do tablicy 1 elementu wartosci 1
			for (int i=2; i<x; i++)  							//uzycie petli for licznik od 2 do mniejszej od x
				fib[i] = fib[i-2] + fib[i-1];					//dodanie do tablicy
				
					System.out.print("Fibonacci numbers("); 
				
				for (int i=0; i<x; i++)  
					if (i<x-1)
						System.out.print(fib[i] + ",");
					else
						System.out.print(fib[i] + ")");
			}
	 }
}