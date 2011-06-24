<%--
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<clsAccount> aclist = (ArrayList<clsAccount>) session.getAttribute("acc");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý tài khoản</title>
        <style media="all" type="text/css">
            #tableaclist{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 10px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #tableaclist th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tableaclist td{
                background-color: #5F676D;
                padding: 2 5 2 5;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #2f4e3d;
                width: 280px;
            }
        </style>
    </head>
    <body>
        <!--Get data from controller-->

        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <br>
                <h1>Tìm kiếm tài khoản:</h1>
                <form id = "formsearch" name="formsearch" action="" method="">
                    <table>
                        <tr>
                            <td>Tên đăng nhập:</td>
                            <td><input type="text" name="username" id="username" </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <p align="right"><b><a href="jspTaoTaiKhoan.jsp">Tạo mới tài khoản</a></b></p>
                <hr><hr>
                <h3>Danh sách các tài khoản trong hệ thống:</h3>
                <form id="acclist">
                    <table id="tableaclist" name="tableaclist">
                        <tr>
                            <th>STT</th><th>Tên đăng nhập</th><th>Họ Tên</th><th>Hiện trạng</th><th>Loại</th><th>Cập nhật</th>
                        </tr>
                        <%for (int i = 0; i < aclist.size(); i++) {%>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=aclist.get(i).getUserName()%></td>
                            <td><%=aclist.get(i).getFullName()%></td>
                            <%if (aclist.get(i).getIsLocked() == 1) {%>
                            <td>Đang khóa</td>
                            <%} else {%>
                            <td>Bình thường</td>
                            <%}%>
                            <%if (aclist.get(i).getType() == 1) {%>
                            <td>Quản lý</td>
                            <%} else if(aclist.get(i).getType() == 2) {%>
                            <td>Giảng viên</td>
                            <%}else{%>
                            <td>Sinh viên viên</td>
                            <%}%>
                            <%if (aclist.get(i).getIsLocked() == 1) {%>
                            <td><a href="../servAccount?action=update&username=<%=aclist.get(i).getUserName()%>" >Mở khóa</a></td>
                            <%} else {%>
                            <td><a href="../servAccount?action=update&username=<%=aclist.get(i).getUserName()%>" >Khóa</a></td>
                            <%}%>
                        </tr>
                        <%}%>
                    </table>
                </form>
                <hr><hr>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script src="../javascripts/jspCapNhatTK.js"></script>
    <script  type = "text/javascript" >
        name="";
        action="search";
        var http = createRequestObject();
        function search(){
            username=document.getElementById("username").value;
            ajaxfunction("../servAccount?action="+action+"&username="+username);
        }

    </script>
</html>
