<%-- 
    Document   : jspChiTietSinhVien.jsp
    Created on : 11-05-2011, 10:15:53
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
        <title>Chi Tiết Sinh Viên</title>
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
                    <b>Trang xem thông tin chi tiết sinh viên....</b>
                </p>
                <%=strErr%>
                <br/><br/><br/>
                <!--listInfomation.add(student.getFullname());
            listInfomation.add(student.getCode());
            listInfomation.add(student.getBirthDay());
            listInfomation.add(student.getClasss());
            listInfomation.add(student.getEmail());
            listInfomation.add(student.getPhone());
            listInfomation.add(student.getAddress());
            listInfomation.add(student.getHome());
            listInfomation.add(student.getIsStuding());
            listInfomation.add(Integer.toString(student.getCourse()));
            listInfomation.add(student.getGender());
            listInfomation.add(student.getCMND());
            listInfomation.add(student.getType());
            listInfomation.add(student.getBacHoc()); -->
                <form action="#" id="frm-detail">
                    <%if(n>0){%>
                        <table>
                            <tr>
                                <td>Họ và tên</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>MSSV</td> <td><%=listResult.get(i++)%></td>
                            </tr>                            
                            <tr>
                                <td>Ngày Sinh</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Lớp</td>  <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Email</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Điện thoại</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ tạm trú</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ thường trú</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Tình Trạng</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Khóa</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                            <td>Giới Tính</td> <td><%=listResult.get(i++)%> </td>
                            </tr>
                            <tr>
                                <td>CMND</td> <td><%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Loại hình đào tạo</td> <td> <%=listResult.get(i++)%></td>
                            </tr>
                            <tr>
                                <td>Bậc Học</td> <td><%=listResult.get(i++)%></td>
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