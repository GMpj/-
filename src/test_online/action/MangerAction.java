package test_online.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_online.serves.MangerManger;
import test_online.serves.MessageManger;

import com.opensymphony.xwork2.ActionSupport;

public class MangerAction extends ActionSupport {
    private int m_id;
    private int com_id;
    private String author;
	private MangerManger mangermanger;
	private MessageManger messagemanger;
	public MangerAction() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		 mangermanger = (MangerManger)ctx.getBean("mangermanger");
		 messagemanger=(MessageManger)ctx.getBean("messagemanger");
	}
	 public String delete_message()throws Exception{
		 if(mangermanger.deleteMessage(m_id)){
			 if(messagemanger.showMessages())
		 return "show_messages";
			 else return "show_false";
		 }
		 else return "show_false";
	 }
	 public String delete_comment()throws Exception{
		 System.out.println(m_id);
		 if(mangermanger.deleteComment(com_id,author,m_id)){
			 if(messagemanger.showMessage(m_id))
		 return "show_message";
			 else return "show_false";
		 }
		 else return "show_false";
	 }
	 
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	 
}
