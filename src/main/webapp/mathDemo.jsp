<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<body bgcolor="teal">
<%--This is Decrarartion --%>
<%!
int counter=10,i=0;
private Integer sum(Integer val1,Integer val2)
{
	return (val1+val2);
}
private Integer diff(Integer val1,Integer val2)
{return (val1-val2);
}
%>
<%--This is JSP scriplet-- --%>
<%
for(i=0;i<counter;i++)
{
out.println("<br>code has run"+i+"times");
}
%>
<h2> code is running second time</h2>
<%
for(i=0;i<counter;i++)
{
out.println("<br>code has run"+i+"times");
}
%>
<br>
<h4>Sum goes here...</h4>
The sum of 2 numbers
<%= sum(16,20) %>
<br>
<%
out.println("sum of 2 numbers is"+sum(30,20));
out.println("Difference of 2 numbers is"+diff(30,20));
%>
<br>
This is JSP Expression::
<%= sum(100,200)
%>
<br>


</body>
</html>

</body>
</html>