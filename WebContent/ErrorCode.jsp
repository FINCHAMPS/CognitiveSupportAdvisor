<%-- 
    Document   : ErrorCode
    Created on : Nov 28, 2016, 1:25:50 PM
    Author     : ADMINIBM
--%>

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
            padding: 20px;
            margin: auto;
         }
         
         h1{
             text-align: center;
         }
        
      </style>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <div style="height: 200px">
            <img src="YB_New.png" style="margin-left: auto" alt="Bank Icon" width="" height="" align="left">
            <img src="watson_small.png" style="margin-right: auto"  alt="Bank Icon" width="" height="" align="right">
            </div>
        <div>
            <h1 style="color: blue"><font size="7">Cognitive Support Advisor</font></h1>
        </div>
            
        <table>
            <tr>
                <td><input style="width: 800px;height:40px" type="text" name="errorCode"/>    <button style="padding: 10px 15px;"type="submit">Search</button></td>
            </tr>
         </table>
        </form>
    </body>
</html>
