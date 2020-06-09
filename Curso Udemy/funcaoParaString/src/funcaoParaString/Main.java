package funcaoParaString;

public class Main {

	public static void main(String[] args) {
		
		String original = "abcde FEGHIJ ABC abc DEFG    ";
		
		//Coloca tudo em letra minúscula
		String s01 = original.toLowerCase();
		//Coloca tudo em letra maiúscula
		String s02 = original.toUpperCase();
		//Tira os espaços do começo e do fim
		String s03 = original.trim();
		//Começa a partir da posição 2
		String s04 = original.substring(2);
		//Começa a partir da posição 2 e vai ate a posição 9
		String s05 = original.substring(2, 9);
		//Substitue todos os 'a' por 'x'
		String s06 = original.replace('a','x');
		//Substitue todos os 'abc' por 'xy'
		String s07 = original.replace("abc","xy");
		//Indica a posição começando da posição inicial
		int x = original.indexOf("bc");
		//Indica a posição começando da posição final
		int y = original.lastIndexOf("bc");
		
		System.out.println("Original: -" + original + "-");
		System.out.println("toLowerCase: -" + s01 + "-");
		System.out.println("toUpperCase: -" + s02 + "-");
		System.out.println("trim: -" + s03 + "-");
		System.out.println("substring(2): -" + s04 + "-");
		System.out.println("substring(2,9): -" + s05 + "-");
		System.out.println("replace('a','x'): -" + s06 + "-");
		System.out.println("replace('abc','xy'): -" + s07 + "-");
		System.out.println("Index of 'bc': " + x);
		System.out.println("Last index of 'bc': " + y);
		
		//Separa o String por " " e guarda em um vetor
		String s = "Yuri Christian Carvalho Costa";
		String[] vetor = s.split(" ");
		
		for(int i = 0; i < 4; i++) {
			System.out.println(vetor[i]);
		}		

	}

}
