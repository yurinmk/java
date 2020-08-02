package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
	
	public static void main(String[] args) {
		
		String strPath = "G:\\Criado\\produtos.csv";
		
		List<String> lista = new ArrayList<>();
		
		//vai ler o arquivo que foi passado no caminho na variável strPath
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			//armazena em line se existe linha ou não
			String line = br.readLine();
			while(line != null) {
				//enquanto existir, pega as informações dentro do arquivo separando por vírgula
				//multiplicando o valor do produto pela quantidade
				//e adiciona na lista
				lista.add(line.split(",")[0] + "," + Double.toString(Double.parseDouble(line.split(",")[1]) * Double.parseDouble(line.split(",")[2])));
				line = br.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		//cria uma variável do tipo File com o caminho que foi passado antes
		File path = new File(strPath);
		
		//cria uma sub-pasta chamada out no caminho que está na variável strPath 
		boolean createdFolder = new File(path.getParent() + "\\out").mkdir();
		//verifica se já existe essa pasta criada
		if(createdFolder == true) {
			//se a pasta foi criada, vai ser criado um arquivo csv chamado summary
			String newPath = path.getParent() + "\\out\\summary.csv";
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath))){
				//adiciona todo que estiver na lista dentro do arquivo summary
				for(String x: lista) {
					bw.write(x);
					bw.newLine();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			//se a pasta não foi criada quer dizer que ela já existe
			String strPath2 = "G:\\Criado\\out\\summary.csv";
			//então vai ser mostrado as novas informações que estão dentro do arquivo novo
			try (BufferedReader br = new BufferedReader(new FileReader(strPath2))){
				String line = br.readLine();
				while(line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}
