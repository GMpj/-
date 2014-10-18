package test_online.serves;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;












import com.opensymphony.xwork2.ActionContext;

import test_online.modol.Comments;
import test_online.modol.MMessage;
import test_online.modol.Student;

@Component("messagemanger")
public class MessageManger {
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 测试注释掉的部分
	 * @param title
	 * @param message
	 * @return
	 */
	public boolean creatMessage(String title,String message){
		MMessage mess=new MMessage();
		System.out.println(title+message);
		mess.setTitle(title);
		System.out.println("hh");
		mess.setMessage(message);
		//System.out.println(ActionContext.getContext());
		ActionContext ac = ActionContext.getContext();
		//HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session=request.getSession(false);
		System.out.println("ok");
		Student t=new Student();
		t=(Student) ac.getSession().get("student");
		//t=(Student)session.getAttribute("student");
		
		System.out.println(t.getName());
		mess.setAuthor(t.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		System.out.println(sdf.format(now));
		mess.setMessage_date(sdf.format(now));
		//mess.setCom_number(0);
		
	
		hibernateTemplate.save(mess);
		return true;
	}
	
	public boolean showMessage(int m_id){
		List<MMessage> message=hibernateTemplate.find("from MMessage mess where m_id='"+m_id+"'");
		List<Comments> comments=hibernateTemplate.find("from Comments comments where m_id='"+m_id+"'");
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message",message.get(0) );
		//System.out.println(message.get(0).getMessage());
		//for(int i=0;i<comments.size();i++)
			//System.out.println(comments.get(i).getComment());
		request.setAttribute("comments",comments );
		return true;
		
	}
	public boolean showMessages(){
		System.out.println("测试获取时间");
		List<MMessage> messages=hibernateTemplate.find("from MMessage mess");
		System.out.println("成功获取时间");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("messages",messages );
		for(int i=0;i<messages.size();i++)
			System.out.println(messages.get(i).getTitle());
		return true;
		
	}
	public boolean saveComments(int m_id,String comment,String par_comm){
		Comments com=new Comments();
		com.setM_id(m_id);
		com.setComment(comment);
		com.setPar_comm(par_comm);
		ActionContext ac = ActionContext.getContext();
		Student t=new Student();
		t=(Student) ac.getSession().get("student");
		com.setAuthor(t.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		com.setComment_date(sdf.format(now));
		hibernateTemplate.save(com);
		List<MMessage>messages=hibernateTemplate.find("from MMessage mess where m_id='"+m_id+"'");
		MMessage message=messages.get(0);
		System.out.println(message.getCom_number());
		message.setCom_number(message.getCom_number()+1);
		System.out.println(message.getCom_number());
		hibernateTemplate.update(message);
		System.out.println("haode");
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
