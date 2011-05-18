<%-- 
    Document   : jspGhiNhanDiemSV
    Created on : Apr 23, 2011, 4:31:30 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList<String> listInfo = (ArrayList<String>) session.getAttribute("listinfomation");
    int n = 0;
   if(listInfo != null)
    n = listInfo.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ghi nhận điểm SV</title>
        <style media="all" type="text/css">
            form{
            margin-left: 120px;
            margin-top: 50px;
            margin-bottom: 120px;
            padding-left: 20px;
            padding-top: 20px;
            padding-bottom: 20px;
            width: 450px;
            border: 2px solid #d20019;
            background-color: #f3e3e4;
            }

            form table{
            width: 100%;
            }

            form table th{
            background-color: #02ffff;

            }
            form table tr{
            background-color: #d2ff02;
            height: 20px
            }

            form table select{
            width: 100%
            }


            #btn{
            margin:20px auto;
            background-color: #dd3399;
            }

            #txtinput{
            width: 100%;
            }
        </style>
        <script  type = "text/javascript" >
         function UpdateScore(){                  
           var FilePath = document.frmInput.filePath.value;
            
            if(FilePath.length == 0){                
                alert("Vui Lòng chọn file trước khi submit");
            }else                
                document.forms["frmInput"].submit();
         }         
       </script>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <p>
                    Phần này QLK nhập điểm SV cho từng môn học.<br/>
                    điểm được cung cấp bởi các GV phụ trách môn học trong một file excel.
                </p>

                <br/><br/>

		<form action="../UpdateScore?function=process" method="post" name="frmInput" enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td>Chọn Lớp</td>
                            <td>
                                <select name="sClassId">
                                <%for(int i = 0; i < n; i++){%>
                                <option><%=listInfo.get(i)%></option>
                                <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Chọn File</td>
                            <td>
                                <input id="txtinput" type="file" name="filePath"><br/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                            <input id="btn" type="button" onclick="UpdateScore()" value="Nhập điểm.">
                            </td>
                        </tr>
                    </table>
		</form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
