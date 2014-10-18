package test_online.modol;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MMessage {
private int m_id;
private String title;
private String message;
private String author;
private int com_number;
private String message_date;

@Id
@GeneratedValue
public int getM_id() {
	return m_id;
}

public void setM_id(int m_id) {
	this.m_id = m_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getCom_number() {
	return com_number;
}
public void setCom_number(int com_number) {
	this.com_number = com_number;
}

public String getMessage_date() {
	return message_date;
}

public void setMessage_date(String message_date) {
	this.message_date = message_date;
}


}
