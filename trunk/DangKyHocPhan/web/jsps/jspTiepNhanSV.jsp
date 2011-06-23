<%-- 
    Document   : jspTiepNhanSV
    Created on : Apr 23, 2011, 4:29:43 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsRule"%>
<%@page import="system.dto.clsCourse"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<String> listClass=(ArrayList<String>) session.getAttribute("listClass");
ArrayList<clsCourse> listCourse=(ArrayList<clsCourse>) session.getAttribute("listCourse");
clsRule rule=(clsRule) session.getAttribute("rule");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiếp Nhận Sinh Viên</title>
        <style media="all" type="text/css">
            #formaddone{
                margin-left: 10px;
                margin-top: 10px;
                width: 720px;
                padding-top: 10px;
                padding-bottom: 10px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #175F6E;
                border: 2px solid #7F38EC;
            }
            #formaddone table{
                width: 100%;
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
                <h3><b><u>Tiếp nhận sinh viên vào khoa công nghệ phần mềm</u></b></h3>
                <u>Một số quy đinh về khi tiếp nhận sinh viên:</u>
                <table>
                    <tr>
                        <td>Tuổi tối thiểu:</td>
                        <td><input type="text" id="minage" value="<%=rule.getMinStudentAge()%>"readonly></td>
                    </tr>
                    <tr>
                        <td>Tuổi tối đa:</td>
                        <td><input type="text" id="maxage" value="<%=rule.getMaxStudentAge()%>"readonly></td>
                    </tr>
                </table>
                <form id="formaddone" name="formaddone" action="../servStudentManager?action=addone" method="post">
                    <u>Thông tin sinh viên</u><br/>
                    <table id="add">
                        <tr>
                            <td>MSSV(*):</td><td><input type="text" name="txtMSSV" id="txtMSSV" size="30px"></td>
                            <td>Họ tên(*):</td><td><input type="text" name="txtname" id="txtname" size="30px"></td>
                        </tr>
                         <tr>
                            <td>Ngày Sinh(*):</td>
                            <td>
                               <select style="width:60px" name="sDay" id="sDay">
                                    <%for(int i = 0; i < 31; i++){%>
                                    <option value="<%=(i+1)%>"><%=(i+1)%></option>
                                    <%}%>
                                </select>
                              <select style="width:60px" name="sMonth" id="sMonth">
                                    <%for(int i = 0; i < 12; i++){%>
                                    <option value="<%=(i+1)%>"><%=(i+1)%></option>
                                    <%}%>
                                </select>
                              <select style="width:60px" name="sYear" id="sYear">
                                    <%for(int i = 1980; i < 2010; i++){%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                            <td>Giới tính(*):</td>
                        <td>
                            <select style="width:190px" name="sSex">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                            </select>
                        </td>
                        </tr>
                        <tr>
                            <td>Lớp(*):</td>
                            <td>
                                <select style="width:190px" name="sClass">
                                    <%for(int i=0;i<listClass.size();i++){%>
                                    <option value="<%=listClass.get(i)%>"><%=listClass.get(i)%></option>
                                      <%}%>
                                 </select>
                            </td>
                            <td>Khóa(*):</td>
                            <td>
                                 <select style="width:190px" name="sCourse" id="sCourse">
                                      <%for(int i=0;i<listCourse.size();i++){%>
                                      <option value="<%=listCourse.get(i).getCourseCode()%>"><%=listCourse.get(i).getCourseCode()%></option>
                                      <%}%>
                                 </select>
                            </td>
                        </tr>
                         <tr>
                            <td>Loại hình đào tạo(*):</td>
                            <td>
                                <select style="width:190px" name="sType" id="sType">
                                    <option value="Chính quy">Chính quy</option>
                                    <option value="Từ xa">Từ xa</option>
                                </select>
                            </td>
                            <td>Bậc học(*):</td>
                            <td>
                                <select style="width:190px" name="sBacHoc" id="sBacHoc">
                                    <option value="Đại học">Đại học</option>
                                    <option value="Cao học">Cao học</option>
                                </select>
                            </td>
                        </tr>
                         <tr>
                            <td>Thường trú(*):</td>
                            <td><input type="text" name="txthome" id="txthome" size="30px"></td>
                            <td>Tạm trú(*):</td>
                            <td><input type="text" name="txtadd" id="txtadd" size="30px"></td>
                        </tr>
                        <tr>
                            <td>CMND(*):</td>
                            <td><input type="text" name="txtcmnd" id="txtcmnd" size="30px"></td>
                            <td>Ngày nhập học(*):</td>
                            <td>
                                <select style="width:60px" name="sDay1" id="sDay1">
                                    <%for(int i = 0; i < 31; i++){%>
                                    <option value="<%=(i+1)%>"><%=(i+1)%></option>
                                    <%}%>
                                </select>
                              <select style="width:60px" name="sMonth1" id="sMonth1">
                                    <%for(int i = 0; i < 12; i++){%>
                                    <option value="<%=(i+1)%>"><%=(i+1)%></option>
                                    <%}%>
                                </select>
                              <select style="width:60px" name="sYear1" id="sYear1">
                                    <%for(int i = 2006; i < 2021; i++){%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Điện thoại:</td>
                            <td><input type="text" name="txtphone" id="txtphone" size="30px"></td>
                            <td>Enail:</td>
                            <td><input type="text" name="txtemail" id="txtemail" size="30px"></td>
                        </tr>
                    </table>
                <br/>
                <input type="button" value="Thêm sinh viên" onclick="PreCheckStudentOne()">
            </form>
            <br/>
            <form id="formbrowse" action="../servStudentManager?action=addlist" method="post" name="formbrowse" enctype="multipart/form-data">
                <u>Thêm Sinh Viên Từ File</u><br/>
                <table id="tablebrowse">
                    <tr>
                        <td><input type="file" name="txtPath" id="txtPath"></td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="insertFromFile()" value="Thêm"></td><td></td>
                    </tr>
                </table>
            </form><br>
             </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
       <script  type = "text/javascript" >
         function PreCheckStudentOne(){
             var curent=new Date().getFullYear();
             var year=document.getElementById("sYear").value;
             var minage=document.getElementById("minage").value;
             var maxage=document.getElementById("maxage").value;
             //var yearin=document.getElementById("sCourse").value+2005;
           if(document.getElementById("txtMSSV").value.length==0){
               alert("Vui lòng nhập MSSV");
           }
           else if(document.getElementById("txtname").value.length==0){
               alert("Vui lòng nhập họ tên sinh viên");
           }
           else if(document.getElementById("txthome").value.length==0){
               alert("Vui lòng nhập địa chỉ thường trú của sinh viên");
           }
           else if(document.getElementById("txtadd").value.length==0){
               alert("Vui lòng nhập địa chỉ tạm trú của sinh viên");
           }
           else if(document.getElementById("txtcmnd").value.length==0){
               alert("Vui lòng nhập CMND của sinh viên");
           }
          else if(curent-year<minage){
               alert("Sinh viên chưa đủ tuổi quy định");
         }
         else if(curent-year>maxage){
            alert("Sinh viên đã quá tuổi quy định");
          }
          //else if(document.getElementById("sYear1").value != yearin){
         //   alert("Năm nhập học không hợp lý");
         // }
           else{
              document.forms["formaddone"].submit();
           }
        }
      function insertFromFile(){
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