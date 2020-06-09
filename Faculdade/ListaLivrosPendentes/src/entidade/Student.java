package entidade;

public class Student {
	
	private String name;
	private String enrollment;
	private String course;
	private String status;
	
	private Books book;
	
	public Student(String name, String enrollment, String course, String status, Books book) {
		this.name = name;
		this.enrollment = enrollment;
		this.course = course;
		this.status = status;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "\n" + "\nName: " + this.name 
				+ ", Enrollment: " + this.enrollment 
				+ ", Course: " + this.course
				+ ", Status: " + this.status
				+ "\nBooks " + this.book;
	}
	
	
	
	

}
