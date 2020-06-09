package uri1006;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		double A, B, C, media;
		
		A = sc.nextDouble();
		B = sc.nextDouble();
		C = sc.nextDouble();
		
		media = ((A * 2.0) + (B * 3.0) + (C * 5.0)) / (2.0 + 3.0 + 5.0);
		
		System.out.printf("MEDIA = %.1f\n" , media);
		
		
		sc.close();

	}

}
