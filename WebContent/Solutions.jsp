<%-- 
    Document   : Solutions
    Created on : Nov 28, 2016, 5:17:20 PM
    Author     : ADMINIBM
--%>

<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cognitive Support Advisor</title>
        
        <style>
            table, th , td {
                border:0px solid grey;
                border-collapse: collapse;
                padding: 0px;
                color: white;
                font-size: medium;
            }
           
            h1{
                text-align: center;
                color: black;
            }
             h4{
               
                color: white;
            }
                      
        </style>
    </head>
    <body>
        <form action="AddNewSolutionServlet" method="post">
        <%
        JSONArray jArray = (JSONArray) request.getAttribute("MySolutionsArray");
        String providedError = (String) request.getAttribute("providedError");
        %>
        <h4>
            <div style="height: 100px">
            <img src="YB_New.png" style="margin-left: auto" alt="Bank Icon" width="" height="" align="left">
            <img src="watson_small.png" style="margin-right: auto"  alt="Bank Icon" width="" height="" align="right">
            </div>
        
             <div> <h1>Cognitive Support Advisor</h1> </div>
        
             <% if(jArray!=null){
                 for ( int i = 0 ; i < jArray.length(); i++ )
                 {%>
                 <p><u><font size="4" color="blue"><%=jArray.getJSONObject(i).getJSONArray("arr").getJSONObject(1).getString("str")%></font></u></p>
                 <p><font color="black"><%=jArray.getJSONObject(i).getJSONArray("arr").getJSONObject(0).getString("str")%></font></p>
                 </br>
                 <%   
                 }
                }
             %>
            
                       
        </form>
    </body>
</html>
