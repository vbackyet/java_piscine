package school21.spring.service.models;

import java.time.LocalDateTime;
import java.util.Objects;
// import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
public class Message {

	private Integer id;
	private User author;
	// private Chatroom chatroom;
	private String text;
	private LocalDateTime messageDateTime;

	public Message(Integer id, User author, String text, LocalDateTime messageDateTime) {
		this.id = id;
		this.author = author;
		// this.chatroom = chatroom;
		this.text = text;
		this.messageDateTime = messageDateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public String getNameOfUser() {
		return author.getLOGIN();
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	// public Chatroom getChatroom() {
	// 	return chatroom;
	// }

	// public void setChatroom(Chatroom chatroom) {
	// 	this.chatroom = chatroom;
	// }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		return id == message.id && author.equals(message.author) && text.equals(message.text) && messageDateTime.equals(message.messageDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, author, text, messageDateTime);
	}

	@Override
    public String toString() {
        return "Message : {" + "\n" +
                "\tid=" + id + "\n" +
                "\tauthor=" + author + "\n" +
                "\ttext='" + text + '\'' + "\n" +
                "\tdate=" + messageDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + '\n' +
                '}';
    }

}