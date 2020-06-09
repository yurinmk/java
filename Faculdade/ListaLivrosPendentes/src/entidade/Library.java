package entidade;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	
	public Library() {
		
	}
	//Uma lista de livros
	private List<Books> book = new ArrayList<>() {
		{
			add(new Books("The Lord of the Rings", "11111-58-10-5"));
			add(new Books("JAVA - The Best", "22222-58-10-4"));
			add(new Books("Python - For All", "33333-58-10-3"));
			add(new Books("COVID 19 - The Cure", "44444-58-10-2"));
			add(new Books("Architecture in a Week", "55555-58-10-1"));
			add(new Books("Virtual reality", "65656-58-10-1"));
			add(new Books("The Internet of Things", "77777-58-10-1"));
			add(new Books("Big Data", "88888-58-10-1"));
			add(new Books("The dilemma of innovation", "99999-58-10-1"));
		}
	};
	//lista de estudantes que tem livros alugados tendo uma composi��o da classe Books
	private List<Student> list = new ArrayList<>() {
		{
			add(new Student("Yuri", "2019100", "SPI", "Pending", book.get(0)));
			add(new Student("Yuri", "2019100", "SPI", "Pending", book.get(8)));
			add(new Student("Kruba", "2019200", "SPI", "Delivered", book.get(1)));
			add(new Student("Kruba", "2019200", "SPI", "Pending", book.get(6)));
			add(new Student("Pedro", "2019300", "SPI", "Pending", book.get(4)));
			add(new Student("Iria", "2019400", "SPI", "Pending", book.get(2)));
			add(new Student("Iria", "2019400", "SPI", "Pending", book.get(5)));
			add(new Student("Iria", "2019400", "SPI", "Pending", book.get(7)));
			add(new Student("Barbara", "2019500", "SPI", "Delivered", book.get(3)));
		}
	};

	public List<Books> getBook() {
		return book;
	}
	
	public void setBook(List<Books> book) {
		this.book = book;
	}
	
	public List<Student> getList() {
		return list;
	}
	
	public void setList(List<Student> list) {
		this.list = list;
	}
	
	//for each que retorna os estudantes que est�o com a lista pendente
	//e para o retorno n�o ficar polu�do caso o estudante tenha mais de um livro pendente
	//foi colocada uma condi��o para que se o o nome do estudante j� tiver sido armazenado
	//na vari�vel temp, o que ser� armazenado em seguida ser� apenas o livro que est� pendente
	//caso n�o esteja armazenado nenhum nome na vari�vel, ser� armazenada a informa��o completa
	public String showPending() {
		String temp = "";
		int i = 0;
		for(Student x : list) { //x.getStatus() == "Pending"
			if(temp.contains(x.getName()) && x.getStatus() == "Pending") {
				i++;
				temp += list.get(i).getBook();
			}else if(x.getStatus() == "Pending"){
				temp += x ;
				i++;
			}
		}
		return temp;
	}
}
