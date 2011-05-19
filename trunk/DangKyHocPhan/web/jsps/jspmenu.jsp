<%-- 
    Document   : jspmenu
    Created on : Apr 23, 2011, 3:50:32 PM
    Author     : ngloc_it
--%>

<%@page import="java.util.ArrayList"%>
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
            <DIV id="flash" style="Z-INDEX: 1; padding-left: 10%; padding-top: 0px; WIDTH: 80%; POSITION: absolute; TOP: 0px; HEIGHT: 1px">
                <OBJECT height=200 width=100%>
                    <embed src="../flash/flash.swf" width="100%" height="120"
                           quality="high" 
                           type="application/x-shockwave-flash" menu="false"
                           wmode="transparent">
                    </embed>
                </OBJECT>
            </DIV>
        </div>
        <div id = "menu">
            <ul>
                <li><a href="jspTrangChu.jsp"> Trang chủ </a>
                </li>
                <li><a href="../ViewListClass?searchengine=false">Xem DS Lớp Học</a> </li>
                <li><a href="../ViewSchedule">Xem TKB</a></li>
                <li><a href="#">Quản Lý Khoa</a>
                    <ul>
                        <!--
                        <li> <a href="../RegistryStudent?function=nothing">Tiếp Nhận SV</a> </li>
                        <li><a href="jspTiepNhanGV.jsp">Tiếp Nhận GV</a> </li>
                        <li><a href="../ViewListStudent?search=no&order=FullName">Danh sách SV</a> </li>
                        <li><a href="../UpdateScore?function=loaddata">Ghi Nhận Điểm SV</a> </li>
                        -->
                        <li><a href="../ManageLecturer?function=loaddata">Quản lý GV</a> </li>
                        <li><a href="../ManageStudent?function=loaddata">Quản lý SV</a> </li>
                        <li><a href="../CreateNewClass?function=loaddata">Tạo Lớp Học</a> </li>                        
                        <li><a href="jspCaiDatTaiKhoan.jsp">Cài Đặt Tài Khoản</a> </li>                        
                        <li><a href="jspXemQuiDinh.jsp">Xem quy định</a> </li>
                    </ul>
                </li>
                <li><a href="#">Sinh Viên</a>
                <ul>
                        <li> <a href="../servRegistration?reg=view">Đăng Ký Môn Học</a> </li>
                        <li><a href="../servProgram">Xem Chương Trình Đào Tạo</a> </li>
                        <li><a href="../ViewSchedule">Xem TKB</a> </li>
                        <li> <a href="../servStudyResult?first=true">Xem kết quả học tập</a> </li>
                        <li><a href="../servUpdateInfo?isupdate=false">Thông tin sinh viên</a> </li>
                        <li> <a href="../servSendComment?guest=notlogin">Gửi Yêu Cầu</a> </li>
                    </ul>
                </li>
                <%
                HttpSession sesstion = request.getSession();
                String username = (String) session.getAttribute("username");
                if(username == null){
                %>
                    <li><a href="jspLogin.jsp">Đăng nhập</a></li>
                <%}
                else{
                %>
                <li><a href="../servLogin?login=false">Đăng xuất</a></li>
                <%}%>

                <li><a href="jspLienHe.jsp">Liên Hệ</a></li>
            </ul>
        </div>       
    </body>
</html>