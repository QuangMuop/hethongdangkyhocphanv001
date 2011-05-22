<%-- 
    Document   : jspCapNhatGV
    Created on : 22-05-2011, 10:35:49
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsLecturer"%>
<%@include file="jspmenu.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    clsLecturer lecturer = null;
    String error = "OK";
    try{
        lecturer = (clsLecturer) session.getAttribute("lecturer");
    }catch(Exception ex){
        error = ex.toString();
    }

    if(lecturer == null)
        lecturer = new clsLecturer();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật giảng viên</title>
        <style media="all" type="text/css">
            #tableinfo{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
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
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 280px;
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

                <form id="form-add-one" name="frmInfo" action="../UpdateLecturer?id=none&function=reupdate" method="post">
                    <u>Cập nhật thông tin giảng viên.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <th>Thông tin</th><th>Giá trị hiện tại</th><th>Giá trị mới</th>
                        </tr>
                        <tr>
                            <td width="120px">Mã GV</td>
                            <td width="200px"><input type="text" value="<%=lecturer.getLecturerCode()%>" readonly></td>
                            <td width="200px"><input type="text" name="txtLecturerCode" value="<%=lecturer.getLecturerCode()%>" readonly></td>
                        </tr>
                        <tr>
                            <td>Họ và tên</td>
                            <td><input type="text" value="<%=lecturer.getFullname()%>" readonly></td>
                            <td><input type="text" name="txtFullName" value="<%=lecturer.getFullname()%>"></td>
                        </tr>                        
                        <tr>
                            <td>Ngày Sinh</td>
                            <td><input type="text" name="txtBirthDay" value="<%=lecturer.getBirthDay()%>" readonly></td>
                            <td>
                                <select name="sDay">
                                    <%for(int j = 0; j < 31; j++){%>
                                        <option><%=(j+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth">
                                    <%for(int j = 0; j < 12; j++){%>
                                        <option><%=(j+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear">
                                    <%for(int j = 0; j < 50; j++){%>
                                        <option><%=(1940+j)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới Tính</td>
                            <td><input type="text" value="<%=lecturer.getGender()%>" readonly></td>
                            <td>
                                <select name="sSex">
                                    <option>Nam</option>
                                    <option>Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td> 
                            <td><input type="text" value="<%=lecturer.getAddress()%>" readonly></td>
                            <td><input type="text" name="txtAddress" value="<%=lecturer.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td> 
                            <td><input type="text" value="<%=lecturer.getPhone()%>" readonly></td>
                            <td><input type="text" name="txtPhoneNumber" value="<%=lecturer.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td>Email</td> 
                            <td><input type="text" value="<%=lecturer.getEmail()%>"readonly></td>
                            <td><input type="text" name="txtEmail" value="<%=lecturer.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Học Hàm</td>
                            <td><input type="text" value="<%=lecturer.getHocHam()%>" readonly></td>
                            <td>
                                <select name="sHocHam">
                                    <option>Cao Học</option>
                                    <option>Thạc sĩ</option>
                                    <option>Tiến Sĩ</option>
                                    <option>P.Giáo Sư</option>
                                    <option>Khác</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Học Vị</td>
                            <td><input type="text" value="<%=lecturer.getHocVi()%>" readonly></td>
                            <td>
                                <select name="sHocVi">
                                    <option>Cao Học</option>
                                    <option>Thạc sĩ</option>
                                    <option>Tiến Sĩ</option>
                                    <option>P.Giáo Sư</option>
                                    <option>Khác</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>CMND</td>
                            <td><input type="text" value="<%=lecturer.getCMND()%>" readonly></td>
                            <td><input type="text" name="txtCMND" value="<%=lecturer.getCMND()%>"></td>
                        </tr>
                    </table>
                        <input type="submit" value="Cập Nhật">
                </form>

                <br/><br/>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
