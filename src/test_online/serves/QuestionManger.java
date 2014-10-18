package test_online.serves;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import test_online.modol.ChoiceQuestion;
import test_online.modol.ExamGrade;
import test_online.modol.Student;

@Component("questionmanger")
public class QuestionManger {
	private HibernateTemplate hibernateTemplate;
	private static List<ChoiceQuestion>cq;

	
	public boolean getTestQuestion(String subject){
		
		cq=hibernateTemplate.find("from ChoiceQuestion choicequestion where subject='"+subject+"'");
		
		
		if(cq!=null&&cq.size()>0){
			System.out.println(cq.size());
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("choicequestion", cq); 
			return true;
			
		}
		else 
			System.out.println("false");
		return false;
	} 
	
	public int check_answer(List<String>answer){
		int count=0;
		if(cq==null){
			System.out.println("cq=null");
			//cq=hibernateTemplate.find("from ChoiceQuestion choicequestion where subject='"+subject+"'");
		}
		else{
		for(int i=0;i<cq.size();i++){
			System.out.println(cq.get(i).getAnswer());
			System.out.println(answer.get(i));
			if(cq.get(i).getAnswer().equals(answer.get(i)))
			count++;
		   
		}
		}
		System.out.println(count);
		return count;
	}
	
	public boolean save_grade(int count){
		System.out.println("start");
		if(cq==null){
			
		}
		else{
			System.out.println("cq="+cq);
			ActionContext ac = ActionContext.getContext();
			Student t=new Student();
			t=(Student) ac.getSession().get("student");
			System.out.println(t.getName());
			ExamGrade eg=new ExamGrade();
			eg.setName(t.getName());
			eg.setSubject(cq.get(0).getSubject());
			System.out.println(count);
			eg.setGrade(count);
			hibernateTemplate.save(eg);
			System.out.println("ok");
		}
		
		
		return true;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
