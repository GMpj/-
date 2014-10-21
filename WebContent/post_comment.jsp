<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

<!--  
<form method="post" action="message_action!save_comment">
内容：
<textarea rows="10" cols="80" name="comment">
</textarea><br>
<input type="submit" name="sub" value="发表"/>
<input type="hidden"  name="m_id" value=<%=request.getParameter("m_id") %>>
<%=request.getParameter("m_id") %>
		<input type="hidden"  name="par_comm" value=<%=request.getParameter("par_comm") %>>
		<%=request.getParameter("par_comm") %>
</form>
-->


<form method="post" action="message_action_save_comment">
内容：
<textarea rows="10" cols="80" name="comment">
</textarea><br>
<input type="submit" name="sub" value="发表"/>
<input type="hidden"  name="m_id" value=<s:property value="#parameters.m_id"/>>
<s:property value="#parameters.m_id"/>

		<input type="hidden"  name="par_comm" value=<s:property value="#parameters.par_comm"/>>
	

</form>
    <br>
</body>
</html>