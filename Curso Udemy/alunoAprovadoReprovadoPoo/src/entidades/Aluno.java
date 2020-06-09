package entidades;

public class Aluno {
	
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	public void resultadoAluno() {
		double resultado = nota1 + nota2 + nota3;
		if(resultado > (100 * 0.6)) {
			System.out.printf("NOTA FINAL = %.2f\nPASSOU" , resultado);
			
		}else {
			System.out.printf("NOTA FINAL = %.2f\nFALHOU\n", resultado);
			System.out.printf("PRECISA DE %.2f PONTOS", Math.abs(resultado - 60.0));
		}
		
	}

}
