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
    clsLecturer lec = (clsLecturer) session.getAttribute("lec");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Câp nhật thông tin giảng viên</title>
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

        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->

                <form id="formaddone" name="formaddone" action="../servLecturerManager?action=update" method="post">
                    <u>Câp nhật thông tin giảng viên: <%=lec.getFullname()%></u><br/>
                    <table id="tableinfo">
                        <tr>
                            <th>Thông tin</th><th>Giá trị hiện tại</th><th>Giá trị mới</th>
                        </tr>
                        <tr>
                            <td width="120px">Mã GV</td>
                            <td width="200px"><input type="text" value="<%=lec.getLecturerCode()%>" readonly></td>
                            <td width="200px"><input type="text" readonly id="txtCode" name="txtCode" value="<%=lec.getLecturerCode()%>" readonly></td>
                        </tr>
                        <tr>
                            <td>Họ tên</td>
                            <td><input type="text" value="<%=lec.getFullname()%>" readonly></td>
                            <td><input type="text" id="txtName" name="txtName" value="<%=lec.getFullname()%>"></td>
                        </tr>                        
                        <tr>
                            <td>Ngày Sinh</td>
                            <td><input type="text" name="txtBirth" value="<%=lec.getBirthDay()%>" readonly></td>
                            <td>
                                <select name="sDay">
                                    <%for (int j = 0; j < 31; j++) {%>
                                    <option value="<%=(j + 1)%>"><%=(j + 1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth">
                                    <%for (int j = 0; j < 12; j++) {%>
                                    <option value="<%=(j + 1)%>"><%=(j + 1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear">
                                    <%for (int j = 0; j < 50; j++) {%>
                                    <option value="<%=(1940 + j)%>"><%=(1940 + j)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới Tính</td>
                            <td><input type="text" value="<%=lec.getGender()%>" readonly></td>
                            <td>
                                <select name="sSex">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td> 
                            <td><input type="text" value="<%=lec.getAddress()%>" readonly></td>
                            <td><input type="text" id="txtAddress" name="txtAddress" value="<%=lec.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td> 
                            <td><input type="text" value="<%=lec.getPhone()%>" readonly></td>
                            <td><input type="text" id="txtPhone" name="txtPhone" value="<%=lec.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td>Email</td> 
                            <td><input type="text" value="<%=lec.getEmail()%>"readonly></td>
                            <td><input type="text" id="txtEmail" name="txtEmail" value="<%=lec.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Học Hàm</td>
                            <td><input type="text" value="<%=lec.getHocHam()%>" readonly></td>
                            <td>
                                <select name="sHocHam">
                                    <option value="Null">Null</option>
                                    <option value="Giáo sư">Giáo sư</option>
                                    <option value="P.Giáo sư">P.Giáo sư</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Học Vị</td>
                            <td><input type="text" value="<%=lec.getHocVi()%>" readonly></td>
                            <td>
                                <select name="sHocVi">
                                    <option value="Null">Null</option>
                                    <option value="Cao học">Cao Học</option>
                                    <option value="Thạc sĩ">Thạc sĩ</option>
                                    <option value="Tiến sĩ">Tiến Sĩ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>CMND</td>
                            <td><input type="text" value="<%=lec.getCMND()%>" readonly></td>
                            <td><input type="text" id="txtCMND" name="txtCMND" value="<%=lec.getCMND()%>"></td>
                        </tr>
                    </table>
                    <input type="button" value="Cập Nhật" onclick="update()">
                </form>

                <br/><br/>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function update(){
            if(document.formaddone.txtName.value.length==0){
                alert("Tên giảng viên không được trống");
            }
            else if(document.formaddone.txtCMND.value.length==0){
                alert("CMND không được trống");
            }
            else{
                document.forms["formaddone"].submit();
            }
        }
    </script>
</html>
