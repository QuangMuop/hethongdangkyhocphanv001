<%-- 
    Document   : jspmenu
    Created on : Apr 23, 2011, 3:50:32 PM
    Author     : ngloc_it
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="../csss/menu.css" rel="stylesheet" type="text/css" media="screen">
    </head>
    <body>
        <MARQUEE onmouseover="this.stop();" onmouseout="this.start();" HEIGHT=25 BGCOLOR=#C0C6CE BEHAVIOR=scroll SCROLLAMOUNT="4">
            Chào mừng đến với hệ thống đăng ký học phần.
        </MARQUEE>

        <div id="logo">

        </div>
        <div id = "menu">
            <ul>
                <li><a href="jspTrangChu.jsp"> Trang chủ </a>
                </li>
                <li><a href="jspXemDSLop.jsp">Xem DS Lớp Học</a> </li>
                <li><a href="jspXemTKB.jsp">Xem TKB</a></li>
                <li><a href="#">Quản Lý Khoa</a>
                    <ul>
                        <li> <a href="jspTiepNhanSV.jsp">Tiếp Nhận SV</a> </li>
                        <li><a href="jspTiepNhanGV.jsp">Tiếp Nhận GV</a> </li>
                        <li> <a href="jspLapTKB.jsp">Lập TKB</a> </li>
                        <li><a href="jspTaoLopHoc.jsp">Tạo Lớp Học</a> </li>
                        <li><a href="jspGhiNhanDiemSV.jsp">Ghi Nhận Điểm SV</a> </li>
                        <li><a href="jspTaoTaiKhoan.jsp">Tạo Tài Khoản Mới</a> </li>
                        <li> <a href="jspCapNhatTaiKhoan.jsp">Cập Nhật Tài Khoản</a> </li>
                        <li><a href="jspCaiDatQuiDinh.jsp">Cài Đặt Qui Định</a> </li>                        
                    </ul>
                </li>
                <li><a href="#">Sinh Viên</a>
                <ul>
                        <li> <a href="jspDangKyMonHoc.jsp">Đăng Ký Môn Học</a> </li>
                        <li><a href="jspXemChuongTrinhDaoTao.jsp">Xem Chương Trình Đào Tạo</a> </li>
                        <li><a href="jspXemTKB.jsp">Xem TKB</a> </li>
                        <li> <a href="jspXemKQHocTap.jsp">Xem KQ Học Tập</a> </li>
                        <li><a href="jspCapNhatThongTin.jsp">Cập Nhật Thông Tin</a> </li>
                        <li> <a href="jspGuiYeuCau.jsp">Gửi Yêu Cầu</a> </li>
                    </ul>
                </li>
                <li><a href="jspLogin.jsp">Login</a></li>
                <li><a href="#">Qui định</a>
                <ul>
                        <li> <a href="jspXemQuiDinh.jsp">Xem Qui Định</a> </li>
                        <li><a href="jspCaiDatQuiDinh.jsp">Sửa Qui Định</a> </li>
                    </ul>
                </li>
                <li><a href="jspLienHe.jsp">Liên Hệ</a></li>
            </ul>
        </div>
        <br/><br/>
        <hr/><hr/>        
    </body>
</html>