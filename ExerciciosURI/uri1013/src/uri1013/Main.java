package uri1013;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int entrada,maior;
		
		maior = 0;
		for (int i = 0; i < 3 ; i++) {
			entrada = sc.nextInt();
			if(entrada > maior) {
				maior = entrada;
			}
		}
		System.out.println(maior + " eh o maior");
		
		sc.close();

	}

}
