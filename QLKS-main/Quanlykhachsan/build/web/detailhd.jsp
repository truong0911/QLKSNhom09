<%-- 
    Document   : detailhd
    Created on : May 7, 2023, 4:09:35 PM
    Author     : HP
--%>

<%@page import="model.PhongDat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.KhachHang"%>
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
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<div class="row" style="margin-top: 20px;">
	<div class="col-md-12  table-responsive">
		<h3>Tạo Hợp Đồng</h3>
        <%
            if(request.getAttribute("data1")!=null){
                PhongDat a = (PhongDat)request.getAttribute("data1");
        %>       
        <div class="row">
            <div class="col-md-5 col-12">
                <a href="clickroom?id=<%=a.getId()%>"><button class="btn btn-danger">Chọn Phòng</button></a>
            </div>
            <div class="col-md-5 col-12">
                   <a href="clickservice?id=<%=a.getId()%>"><button class="btn btn-danger">Chọn Dịch Vụ</button></a>
            </div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-body">
                <form action="detail" method="post">
                    <input type="text" name="id" value="<%= a.getId()%>" hidden="true">
                <div class="row">
                    <div class="col-md-5 col-12">
                        <div class="form-group">
                            <label for="discount">Tên Khách Hàng:</label>
                            <select class="form-control" name="idkh" id="loaiphong" required="true">
                          <option>-- Chọn --</option>
                          <%
                            ArrayList<KhachHang> l = (ArrayList<KhachHang>)request.getAttribute("data");
                            for(KhachHang i:l){
                                if(i.getId() == a.getKh().getId()){ 
                           %>
                                <option selected value="<%= i.getId()%>"><%= i.getId()%> - <%= i.getHoten()%> - <%= i.getCccd()%></option>';
                            <%
                                } else{
                            %>
                                <option value="<%= i.getId()%>"><%= i.getId()%> - <%= i.getHoten()%> - <%= i.getCccd()%></option>
                            <%
                                    }
                                }
                            %>
                      </select>
                        </div>
                        <div class="form-group">
                            <label for="discount">Ngày đặt:</label>
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
                </div>
                    <div class="form-group">
                        <button class="btn btn-success">Xác Nhận</button>
                    </div>
                </form>
                 <%
                     }
                 %>
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