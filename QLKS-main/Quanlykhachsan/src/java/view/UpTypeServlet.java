/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controler.LoaiphongDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Loaiphong;

/**
 *
 * @author HP
 */
@WebServlet(name = "UpTypeServlet", urlPatterns = {"/suatype"})
public class UpTypeServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpTypeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpTypeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id_raw = request.getParameter("id");
        try{
            int id = Integer.parseInt(id_raw);
            LoaiphongDAO l = new LoaiphongDAO();
            Loaiphong p = l.layTheoId(id);
            request.setAttribute("data", p);
            request.getRequestDispatcher("updateType.jsp").forward(request, response);
        } catch(NumberFormatException e){
            System.out.println(e);
        }
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
        request.setCharacterEncoding("UTF-8"); 
        String id_raw = request.getParameter("id");
        String tenloai = request.getParameter("tenloai");
        String songuoi_raw = request.getParameter("songuoi");
        String sogiuong_raw = request.getParameter("sogiuong");
        String dongia_raw = request.getParameter("dongia");
        try{
            int id = Integer.parseInt(id_raw);
            int songuoi = Integer.parseInt(songuoi_raw);
            int sogiuong = Integer.parseInt(sogiuong_raw);
            int dongia = Integer.parseInt(dongia_raw);
            LoaiphongDAO a = new LoaiphongDAO();
            Loaiphong b = new Loaiphong(id,tenloai,dongia,songuoi,sogiuong);
            a.update(b);  
            response.sendRedirect("type"); 
            
        } catch(NumberFormatException e){
            System.out.println(e);
        }
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
