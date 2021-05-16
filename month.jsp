<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String bgcolor = "#9d9dff";
	String tablecolor = "#dddddd";
	String fontcolor = "#666666";
    String purple = "#9c9cfc";
    String dgrey = "#dcdcdc";
    String lgrey = "#eeeeee";
    String dgtext = "#6b646e";
    String lgtext = "#777777";

	//String tableborder = "#ffff00";
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

%>
<table style="border: 0px; background-color: lightgrey;">

</table>