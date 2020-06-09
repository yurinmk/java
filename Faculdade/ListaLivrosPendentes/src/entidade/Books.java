package entidade;

public class Books {
	
	private String title;
	private String isbn;
	
	public Books() {
	}

	public Books(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "\nTitle: " + title + " - ISBN: " + isbn;
	}
	
	

}
