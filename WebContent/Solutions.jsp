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
        <title>JSP Page</title>
        
        <style>
            table, th , td {
                border:0px solid grey;
                border-collapse: collapse;
                padding: 5px;
                color: white;
                font-size: medium;
            }
            body{
                background-color : navajowhite;
                background-image : url("ornament.jpg");
                }
            h1{
                text-align: center;
                color: white;
            }
             h4{
               
                color: white;
            }
            input[type="checkbox"]
            {
                vertical-align:middle;
                color: white;
            }
            textarea{
                overflow-y: scroll;
            }
            .button {
                background-color:#D3D3D3;
                border: grey;
                color: black;
                width: 200px;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 12px;
                border: 2px solid #555555;
            }
        </style>
    </head>
    <body>
        <form>
        <%
        JSONArray jArray = (JSONArray) request.getAttribute("MySolutionsArray");
        String providedError = (String) request.getAttribute("providedError");
        %>
        <h4>
      
          
        
          <div>
                <h1>Cognitive Support Advisor</h1>
          </div>
        
            <%for (int i = 0 ; i < jArray.length(); i++){  %>
           
                 
        <fieldset>
             <legend><h4>Solution No.<%=(i+1)%> </h4> </legend>
                <table style="width:100%">
<!--                    <tr>
                        <td colspan="2" align="center">
                            <input type="checkbox" name="checkbox" value=""/> &nbsp;&nbsp;Select this solution if it helped resolve your problem.
                        </td>           
                    </tr>-->
                    
                    <tr>
                       <td colspan="2">
                           <input type="checkbox" name="checkbox" id="checkbox" value="checkbox">&nbsp;&nbsp; Select this solution if it helped resolve your problem.
                        </td 
                    </tr> 
                    <tr>
                        <td style="width:20%"><h4>Error Code / Description:</h4></td>
                        <td style="width:100%"><input style="width:100%;" type="text" name="errorCode" id="errorCodeId" value="<%=providedError%>"> </td>
                    </tr>

                    <tr>
                        <td style="width:20%"><h4>Steps :</h4></td>
                        <td style="width:100%"><textarea style="width:100%; height:100px;" name="steps" id="steps"><%=jArray.getJSONObject(i).getJSONObject("arr").getString("str")%></textarea></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="right">
                            <button type="submit" >Edit</button>
                            <button type="reset">Save</button>
                        </td>
                    </tr>
                </table>
        </fieldset>
        
            <% } %>
            <div style="width:100%;height:100px;vertical-align:central;margin-top: 2em;text-align:center;">
               
                <button class="button" type="">Add New</button>
                <button class="button" type="">Search</button>
                <button class="button" type="">Close</button>
                
            </div>
        </form>
    </body>
</html>
