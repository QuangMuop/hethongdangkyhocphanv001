package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspXemTKB_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
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
      out.write("                <li><a href=\"jspXemQuiDinh.jsp\">Qui định</a>                \n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspLienHe.jsp\">Liên Hệ</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>       \n");
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
      out.write("        <title>Thời Khóa Biểu</title>\n");
      out.write("        <style media=\"all\" type=\"text/css\">\n");
      out.write("            table{\n");
      out.write("                margin-left: 250px;\n");
      out.write("                margin-top:20px;\n");
      out.write("                padding: 10 10 10 10;\n");
      out.write("                background-color: #92C7C7;\n");
      out.write("                border: 3px solid #7F38EC;\n");
      out.write("            }\n");
      out.write("            table td{\n");
      out.write("                border: 1px solid #461B7E;\n");
      out.write("                background-color: #C8BBBE;\n");
      out.write("                padding: 5 10 5 10;\n");
      out.write("            }\n");
      out.write("            table a{\n");
      out.write("                background-color: \t#B93B8F;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>BẠN ĐANG Ở TRANG XEM THỜI KHÓA BIỂU!</h1><br/>\n");
      out.write("        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>\n");
      out.write("\n");
      out.write("        <br/><br/>\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 2</a></td></tr><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <tr><td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <tr><td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <tr><td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 3</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 4</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 5</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 6</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Thứ 7</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td><a href=\"#\">Chủ Nhật</a></td></tr><td></td><td></td><td></td><td></td><td></td><td></td>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 1</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>Mã môn 2</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td><td>...</td><td>Lập Trình Hướng Đối Tượng</td><td>P.202</td><td>Ca 1-2</td><td>Ts. Vũ Thanh Nguyên</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <br/><br/><br/><br/><br/><br/><br/><br/>\n");
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
