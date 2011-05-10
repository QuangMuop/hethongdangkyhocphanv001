<%-- 
    Document   : jspDanhSachSinhVien
    Created on : 10-05-2011, 11:23:56
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách Sinh Viên</title>
        <style media="all" type="text/css">
            #frmsearch{
                margin-left: 20px;
            }
            #frmlststudent{
                margin-left: 20px;
                margin-top: 20px;
            }
            #frmlststudent table{
                border-left: 2px solid;
                border-right: 2px solid;
            }
            #frmlststudent table th{
                background-color: #d456ff;
            }
            #frmlststudent table td{
                padding-left: 7px;
                padding-right: 7px;
            }
            #frmexport{
                margin-left: 20px;
                margin-top: 40px;
            }
        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form action="#" method="post" id="frmsearch">
                    <h3>Gồm tất cả các SV của trường ĐH CNTT - ĐHQG Hồ Chí Minh từ 1002 năm trước</h3>
                    <b>Lớp</b>
                    <select name="sSearch">
                        <option>CNMP01</option>
                        <option>CNMP02</option>
                        <option>CNMP03</option>
                        <option>CNMP04</option>
                        <option>CNMP05</option>
                        <option>CNMP06</option>
                        <option>CNMP07</option>
                        <option>CNMP08</option>
                    </select>
                    <input type="submit" value="|  Tìm  |">
                </form>

                <form action="#" method="post" id="frmlststudent">
                    <h3>Danh sách SV</h3>
                    <table id="infomation">
                        <tr>
                            <th>Họ Và Tên</th><th>MSSV</th><th>Lớp</th><th>Email</th><th></th><th></th>
                        </tr>
                        <tr>
                            <td>Nguyễn Văn Lộc</td><td>07520210</td><td>CNPM02</td><td>locnv.uit@gmail.com</td><td><a href="#">Cập nhật</a></td><td><a href="#">Xóa</a></td>
                        </tr>
                        <tr>
                            <td>Nguyễn Văn Lộc</td><td>07520210</td><td>CNPM02</td><td>locnv.uit@gmail.com</td><td><a href="#">Cập nhật</a></td><td><a href="#">Xóa</a></td>
                        </tr>
                        <tr>
                            <td>Nguyễn Văn Lộc</td><td>07520210</td><td>CNPM02</td><td>locnv.uit@gmail.com</td><td><a href="#">Cập nhật</a></td><td><a href="#">Xóa</a></td>
                        </tr>
                        <tr>
                            <td>Nguyễn Văn Lộc</td><td>07520210</td><td>CNPM02</td><td>locnv.uit@gmail.com</td><td><a href="#">Cập nhật</a></td><td><a href="#">Xóa</a></td>
                        </tr>
                    </table>
                </form>
                <form action="" method="post" id="frmexport">
                        <input type="submit" value="| Xuất File |">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
