<%-- 
    Document   : jspQuanLySinhVien
    Created on : 19-05-2011, 22:10:10
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsStudent"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList<clsStudent> listStudent = (ArrayList<clsStudent>) session.getAttribute("liststudent");
    ArrayList<String> listClass = (ArrayList<String>) session.getAttribute("listClass");
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sinh viên</title>
        <style media="all" type="text/css">
            #tableliststudent{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;                
            }
            #tableliststudent th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
                text-align: center;
            }
            #tableliststudent td{
                background-color: #b1B700;
                padding: 2 5 2 5;
                text-align: left;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 320px;
            }
            #red{
                margin-left: 32px;
                margin-top: 15px;
                background-color: #e4e4e3;
                width: 250px;
                height: 32px;
            }
            #red:hover {
                border: 2px solid #ff092d;
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
                
                <br/>

                <h1>Tìm kiếm sinh viên:</h1>
                <form id = "formsearch" name="formsearch" action="#" method="post">
                     <table>
                         <tr>
                             <td><input type="radio" name="radiooption" checked="true" onclick="selectAll()" ></td>
                             <td>All</td>
                         </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" onclick="selectClass()"></td>
                            <td>
                                <select name="sClass" id="sClass">
                                   <%for(int i = 0; i < listClass.size(); i++){%>
                                   <option value="<%=listClass.get(i)%>"><%=listClass.get(i)%></option>
                                    <%}%>
                                </select> Tìm theo lớp
                            </td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" onclick="selectCode()"></td>
                            <td>
                                <input type="text" name="txtcode" id="txtcode"> Tìm theo MSSV
                            </td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" onclick="selectName()"></td>
                            <td>
                                <input type="text" name="txtName" id="txtName"> Tìm theo tên
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                 <p align="right"><b><a href="../servStudentManager?action=create">Tiếp nhận sinh viên</a></b></p>
                <hr><hr>
                <form method="#">
                    Danh sách sinh viên:<br/>                    
                    <table id="tableliststudent" name="tableliststudent">
                        <tr>
                            <th>STT</th><th>MSSV</th><th>Họ Tên</th><th>Lớp</th><th>Ngày sinh</th><th>Giới tính</th><th>Loại</th><th>Sửa</th><th>Xóa</th>
                        </tr>
                        <%for(int i = 0; i < listStudent.size(); i++){%>
                            <tr>
                                <td><%=(i+1)%></td>
                                <td><%=listStudent.get(i).getCode()%></td>
                                <td><%=listStudent.get(i).getFullname()%></td>
                                <td><%=listStudent.get(i).getClasss()%></td>
                                <td><%=listStudent.get(i).getBirthDay()%></td>
                                <td><%=listStudent.get(i).getGender()%></td>
                                 <td><%=listStudent.get(i).getType()%></td>
                                <td><a href="../servStudentManager?action=edit&MSSV=<%=listStudent.get(i).getCode()%>">Sửa</a></td>
                                <td><a href="../servStudentManager?action=delete&MSSV=<%=listStudent.get(i).getCode()%>">Xóa</a></td>
                            </tr>
                        <%}%>
                    </table>
                    <a href="#">Tải file</a>
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
        name="All";
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
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                http.open("GET","../servStudentManager?action="+action+"&type="+typesearch+"&name="+name,true);
                http.onreadystatechange = handleResponse;
                http.send(null);
            }
        }

        function handleResponse(){
            if(http.readyState == 4 && http.status == 200){
                var detail=document.getElementById("tableliststudent");
                detail.innerHTML=http.responseText;
            }
        }
         function selectCode(){
             typesearch="mssv";

         }
         function selectName(){
             typesearch="name";
         }
         function selectClass(){
             typesearch = "classname";
         }
        function selectAll(){
           typesearch="All";
        }
       </script>
</html>
