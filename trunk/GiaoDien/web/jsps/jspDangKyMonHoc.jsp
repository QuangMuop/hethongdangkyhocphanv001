<%-- 
    Document   : jspDanhKyMonHoc
    Created on : Apr 23, 2011, 4:32:56 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký môn học.</title>
        <style media="all" type="text/css">
            #table-list-class{
                margin-left: 10%;
                margin-top: 100px;
                width: 80%;
                border-left: 2px solid;
                border-right: 2px solid;
            }
            #table-list-class th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #table-list-class td{
                background-color: 	#b1B700;
                padding: 2 5 2 5;
            }
            #form-action{
                margin-left: 10%;
                margin-top: 30px;
                padding: 0 2 0 2;
            }
            #form-action table{
                width: 225px;
            }
            #btn-set{
                width: 80px;
                background-color: #E3E4FA;
            }
        </style>
    </head>
    <body>
        <h1>BẠN ĐANG Ở TRANG ĐĂNG KÝ MÔN HỌC!</h1><br/>
        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>
        <br/><br/>

        <table id="table-list-class">
            <tr>
                <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>Tổng SV</th><th>Đã ĐK</th><th><th>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>            
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td><td>125</td><td>135</td><td><input type="checkbox"></td>
            </tr>
        </table>

        <form id = "form-action" method="post" action="">
            <table>
                <tr>
                    <td><input id="btn-set" type="button" onclick="" name="btnPreview" value="Xem Trước"></td>
                    <td><input id="btn-set" type="button" onclick="" name="btnSubmit" value="Đăng ký"></td>
                    <td><input id="btn-set" type="button" onclick="" name="btnCancel" value="Hủy"></td>
                </tr>
            </table>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
</html>
