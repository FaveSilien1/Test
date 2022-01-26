<%@ page import="java.io.*" isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Somme error in page</h2>

 Message : <%= exception.getMessage() %>
<h3> StrackTrace :</h3>
<%

   StringWriter sw = new StringWriter();
   PrintWriter pw = new PrintWriter(sw);

   exception.printStackTrace(pw);
   out.println("<pre>");
   out.println(sw);
   out.println("</pre>");
   pw.close();
   sw.close();
%>

%>

</body>
</html>