<%-- 
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách lớp học</title>
        <style media="all" type="text/css">
            #table-list-class{
                margin-left: 20%;
                margin-top: 20px;
                width: 60%;
                border-left: 2px solid;
                border-right: 2px solid;
            }
            #table-list-class th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #table-list-class td{
                background-color: #b1B700;
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
            #form-search{
                margin-left: 20%;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 320px;
            }
        </style>
    </head>
    <body>
        <h1>BẠN ĐANG Ở TRANG XEM DANH SÁCH LỚP HỌC!</h1><br/>
        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>

        <br/><br/>

        <h3>Phần này cung cấp các chức năng search
        ???sao không cho thêm chức năng search vào trang đăng ký môn học và bỏ chức năng này
        (chức năng xem danh sách lớp học) đi nhỉ...
        </h3>

        <form id = "form-search" action="" method="post">
            <table>
                <tr>
                    <td><input type="checkbox" name="chkSearchByName"></td>
                    <td>
                        <select name="sName">
                            <option>Lập Trình Hướng Đối Tượng</option>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="chkSearchByID"></td>
                    <td>
                            <select name="sID">
                                <option>SE01</option>
                            </select>
                    </td>
                    <td><input type="submit" value="Tìm Kiếm"></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="chkSearchByTeacher"></td>
                    <td>
                        <select name="sTeacherName">
                            <option>Vũ Thanh Nguyên</option>
                        </select>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
        <hr/>
        <h3>Phần này là danh sách các lớp học hiện có.</h3>

        <table id="table-list-class">
            <tr>
                <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
            </tr>
            <tr>
                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
            </tr>
        </table>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
</html>
