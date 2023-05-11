<%-- 
    Document   : detailpay
    Created on : May 8, 2023, 2:46:21 AM
    Author     : HP
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.PhongDat"%>
<%@page import="model.dtphong_dv"%>
<%@page import="model.dtphong_ct"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Quan lý khách sạn</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="icon" type="image/png" href="https://gokisoft.com/uploads/2021/03/s-568-ico-web.jpg" />

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="css/dashboard.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="trangchu.jsp">Quản lý khách sạn</a>
  <input class="form-control form-control-dark w-100" type="text" placeholder="Tìm kiếm" aria-label="Search">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="logout">Thoát</a>
    </li>
  </ul>
</nav>  
<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" href="">
              <i class="bi bi-house-fill"></i>
              Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="service">
              <i class="bi bi-folder"></i>
              Quản lý dịch vụ
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="book">
              <i class="bi bi-file-earmark-text"></i>
              Quản lý đặt phòng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="customer">
              <i class="bi bi-people-fill"></i>
              Quản lý khách hàng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="type">
              <i class="bi bi-house-door-fill"></i>
              Quản lý loại phòng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="room">
              <i class="bi bi-house-door-fill"></i>
              Quản lý phòng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="user">
              <i class="bi bi-people-fill"></i>
              Quản lý nhân viên
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="pay">
              <i class="bi bi-currency-dollar"></i>
              Quản lý thanh toán
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="statitis.jsp">
              <i class="bi bi-file-earmark-text-fill"></i>
              Quản lý thống kê
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <!-- hien thi tung chuc nang cua trang quan tri START-->
    <div class="row" style="margin-top: 20px;">
	<div class="col-md-12  table-responsive">
		<h3>Chi Tiết Hóa Đơn</h3>
        <div class="panel panel-primary">
            <div class="panel-body">
                <%
                    Locale localeVN = new Locale("vi", "VN");
                    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                    if(request.getAttribute("data")!=null){
                       PhongDat a = (PhongDat)request.getAttribute("data");
                %>
                <form action="detailpay" method="post">
                    <input type="text" name="id" value="<%= a.getId()%>" hidden="true">
                <div class="row">
                    <div class="col-md-5 col-12">
                        <div class="form-group">
                            <label for="discount">Tên Khách Hàng:</label>
                            <input type="text" class="form-control"  name="hoten" value="<%= a.getKh().getHoten()%>">
                        </div>
                        <div class="form-group">
                            <label for="discount">Ngày Đặt:</label>
                            <input type="date" class="form-control"  name="ngaydat" value="<%= a.getNgaydat()%>">
                        </div>
                    </div>
                    <div class="col-md-5 col-12">
                        <div class="form-group">
                            <label for="price">Số người ở:</label>
                            <input type="text" class="form-control" name="songuoio" value="<%= a.getSongaythuco()%>">
                        </div>
                        <div class="form-group">
                            <label for="usr">Ngày Trả:</label>
                            <input type="date" class="form-control" name="ngaytra" value="<%= a.getNgaytra()%>">
                        </div>
                    </div>
                        <%}%>
                </div>
                    <div class="form-group">
                        <h6 style="margin-top: 20px;">Phòng Đặt</h6>
<!--                        <label for="usr">Phòng Đặt:</label>-->
                    </div>
                    <table class="table table-bordered table-hover" style="margin-top: 20px;text-align: center">
                        <thead>
                            <th>STT</th>
                            <th>Tên Phòng</th>
                            <th>Ngày Đặt</th>
                            <th>Số ngày ở</th>
                            <th>Đơn Giá</th>
                            <th>Thành tiền</th>  
                        </thead>
                        <tbody> 
                            <%
                                int index = 0;
                                int x = 0;
                                ArrayList<dtphong_ct>list = (ArrayList<dtphong_ct>) request.getAttribute("data1");
                                for(dtphong_ct i:list){
                                    x += i.getThanhtien();
                            %>
                            <tr>
                                <th><%=(++index)%></th>
                                <td><%= i.getP().getTenphong()%></td>
                                <td><%= i.getNgay()%></td>
                                <td><%= i.getSongayo()%></td>
                                <td><%= currencyVN.format(i.getDongia())%></td>
                                <td><%= currencyVN.format(i.getThanhtien())%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <div class="form-group">
                        <h6 style="margin-top: 20px;">Dịch Vụ Dùng</h6>
<!--                        <label for="usr">Phòng Đặt:</label>-->
                    </div>
                    <table class="table table-bordered table-hover" style="margin-top: 20px;text-align: center">
                        <thead>
                            <th>STT</th>
                            <th>Tên Phòng</th>
                            <th>Tên Dịch Vụ</th>
                            <th>Ngày Đặt</th>
                            <th>Số Lần</th>
                            <th>Đơn Giá</th>
                            <th>Thành Tiền</th>
                        </thead>
                        <tbody>
                            <%
                                int tmp = 0;
                                int y = 0;
                                ArrayList<dtphong_dv>l = (ArrayList<dtphong_dv>) request.getAttribute("data2");
                                for(dtphong_dv i:l){
                                    y += i.getThanhtien();
                            %>
                            <tr>
                                <th><%=(++tmp)%></th>
                                <td><%= i.getP().getTenphong()%></td>
                                <td><%= i.getDv().getTen()%></td>
                                <td><%= i.getNgay()%></td>
                                <td><%= i.getSoluong()%></td>
                                <td><%= currencyVN.format(i.getDongia())%></td>
                                <td><%= currencyVN.format(i.getThanhtien())%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                     <div class="form-group">
                        <label for="usr" style="color:red; font-style: Tahoma">Tổng Tiền: <%= currencyVN.format(x+y)%> </label>
<!--                        <input type="text" class="form-control" name="ngaytra" value="">-->
                     </div>
                    <% if(request.getAttribute("data")!=null){
                       PhongDat a = (PhongDat)request.getAttribute("data");
                       if(a.getStatus()==1){
                    %>
                        <a href="pay"><button class="btn btn-success">Quay Lại</button></a>
                     <%
                            } else{
                     %>
                         <button type="submit" class="btn btn-success">Thanh Toán</button>
                     <%
                            }
                        }
                     %>
                </form>
            </div>
        </div>

	</div>
</div>
    <!-- END -->
    </main>
  </div>
</div>
</body>
</html>