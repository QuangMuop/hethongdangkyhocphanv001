<%@page import="system.dto.clsStudent"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList<clsStudent> listStudent = (ArrayList<clsStudent>) session.getAttribute("liststudent");
    ArrayList<String> listClass = (ArrayList<String>) session.getAttribute("listClass");
    Integer numStudent = (Integer) session.getAttribute("numStudent");
   
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
                border: 3px solid #73726E;
            }
            #tableliststudent th{
                height: 32px;
                font-weight: bold;
                background: url("../imgs/opaque_10.png") repeat scroll 0 0 transparent;
                text-align: center;
            }
            #tableliststudent td{
                background: url("../imgs/opaque_10.png") repeat scroll 0 0 transparent;
                padding: 2 5 2 5;
                text-align: left;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background: url("../imgs/opaque_10.png") repeat scroll 0 0 transparent;
                border: 3px solid #73726E;
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
                <form id="formdown" name="formdown" action="../DownloadFile?action=test" method="post">
                    Danh sách sinh viên:<br/>
                    <table id="tableliststudent" name="tableliststudent">
                        <tr>
                            <th>STT</th><th>MSSV</th><th>Họ Tên</th><th>Lớp</th><th>Ngày sinh</th><th>Giới tính</th><th>Loại</th><th>Sửa</th><th>Xóa</th><th>Cập nhật</th>
                        </tr>
                        <%for(int i = 0; i < listStudent.size(); i++){%>
                            <tr>
                                <td><%=(i+1)%></td>
                                <td><a href="../servStudentManager?action=detail&MSSV=<%=listStudent.get(i).getCode()%>"><%=listStudent.get(i).getCode()%></a></td>
                                <td><%=listStudent.get(i).getFullname()%></td>
                                <td><%=listStudent.get(i).getClasss()%></td>
                                <td><%=listStudent.get(i).getBirthDay()%></td>
                                <td><%=listStudent.get(i).getGender()%></td>
                                 <td><%=listStudent.get(i).getType()%></td>
                                <td><a href="../servStudentManager?action=edit&MSSV=<%=listStudent.get(i).getCode()%>">Sửa</a></td>
                                <td><a href="../servStudentManager?action=predelete&MSSV=<%=listStudent.get(i).getCode()%>">Xóa</a></td>
                                <%if(listStudent.get(i).getNote().equalsIgnoreCase("null")||listStudent.get(i).getNote().equalsIgnoreCase("")){%>
                                <td>Không</td>
                                <%}else{%>
                                <td>Có</td>
                                <%}%>
                            </tr>
                        <%}%>
                    </table>
                    <input style="position:absolute; left:650px;" type="button" value="|<<" onclick="nprepage()">
                    <input style="position:absolute; left:680px;" type="button" value="<<" onclick="prepage()">
                    <input style="position:absolute; left:710px;" type="button" value=">>" onclick="nextpage()">
                    <input style="position:absolute; left:740px;" type="button" value=">>|" onclick="nnextpage()"><br>
                        <input type="hidden" value="<%=numStudent%>" id="numstu" />
                        <input type="button" value="Tải file" onclick="load()"/>
                        </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
     <script src="../javascripts/jsSinhVien.js"></script>
     <script  type = "text/javascript" >
        typesearch="All";
        name="All";
        action="search";
        action1="studentlist";
        start=0;
        end=document.getElementById("numstu").value;
           var http = createRequestObject();
        function search(){
            if(http){
                start=0;
                if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                ajaxfunction("../servStudentManager?action="+action+"&type="+typesearch+"&name="+name+"&start="+start);
            }
        }
        function nprepage(){
           search();
        }
        function prepage(){
            start=start-5;
            if(start<0){
                start=0;
            }
             if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                ajaxfunction("../servStudentManager?action="+action+"&type="+typesearch+"&name="+name+"&start="+start);
       
        }
        function nextpage(){
            start=start+5;
            if(start+5>end){
                start=end-5;
            }
            if(start<0){
                start=0;
            }
            if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                ajaxfunction("../servStudentManager?action="+action+"&type="+typesearch+"&name="+name+"&start="+start);
        }
        function nnextpage(){
            start=end-5;
            if(start<0){
                start=0;
            }
                 if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
                ajaxfunction("../servStudentManager?action="+action+"&type="+typesearch+"&name="+name+"&start="+start);
       
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
       function load(){
            if(start<0){
                start=0;
            }
                 if(typesearch=="name"){
                    name=document.formsearch.txtName.value;
               }else if(typesearch == "mssv"){
                    name=document.formsearch.txtcode.value;
                }else if(typesearch == "classname"){
                    name = document.formsearch.sClass.value;
                }
            document.forms["formdown"].action="../DownloadFile?action=studentlist&type="+typesearch+"&name="+name;
            document.forms["formdown"].submit();
                   // downloadfunction("../DownloadFile?action=test&type="+typesearch+"&name="+name);
       
       }
       </script>
</html>
