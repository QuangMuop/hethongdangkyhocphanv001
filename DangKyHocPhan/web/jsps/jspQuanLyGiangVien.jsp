<%-- 
    Document   : jspQuanLyGiangVien
    Created on : 19-05-2011, 22:13:30
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsLecturer"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    int nLecturer = 0, i = 0, j = 0;
    String error = "OK";
    ArrayList<clsLecturer> listLecturer = null;
    try{
       listLecturer = (ArrayList<clsLecturer>) session.getAttribute("listlecturer");
    }catch(Exception ex){
        error = ex.toString();
    }

    if(listLecturer != null)
        nLecturer = listLecturer.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý giảng viên</title>
        <style media="all" type="text/css">
            #tablelistlecturer{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #tablelistlecturer th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tablelistlecturer td{
                background-color: #b1B700;
                padding: 2 5 2 5;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 320px;
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
                <h4><a href="../RegistryLecturer?function=nothing">Thêm giảng viên</a></h4>

                <br>
                <h3>Danh sách Giảng viên khoa công nghệ phần mềm</h3>
                <br/>
                 <form id = "formsearch" name="formsearch" action="../ManageLecturer?searchengine=true" method="post">
                     <table>
                         <tr>
                             <td><input type="radio" name="radiooption" id="rsubject" checked="true" onclick="selectAll()" ></td>
                             <td>All</td>
                         </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rsubject" checked="false" onclick="selectId()"></td>
                            <td><input type="text" name="txtId"> Tìm theo mã GV</td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rlecturer" checked="false" onclick="selectName()"></td>
                            <td><input type="text" name="txtName"> Tìm theo tên GV</td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <hr/><hr/>

                <form id="classlist">
                  <table id="tablelistlecturer" name="tablelistlecturer">
                    <tr>
                        <th>STT</th><th>Mã GV</th><th>Họ và tên</th><th>Ngày Sinh</th><th>Học Hàm</th><th>Học Vị</th><th>ĐT</th><th>Địa chỉ</th><th>Sửa</th><th>Xóa</th>
                    </tr>
                    <%if(nLecturer > 0){
                        for(i = 0; i < nLecturer; i++){
                    %>
                    <tr>
                        <td><%=(i+1)%></td>
                        <td><a href="../LecturerDetail?lecturerecode=<%=listLecturer.get(i).getLecturerCode()%>"><%=listLecturer.get(i).getLecturerCode()%></a></td>
                        <td><%=listLecturer.get(i).getFullname()%></td>
                        <td><%=listLecturer.get(i).getBirthDay()%></td>
                        <td><%=listLecturer.get(i).getHocHam()%></td>
                        <td><%=listLecturer.get(i).getHocVi()%></td>
                        <td><%=listLecturer.get(i).getPhone()%></td>
                        <td><%=listLecturer.get(i).getAddress()%></td>
                        <td><a href="../UpdateLecturer?id=<%=listLecturer.get(i).getLecturerCode()%>&function=update"> Sửa</a></td>
                        <td><a href="../UpdateLecturer?id=<%=listLecturer.get(i).getLecturerCode()%>&function=delete">Xóa</a></td>
                    </tr>
                        <%}%>
                     <%}%>
                </table>
                </form>
                <h4><a href="../RegistryLecturer?function=nothing">Thêm giảng viên</a></h4>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        typesearch="All";
        name="";
        action="search";
        actor="Admin";
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
                if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
                }
                else{
                    name=document.formsearch.txtId.value;
                }
                http.open("GET","../ManageLecturer?action="+action+"&type="+typesearch+"&name="+name+"&actor="+actor,true);
                http.onreadystatechange = handleResponse;
                http.send(null);
            }
        }

        function handleResponse(){
            if(http.readyState == 4 && http.status == 200){
                var detail=document.getElementById("tablelistlecturer");
                detail.innerHTML=http.responseText;
            }
        }
         function selectName(){
             typesearch="name";
         }
         function selectId(){
             typesearch="id";
         }
        function selectAll(){
           typesearch="All";
        }
       </script>
</html>
