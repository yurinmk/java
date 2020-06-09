package uri1018;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n100,n50,n20,n10,n5,n2,n1,temp;
				
		n100 = (int) x / 100;
		temp = x%100;
		n50 = (int) temp / 50;
		temp = temp%50;
		n20 = (int) temp / 20;
		temp = temp%20;
		n10 = (int) temp / 10;
		temp = temp%10;
		n5 = (int) temp / 5;
		temp = temp%5;
		n2 = (int) temp / 2;
		temp = temp%2;
		n1 = (int) temp / 1;
		
		System.out.println(x);
		System.out.println(n100 + " nota(s) de R$ 100,00");
		System.out.println(n50 + " nota(s) de R$ 50,00");
		System.out.println(n20 + " nota(s) de R$ 20,00");
		System.out.println(n10 + " nota(s) de R$ 10,00");
		System.out.println(n5 + " nota(s) de R$ 5,00");
		System.out.println(n2 + " nota(s) de R$ 2,00");
		System.out.println(n1 + " nota(s) de R$ 1,00");
		
		
		sc.close();
	}

}
