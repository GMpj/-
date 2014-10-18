package test_online.modol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChoiceQuestion {

	private int id_question_em;
	private String question_title;
	private String ChoiceA;
	private String ChoiceB;
	private String ChoiceC;
	private String ChoiceD;
	private String subject;
	private String answer;
	
	@Id
	@GeneratedValue
	public int getId_question_em() {
		return id_question_em;
	}
	public void setId_question_em(int id_question_em) {
		this.id_question_em = id_question_em;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getChoiceA() {
		return ChoiceA;
	}
	public void setChoiceA(String choiceA) {
		ChoiceA = choiceA;
	}
	public String getChoiceB() {
		return ChoiceB;
	}
	public void setChoiceB(String choiceB) {
		ChoiceB = choiceB;
	}
	public String getChoiceC() {
		return ChoiceC;
	}
	public void setChoiceC(String choiceC) {
		ChoiceC = choiceC;
	}
	public String getChoiceD() {
		return ChoiceD;
	}
	public void setChoiceD(String choiceD) {
		ChoiceD = choiceD;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
