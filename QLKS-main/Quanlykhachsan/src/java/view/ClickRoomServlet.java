/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controler.DtphongctDAO;
import controler.PhongDAO;
import controler.PhongdatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Phong;
import model.PhongDat;
import model.dtphong_ct;

/**
 *
 * @author HP
 */
@WebServlet(name = "ClickRoomServlet", urlPatterns = {"/clickroom"})
public class ClickRoomServlet extends HttpServlet {

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
            out.println("<title>Servlet ClickRoomServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClickRoomServlet at " + request.getContextPath() + "</h1>");
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
            PhongdatDAO a = new PhongdatDAO();
            PhongDat l = a.layTheoId(id);
            request.setAttribute("dulieu", l);
            PhongDAO b = new PhongDAO();
            ArrayList<Phong> list = b.layTatCa();
            request.setAttribute("data", list); 
            request.getRequestDispatcher("clickroom.jsp").forward(request, response); 
        }catch(NumberFormatException e){
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
        String id_raw = request.getParameter("id");
        String[] idp_raw = request.getParameterValues("phong");
        String ngaydat = request.getParameter("ngaydat");
        String songayo = request.getParameter("songayo");
        int id = Integer.parseInt(id_raw);
        int sno = Integer.parseInt(songayo);
        PhongdatDAO pd = new PhongdatDAO();
        PhongDat p = pd.layTheoId(id);
        PhongDAO d = new PhongDAO();
        DtphongctDAO dt = new DtphongctDAO();
        for(int i=0;i<idp_raw.length;i++){
            int a = Integer.parseInt(idp_raw[i]);
            Phong x = d.layTheoId(a);
            dtphong_ct b = new dtphong_ct(0,p,x,sno,x.getLp().getDongia(),sno*x.getLp().getDongia(),ngaydat);  
            dt.themCTDatphong(b);
            d.datp(a); 
        }
        response.sendRedirect("book"); 
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
