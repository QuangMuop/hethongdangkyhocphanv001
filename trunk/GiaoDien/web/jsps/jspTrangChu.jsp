<%-- 
    Document   : jspTrangChu
    Created on : Apr 23, 2011, 10:59:14 PM
    Author     : ngloc_it
--%>

<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ</title>
        <style media="all" type="text/css">
            #ul-menu{
                display: block;
                width: 250px;
                background-color: #EBF4F4;
            }
            #ul-menu a{
                list-style: none;
                margin-left: 25px;
                background-color: #FCF5E3;
            }
        </style>
    </head>
    <body>
        <h1>BẠN ĐANG Ở TRANG CHỦ!</h1><br/>
        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>

        <ul id="ul-menu">
            <li><a href="jspTrangChu.jsp"> Trang chủ </a></li>
            <li><a href="jspXemDSLop.jsp">Xem DS Lớp Học</a> </li>
            <li><a href="jspXemTKB.jsp">Xem TKB</a></li>
            <li> <a href="jspTiepNhanSV.jsp">Tiếp Nhận SV</a> </li>
            <li><a href="jspTiepNhanGV.jsp">Tiếp Nhận GV</a> </li>
            <li> <a href="jspLapTKB.jsp">Lập TKB</a> </li>
            <li><a href="jspTaoLopHoc.jsp">Tạo Lớp Học</a> </li>
            <li><a href="jspGhiNhanDiemSV.jsp">Ghi Nhận Điểm SV</a> </li>
            <li> <a href="jspTaoTaiKhoan.jsp">Tạo Tài Khoản mới</a> </li>
            <li> <a href="jspCapNhatTaiKhoan.jsp">Cập Nhật Tài Khoản</a> </li>
            <li><a href="jspCaiDatQuiDinh.jsp">Cài Đặt Qui Định</a> </li>
            <li> <a href="jspDangKyMonHoc.jsp">Đăng Ký Môn Học</a> </li>
            <li><a href="jspXemChuongTrinhDaoTao.jsp">Xem Chương Trình Đào Tạo</a> </li>
            <li><a href="jspXemTKB.jsp">Xem TKB</a> </li>
            <li> <a href="jspXemKQHocTap.jsp">Xem KQ Học Tập</a> </li>
            <li><a href="jspCapNhatThongTin.jsp">Cập Nhật Thông Tin</a> </li>
            <li> <a href="jspGuiYeuCau.jsp">Gửi Yêu Cầu</a> </li>
            <li><a href="jspLogin.jsp">Login</a></li>
            <li> <a href="jspXemQuiDinh.jsp">Xem Qui Định</a> </li>
            <li><a href="jspCaiDatQuiDinh.jsp">Sửa Qui Định</a> </li>
            <li><a href="jspLienHe.jsp">Liên Hệ</a></li>
        </ul>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
</html>