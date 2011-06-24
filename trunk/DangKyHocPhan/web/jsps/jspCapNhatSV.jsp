<%--
    Document   : jspCapNhatGV
    Created on : 22-05-2011, 10:35:49
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsRule"%>
<%@page import="system.dto.clsCourse"%>
<%@page import="system.dto.clsStudent"%>
<%@include file="jspmenu.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    clsStudent student = (clsStudent) session.getAttribute("student");
    ArrayList<String> listClass = (ArrayList<String>) session.getAttribute("listClass");
    ArrayList<clsCourse> listCourse = (ArrayList<clsCourse>) session.getAttribute("listCourse");
    clsRule rule = (clsRule) session.getAttribute("rule");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Câp nhật thông tin sinh viên</title>
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

                <form id="formaddone" name="formaddone" action="../servStudentManager?action=update" method="post">
                    <u>Câp nhật thông tin sinh viên: <%=student.getFullname()%></u><br/>
                    <br>
                    <%if (student.getNote().equalsIgnoreCase("null") || student.getNote().equalsIgnoreCase("")) {%>
                    <%} else {%>
                    <i>Thông tin sinh viên mới cập nhật:</i><br>
                    <textarea cols="1" rows="10"  name="update" readonly style="left: 20px; width: 720px; height: 100px;" ><%=student.getNote()%></textarea>
                    <br>
                    <%}%>
                    <u>Một số quy đinh về sinh viên:</u>
                    <table>
                        <tr>
                            <td>Tuổi tối thiểu:</td>
                            <td><input type="text" id="minage" value="<%=rule.getMinStudentAge()%>"readonly></td>
                        </tr>
                        <tr>
                            <td>Tuổi tối đa:</td>
                            <td><input type="text" id="maxage" value="<%=rule.getMaxStudentAge()%>"readonly></td>
                        </tr>
                    </table>
                    <table id="tableinfo">
                        <tr>
                            <th>Thông tin</th><th>Giá trị hiện tại</th><th>Giá trị mới</th>
                        </tr>
                        <tr>
                            <td width="120px">MSSV</td>
                            <td width="200px"><input type="text" value="<%=student.getCode()%>" readonly></td>
                            <td width="200px"><input type="text" readonly id="txtCode" name="txtCode" value="<%=student.getCode()%>" readonly></td>
                        </tr>
                        <tr>
                            <td>Họ tên</td>
                            <td><input type="text" value="<%=student.getFullname()%>" readonly></td>
                            <td><input type="text" id="txtname" name="txtname" value="<%=student.getFullname()%>"></td>
                        </tr>
                        <tr>
                            <td>Ngày Sinh</td>
                            <td><input type="text" name="txtBirth" value="<%=student.getBirthDay()%>" readonly></td>
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
                                <select name="sYear" id="sYear">
                                    <%for (int i = 1980; i < 2010; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lớp:</td>
                            <td><input type="text" value="<%=student.getClasss()%>" readonly></td>
                            <td>
                                <select name="sClass">
                                    <%for (int i = 0; i < listClass.size(); i++) {%>
                                    <option value="<%=listClass.get(i)%>"><%=listClass.get(i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Khóa học:</td>
                            <td><input type="text" value="<%=student.getCourse()%>" readonly></td>
                            <td>
                                <select name="sCourse">
                                    <%for (int i = 0; i < listCourse.size(); i++) {%>
                                    <option value="<%=listCourse.get(i).getCourseCode()%>"><%=listCourse.get(i).getCourseCode()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Tình trạng:</td>
                            <td><input type="text" value="<%=student.getIsStuding()%>" readonly></td>
                            <td>
                                <select name="sStatus">
                                    <option value="Đang học">Đang học</option>
                                    <option value="Đang học">Thôi học</option>
                                    <option value="Đang học">Đã tốt nghiệp</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới Tính:</td>
                            <td><input type="text" value="<%=student.getGender()%>" readonly></td>
                            <td>
                                <select name="sSex">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ liên lạc:</td>
                            <td><input type="text" value="<%=student.getAddress()%>" readonly></td>
                            <td><input type="text" id="txtadd" name="txtadd" value="<%=student.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ thường trú:</td>
                            <td><input type="text" value="<%=student.getHome()%>" readonly></td>
                            <td><input type="text" id="txthome" name="txthome" value="<%=student.getHome()%>"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td>
                            <td><input type="text" value="<%=student.getPhone()%>" readonly></td>
                            <td><input type="text" id="txtphone" name="txtphone" value="<%=student.getPhone()%>"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" value="<%=student.getEmail()%>"readonly></td>
                            <td><input type="text" id="txtemail" name="txtemail" value="<%=student.getEmail()%>"></td>
                        </tr>
                        <tr>
                            <td>Ngày nhập học</td>
                            <td><input type="text" name="txtNgayNhapHoc" value="<%=student.getNhaphoc()%>" readonly></td>
                            <td>
                                <select name="sDay1">
                                    <%for (int j = 0; j < 31; j++) {%>
                                    <option value="<%=(j + 1)%>"><%=(j + 1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth1">
                                    <%for (int j = 0; j < 12; j++) {%>
                                    <option value="<%=(j + 1)%>"><%=(j + 1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear1" id="sYear1">
                                    <%for (int i = 2005; i < 2021; i++) {%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Loại hình đòa tạọ</td>
                            <td><input type="text" value="<%=student.getType()%>" readonly></td>
                            <td>
                                <select name="sType">
                                    <option value="Chính quy">Chính quy</option>
                                    <option value="Từ xa">Từ xa</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Bậc học:̣</td>
                            <td><input type="text" value="<%=student.getBacHoc()%>" readonly></td>
                            <td>
                                <select name="sBacHoc">
                                    <option value="Đại học">Đại học</option>
                                    <option value="Cao học">Cao học</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>CMND</td>
                            <td><input type="text" value="<%=student.getCMND()%>" readonly></td>
                            <td><input type="text" id="txtCMND" name="txtCMND" value="<%=student.getCMND()%>"></td>
                        </tr>
                    </table>
                    <input type="button" value="Cập Nhật" onclick="UpdateStudent()">
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
        function UpdateStudent(){
            var curent=new Date().getFullYear();
            var year=document.getElementById("sYear").value;
            var minage=document.getElementById("minage").value;
            var maxage=document.getElementById("maxage").value;
            if(document.getElementById("txtname").value.length==0){
                alert("Vui lòng nhập họ tên sinh viên");
            }
            else if(document.getElementById("txtadd").value.length==0){
                alert("Vui lòng nhập địa chỉ liên lạc của sinh viên");
            }
            else if(document.getElementById("txthome").value.length==0){
                alert("Vui lòng nhập địa chỉ thường trú của sinh viên");
            }
            else if(document.getElementById("txtCMND").value.length==0){
                alert("Vui lòng nhập CMND của sinh viên");
            }
            else if(curent-year<minage){
                alert("Sinh viên chưa đủ tuổi quy định");
            }
            else if(curent-year>maxage){
                alert("Sinh viên đã quá tuổi quy định");
            }
            // else if(document.getElementById("sYear1").value != yearin){
            // alert("Năm nhập học không hợp lý");
            //  }
            else{
                document.forms["formaddone"].submit();
            }
        }
    </script>
</html>
