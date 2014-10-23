package test_online.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_online.serves.AnalyzeURL;
import test_online.serves.MessageManger;
import test_online.serves.StudentManger;

import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {

	private String title;
	private String message;
	private String comment;
	private int m_id=0;
	private String par_comm;
	private MessageManger mm;
	
	 public MessageAction() {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
			 mm = (MessageManger)ctx.getBean("messagemanger");
		}

	 public String  execute()throws Exception{
		 if(mm.creatMessage(title, message)){
			 if(mm.showMessages())
		     return "show_messages";
			else return"show_false";
				}
		 else return "show_false";
	 }
	 
	 public String show_message()throws Exception{
		 System.out.println(m_id);
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println(request.getRequestURI());
		//m_id=Integer.valueOf(AnalyzeURL.AnalyzeURLid(request.getRequestURI().toString()));
		//request.getRequestURL()
		System.out.println(m_id);
		if(mm.showMessage(m_id))
		 return "show_message";
		else return "show_false";
	 }
	 public String show_messages()throws Exception{
			if(mm.showMessages())
			{
				//HttpServletRequest request=ServletActionContext.getRequest();
				///request.setAttribute("fromAction", true);
				 return "show_messages";
				 
			}
			
			else return "show_false";
		 }
	 public String save_comment()throws Exception{
		 System.out.println(comment);
		if( mm.saveComments(m_id, comment, par_comm)){
			//if(mm.showMessage(m_id))
				//return "show_message";
			//else return "show_false";
			//HttpServletRequest request=ServletActionContext.getRequest();
			
			return"success";
		}
			
		 
		else return "show_false";
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

	public MessageManger getMm() {
		return mm;
	}

	public void setMm(MessageManger mm) {
		this.mm = mm;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getPar_comm() {
		return par_comm;
	}

	public void setPar_comm(String par_comm) {
		this.par_comm = par_comm;
	}

	
}
