<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="test_online.modol.Student" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

<s:property value="#session.student.name"/>

   <form method="post" action="login.jsp">                   
    	<input type="submit" name="login" value="登录"/>
    </form>
    
     <form method="post" action="test_action">                   
    	<input type="submit" name="subject" value="英语"/>
    </form>
    
    <form method="post" action="post_message.jsp">                  
    	<input type="submit" name="sub" value="发表主题"/>
    </form>
    
    <form method="post" action="show_messages.jsp">                 
    	<input type="submit" name="sub" value="查看主题"/>
    </form>
    
    <br>
</body>
</html>