package application;

import java.io.File;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path:");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("Nome do arquivo: " + path.getName());
		System.out.println("Caminho sem o nome do arquivo: " + path.getParent());
		System.out.println("Caminho completo: " + path.getPath());
		
		sc.close();
		
	}

}
