<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="test_online.modol.MMessage" 
import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帖子列表</title>

</head>
<body>
 <form method="post" action="post_message.jsp">
  <input type="submit" name=submit value="发表主题">
   
</form>
<table>
 <%
   System.out.println("good");
   List<MMessage>messages=(List<MMessage>)request.getAttribute("messages");
   System.out.println("asd");
   System.out.println(messages.size());
   String s="";
   if(messages.size()==0)
	   s="没有帖子";
	for(int i=0;i<messages.size();i++){
		System.out.println(i);
		MMessage message=messages.get(i);
		//String title=message.getTitle();
	    //int m_id=message.getM_id();
	
		%>
          <%=s %>
           <tr>
           <td><%=message.getTitle() %> </td>
           <td><%=message.getCom_number() %></td>
           <td><%=message.getAuthor() %>  </td>
           <td><%=message.getMessage_date() %> </td> 
           
            <form method="post" action="message_action!show_message">
           <td><input type="submit" name=submit value="查看">
	  <input type="hidden"  name="m_id" value="<%=message.getM_id()%>"> </td>
	   </form>
	    <form method="post" action="manger_action!delete_message">
           <td><input type="submit" name=submit value="删除">
	  <input type="hidden"  name="m_id" value="<%=message.getM_id()%>"> </td>
	   </form>
	  </tr>
	 
	  <%
	  }
	  %>
   </table>
</body>
</html>
