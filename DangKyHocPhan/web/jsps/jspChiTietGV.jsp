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
    ArrayList<String> listResult = new ArrayList<String>();
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
            #tableinfo{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 400px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: left;
            }
            #tableinfo th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tableinfo td{
                background-color: #b1B700;
                padding: 2 5 2 5;
            }            
            #frminfo{
                margin-left: 25px;
                width: 400px;
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
                <p>
                    Thông tin chi tiết về giảng viên
                    <%=listResult.get(1)%>
                </p>
                <!--
                    //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
                    //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
                -->
                <form action="#" id="frminfo">
                    <%if(n>0){%>
                    <table id="tableinfo">
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
                                <a href="../UpdateLecturer?id=<%=listResult.get(0)%>">Cập nhật thông tin</a>
                     <%}%>

                     <br/><br/><br/>
                     <h3><u>Những hoạt động của GV <%=listResult.get(1)%></u></h3>
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