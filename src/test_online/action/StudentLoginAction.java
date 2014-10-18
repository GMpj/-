package test_online.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_online.serves.StudentManger;

import com.opensymphony.xwork2.ActionSupport;

public class StudentLoginAction extends ActionSupport {
 private int id_number;
 private String password;
 private StudentManger sm;
 
 public StudentLoginAction() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		 sm = (StudentManger)ctx.getBean("studentmanger");
	}

 public String execute() throws Exception{
	 System.out.println("1");
	 if(sm.put_session(id_number, password)){
		 System.out.println("4");
		 return "login_success";
	 }
	 else return "login_false";
 }

public int getId_number() {
	return id_number;
}

public void setId_number(int id_number) {
	this.id_number = id_number;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public StudentManger getSm() {
	return sm;
}

public void setSm(StudentManger sm) {
	this.sm = sm;
}
 
 
}
