<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="test_online.modol.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<%
 Student st=(Student)session.getAttribute("student");
 String s=st.getName();
%>
<%=s %>
<form method="post" action="test_action">
                           
    	<input type="submit" name="subject" value="英语"/>
    </form>
    <form method="post" action="post_message.jsp">
                           
    	<input type="submit" name="sub" value="发表主题"/>
    </form>
    <form method="post" action="message_action!show_messages">
                           
    	<input type="submit" name="sub" value="查看主题"/>
    </form>
    <br>
</body>
</html>