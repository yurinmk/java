package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	//tem um formato de data para a aplicação inteira ao invés de ter uma cópia para cada post
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	// COMPOSIÇÃO
	private List<Comment> comment = new ArrayList<>();

	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void addComment(Comment comment) {
		this.comment.add(comment);
	}

	public void removeComment(Comment comment) {
		this.comment.remove(comment);
	}

	//toString normal
	/*public String toString() {
		String temp = "Comments:\n";
		for (Comment x : comment) {
			temp += x.getText() + "\n";
		}
		return this.content + "\n" + this.likes + " Likes - " + this.moment + "\n" + this.content + "\n" + temp;
	}*/
	//usar o StringBuilder se torna melhor do que o toString convencional 
	//porque usa menos memória, pois não faz tantas concatenações 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.title + "\n");
		sb.append(this.likes + " Likes - ");
		//formata o moment na data passada como paranmetro no sdf
		sb.append(sdf.format(this.moment) + "\n");
		sb.append(this.content + "\n");
		sb.append("Comments:\n");
		for(Comment x : comment) {
			sb.append(x.getText() + "\n");
		}
		return sb.toString();
		
	}

}
