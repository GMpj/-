<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>

<%@ page import="test_online.modol.MMessage"%>
<%@ page import="test_online.modol.Comments"
import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>帖子</title>
</head>

<body>

<%
MMessage message=(MMessage)request.getAttribute("message");
List<Comments>comments=(List<Comments>)request.getAttribute("comments");

%>
标题：<%=message.getTitle() %>
<br> 作者：<%=message.getAuthor() %>
<br> 内容：<%=message.getMessage() %>

<form action="post_comment.jsp"method="post">
<input type="submit" name=submit value="评论">
     <input type="hidden"  name="m_id" value=<%=message.getM_id() %>>
		<input type="hidden"  name="par_comm" value="">
</form>
<form action="message_action!show_messages"method="post"> 
<input type="submit" name=submit value="返回帖子列表">
</form>
评论：


<% if(!comments.isEmpty()){
	for(int i=0;i<comments.size();i++){
		Comments comment=comments.get(i);	
		
		 
		String s="";
		if(comment.getPar_comm().equals(""))	
			 s=comment.getAuthor()+"评论：";
		else  
		s=comment.getAuthor()+"回复"+comment.getPar_comm()+"：";
		%>
		
	<br>	<%=s %>
        <%=comment.getComment() %>
		<br><%=comment.getComment_date() %>
		<form action="post_comment.jsp"method="post">
	<input type="submit" name=submit value="回复">
	  <input type="hidden"  name="m_id" value="<%=message.getM_id() %>">
		<input type="hidden"  name="par_comm" value="<%=comment.getAuthor() %>">
		</form>
		
		<form action="manger_action!delete_comment"method="post">
	<input type="submit" name=submit value="删除">
	  <input type="hidden"  name="Com_id" value="<%=comment.getCom_id() %>">
		<input type="hidden"  name="author" value="<%=comment.getAuthor() %>">
		<input type="hidden"  name="m_id" value="<%=message.getM_id() %>">
		</form>
			
	
	
		<% }
}

%>
	
       
</body>
</html>