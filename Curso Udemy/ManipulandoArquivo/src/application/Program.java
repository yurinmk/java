package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//Vai fazer um vetor com o nome de todas as pastas que estão no caminho passado
		File[] folders = path.listFiles(File::isDirectory);
		
		System.out.println("FOLDERS:");
	
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		//vai fazer um vetor com o nome de todos os arquivos que estão no caminho passado
		File[] files = path.listFiles(File::isFile);
		
		System.out.println("FILES:");
		for(File file : files) {
			System.out.println(file);
		}
		
		//new File(strPath + "\\Criado").mkdir() cria uma pasta a partir do caminho que foi passado
		boolean success = new File(strPath + "\\Criado").mkdir();
		
		System.out.println("Directory created successfully? " + success);
		
		sc.close();
		
	}
}
