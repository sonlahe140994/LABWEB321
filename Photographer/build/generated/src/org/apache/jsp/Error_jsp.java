package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Contact</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Header.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/HomePage.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Right.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/contact.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"https://www.google.com/jsapi?callback=gloader_ready\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body style=\"padding-left: 100px;padding-right: 100px;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"main\">\n");
      out.write("                <!--top-->\n");
      out.write("                <div class=\"top\">\n");
      out.write("                    <div class=\"nav\">\n");
      out.write("                        <div class=\"nav-inner\">\n");
      out.write("                            <ul>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"\">My Font Page</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"\">Gallery 1</a></li>\n");
      out.write("                                <li><a href=\"\">Gallery 2</a></li>\n");
      out.write("                                <li><a href=\"\">Contact</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header\">\n");
      out.write("                        <div class=\"image\">\n");
      out.write("                            <img src=\"img/logo.png\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"title\">\n");
      out.write("                            <p class=\"patitle\">PHOTOGRAPHER</p>\n");
      out.write("                            <p class=\"subtitle\">Welcome to this website</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--Body-->\n");
      out.write("                <div class=\"body-page\">\n");
      out.write("                    <div class=\"body-1\">\n");
      out.write("                        <h1>Error</h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--Footer-->\n");
      out.write("                <div class=\"footer\">\n");
      out.write("                    <div class=\"link-number\">\n");
      out.write("                        <a href=\"\">Created with SimpleSite</a>\n");
      out.write("                        <span class=\"footer-page-counter-item\">8</span>\n");
      out.write("                        <span class=\"footer-page-counter-item\">3</span>\n");
      out.write("                        <span class=\"footer-page-counter-item\">1</span>\n");
      out.write("                        <span class=\"footer-page-counter-item\">9</span>\n");
      out.write("                        <span class=\"footer-page-counter-item\">9</span>\n");
      out.write("                        <span class=\"footer-page-counter-item\">7</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/contact.js\"></script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
