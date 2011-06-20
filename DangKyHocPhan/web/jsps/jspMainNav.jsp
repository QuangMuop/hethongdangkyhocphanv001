<%-- 
    Document   : jspMainNav
    Created on : 26-04-2011, 21:12:12
    Author     : ngloc_it
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <style media="all" type="text/css">
        #mainmenu a{
        font-family:Arial, Helvetica, sans-serif;
        font-size:16px;
        color:#272727;
        font-weight:bold;
        text-decoration:none;
        margin-left: 20px;
}
#mainmenu a:hover{
        color:red;
}
#mainmenu li{
        list-style:none;
}
#mainmenu li a{
        line-height:35px;
}
#mainmenu li li{
        display:block;
        background: #ADDFFF;
        text-align:left;
   }
#mainmenu li li a{
        line-height:30px;
}
#mainmenu ul li ul{
        position:absolute;
        margin-left:10px;
        display:none;
}
#mainmenu li:hover>ul{
        display:block;
}
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
    </head>
    <body>
        <div id="mainmenu">
        <ul>
                <li><a href="jspTrangChu.jsp"> Trang chủ </a></li>
                <li> <a href="#">Quản lý khoa</a>
                   <ul>
                        <li><a href="#"> Quản lý giảng viên</a></li>
                        <li><a href="#"> Quản lý sinh viên</a></li>
                    </ul>
                </li>
                <li><a href="#"> Giảng viên </a></li>
                <li><a href="#"> Sinh viên </a></li>
                <li><a href="#"> Đăng nhập </a></li>
                <li><a href="#"> Liên hệ </a></li>
        </ul>
       </div>
    </body>
</html>
