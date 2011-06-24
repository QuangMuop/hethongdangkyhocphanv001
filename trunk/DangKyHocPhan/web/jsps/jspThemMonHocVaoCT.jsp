<%--
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsSubject"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    Integer code = (Integer) session.getAttribute("code");
    ArrayList<clsSubject> sub = (ArrayList<clsSubject>) session.getAttribute("sublist");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm môn học vào chương trình</title>
        <style media="all" type="text/css">

        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u><b>Thêm một môn học mới vào chương trình đào tạo :</b></u><br/>
                <form id="frmInfo" action="../servProManage?action=insert" method="post" name="frmInfo">
                    <u>Thông tin môn học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Mã chương trình:</td>
                            <td><b><%=code%></b></td>
                        </tr>
                        <tr>
                            <td>Môn học</td>
                            <td>
                                <select name="sub" id="sub">
                                    <%for (int i = 0; i < sub.size(); i++) {%>

                                    <option value="<%=sub.get(i).getSubCode()%>"><%=sub.get(i).getSubName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Học kỳ dự kiến</td>
                            <td>
                                <select style="width:100px" name="semester" id="semester">
                                    <%for (int i = 1; i < 10; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <input type="submit" value="Thêm môn học" >
                    <input type="hidden" name="code" id="code" value="<%=code%>">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>

</html>
