<%@page import="system.dto.clsClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<clsClass> classlist = (ArrayList<clsClass>) session.getAttribute("clases");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điểm kết thúc học kỳ</title>
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
                <br><h3>Điểm cuối kỳ các lớp học:</h3>
                <form action="" name="classname"  id="classname" method="post">
                    <table>
                        <tr>
                            <td width="150px"><b>Lớp học: </b> </td>
                            <td>
                                <select style="width:300px" name="sclassname" id="sclassname" onchange="ReloadScore()">
                                    <option value="All">-----------------------------</option>
                                    <%for (int i = 0; i < classlist.size(); i++) {%>
                                    <option value="<%=classlist.get(i).getClassName()%>"><%=classlist.get(i).getClassName()%> - <%=classlist.get(i).getSubName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                    </table>
                </form>
                <hr/><hr/>
                <form id="formdetail" name="formdetail">
                    <u>Chi tiết điểm theo lớp</u>
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >

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
    <script src="../javascripts/jsDiemCuoiKy.js"></script>
    <script  type = "text/javascript" >
        var http = createRequestObject();
        function ReloadScore(){
            if(http){
                var action="reload";
                var classname=document.classname.sclassname.value;
                if(classname=="All");
                else
                    ajaxfunction("../ServScore?action="+action+"&classname="+classname);
            }
        }
        
    </script>
</html>
