<%--
    Document   : jspThongTinSinhVien
    Created on : 08-05-2011, 15:37:42
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsStudent;"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    clsStudent student = (clsStudent) session.getAttribute("student");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin sinh viên</title>
        <style media="all" type="text/css">
            #myform{
                background-color: #495C28;
                width: 400px;
                float: left;
                margin-left:  50px;
            }

            #frminfomation table{

                width: 100%;
                background-color: #495C28;
            }

            #frmaction{
                padding-top: 50px;
                clear: both;
                margin-left: 30%;
                padding-top: 25px;
                padding-bottom: 50px;
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
                <form action="../servUpdateInfo?isupdate=true" method="post" id="myform" name="myform">
                    <br>
                    <h3>Thông tin sinh viên</h3>
                    <h1>MSSV:<%=student.getCode()%></h1>
                    <br>
                    <table id="infomation">
                        <tr>
                            <td width="300px">Họ và tên:</td>
                            <td><input  type="text" size="25" name="name" value="<%=student.getFullname()%>"/></td>
                        </tr>
                        <tr>
                            <td>Ngày sinh:</td>
                            <td>
                                <select name="day">
                                    <%for (int i = 1; i < 32; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                                <select name="month">
                                    <%for (int i = 1; i < 13; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                                <select  name="year">
                                    <%for (int i = 1980; i < 2010; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới tính:</td>
                            <td>
                                <select style="width:160px"  name="gender">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lớp:</td>
                            <td><input type="text" id="classs" name="classs" size="25" value="<%=student.getClasss()%>"></td>
                        </tr>
                        <tr>
                            <td>Khóa:</td>
                            <td><input type="text" id="course" name="course" size="25" value="<%=student.getCourse()%>"></td>
                        </tr>
                        <tr>
                            <td>Loại hình học:</td>
                            <td>
                                <select style="width:160px" name="type">
                                    <option value="Chính quy">Chính quy</option>
                                    <option value="Từ xa qua mạng">Từ xa qua mạng</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Bậc học:</td>
                            <td>
                                <select style="width:160px" name="bachoc">
                                    <option value="Đại học">Đại học</option>
                                    <option value="Cao học">Cao học</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="text" id="email" name="email" size="25" value="<%=student.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại:</td>
                            <td><input type="text" name="phone" size="25" value="<%=student.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ liên lạc:</td>
                            <td><input type="text" name="address" size="50" value="<%=student.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ thường trú:</td>
                            <td><input type="text" id="home" name="home" size="50" value="<%=student.getHome()%>"></td>
                        </tr>
                        <tr>
                            <td>CMND:</td>
                            <td><input type="text" name="cmnd" size="25" value="<%=student.getCMND()%>"></td>
                        </tr>
                    </table>
                </form>
                <form id="frmaction" action="#" method="post">
                    <input type="button" onclick="UpdateInfo()" name="update" value="Hoàn tất cập nhật"/>
                </form>
            </div><!--End Contents-->
            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function UpdateInfo(){
            var lop = document.myform.classs.value;
            var name = document.myform.name.value;
            var course = document.myform.course.value;
            var home = document.myform.home.value;
            if(name.length==0){
                alert("Họ và tên không thể để trống");
            }
            else if(lop.length==0){
                alert("Lớp học không thể để trống");
            }else if(course.length==0){
                alert("Khóa học không thể để trống");
            } else if(home.length==0){
                alert("Địa chỉ thường trú không được để trống");
            }
            else{
                document.forms["myform"].submit();
            }
        }
    </script>
</html>