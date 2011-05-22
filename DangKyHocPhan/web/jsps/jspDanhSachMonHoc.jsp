<%--
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsSubject> sub=(ArrayList<clsSubject>) session.getAttribute("sub");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý môn học</title>
        <style media="all" type="text/css">
            #subjectlist{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #subjectlist th{
                height: 22px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #subjectlist td{
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
        <!--Get data from controller-->

        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <br>
                <h1>Tìm kiếm môn học:</h1>
                <form id = "formsearch" name="formsearch" action="#" method="post">
                     <table>
                         <tr>
                             <td>Tên môn học:</td>
                             <td><input type="text" id="subname" name="subname"></td>
                         </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <p align="right"><b><a href="jspTaoMoiMonHoc.jsp">Thêm môn học mới</a></b></p>
                 <hr><hr>
                <h3>Danh sách các môn học :</h3>
                <form id="sublist">
                  <table id="subjectlist" name="subjectlist">
                    <tr>
                        <th>STT</th><th>Mã môn</th><th>Môn học</th><th>Số TC</th><th>Số TCLT</th><th>Số TCTH</th><th>Sửa</th><th>Xóa</th>
                    </tr>
                    <%for(int i=0;i<sub.size();i++){%>
                    <tr>
                        <td><%=i+1%></td><td><%=sub.get(i).getSubCode()%></td><td><%=sub.get(i).getSubName()%></td>
                        <td><%=sub.get(i).getNumTC()%></td><td><%=sub.get(i).getTCLT()%></td><td><%=sub.get(i).getTCTH()%></td>
                        <td><a href="../servSubject?action=edit&subcode=<%=sub.get(i).getSubCode()%>">Sửa</a></td>
                        <td><a href="../servSubject?action=delete&subcode=<%=sub.get(i).getSubCode()%>">Xóa</a></td>
                    </tr>
                    <%}%>
                </table>
                </form>
                </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
     <script  type = "text/javascript" >
           action="search";
           function createRequestObject(){
            var req;
            if(window.XMLHttpRequest){
                //For Firefox, Safari, Opera
                req = new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                //For IE 5+
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
            else{
                //Error for an old browser
                alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');
            }
            return req;
        }

        //Make the XMLHttpRequest Object
        var http = createRequestObject();
        function search(){
            if(http){
                name=document.getElementById("subname").value;
                 http.open("GET","../servSubject?action="+action+"&name="+name,true);
                http.onreadystatechange = handleResponse;
                http.send(null);
            }
        }

        function handleResponse(){
            if(http.readyState == 4 && http.status == 200){
                var detail=document.getElementById("subjectlist");
                detail.innerHTML=http.responseText;
            }
        }
        
       </script>
</html>
