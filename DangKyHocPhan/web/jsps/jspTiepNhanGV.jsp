<%-- 
    Document   : jspTiepNhanGV
    Created on : Apr 23, 2011, 4:29:54 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsRule"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
clsRule rule=(clsRule) session.getAttribute("rule");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiếp nhận giảng viên</title>
        <style media="all" type="text/css">
             #formaddone{
                    margin-left: 20px;
                    margin-top: 20px;
                    margin-bottom: 10px;
                    width: 320px;
                    padding-top: 20px;
                    padding-bottom: 20px;
                    padding-right: 10px;
                    padding-left: 10px;
                    background-color: #153E7E;
                    border: 3px solid #7F38EC;
                }
                   #formbrowse{
                       margin-top: 10px;
                    margin-left: 20px;
                    margin-bottom: 20px;
                    width: 320px;
                    padding-top: 20px;
                    padding-bottom: 20px;
                    padding-right: 10px;
                    padding-left: 10px;
                    background-color: #2f4e3d;
                    border: 3px solid #7F38EC;
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
                <p><b>Tiếp nhận giảng viên vào khoa công nghệ phần mềm: </b></p>
                <u>Một số quy đinh về khi tiếp nhận giảng viên:</u>
                <table>
                    <tr>
                        <td>Tuổi tối thiểu:</td>
                        <td><input type="text" id="minage" value="<%=rule.getMinLecturerAge()%>"readonly></td>
                    </tr>
                    <tr>
                        <td>Tuổi tối đa:</td>
                        <td><input type="text" id="maxage" value="<%=rule.getMaxLecturerAge()%>"readonly></td>
                    </tr>
                </table>
                <form id="formaddone" name="frmAddOne" action="../servLecturerManager?action=addone" method="post">
                    <u>Thêm một giảng viên.</u><br/><br/>
                    <table id="tableaddone">
                        <tr>
                            <td>Mã GV(*):</td> <td><input type="text" name="txtCode" id="txtCode"></td>
                        </tr>
                        <tr>
                            <td>Họ Tên(*):</td> <td><input type="text" name="txtname" id="txtname"></td>
                        </tr>
                        <tr>
                            <td>Ngày Sinh</td>
                            <td>
                                 <select name="sDay">
                                    <%for(int j = 0; j < 31; j++){%>
                                    <option value="<%=(j+1)%>"><%=(j+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth">
                                    <%for(int j = 0; j < 12; j++){%>
                                    <option value="<%=(j+1)%>"><%=(j+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear" id="sYear">
                                    <%for(int j = 0; j < 50; j++){%>
                                    <option value="<%=(1940+j)%>"><%=(1940+j)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới tính(*):</td>
                            <td>
                                <select name="sSex">
                                    <option value="Nam">Nam</option>
                                    <option value="Nữ">Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td> <td><input type="text" name="txtAddress" id="txtAddress"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td> <td><input type="text" name="txtPhone" id="txtPhone"></td>
                        </tr>
                        <tr>
                            <td>Email</td> <td><input type="text" name="txtEmail" id="txtEmail"></td>
                        </tr>
                        <tr>
                            <td>Học Hàm</td>
                            <td>
                                 <select name="sHocHam">
                                     <option value="Null">Null</option>
                                    <option value="Giáo sư">Giáo sư</option>
                                    <option value="P.Giáo sư">P.Giáo sư</option>
                                  </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Học Vị</td>
                            <td>
                               <select name="sHocVi">
                                    <option value="Null">Null</option>
                                    <option value="Cao học">Cao Học</option>
                                    <option value="Thạc sĩ">Thạc sĩ</option>
                                    <option value="Tiến sĩ">Tiến Sĩ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>CMND(*):</td>
                            <td><input type="text" name="txtCMND" id="txtCMND"></td>
                        </tr>
                    </table>
                    <input type="button" value="Thêm" onclick="PreCheckOne()">
                 </form>
                  <hr><hr>
                <form id="formbrowse" name="formbrowse" action="../servLecturerManager?action=addlist"
                      method="post" enctype="multipart/form-data">
                    <u>Thêm Giảng Viên Từ File</u><br/><br/>
                    <table id="tablebrowse">
                        <tr>
                            <td><input type="file" name="txtPath" id="txtPath"></td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="precheckfile()" value="Thêm"></td><td></td>
                        </tr>
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
    <script  type = "text/javascript" >
         function PreCheckOne(){
             var curent=new Date().getFullYear();
             var year=document.getElementById("sYear").value;
             var minage=document.getElementById("minage").value;
             var maxage=document.getElementById("maxage").value;
           if(document.getElementById("txtCode").value.length==0){
               alert("Vui lòng nhập mã giảng viên");
           }
           else if(document.getElementById("txtname").value.length==0){
               alert("Vui lòng nhập họ tên giảng viên");
           }
           else if(document.getElementById("txtCMND").value.length==0){
               alert("Vui lòng nhập CMND của giảng viên");
           }
           else if(curent-year<minage){
                alert("Giảng viên chưa đut tuổi quy định");
           }
           else if(curent-year>maxage){
                alert("Giảng viên đã quá tuổi quy định");
           }
           else{
              document.forms["formaddone"].submit();
           }
        }
      function precheckfile(){
             var filename=document.getElementById("txtPath").value;
              if(filename.length==0){
                  alert("Bạn chưa chọn file");
              }
             else{
                  var duoi=filename.substr(filename.length-4, 4);
                  if(duoi!=".xls"&&duoi!="xlsx"){
                      alert("Chỉ hỗ trợ thêm sinh viên từ file excel, xin chọn file khác");
                  }else {
                 document.forms["formbrowse"].submit();

                  }
              }
      }
       </script>
</html>