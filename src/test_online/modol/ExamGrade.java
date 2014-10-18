package test_online.modol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExamGrade {

	private int id_exam_grade;
	private String subject;
	private String name;
	private int grade;
	@Id
	@GeneratedValue
	public int getId_exam_grade() {
		return id_exam_grade;
	}
	public void setId_exam_grade(int id_exam_grade) {
		this.id_exam_grade = id_exam_grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
