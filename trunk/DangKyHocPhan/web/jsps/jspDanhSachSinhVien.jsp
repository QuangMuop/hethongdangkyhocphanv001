<%--
    Document   : jspDanhSachSinhVien
    Created on : 10-05-2011, 11:23:56
    Author     : ngloc_it
--%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách Sinh Viên</title>
        <style media="all" type="text/css">
            #frmsearch{
                margin-left: 20px;
            }
            #frmlststudent{
                margin-left: 20px;
                margin-top: 20px;
            }
            #frmlststudent table{
                border-left: 2px solid;
                border-right: 2px solid;
            }
            #frmlststudent table th{
                background-color: #d456ff;
            }
            #frmlststudent table td{
                padding-left: 7px;
                padding-right: 7px;
            }
            #frmexport{
                margin-left: 20px;
                margin-top: 40px;
            }
        </style>
        <script language="javascript">
            function processSearchClass(){
                document.forms["frmSearchByClass"].submit();
             }
            function processSearchFullName(){
                var name = document.frmSearchByFullName.txtFullName.value;
                if(name.length == 0)
                    alert("Hãy Nhập Họ Tên Đầy Đủ Và Nhấn Tìm");
                else
                    document.forms["frmSearchByFullName"].submit();
             }
             function processSearchMSSV(){
                 var mssv = document.frmSearchByMSSV.txtMSSV.value;
                 if(mssv.length == 0)
                    alert("Hãy Nhập MSSV Và Nhấn Tìm");
                else
                    document.forms["frmSearchByMSSV"].submit();
             }
        </script>
    </head>
    <body>
        <%
            String strErr = "";
            int n = 0;
            int i = 0;
            ArrayList<String> listInfomation = new ArrayList<String>();
            try{
                listInfomation = (ArrayList<String>) session.getAttribute("listinfomation");
                n = listInfomation.size();
                strErr = "Ok";
            }catch(Exception ex){
                strErr = ex.toString();
            }
        %>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <!--FORM SEARCH By CLASS -->
                <h3>Danh sách sinh viên khoa công nghệ phần mềm</h3>
                <table>
                    <tr>
                        <td>
                            <b>Tìm theo lớp</b>
                        </td>
                        <td>
                            <form action="../ViewListStudent?search=yes&order=FullName" method="post" name="frmSearchByClass">

                                <select name="sSearch" onchange="processSearchClass()">
                                    <%
                                    String[] options = {"ALL", "CNPM01", "CNPM02", "CNPM03", "CNPM04", "CNPM05"
                                    , "CNPM06", "CNPM07", "CNPM08", "CNPM09", "CNPM10"};
                                    String selected = "";
                                    try{
                                        selected = (String) session.getAttribute("classnametemp");
                                    }catch(Exception ex){
                                        strErr += ex.toString();
                                    }
                                    for(int j = 0; j < options.length; j++){
                                    %>
                                    <option <%if(options[j].equals(selected)){%>selected ="yes"<%}%>><%=options[j]%></option>
                                    <%}%>
                                </select>
                            </form>
                        </td>
                    </tr>
                    <!--FORM SEARCH By MSSV -->
                    <tr>
                        <td>
                            <b>Tìm Theo MSSV  </b>
                        </td>
                        <td>
                            <form action="../ViewListStudent?search=frmMSSV" method="post" name="frmSearchByMSSV">
                                <input type="text" name="txtMSSV">
                                <input type="button" onclick="processSearchMSSV()" value="|  Tìm  |">
                            </form>
                        </td>
                    </tr>
                    <!--FORM SEARCH By FULLNAME -->
                    <tr>
                        <td>
                            <b>Tìm Theo Tên  </b>
                        </td>
                        <td>
                            <form action="../ViewListStudent?search=frmFullName" method="post" name="frmSearchByFullName">
                                <input type="text" name="txtFullName">
                                <input type="button" onclick="processSearchFullName()" value="|  Tìm  |">
                            </form>
                        </td>
                    </tr>
                </table>
                <!-- This hold list of students found by search engine. -->
                <form action="#" method="post" id="frmlststudent">
                    <h3><u>Danh sách SV</u></h3>
                    <table id="infomation">
                        <tr>
                            <th>Họ Tên</th>
                            <th>MSSV</th>
                            <th>Lớp</th>
                            <th>Email</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <!--
                            //Fullname, MSSV, BirthDay, ClassName, Email, Phone, Address,Home,
                            //IsStudying, courseCode, nhap hoc, gender, CMND, Type, Bac hoc, Note
                        -->
                        <%if(n>0){
                            while(i<n){%>
                            <tr>
                                <td><%=listInfomation.get(i++)%></td><!--FullName-->
                                <%String mssv =  listInfomation.get(i);%><td><a href="../StudentDetail?MSSV=<%=listInfomation.get(i)%>"><%=listInfomation.get(i++)%></a></td><!--MSSV-->
                                <%i++;%><td><%=listInfomation.get(i++)%></td><!--ClassName-->
                                <td><%=listInfomation.get(i++)%></td><!--Email-->
                                <%i+=11;%>
                                <td><a href="../StudentDetail?MSSV=<%=mssv%>">Cập nhật</a></td>
                                <td><a href="../UpdateStudent?functionname=delete&mssv=<%=mssv%>">Xóa</a></td>
                            </tr>
                          <%}%>
                        <%}%>
                            <!--
                        <tr>
                            <td>Nguyễn Văn Lộc</td><td>07520210</td><td>CNPM02</td><td>locnv.uit@gmail.com</td><td><a href="#">Cập nhật</a></td><td><a href="#">Xóa</a></td>
                        </tr> -->
                    </table>
                </form>
                <form action="../ViewListStudent?search=yes&exportfile=true" method="post" id="frmexport">
                    <a href="../ViewListStudent?search=yes&exportfile=true">Download file</a>                    
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>