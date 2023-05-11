/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controler.DichvuDAO;
import controler.DtphongctDAO;
import controler.DtphongdvDAO;
import controler.PhongDAO;
import controler.PhongdatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DichVu;
import model.Phong;
import model.PhongDat;
import model.dtphong_ct;
import model.dtphong_dv;

/**
 *
 * @author HP
 */
@WebServlet(name = "ClickSerServlet", urlPatterns = {"/clickservice"})
public class ClickSerServlet extends HttpServlet {

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
            out.println("<title>Servlet ClickSerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClickSerServlet at " + request.getContextPath() + "</h1>");
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
            DichvuDAO b = new DichvuDAO();
            ArrayList<DichVu> list = b.layTatCa();
            request.setAttribute("data", list); 
            DtphongctDAO dt = new DtphongctDAO();
            ArrayList<dtphong_ct> li = dt.layTheoIdpd(id);
            request.setAttribute("data1", li); 
            request.getRequestDispatcher("clickservice.jsp").forward(request, response); 
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
        String idp_raw = request.getParameter("idp");
        String[] iddv_raw = request.getParameterValues("dichvu");
        String ngaydat = request.getParameter("ngaydat");
        String solan = request.getParameter("solan");
        int id = Integer.parseInt(id_raw);
        int idp = Integer.parseInt(idp_raw);
        int sno = Integer.parseInt(solan);
        PhongdatDAO pd = new PhongdatDAO();
        PhongDat p = pd.layTheoId(id);
        PhongDAO d = new PhongDAO();
        Phong b = d.layTheoId(idp);
        DichvuDAO dv = new DichvuDAO();
        DtphongdvDAO y = new DtphongdvDAO();
        for(int i=0;i<iddv_raw.length;i++){
            int a = Integer.parseInt(iddv_raw[i]);
            DichVu x = dv.layTheoId(a);
            dtphong_dv c = new dtphong_dv(0,p,b,x,sno,x.getGia(),sno*x.getGia(),ngaydat);
            y.themDatdv(c); 
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
