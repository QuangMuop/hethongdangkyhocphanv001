<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<Integer> procode=(ArrayList<Integer>) session.getAttribute("procode");
ArrayList<clsProgram> pro=(ArrayList<clsProgram>) session.getAttribute("pro");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý chương trình đào tạo</title>
        <style media="all" type="text/css">

            #procode{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom:  10px;
                width: 1000px;
            }
            #procode table{
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
                background-color: #5F676D;
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
                <br><h3>Chi tiết từng chương trình đào tạo cúa khoa Kỹ Thuật Phần Mềm:</h3>
                <form action="../servProManage?action=addsub" name="pro"  id="pro" method="post">
                    <table>
                        <tr>
                            <td width="150px"><b>Mã chương trình: </b> </td>
                            <td>
                                <select style="width:50px" name="procode" id="procode" onchange="reloadPro()">
                                    <%for(int i=0;i<procode.size();i++){%>
                                    <option value="<%=procode.get(i)%>"><%=procode.get(i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="button" value="Thêm môn học" onclick="addsub()"></td>
                            <td><input type="button" value="Xóa môn học" onclick="delsub()"></td>
                        </tr>
                    </table>
                    <p align="right"><a href="../servProManage?action=create">Tạo mới chương trình đào tạo</a></p>
                </form>
                <form action="../servProManage?action=delsub" name="temp"  id="temp" method="post">
                    <input type="hidden" name="codepro" id="codepro" value="1" readonly>
                </form>
                <hr/><hr/>
                <form id="formdetail" name="formdetail">
                    <u>Chi tiết</u>
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th>STT</th><th>Mã CT</th><th>Mã môn học</th><th >Tên môn học</th><th>Học kỳ</th>
                        </tr>
                        <%for(int i=0;i<pro.size();i++){%>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=pro.get(i).getProgramCode()%></td>
                            <td><%=pro.get(i).getSubjectCode()%></td>
                            <td><%=pro.get(i).getSubName()%></td>
                            <td><%=pro.get(i).getSemester()%></td>
                        </tr>
                        <%}%>
                    </table>
                    <br/>
                </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script src="../javascripts/jsChuongTrinhDT.js"></script>
    <script  type = "text/javascript" >
        var http = createRequestObject();
        function reloadPro(){
            if(http){
                var action="reload";
                var procode=document.pro.procode.value;
                document.temp.codepro.value=procode;
                ajaxfunction("../servProManage?action="+action+"&procode="+procode);
            }
        }
        function addsub(){
            document.forms["pro"].submit();
        }
        function delsub(){
            
            document.forms["temp"].submit();
        }
    </script>
</html>
