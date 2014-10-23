<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="test_online.modol.MMessage"%>
<%@ page import="test_online.modol.Comments"
import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>帖子</title>
</head>
<script type="text/javascript">
function ck(){
	if(!document.getElementById("fromAction").value)
		document.getElementById("show").submit();
	}
</script>
<body onload="ck()">

<input type="hidden"  id="fromAction" value=<s:property value="#request.fromAction"/>>

<form method="post" action="message_action_show_message" id="show"> </form>

标题：<s:property value="#request.message.title"/>
<br> 作者：<s:property value="#request.message.author"/>
<br> 内容：<s:property value="#request.message.message"/>


<form action="post_comment.jsp"method="post">
<input type="submit" name=submit value="评论">
     <input type="hidden"  name="m_id" value=<s:property value="#request.message.m_id"/>>
		<input type="hidden"  name="par_comm" value="">
</form>

 <form action="show_messages.jsp" method="post">
 <input type="submit" name=submit value="返回帖子列表">
 </form>
评论：


	<br><s:iterator value="#request.comments" id="comments">
		<s:if test="par_comm">
		<s:property value="author"/>评论:
		</s:if>
		<s:else><s:property value="author"/>回复<s:property value="par_comm"/>:
		 </s:else>
	<br>	
       <s:property value="comment"/>
		<br><s:property value="comment_date"/>
		<form action="post_comment.jsp"method="post">
	<input type="submit" name=submit value="回复">
	  <input type="hidden"  name="m_id" value=<s:property value="#request.message.m_id"/>>
		<input type="hidden"  name="par_comm" value=<s:property value="author"/>>
		</form>
		
		<form action="manger_action!delete_comment"method="post">
	<input type="submit" name=submit value="删除">
	  <input type="hidden"  name="com_id" value=<s:property value="com_id"/>>
		<input type="hidden"  name="author" value=<s:property value="author"/>>
		<input type="hidden"  name="m_id" value=<s:property value="#request.message.m_id"/>>
		<s:property value="#request.message.m_id"/>
		</form>
	</s:iterator> 
 
</body>
</html>