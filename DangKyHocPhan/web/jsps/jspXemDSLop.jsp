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
ArrayList<clsClass> clases=(ArrayList<clsClass>) session.getAttribute("clases");
ArrayList<clsLecturer> lec=(ArrayList<clsLecturer>) session.getAttribute("lec");
ArrayList<clsSubject> sub=(ArrayList<clsSubject>) session.getAttribute("sub");
String time=(String) session.getAttribute("time");
int n=clases.size();
int j=0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách lớp học</title>
        <style media="all" type="text/css">
            #tablelistclass{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #tablelistclass th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tablelistclass td{
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
                <h3>Danh sách các môn học trong <%=time%>:</h3>
                <form id="classlist">
                  <table id="tablelistclass" name="tablelistclass">
                    <tr>
                        <th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Số TC</th><th>Ngày</th><th>Phòng</th><th>Ca</th><th>Sửa</th><th>Xóa</th>
                    </tr>
                     <%for(j=0;j<n;j++){%>
                     <tr>
                         <td><%=j+1%></td>
                         <td><a href="../servClassView?action=detail&classname=<%=clases.get(j).getClassName()%>"><%=clases.get(j).getClassName() %></a></td>
                         <td><%=clases.get(j).getSubName()%></td>
                         <td><%=clases.get(j).getLecturerName()%></td>
                         <td><%=clases.get(j).getNumTC()%></td>
                         <td>Thứ <%=clases.get(j).getDate()%></td>
                         <td><%=clases.get(j).getRoom()%></td>
                         <td><%=clases.get(j).getShift()%></td>
                         <td><a href="../servClassView?action=edit&classname=<%=clases.get(j).getClassName()%>">Sửa</a></td>
                         <td><a href="../servClassView?action=delete&classname=<%=clases.get(j).getClassName()%>">Xóa</a></td>
                     </tr>
                     <%}%>
                </table>
                </form>
                <hr><hr>
                <h1>Tìm kiếm lớp học:</h1>
                <form id = "formsearch" name="formsearch" action="../ViewListClass?searchengine=true" method="post">
                     <table>
                         <tr>
                             <td><input type="radio" name="radiooption" id="rsubject" checked="true" onclick="selectAll()" ></td>
                             <td>All</td>
                         </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rsubject" onclick="selectsub()"></td>
                            <td>
                                <select name="ssubject" id="ssubject">
                                   <%for(int i=0;i<sub.size();i++){%>
                                    <option value="<%=sub.get(i).getSubCode()%>"><%=sub.get(i).getSubName()%></option>
                                    <%}%>
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="radio" name="radiooption" id="rlecturer" onclick="selectLec()"></td>
                            <td>
                                <select name="sLecturer" id="sLecturer">
                                    <%for(int i=0;i<lec.size();i++){%>
                                    <option value="<%=lec.get(i).getLecturerCode()%>"><%=lec.get(i).getFullname()%></option>
                                    <%}%>
                               </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="button" onclick="search()" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
                <p align="right"><b><a href="../servClassView?action=create">Mở lớp học mới</a></b></p>
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
                if(typesearch=="subname"){
                    name=document.getElementById("ssubject").value;
                }
                else{
                    name=document.formsearch.sLecturer.value;
                }
                http.open("GET","../servClassView?action="+action+"&type="+typesearch+"&name="+name+"&actor="+actor,true);
                http.onreadystatechange = handleResponse;
                http.send(null);
            }
        }

        function handleResponse(){
            if(http.readyState == 4 && http.status == 200){
                var detail=document.getElementById("tablelistclass");
                detail.innerHTML=http.responseText;
            }
        }
         function selectLec(){
             typesearch="lecturer";

         }
         function selectsub(){
             typesearch="subname";
         }
        function selectAll(){
           typesearch="All";
        }
       </script>
</html>
