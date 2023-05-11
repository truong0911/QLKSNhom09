/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controler.NguoiDungDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NguoiDung;

/**
 *
 * @author HP
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/capnhatuser"})
public class UpdateUserServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUserServlet at " + request.getContextPath() + "</h1>");
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
            NguoiDungDAO a = new NguoiDungDAO();
            NguoiDung b =a.layTheoId(id);
            request.setAttribute("sua", b);
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
        }
        catch(NumberFormatException e){
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
        String id_raw = request.getParameter("idNguoiDung");
        String hoten = request.getParameter("hoten");
        String gioitinh = request.getParameter("gioitinh");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String chucvu = request.getParameter("chucvu");
        String cccd = request.getParameter("cccd");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int id;
        try{
            id = Integer.parseInt(id_raw);
            NguoiDungDAO a = new NguoiDungDAO();
            NguoiDung b = new NguoiDung(id,hoten,gioitinh,diachi,sdt,chucvu,cccd,username,password);
            a.update(b);
            response.sendRedirect("user"); 
        } catch(NumberFormatException e){
            
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
