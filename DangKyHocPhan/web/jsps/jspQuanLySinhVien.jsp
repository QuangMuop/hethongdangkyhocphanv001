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
    String error = "OK";
    int n = 0, i;
    ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
    try{
        listStudent = (ArrayList<clsStudent>) session.getAttribute("liststudent");
    }catch(Exception ex){
        error = ex.toString();
    }
    if(listStudent != null)
        n = listStudent.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sinh viên</title>
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
                             <td><input type="radio" name="radiooption" id="rsubject" checked="true" onclick="selectAll()" ></td>
                             <td>All</td>
                         </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rsubject" onclick="selectClass()"></td>
                            <td>
                                <select name="sClass" id="ssubject">
                                   <%for(i = 0; i < 10; i++){%>
                                   <option>CNPM<%if(i < 9){%><%=0%><%}%><%=(i+1)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rlecturer" onclick="selectId()"></td>
                            <td>
                                <input type="text" name="txtId"> Tìm theo mã số SV
                            </td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rlecturer" onclick="selectName()"></td>
                            <td>
                                <input type="text" name="txtName"> Tìm theo tên
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <hr><hr>
                <form method="#">
                    Danh sách sinh viên:<br/>                    
                    <table id="tableliststudent" name="tableliststudent">
                        <tr>
                            <th>STT</th><th>Họ và tên</th><th>MSSV</th><th>Lớp</th><th>Ngày Sinh</th><th>Sửa</th><th>Xóa</th>
                        </tr>
                        <%for(i = 0; i < n; i++){%>
                            <tr>
                                <td><%=(i+1)%></td>
                                <td><%=listStudent.get(i).getFullname()%></td>
                                <td><a href="#"><%=listStudent.get(i).getCode()%></a></td>
                                <td><%=listStudent.get(i).getClasss()%></td>
                                <td><%=listStudent.get(i).getBirthDay()%></td>
                                <td><a href="../StudentDetail?MSSV=<%=listStudent.get(i).getCode()%>">Sửa</a></td>
                                <td><a href="../UpdateStudent?functionname=delete&mssv=<%=listStudent.get(i).getCode()%>">Xóa</a></td>
                            </tr>
                        <%}%>
                    </table>
                    <a href="#">Tải file</a>
                    <a href="../RegistryStudent?function=nothing">Tiếp nhận sinh viên</a>
                    <a href="../UpdateScore?function=loaddata">Ghi Nhận Điểm SV</a>
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
                }else if(typesearch == "mssv"){
                    name=document.formsearch.txtId.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                http.open("GET","../ManageStudent?action="+action+"&type="+typesearch+"&name="+name+"&actor="+actor,true);
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
         function selectId(){
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
