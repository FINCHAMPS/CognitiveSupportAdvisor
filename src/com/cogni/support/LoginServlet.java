/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cogni.support;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cogni.core.*;
import javax.servlet.RequestDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
/**
 *
 * @author ADMINIBM
 */
public class LoginServlet extends HttpServlet {
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            ErrorBean eb = new ErrorBean();
            eb.setError(String.valueOf(request.getParameter("errorCode")));
            
            //MyService ms = new MyService();
            
            MyServiceWithTitles mswt = new MyServiceWithTitles();
            JSONObject js = XML.toJSONObject(mswt.CallRRService( eb.getError()));
           
            // JSONArray jArray = js.getJSONObject("response").getJSONObject("result").getJSONArray("doc"); // Commented by Chaitanya on 02/12/2016 to resolve single fetch issue
            
            // Added by Chaitanya - 12/06/2016 - To resolve single doc fetch issue
            JSONArray jArray = null;
            JSONObject responseJObj = js.getJSONObject("response");
            if((responseJObj != null) && (responseJObj.has("result"))){
            	
            	JSONObject resultJObj = responseJObj.getJSONObject("result");
            	
            	if((resultJObj != null) && (resultJObj.has("doc"))){

            		Object obj = resultJObj.get("doc");

            		if(obj != null){

            			if(obj instanceof JSONArray){

            				jArray = (JSONArray)obj;
            				
			            }else{

			            	if(obj instanceof JSONObject){

			            		jArray = new JSONArray();
			            		jArray.put(obj);
			            	}
			            } // else 
		            } // if obj not null
            	} // if resultObj
            } // if responseObj
            //Following code handles no solutions found scenario
            if(jArray == null){
            	jArray = new JSONArray();
                JSONArray arr = new JSONArray();
                JSONObject bodyObj = new JSONObject("{\"str\":\"Your query did not yield any solutions. Please refine your search and try again.\",\"name\":\"body\"}");
                JSONObject titleObj = new JSONObject("{\"str\":\"Not Found\",\"name\":\"title\"}");
                arr.put(0, bodyObj);
                arr.put(1, titleObj);
                jArray.put(new JSONObject().put("arr", arr));
       
            }
            
            
            // ----------------------------End of additions - Chaitanya - 02/12/2016
            
            
            
            out.println("<h1>Solutions<h1>");
            
            request.setAttribute("MySolutionsArray", jArray);
            request.setAttribute("providedError", eb.getError());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Solutions.jsp");
            dispatcher.forward(request, response);
            
        }catch(Exception e){
            e.printStackTrace();
        }
              
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
       //response.setContentType("text/html");
       //PrintWriter out = response.getWriter();
       //out.print("hello");
       //out.flush();
       //out.close();
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
