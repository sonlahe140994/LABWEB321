package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class takequiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <title>Take Quiz</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/takequiz.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("            <div class=\"body\">\r\n");
      out.write("                <div class=\"welcome\">\r\n");
      out.write("                    <p>Welcome <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.a.getUserName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"enter\">\r\n");
      out.write("                    <h1>Enter number of Questions:</h1>\r\n");
      out.write("                    <div><input type=\"text\" id=\"numOfQues\" value=\"12\"></div>\r\n");
      out.write("                    <button id=\"start-btn\">Start</button>\r\n");
      out.write("                    <script>\r\n");
      out.write("                        var button = document.querySelector('button');\r\n");
      out.write("                        button.onclick = function () {\r\n");
      out.write("                            alert(\"hello\");\r\n");
      out.write("                        };\r\n");
      out.write("                    </script>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"quiz\">\r\n");
      out.write("                    <div class=\"time\">Time remaining <span>10:03</span></div>\r\n");
      out.write("                    <div class=\"list-ques\">\r\n");
      out.write("                        <div class=\"ques\">\r\n");
      out.write("                            <h2>The name of capital of VietNam after year of 1975?</h2>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ha Noi</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ho Chi Minh</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"ques\">\r\n");
      out.write("                            <h2>The name of capital of VietNam after year of 1975?</h2>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ha Noi</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ho Chi Minh</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"ques\">\r\n");
      out.write("                            <h2>The name of capital of VietNam after year of 1975?</h2>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ha Noi</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ho Chi Minh</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"ques\">\r\n");
      out.write("                            <h2>The name of capital of VietNam after year of 1975?</h2>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ha Noi</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ho Chi Minh</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"ques\">\r\n");
      out.write("                            <h2>The name of capital of VietNam after year of 1975?</h2>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ha Noi</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Ho Chi Minh</div></li>\r\n");
      out.write("                                <li><div class=\"ans\"><input type=\"checkbox\">Sai Gon</div></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"btn-next\"><input type=\"button\" value=\"Next\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"result\">\r\n");
      out.write("                    <div class=\"score\"><p>Your score <span>7.5</span> <span>(75%)</span> <span>- Passed</span></p></div>\r\n");
      out.write("                    <div class=\"score\">Take another test <button>Start</button></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/takequiz.js\"></script>\r\n");
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
