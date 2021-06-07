package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Contact;

public final class Right_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Right</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Right.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"intro-product\" id=\"sci\">\r\n");
      out.write("            <div class=\"header-right\">\r\n");
      out.write("                <h4>Share this page</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");

                if (request.getAttribute("contact") != null) {
                    Contact ct = (Contact) request.getAttribute("contact");
            
      out.write("\r\n");
      out.write("            <div class=\"social\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <ul class=\"ulsocial\">\r\n");
      out.write("                        <li><img src=\"img/face.png\" alt=\"\"><a onclick=\"shareFb()\" href=\"#\">Share on Facebook</a></li>\r\n");
      out.write("                        <li><img src=\"img/twitter.png\" alt=\"\"><a href=\"#\">Share on Twitter</a></li>\r\n");
      out.write("                        <li><img src=\"img/google.png\" alt=\"\"><a href=\"#\">Share on Google+</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <script>\r\n");
      out.write("            window.fbAsyncInit = function () {\r\n");
      out.write("                FB.init({\r\n");
      out.write("                    appId: '464714577956097',\r\n");
      out.write("                    autoLogAppEvents: true,\r\n");
      out.write("                    xfbml: true,\r\n");
      out.write("                    version: 'v10.0'\r\n");
      out.write("                });\r\n");
      out.write("            };\r\n");
      out.write("            FB.getLoginStatus(function (response) {\r\n");
      out.write("                if (response.status === 'connected') {\r\n");
      out.write("                    alert('yes')\r\n");
      out.write("                    var uid = response.authResponse.userID;\r\n");
      out.write("                    var accessToken = response.authResponse.accessToken;\r\n");
      out.write("                } else if (response.status === 'not_authorized') {\r\n");
      out.write("                    alert('No');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <script async defer crossorigin=\"anonymous\" src=\"https://connect.facebook.net/en_US/sdk.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            function shareFb() {\r\n");
      out.write("                FB.ui({\r\n");
      out.write("                    method: 'share',\r\n");
      out.write("                    href: 'http://us-123photo.simplesite.com/'\r\n");
      out.write("                }, function (response) {\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
