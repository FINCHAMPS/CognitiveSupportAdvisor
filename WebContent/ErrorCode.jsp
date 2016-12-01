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
        <title>Error Code Page</title>
        
         <style>
         table, th , td {
            border:3px solid grey;
            border-collapse: collapse;
            padding: 20px;
            margin: auto;
         }
         
        
         body{
             background-color: lightblue;
             background-image : url("main.jpeg");
             
         }
         h1{
             text-align: center;
         }
      </style>
    </head>
    <body>
        <form action="LoginServlet" method="post">
        <div>
            <h1>Welcome to Cognitive Support Advisor</h1>
        </div>
        <table>
         <!--   <tr>
                <td><b>Enter Error Code :</b></td>
                <td><input style="width:200px;" type="text" name="errorCode" id="errorCodeId" value=""></td>
            </tr> -->
            
            <tr>
                <td align=""><b>Enter Error Code/Description :</b></td>
                <td><textarea style="width:200px; height:200px;" name="errorCode" id="errorDescId"></textarea></td>
            </tr>
           
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" >Submit</button>
                    <button type="reset">Cancel</button>
                </td>
            </tr>
         </table>
        </form>
    </body>
</html>
