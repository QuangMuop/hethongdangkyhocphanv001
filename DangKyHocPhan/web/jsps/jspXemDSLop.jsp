<%-- 
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsSubject"%>
<%@page import="system.dto.clsClass"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
            ArrayList<clsClass> listClass = new ArrayList<clsClass>();
            ArrayList<clsSubject> listSubject = new ArrayList<clsSubject>();
            ArrayList<String> listLecturerName = new ArrayList<String>();

            listClass = (ArrayList<clsClass>)session.getAttribute("listclass");
            listSubject = (ArrayList<clsSubject>)session.getAttribute("listsubject");
            listLecturerName = (ArrayList<String>)session.getAttribute("listlecturername");
            String s = (String) session.getAttribute("a");
            int i, n;
            n = listClass.size();
            String tt = listLecturerName.get(1);
            i = n;            
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách lớp học</title>
        <style media="all" type="text/css">
            #table-list-class{
                margin-left: 20px;
                margin-top: 20px;
                margin-bottom: 120px;
                width: 650px;
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
        <!--Get data from controller-->
        
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                ---Search area---
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


                <h3>Phần này là danh sách các lớp học đã mở.</h3>
                <table id="table-list-class">
                    <tr>
                        <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>
                    </tr>

                    <%
                    for(i = 0; i < n; i++){%>
                        <tr>
                            <td><a href="jspChiTietLopHoc.jsp?id=<%=listClass.get(i).getClassName()%>"/><%=listClass.get(i).getClassName()%></td>
                            <td><%=listSubject.get(i).getSubName()%></td>
                            <td><%=listLecturerName.get(i)%></td>
                            <td><%=listSubject.get(i).getTCLT()%></td>
                            <td><%=listSubject.get(i).getTCTH()%></td>
                            <td><%=listClass.get(i).getRoom()%></td>
                            <td><%=listClass.get(i).getDate()%></td>
                            <td><%=listClass.get(i).getShift()%></td>
                        </tr>
                    <%}%>
                    <!--
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                    -->
                   
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
