<%-- 
    Document   : customer
    Created on : May 5, 2023, 9:41:48 PM
    Author     : HP
--%>

<%@page import="model.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Quản lý khách sạn</title>
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
		<h3>Quản lý khách hàng</h3>

        <a href="addCus.jsp"><button class="btn btn-success">Thêm Khách Hàng</button></a>

        <table class="table table-bordered table-hover" 
            style="margin-top: 20px;">
            <thead>
                <th>STT</th>
                <th>Họ & Tên</th>
                <th>SĐT</th>
                <th>Địa Chỉ</th>
                <th>CCCD</th>
                <th style="width: 50px;"></th>
                <th style="width: 50px;"></th>
            </thead>
            <tbody>
            <% 
                  int index = 0;
                  ArrayList<KhachHang> list = (ArrayList<KhachHang>) request.getAttribute("data") ;
                  for(KhachHang i:list){
            %>
                <tr>
                    <th><%=(++index)%></th>
                    <td><%= i.getHoten()%></td>
                    <td><%= i.getSdt()%></td>
                    <td><%= i.getDiachi()%></td>
                    <td><%= i.getCccd()%></td>
                    <th style="width: 50px;">
                        <a href = "suacustomer?id=<%= i.getId()%>"><button class="btn btn-warning">Sửa</button></a>
                    </th>
                    <th style="width: 50px;">
                        <a href = "xoacus?id=<%= i.getId()%>"><button class="btn btn-danger">Xóa</button></a>
<!--                        <button onclick ="deleteUser(<%= i.getId()%>)" class="btn btn-danger">Xóa</button>                    -->
                    </th>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
	</div>
</div>
    <!-- END -->
    </main>
  </div>
</div>
</body>
</html>