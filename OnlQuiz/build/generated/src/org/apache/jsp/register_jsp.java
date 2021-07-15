package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Permission;
import java.util.ArrayList;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/register.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("            <div class=\"body\">\r\n");
      out.write("                <h1>Registration Form</h1>\r\n");
      out.write("                <form action=\"RegisterServlet\" method=\"post\" class=\"f-login\">\r\n");
      out.write("                    <div class=\"input-area\">\r\n");
      out.write("                        <span>User Name: </span\r\n");
      out.write("                        ><input type=\"text\" name=\"user\" class=\"input-data\" required=\"true\"/><br />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-area\">\r\n");
      out.write("                        <span>Password: </span\r\n");
      out.write("                        ><input type=\"password\" name=\"pass\" class=\"input-data\" required=\"true\" /><br />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-area\">\r\n");
      out.write("                        <span>User Type: </span>\r\n");
      out.write("                        <select name=\"\" id=\"\" class=\"user-type\">\r\n");
      out.write("                            ");

                                if (request.getAttribute("listPer") != null) {
                                    ArrayList<Permission> listPer = (ArrayList<Permission>) request.getAttribute("listPer");
                                    for (Permission i : listPer) {
                            
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print(i.getId());
      out.write('"');
      out.write('>');
      out.print(i.getName());
      out.write("</option>\r\n");
      out.write("                            ");
}
                                }
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-area\">\r\n");
      out.write("                        <span>Email: </span>\r\n");
      out.write("                        <input type=\"text\" class=\"input-data email-input\" required=\"true\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"input-area\">\r\n");
      out.write("                        <input type=\"submit\" value=\"Sign in\" class=\"res-btn\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
