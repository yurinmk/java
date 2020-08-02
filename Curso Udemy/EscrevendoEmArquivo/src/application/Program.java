package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	
	public static void main(String[] args) {
		
		String[] lines = new String[] {"Este arquivo foi escrito no eclipse","Vlw!","Flw!","He nohs!"};
		
		String path = "G:\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
