<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ page import="test_online.modol.ChoiceQuestion" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>试题</title>
</head>



<script>
var count = 10;
while(count>=0){
jQuery('#time').html('第'+count+'秒');
count--;
}
</script> 
<form id="frm" action="test_action!save_grade">
考试还剩余<div id="time"></div><div id='time'></div>
		<input type="hidden"  name="test_id" value=<%=test_id %>>
</form>
<script>
    var times = 3* 60;//剩余时间,单位秒
    var timeDiv = document.getElementById("time");
    var timeObj = null;
    function timer(){
    	if(times == 0){
            //倒计时结束，提交表单
            disp_alert();
            document.getElementById("frm").submit();
            window.clearInterval(timeObj);
            
            
        }
        var t = Math.floor(times/60) +"分"+times%60+"秒"
        timeDiv.innerHTML = t;
        times --;
    }
    timeObj = window.setInterval(timer,1000);
    function disp_alert()
{
alert("考试结束！");
}
</script>

<body>
<%!
	StringBuffer group=new StringBuffer("group1");
%>
<%
List<ChoiceQuestion>result=(List<ChoiceQuestion>)request.getAttribute("choicequestion");
%>
<%!int test_id;
 %>
<form action="test_action!save_grade"method="post"name=form>
<% if(!result.isEmpty()){
    test_id=result.size();
	for(int i=0;i<result.size();i++){
		group.replace(0,group.length(),"group"+i);
		ChoiceQuestion t=result.get(i);
		String I="group"+i;
		System.out.println(I);
		%>
		 
		<%=i+1 %>、<%= t.getQuestion_title()%>
		<br><input type="radio" name="<%=I %>" value="A"/><%= t.getChoiceA() %>
		 <br><input type="radio" name="<%=I %>" value="B"/><%= t.getChoiceB() %>
		 <br><input type="radio" name="<%=I %>" value="C"/><%= t.getChoiceC() %>
		<br><input type="radio" name="<%=I %>" value="D"/><%= t.getChoiceD() %>
		<br>
		<% }
}

%>
		<input type="submit" name=submit onclick="disp_alert()" value="提交">
		<input type="hidden"  name="test_id" value=<%=test_id %>>
		
	   <%= test_id %>
	</form>
       
</body>
</html>