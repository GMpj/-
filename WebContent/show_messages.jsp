<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="test_online.modol.MMessage" import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帖子列表</title>
</head>
<script type="text/javascript">
function ck(){
	if(!document.getElementById("fromAction").value)
		//var str=<s:property value="#request.messages"/>;
		//if(!str)
		document.getElementById("show").submit();
	}
</script>
<body onload="ck()">

	<input type="hidden"  id="fromAction" value=<s:property value="#request.fromAction"/>> 
   
   <form method="post" action="message_action_show_messages" id="show">
	   </form>
	   
   <s:if test="!#request.messages">没有帖子</s:if>
   <s:else>
   <table> 
          <s:iterator value="#request.messages" id="message">
           <tr>
           <td><s:property value="title"/></td>
           <td><s:property value="com_number"/></td>
           <td><s:property value="author"/></td>
           <td><s:property value="message_date"/></td> 
           
            <form method="get" action="message_action!show_message">
           <td><input type="submit" name=submit value="查看">
	  <input type="hidden"  name="m_id" value=<s:property value="m_id"/>> </td>
	   </form>
	    <form method="post" action="manger_action!delete_message">
           <td><input type="submit" name=submit value="删除">
	  <input type="hidden"  name="m_id" value=<s:property value="m_id"/>> </td>
	   </form>
	  </tr>
	  </s:iterator>
	  </table>
	</s:else>
   
</body>
</html>
