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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            MyService ms = new MyService();
          
            JSONObject js = XML.toJSONObject(ms.CallRRService( eb.getError()));
          //  out.println("<p>"+ js.toString() +"</p>");
            
          //  out.println("<p> Fetching data From ArrayList </p>");
            
          //  int len = js.getJSONObject("response").getJSONObject("result").getJSONArray("doc").length();
           
             JSONArray jArray = js.getJSONObject("response").getJSONObject("result").getJSONArray("doc");
            
            out.println("<h1>Solutions<h1>");
            if(jArray!=null)
               {
                for (int i = 0; i < jArray.length(); i++) {
                    out.println("<h4>" + jArray.getJSONObject(i).getJSONObject("arr").getString("str") + "<h4>");
                    out.print("</br>");
                }

            }
            
            /*  out.println("<h4>Length  of ArrayList" + String.valueOf(len) + "</h4>");
            out.println("<h4>Entered Error Code : " + request.getParameter("errorCode") + "</h4>");
            out.println("</br>");
            out.println("<h4>Entered Error Code : " + js.getJSONObject("response").getJSONObject("result").getJSONArray("doc").ge + "</h4>");*/
            out.println("</body>");
            out.println("</html>");
      
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
