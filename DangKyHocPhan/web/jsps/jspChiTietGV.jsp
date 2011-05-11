<%-- 
    Document   : jspChiTietGV
    Created on : 11-05-2011, 16:58:05
    Author     : ngloc_it
--%>

<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    int i = 0;
    int n = 0;
    String strErr = "";
    ArrayList<String> listResult = null;
    try{
        listResult = (ArrayList<String>) session.getAttribute("listinfomation");
        session.removeAttribute("listinfomation");
        n = listResult.size();
        strErr = "No Error";
     }catch(Exception ex){
        strErr = ex.toString();
     }
%>
<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết giảng viên</title>
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
                <p>
                    Thông tin chi tiết về giảng viên....
                </p>
                <!--
                    //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
                    //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
                -->
                <form action="#" id="frm-detail">
                    <%if(n>0){%>
                        <table>
                            <tr>
                                <td>Mã GV</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Họ Và Tên</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Ngày Sinh</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Email</td>  <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Số ĐT</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Địa Chỉ</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Học Hàm</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Học Vị</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Giới Tính</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>CMND</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                            <td>Tình Trang hôn nhân</td> <td>KXĐ</td>
                            </tr>                            
                        </table>
                     <%}%>

                     <br/><br/><br/>
                    <h3><u>Những hoạt động của SV ...</u></h3>
                    <br/><br/><br/><br/><br/>
                </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>