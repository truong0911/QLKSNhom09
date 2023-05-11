/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controler.KhachHangDAO;
import controler.PhongdatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.KhachHang;
import model.PhongDat;

/**
 *
 * @author HP
 */
@WebServlet(name = "DetailHdServlet", urlPatterns = {"/detail"})
public class DetailHdServlet extends HttpServlet {

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
            out.println("<title>Servlet DetailHdServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailHdServlet at " + request.getContextPath() + "</h1>");
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
            PhongdatDAO p = new PhongdatDAO();
            PhongDat v = p.layTheoId(id);
            request.setAttribute("data1", v); 
            KhachHangDAO k = new KhachHangDAO();
            ArrayList<KhachHang> d = k.layTatCa();
            request.setAttribute("data", d);
            request.getRequestDispatcher("detailhd.jsp").forward(request, response); 
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
        String idpd_raw = request.getParameter("id");
        String id_raw = request.getParameter("idkh");
        String ngaydat = request.getParameter("ngaydat");
        String ngaytra = request.getParameter("ngaytra");
        String songuoio = request.getParameter("songuoio");
        try{
            int idpd = Integer.parseInt(idpd_raw);
            int id = Integer.parseInt(id_raw);
            int sno = Integer.parseInt(songuoio);
            SimpleDateFormat df = new SimpleDateFormat("mm:HH dd/MM/yyyy");
            KhachHangDAO k = new KhachHangDAO();
            KhachHang d = k.layTheoId(id);
            PhongdatDAO pd = new PhongdatDAO();
            PhongDat p = new PhongDat(idpd,d,ngaydat,ngaytra,sno,0);
            pd.update(p); 
            response.sendRedirect("book");
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