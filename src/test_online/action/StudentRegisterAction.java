package test_online.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_online.modol.Student;
import test_online.serves.StudentManger;

import com.opensymphony.xwork2.ActionSupport;

public class StudentRegisterAction extends ActionSupport{
	
    private int id_st;
	private int id_number;
	private String name;
	private String password;
	private String college;
	private String major;
	private int grade;
	private StudentManger sm;
	
	public StudentRegisterAction() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		 sm = (StudentManger)ctx.getBean("studentmanger");
	}

	public String execute() throws Exception {
	
		Student st=new Student();
		st.setId_st(id_st);
		st.setId_number(id_number);
		st.setName(name);
		st.setPassword(password);
		st.setCollege(college);
		st.setMajor(major);
		st.setGrade(grade);
		if(sm.check(id_number)){
		sm.save(st);
		return "register_success";
		}
		else return "register_false";
	}



	public int getId_st() {
		return id_st;
	}

	public void setId_st(int id_st) {
		this.id_st = id_st;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_number() {
		return id_number;
	}



	public void setId_number(int id_number) {
		this.id_number = id_number;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCollege() {
		return college;
	}



	public void setCollege(String college) {
		this.college = college;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public StudentManger getSm() {
		return sm;
	}

	public void setSm(StudentManger sm) {
		this.sm = sm;
	}

	
}
