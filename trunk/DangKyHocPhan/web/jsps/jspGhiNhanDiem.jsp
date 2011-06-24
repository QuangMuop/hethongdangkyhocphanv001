<%--
    Document   : jspLienHe
    Created on : Apr 23, 2011, 4:35:14 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsClass"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsClass> result=(ArrayList<clsClass>) session.getAttribute("clases");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ghi nhận điểm</title>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form id="updatescore" name="updatescore" action="../servUpdateScore?action=update" method="post" enctype="multipart/form-data">
                    <h3>Ghi nhận điểm môn học:</h3>
                    <i>Giảng viên hoặc quản lý cập nhật điểm môn học theo từng lớp học</i><br>
                    Chọn lớp học:
                    <select name="sclass" id="sclass">
                        <%for(int i=0; i<result.size();i++){%>
                        <option value="<%=result.get(i).getSubCode()%>"><%=result.get(i).getClassName()%> - <%=result.get(i).getSubName()%></option>
                        <%}%>
                    </select><br>
                    <u>Chọn file điểm</u><br/>
                    <table id="tablebrowse">
                        <tr>
                            <td><input type="file" name="txtPath" id="txtPath"></td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="Updatescore()" value="Ghi nhận điểm"></td><td></td>
                        </tr>
                    </table><br><br>
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function Updatescore(){
            var filename=document.getElementById("txtPath").value;
            if(filename.length==0){
                alert("Bạn chưa chọn file");
            }
            else{
                var duoi=filename.substr(filename.length-4, 4);
                if(duoi!=".xls"&&duoi!="xlsx"){
                    alert("Chỉ hỗ trợ thêm sinh viên từ file excel, xin chọn file khác");
                }else {
                    document.forms["updatescore"].submit();

                }
            }
        }
    </script>
</html>
