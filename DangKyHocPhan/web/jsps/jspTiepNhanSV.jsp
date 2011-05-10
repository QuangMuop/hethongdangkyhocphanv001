<%-- 
    Document   : jspTiepNhanSV
    Created on : Apr 23, 2011, 4:29:43 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiếp Nhận Sinh Viên</title>
        <style media="all" type="text/css">
            #form-add-one{
                margin-left: 50px;
                margin-top: 20px;
                width: 350px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
            }
            #form-add-one u{
                background-color: #FFFF00;
            }
            #form-browse{
                margin-left: 50px;
                margin-top: 20px;
                margin-bottom: 120px;
                width: 350px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
            }
            #form-browse u{
                background-color: #FFFF00;
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
                <form id="form-add-one" action="../RegistryStudent?function=addone" method="post">
                    <u>Thêm 1 SV vào database.</u><br/><br/>
                    <table id="table-add-one">
                        <tr>
                            <td>MSSV</td> <td><input type="text" name="txtMSSV"></td>
                        </tr>
                        <tr>
                            <td>Họ</td> <td><input type="text" name="txtFirstName"></td>
                        </tr>
                        <tr>
                            <td>Tên</td> <td><input type="text" name="txtLastName"></td>
                        </tr>
                        <tr>
                            <td>Ngày Sinh</td>
                            <td>
                                <select name="sDay">
                                    <%for(int i = 0; i < 31; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth">
                                    <%for(int i = 0; i < 12; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear">
                                    <%for(int i = 0; i < 50; i++){%>
                                        <option><%=(1980+i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lớp</td>
                            <td>
                            <select name="sClass">
                                    <%for(int i = 1; i < 10; i++){%>
                                        <option>
                                            CNPM <% if(i<10){%>0<%}%><%=i%>
                                        </option>
                                    <%}%>
                            </select>
                            </td>
                    </tr>
                        <tr>
                            <td>Giới Tính</td>
                            <td>
                                <select name="sSex">
                                    <option>Nam</option>
                                    <option>Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ thường trú</td> <td><input type="text" name="txtThuongTru"></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ tạm trú</td> <td><input type="text" name="txtTamTru"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td> <td><input type="text" name="txtPhoneNumber"></td>
                        </tr>
                        <tr>
                            <td>Email</td> <td><input type="text" name="txtEmail"></td>
                        </tr>
                        <tr>
                            <td>Khóa</td>
                            <td>
                                <select name="sCourse">
                                    <%for(int i = 0; i < 9; i++){%>
                                        <option><%=(1+i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <input type="submit" value="Thêm">
                </form>

                <br/><br/>
                <!--
                <form action="upload-script-url" method="post" enctype="multipart/form-data">
                    <input type="file" name="file">
                    <input type="submit">
                </form>
                -->
                <form id="form-browse" action="../RegistryStudent?function=addlist" method="post" name="frmFile">
                    <u>Thêm Sinh Viên Từ File</u><br/><br/>
                    <table id="table-browse">
                        <tr>
                            <td><input type="file" name="txtPath"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Thêm"></td><td></td>
                        </tr>
                    </table>
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
