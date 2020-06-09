package uri1005;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double A, B, media;
		
		A = sc.nextDouble();
		B = sc.nextDouble();
		
		media = ((A * 3.5) + (B * 7.5)) / (3.5 + 7.5);
		
		System.out.printf("MEDIA = %.5f\n" , media);
		
		
		sc.close();

	}

}
