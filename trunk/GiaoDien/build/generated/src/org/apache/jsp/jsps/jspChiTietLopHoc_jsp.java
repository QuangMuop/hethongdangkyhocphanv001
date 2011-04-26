package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspChiTietLopHoc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/jsps/jspmenu.jsp");
  }

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"../csss/menu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <MARQUEE onmouseover=\"this.stop();\" onmouseout=\"this.start();\" HEIGHT=25 BGCOLOR=#C0C6CE BEHAVIOR=scroll SCROLLAMOUNT=\"4\">\n");
      out.write("            Chào mừng đến với hệ thống đăng ký học phần.\n");
      out.write("        </MARQUEE>\n");
      out.write("\n");
      out.write("        <div id=\"logo\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id = \"menu\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"jspTrangChu.jsp\"> Trang chủ </a>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspXemDSLop.jsp\">Xem DS Lớp Học</a> </li>\n");
      out.write("                <li><a href=\"jspXemTKB.jsp\">Xem TKB</a></li>\n");
      out.write("                <li><a href=\"#\">Quản Lý Khoa</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li> <a href=\"jspTiepNhanSV.jsp\">Tiếp Nhận SV</a> </li>\n");
      out.write("                        <li><a href=\"jspTiepNhanGV.jsp\">Tiếp Nhận GV</a> </li>\n");
      out.write("                        <li><a href=\"jspTaoLopHoc.jsp\">Tạo Lớp Học</a> </li>\n");
      out.write("                        <li><a href=\"jspGhiNhanDiemSV.jsp\">Ghi Nhận Điểm SV</a> </li>\n");
      out.write("                        <li><a href=\"jspCaiDatTaiKhoan.jsp\">Cài Đặt Tài Khoản</a> </li>\n");
      out.write("                        <!--<li> <a href=\"jspCapNhatTaiKhoan.jsp\">Cập Nhật Tài Khoản</a> </li>-->\n");
      out.write("                        <li><a href=\"jspCaiDatQuiDinh.jsp\">Cài Đặt Qui Định</a> </li>                        \n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\">Sinh Viên</a>\n");
      out.write("                <ul>\n");
      out.write("                        <li> <a href=\"jspDangKyMonHoc.jsp\">Đăng Ký Môn Học</a> </li>\n");
      out.write("                        <li><a href=\"jspXemChuongTrinhDaoTao.jsp\">Xem Chương Trình Đào Tạo</a> </li>\n");
      out.write("                        <li><a href=\"jspXemTKB.jsp\">Xem TKB</a> </li>\n");
      out.write("                        <li> <a href=\"jspXemKQHocTap.jsp\">Xem KQ Học Tập</a> </li>\n");
      out.write("                        <li><a href=\"jspCapNhatThongTin.jsp\">Cập Nhật Thông Tin</a> </li>\n");
      out.write("                        <li> <a href=\"jspGuiYeuCau.jsp\">Gửi Yêu Cầu</a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspLogin.jsp\">Login</a></li>\n");
      out.write("                <li><a href=\"jspXemQuiDinh.jsp\">Qui định</a>\n");
      out.write("                <!--<ul>\n");
      out.write("                        <li> <a href=\"jspXemQuiDinh.jsp\">Xem Qui Định</a> </li>\n");
      out.write("                        <li><a href=\"jspCaiDatQuiDinh.jsp\">Sửa Qui Định</a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                -->\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspLienHe.jsp\">Liên Hệ</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <br/><br/>\n");
      out.write("        <hr/><hr/>        \n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Chi tiêt lớp học</title>\n");
      out.write("        <style media=\"all\" type=\"text/css\">\n");
      out.write("            #form-class-info{\n");
      out.write("            margin-left: 250px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            width: 350px;\n");
      out.write("            border: 2px solid;\n");
      out.write("            background-color: #f3df02;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form-class-info table td{\n");
      out.write("            font-weight: bold\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form-list-student{\n");
      out.write("            margin-left: 200px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            width: 500px;\n");
      out.write("            border-left: 2px solid;\n");
      out.write("            border-right: 2px solid;\n");
      out.write("            background-color: #f3df02;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form-list-student table{\n");
      out.write("            width: 100%\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #form-list-student table th{\n");
      out.write("            background-color: #ff02ed;\n");
      out.write("            border: 1px solid;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>BẠN ĐANG Ở TRANG Chi tiết lớp học!</h1><br/>\n");
      out.write("        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>\n");
      out.write("        <p>\n");
      out.write("            trong trang này: SV có thể xem DS SV, thông tin của lớp học đó.<br/>\n");
      out.write("            Quản lý khoa được quyền xuất DS SV ra file.\n");
      out.write("        </p>\n");
      out.write("        <br/><br/>\t\t\n");
      out.write("\t\t<form id=\"form-class-info\" action=\"#\" method=\"post\">\n");
      out.write("\t\t\t<u>Phần cung cấp thông tin về lớp học.</u><br/><br/>\n");
      out.write("\t\t\t<table>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Mã lớp: </td><td>SE001</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Tên Lớp: </td><td>Lập trình hướng đối tượng</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Mã GV: </td><td>GV001</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Tên GV: </td><td>Ts. Nguyễn Văn A</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Số Lượng SV: </td><td>1001</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<br/><br/>\t\t\t\t\t\t\n");
      out.write("\t\t</form>\n");
      out.write("\t\t\n");
      out.write("\t\t<br/><br/>\n");
      out.write("\t\t<u>Phần này liệt Danh sach SV trong lớp.</u><br/><br/>\n");
      out.write("\t\t<form name=\"form_list_student\" id=\"form-list-student\" action=\"#\" method=\"post\">\n");
      out.write("\t\t\t<table id=\"table-list-class\">\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th><a href=\"#\">STT</a></th><th><a href=\"#\">MSSV</a></th><th><a href=\"#\">Họ Và Tên</a></th><th><a href=\"#\">Khoa</a></th><th><a href=\"#\">TG ĐK</a></th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>001</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>002</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>003</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>004</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>005</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"submit\" value=\"   Xuất file   \">\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<br/><br/><br/><br/><br/><br/><br/><br/><br/>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
