package test_online.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_online.serves.QuestionManger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private String subject;
	private QuestionManger qm;
	private ArrayList<String> answer;
	private int test_id=0;
	private HttpServletRequest request;

	
	public TestAction(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		qm=(QuestionManger)ctx.getBean("questionmanger");
	}
	
	
	public String execute () throws Exception{
		System.out.println(subject);
		if(qm.getTestQuestion(subject))
			return "show_success";
		else return "show_false";
		
	}
	
/**
 * 测试获取request的方法
 * @return
 * @throws Exception
 */
	public String save_grade()throws Exception{
	   
		request=ServletActionContext.getRequest();
		System.out.println("test_id="+request.getParameter("test_id"));
		test_id=Integer.parseInt(request.getParameter("test_id"));
        for(int i=0;i<test_id;i++){
        	String I="group"+i;
        	System.out.println(I);
        	String a=(String) request.getParameter(I);
        	if(a==null){
        		
        	}
        	else{
        		
            	System.out.println(a);
            	//answer.add(a);
            	answer=new ArrayList<String>();
            	answer.add(i, a);
        	}
             
        }
	
		int count=qm.check_answer(answer);
		System.out.println("count="+count);
		if(qm.save_grade(count))
			return "grade_success";
		else return "show_false";
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public QuestionManger getQm() {
		return qm;
	}

	public void setQm(QuestionManger qm) {
		this.qm = qm;
	}

	
}
