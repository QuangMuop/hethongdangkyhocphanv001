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
    ArrayList<clsLecturer> leclist=(ArrayList<clsLecturer>) session.getAttribute("leclist");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý giảng viên</title>
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
                <br>
                <u>Tìm kiếm giảng viên:</u>
                <br/>
                 <form id = "formsearch" name="formsearch" action="../ManageLecturer?searchengine=true" method="post">
                     <table>
                         <tr>
                             <td><input type="radio" name="radiooption" id="rsubject" checked="true" onclick="selectAll()" ></td>
                             <td>All</td>
                         </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rsubject" onclick="selectId()"></td>
                            <td><input type="text" name="txtId"> Tìm theo mã GV</td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rlecturer" onclick="selectName()"></td>
                            <td><input type="text" name="txtName"> Tìm theo tên GV</td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <p align="right"><a href="../servLecturerManager?action=add"><b>Thêm giảng viên</b></a></p>
                <hr/><hr/>
                <u><b>Danh sách các giảng viên khoa công nghệ phần mềm:</b></u>
                <form id="classlist">
                  <table id="tablelistlecturer" name="tablelistlecturer">
                    <tr>
                        <th>STT</th><th>Mã GV</th><th>Họ Tên</th><th>Ngày Sinh</th><th>Giới tính</th><th>Học hàm</th><th>Học vị</th><th>Sửa</th><th>Xóa</th>
                    </tr>
                    <%for(int i=0; i<leclist.size();i++){%>
                    <tr>
                        <td><%=i+1%></td>
                        <td><a href="../servLecturerManager?action=detail&code=<%=leclist.get(i).getLecturerCode()%>"><%=leclist.get(i).getLecturerCode()%></a></td>
                        <td><%=leclist.get(i).getFullname()%></td>
                        <td><%=leclist.get(i).getBirthDay()%></td>
                        <td><%=leclist.get(i).getGender()%></td>
                        <td><%=leclist.get(i).getHocHam()%></td>
                        <td><%=leclist.get(i).getHocVi()%></td>
                        <td><a href="../servLecturerManager?code=<%=leclist.get(i).getLecturerCode()%>&action=edit">Sửa</a></td>
                        <td><a href="../servLecturerManager?code=<%=leclist.get(i).getLecturerCode()%>&action=predelete">Xóa</a></td>
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
        typesearch="All";
        name="";
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
                if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
                }
                else{
                    name=document.formsearch.txtId.value;
                }
                http.open("GET","../servLecturerManager?action="+action+"&type="+typesearch+"&name="+name,true);
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
