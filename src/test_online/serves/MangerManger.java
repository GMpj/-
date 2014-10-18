package test_online.serves;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import test_online.modol.Comments;
import test_online.modol.MMessage;
import test_online.modol.Student;

import com.opensymphony.xwork2.ActionContext;
@Component("mangermanger")
public class MangerManger {
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 测试如何进行删除，一条信息和多条信息
	 * @param m_id
	 * @return
	 */
   public boolean deleteMessage(int m_id){
	   ActionContext ac = ActionContext.getContext();
		Student t=new Student();
		t=(Student) ac.getSession().get("student");
		if(t.getManger()==1){
     
	    hibernateTemplate.delete(hibernateTemplate.get(MMessage.class, m_id));
		List<Comments> comments=hibernateTemplate.find("from Comments comments where m_id='"+m_id+"'");
	   hibernateTemplate.deleteAll(comments);
	   System.out.println("删除帖子成功");
	   return true;
	   }
	   return false;
   }
   /**
    * 测试equals
    * @param com_id
    * @param author
    * @return
    */
   public boolean deleteComment(int com_id,String author,int m_id){
	   ActionContext ac = ActionContext.getContext();
		Student t=new Student();
		t=(Student) ac.getSession().get("student");
		System.out.println(author);
		System.out.println(t.getName()==author);
		System.out.println(t.getName().equals(author));
		System.out.println(author.equals(t.getName()));
		//System.out.println(com_id);
		//System.out.println(hibernateTemplate.get(Comments.class, com_id));
		if(t.getName().equals(author)||t.getManger()==1){
	   hibernateTemplate.delete(hibernateTemplate.get(Comments.class, com_id));
	   List <MMessage>mess= hibernateTemplate.find("from MMessage mess where m_id= '"+m_id+"'");
	   MMessage message=mess.get(0);
	   message.setCom_number(message.getCom_number()-1);
	   hibernateTemplate.update(message);
	   System.out.println("删除回复成功"); 
	   return true;
	   }
		else return false;
   }
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
