package test_online.serves;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

import test_online.modol.Student;


@Component("studentmanger")
public class StudentManger {

	private HibernateTemplate hibernateTemplate;
	
	public void save(Student st){
		System.out.println("ok");
		hibernateTemplate.save(st);
		System.out.println("success");
	}
	
	public 	boolean check(int id_number){
		List<Student>student =hibernateTemplate.find("from Student st where id_number='"+id_number+"'");

		if(student !=null&&student.size()>0){
			System.out.println(student.get(0).getId_number());
			return false;
		}
		else return true;
	}
	
	public boolean put_session(int id_number,String password){
		 System.out.println("2");
		List<Student>student =hibernateTemplate.find("from Student st where id_number='"+id_number+"'and password='"+password+"'");

		 System.out.println("3");
		if(student !=null&&student.size()>0){
		ActionContext ac = ActionContext.getContext();
		System.out.println(student.get(0).getId_number());
	       ac.getSession().put("student",student.get(0));
	       return true;
		}
		else
		 System.out.println("false");
		 return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
