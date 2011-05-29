
<%@page import="system.dto.clsProgram"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsProgram> prolist=(ArrayList<clsProgram>) session.getAttribute("prolist");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chương trình đào tạo mới</title>
        <style media="all" type="text/css">

                #pro{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom:  10px;
                 width: 1000px;
                }
                #pro table{
                width: 100%;
                padding-left: 5px;
                padding-right: 5px;
                }
                #formdetail table{
                width: 100%;
                    padding-left: 10px;
                        padding-right: 10px;
                        text-align: center;

                }
                #formdetail table th{
                background-color:#00ff00;
                height: 30px;
                border-color: black;
                }

                #formdetail table td{
                text-align: center;
                background-color: #ffe2ff
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
                <br><h3>Chương trình đào tạo khung mới của khoa Kỹ Thuật Phần Mềm:</h3>
                <form action="" name="pro"  id="pro">
                    <table>
                      <tr>
                          <td width="150px"><b>Mã chương trình: </b> </td>
                          <td><%=prolist.get(0).getProgramCode()%></td>
                    </table>
                   </form>
                <hr/><hr/>
                <form id="formdetail" name="formdetail" action="../servProManage?action=complete" method="post">
                 <u>Chi tiết</u>
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th>STT</th><th>Mã môn học</th><th>Tên môn học</th><th>Học kỳ</th>
                        </tr>
                        <%for(int i=0;i<prolist.size();i++){%>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=prolist.get(i).getSubjectCode()%></td>
                            <td><%=prolist.get(i).getSubName()%></td>
                            <td><%=prolist.get(i).getSemester()%></td>
                        </tr>
                        <%}%>
                        </table>
			<br/>
                       </form>
                         <form id="frmreset" name="frmreset" method="post" action="../servProManage?action=reset">
                     <table>
                         <tr>
                             <td><input type="button" onclick="complete()" value="Hoàn tất"></td>
                             <td><input type="button" onclick="reseet()" value="Chọn lại"></td>
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
     <script  type = "text/javascript" >
        function reseet(){
             document.forms["frmreset"].submit();
        }
        function complete(){
            document.forms["formdetail"].submit();
        }
       </script>
   </html>
