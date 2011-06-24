<%-- 
    Document   : jspChiTietLopHoc
    Created on : 26-04-2011, 11:14:32
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsStudent"%>
<%@page import="system.dto.clsClass"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiêt lớp học</title>
        <style media="all" type="text/css">
            #formclassinfo{
                margin-left: 10px;
                margin-top: 20px;
                width: 740px;
            }
            #formclassinfo table{
                width: 100%;
                font-weight: bold
            }

            #formliststudent{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom: 20px;
                width: 740px;

            }

            #formliststudent table{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom: 10px;
                width: 730px;
                border-left: 2px solid;
                border-right: 2px solid;
                border-top: 2px solid;
                border-bottom:  2px solid;
            }

            #formliststudent table th{
                height: 22px;
                background-color: #F9B7FF;
                border-left: 1px solid;
                border-right: 1px solid;
                border-bottom:  1px solid;
                border-top:  1px solid;
            }
            #formliststudent table td{
                background-color: #b1B700;
                padding: 2 5 2 5;
                text-align: center;
            }
        </style>

    </head>
    <body>
        <%
            clsClass cls = (clsClass) session.getAttribute("classdetail");
            ArrayList<clsStudent> studentlist = (ArrayList<clsStudent>) session.getAttribute("studentlist");
            int n = studentlist.size();
            int i = 0;
        %>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form id="formclassinfo" action="#" method="post">
                    <u>Thông tin lớp học:</u><br/>
                    <table>
                        <tr>
                            <td>Mã lớp: </td>
                            <td><%=cls.getClassName()%></td>
                            <td>Môn học:</td>
                            <td><%=cls.getSubName()%></td>
                        </tr>
                        <tr>
                            <td>Giảng viên: </td>
                            <td><%=cls.getLecturerName()%></td>
                            <td>Ngày học: </td>
                            <td>Thứ <%=cls.getDate()%></td>
                        </tr>
                        <tr>
                            <td>Ca: </td>
                            <td><%=cls.getShift()%></td>
                            <td>Phòng: </td>
                            <td><%=cls.getRoom()%></td>
                        </tr>

                    </table>
                </form>
                <br/><hr><hr>
                <u>Danh sách các sinh viên đăng ký lớp học: <%=n%> sinh viên</u>
                <form name="formliststudent" id="formliststudent" action="#" method="post">
                    <table id="tableliststudent">
                        <tr>
                            <th>STT</th><th>MSSV</th><th>Họ Và Tên</th><th>Lớp</th>
                        </tr>
                        <%for (i = 0; i < n; i++) {%>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=studentlist.get(i).getCode()%></td>
                            <td><%=studentlist.get(i).getFullname()%></td>
                            <td><%=studentlist.get(i).getClasss()%></td>
                        </tr>
                        <%}%>
                    </table>
                    <br/>
                    <input type="submit" value="   Xuất file   ">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
