<%-- 
    Document   : Resolution
    Created on : Nov 30, 2016, 2:45:59 PM
    Author     : ADMINIBM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resolution Page</title>

        <style>
            table, th , td {
                border-collapse: collapse;
                padding: 20px;
                margin: auto;
                font-size: medium;

                align-self: auto;
            }


            body{
                background-color : navajowhite;
                }
    
            h1{
                text-align: center;
            }

        </style>
    </head>
    <body>
        <form>
            <div>
                <h1>Cognitive Support Advisor</h1>
            </div>
            <fieldset>
                <legend> Solution </legend>

                <table>
                    <tr>
                        <td colspan="2" align="center"><input type="checkbox" name="checkbox" id="checkbox" value="">
                            select this solution if it helped resolve your problem.</td>           
                    </tr>
                    <tr>
                        <td>Error Code :</td>
                        <td><input style="width:200px;" type="text" name="errorCode" id="errorCodeId" value=""></td>
                    </tr>

                    <tr>
                        <td style="vertical-align:top">Steps :</td>
                        <td><textarea style="width:200px; height:200px;" name="steps" id="steps"></textarea></td>
                    </tr>

                    <tr>
                        <td colspan="2" align="right">
                            <button type="submit" >Edit</button>
                             
                            <button type="reset">Save</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html> 
