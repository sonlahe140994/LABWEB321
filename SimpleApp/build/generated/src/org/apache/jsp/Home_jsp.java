package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Author;
import dal.AuthorDAO;
import model.Card;
import java.util.ArrayList;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/body-home.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body style=\"margin: 0;padding: 0;\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div>\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("                <div class=\"body\">\r\n");
      out.write("                    <div class=\"notification\">\r\n");
      out.write("                        <p><span>Psst.</span> Don't forget to confirm your mail! Just look for the message we sent you.\r\n");
      out.write("                            <span>Resend Email</span> or <span>change your address</span></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"body-item\">\r\n");
      out.write("                        <div class=\"background-gallery-item\">\r\n");
      out.write("                            <div class=\"row-item\">\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    <div class=\"info-card\">\r\n");
      out.write("                                        <div class=\"invite-saving\">\r\n");
      out.write("                                            <p>Are your friends saving ideas you might like?</p>\r\n");
      out.write("                                            <div class=\"list-img-suggest\">\r\n");
      out.write("                                                <img src=\"img/limg1.jpg\" alt=\"\">\r\n");
      out.write("                                                <img src=\"img/limg2.jpg\" alt=\"\">\r\n");
      out.write("                                                <img src=\"img/limg3.jpg\" alt=\"\">\r\n");
      out.write("                                                <img src=\"img/limg4.jpg\" alt=\"\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"invite-bar\">\r\n");
      out.write("                                                <a href=\"#\">More ideas from friends</a>\r\n");
      out.write("                                                <div class=\"arrow\"></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"invite-bar\">\r\n");
      out.write("                                            <a href=\"#\">Invite friend to Pinterest</a>\r\n");
      out.write("                                            <div class=\"arrow\"></div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    ");

                                        if (request.getAttribute("lCard") != null) {
                                            AuthorDAO ad = new AuthorDAO();
                                            ArrayList<Card> listCard = (ArrayList<Card>) request.getAttribute("lCard");
                                            for (Card i : listCard) {
                                                Author au = ad.getAuthorById(i.getAuthorId());
                                    
      out.write("\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <div class=\"list-img-card\">\r\n");
      out.write("                                            <div class=\"save-button\">\r\n");
      out.write("                                                <div class=\"pin-save-icon\"></div>\r\n");
      out.write("                                                <span>Save</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <img class=\"list-img\" src=\"img/");
      out.print(i.getImgMain());
      out.write("\" alt=\"\">\r\n");
      out.write("                                            ");

                                                if (i.getExpandPin() != null) {
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"link-contact\">\r\n");
      out.write("                                                <a>\r\n");
      out.write("                                                    <div class=\"logo-contact\"></div>\r\n");
      out.write("                                                    <span class=\"contact-text\">Learn more at ");
      out.print(i.getExpandPin());
      out.write("</span>\r\n");
      out.write("                                                </a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");
} else {
      out.write("\r\n");
      out.write("                                            <div class=\"expand\"><a href=\"\">Expand Pin</a></div>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <article>\r\n");
      out.write("                                            ");

                                                if (i.getFromUrl() != null && i.getFromLogo() != null) {
                                            
      out.write("\r\n");
      out.write("                                            <aside>\r\n");
      out.write("                                                <img src=\"img/");
      out.print(i.getFromLogo());
      out.write("\" alt=\"\">\r\n");
      out.write("                                                <span>from ");
      out.print(i.getFromUrl());
      out.write("</span>\r\n");
      out.write("                                            </aside>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                            <title>");
      out.print(i.getTitle());
      out.write("</title>\r\n");
      out.write("             \r\n");
      out.write("                                            <p>");
      out.print(i.getDes());
      out.write("\r\n");
      out.write("                                            </p>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"repin\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">");
      out.print(i.getNumOfPin());
      out.write("</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"like-icon\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">");
      out.print(i.getNumOfLike());
      out.write("</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </article>\r\n");
      out.write("                                        <div class=\"credit-item\">\r\n");
      out.write("                                            <img src=\"img/au1.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"credit-infor\">\r\n");
      out.write("                                                <p class=\"credit-name\">");
      out.print(au.getAuthorName());
      out.write("</p>\r\n");
      out.write("                                                <p class=\"credit-type-img\">");
      out.print(au.getNameConcept());
      out.write("</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button class=\"credit-button\"></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"footer-card\">\r\n");
      out.write("                                            From Insects\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    ");
}
                                        }
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <div class=\"list-img-card\">\r\n");
      out.write("                                            <div class=\"save-button\">\r\n");
      out.write("                                                <div class=\"pin-save-icon\"></div>\r\n");
      out.write("                                                <span>Save</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <img class=\"list-img\" src=\"img/cardimg6.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"expand\"><a href=\"#\">Expand</a></div>\r\n");
      out.write("                                            <div class=\"link-contact\">\r\n");
      out.write("                                                <div class=\"logo-contact\"></div>\r\n");
      out.write("                                                <span class=\"contact-text\">Learn more at businessinsider.com</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <article>\r\n");
      out.write("                                            <aside>\r\n");
      out.write("                                                <img src=\"img/logo1.png\" alt=\"\">\r\n");
      out.write("                                                <span>from DC Database</span>\r\n");
      out.write("                                            </aside>\r\n");
      out.write("                                            <title>Superman/Wonder Woman Futures End Vol 1 1</title>\r\n");
      out.write("                                            <a href=\"\">#albertobokos</a>\r\n");
      out.write("                                            <p>Superman & Wonder Woman by Bart Sears\r\n");
      out.write("                                            </p>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"repin\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">624</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"like-icon\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">100</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </article>\r\n");
      out.write("                                        <div class=\"credit-item\">\r\n");
      out.write("                                            <img src=\"img/avt.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"credit-infor\">\r\n");
      out.write("                                                <p class=\"credit-name\">Sylvia Maurer</p>\r\n");
      out.write("                                                <p class=\"credit-type-img\">Insects</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button class=\"credit-button\"></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"footer-card\">\r\n");
      out.write("                                            From Insects\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <div class=\"list-img-card\">\r\n");
      out.write("                                            <div class=\"save-button\">\r\n");
      out.write("                                                <div class=\"pin-save-icon\"></div>\r\n");
      out.write("                                                <span>Save</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <img class=\"list-img\" src=\"img/cardimg6.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"expand\"><a href=\"#\">Expand</a></div>\r\n");
      out.write("                                            <div class=\"link-contact\">\r\n");
      out.write("                                                <div class=\"logo-contact\"></div>\r\n");
      out.write("                                                <span class=\"contact-text\">Learn more at businessinsider.com</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <article>\r\n");
      out.write("                                            <aside>\r\n");
      out.write("                                                <img src=\"img/logo1.png\" alt=\"\">\r\n");
      out.write("                                                <span>from DC Database</span>\r\n");
      out.write("                                            </aside>\r\n");
      out.write("                                            <title>Superman/Wonder Woman Futures End Vol 1 1</title>\r\n");
      out.write("                                            <a href=\"\">#albertobokos</a>\r\n");
      out.write("                                            <p>Superman & Wonder Woman by Bart Sears\r\n");
      out.write("                                            </p>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"repin\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">624</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"like-icon\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">100</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </article>\r\n");
      out.write("                                        <div class=\"credit-item\">\r\n");
      out.write("                                            <img src=\"img/avt.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"credit-infor\">\r\n");
      out.write("                                                <p class=\"credit-name\">Sylvia Maurer</p>\r\n");
      out.write("                                                <p class=\"credit-type-img\">Insects</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button class=\"credit-button\"></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"footer-card\">\r\n");
      out.write("                                            From Insects\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <div class=\"list-img-card\">\r\n");
      out.write("                                            <div class=\"save-button\">\r\n");
      out.write("                                                <div class=\"pin-save-icon\"></div>\r\n");
      out.write("                                                <span>Save</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <img class=\"list-img\" src=\"img/cardimg6.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"expand\"><a href=\"#\">Expand</a></div>\r\n");
      out.write("                                            <div class=\"link-contact\">\r\n");
      out.write("                                                <div class=\"logo-contact\"></div>\r\n");
      out.write("                                                <span class=\"contact-text\">Learn more at businessinsider.com</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <article>\r\n");
      out.write("                                            <aside>\r\n");
      out.write("                                                <img src=\"img/logo1.png\" alt=\"\">\r\n");
      out.write("                                                <span>from DC Database</span>\r\n");
      out.write("                                            </aside>\r\n");
      out.write("                                            <title>Superman/Wonder Woman Futures End Vol 1 1</title>\r\n");
      out.write("                                            <a href=\"\">#albertobokos</a>\r\n");
      out.write("                                            <p>Superman & Wonder Woman by Bart Sears\r\n");
      out.write("                                            </p>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"repin\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">624</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"like-icon\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">100</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </article>\r\n");
      out.write("                                        <div class=\"credit-item\">\r\n");
      out.write("                                            <img src=\"img/avt.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"credit-infor\">\r\n");
      out.write("                                                <p class=\"credit-name\">Sylvia Maurer</p>\r\n");
      out.write("                                                <p class=\"credit-type-img\">Insects</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button class=\"credit-button\"></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"footer-card\">\r\n");
      out.write("                                            From Insects\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"column-item\">\r\n");
      out.write("                                    <div class=\"card\">\r\n");
      out.write("                                        <div class=\"list-img-card\">\r\n");
      out.write("                                            <div class=\"save-button\">\r\n");
      out.write("                                                <div class=\"pin-save-icon\"></div>\r\n");
      out.write("                                                <span>Save</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <img class=\"list-img\" src=\"img/cardimg6.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"expand\"><a href=\"#\">Expand</a></div>\r\n");
      out.write("                                            <div class=\"link-contact\">\r\n");
      out.write("                                                <div class=\"logo-contact\"></div>\r\n");
      out.write("                                                <span class=\"contact-text\">Learn more at businessinsider.com</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <article>\r\n");
      out.write("                                            <aside>\r\n");
      out.write("                                                <img src=\"img/logo1.png\" alt=\"\">\r\n");
      out.write("                                                <span>from DC Database</span>\r\n");
      out.write("                                            </aside>\r\n");
      out.write("                                            <title>Superman/Wonder Woman Futures End Vol 1 1</title>\r\n");
      out.write("                                            <a href=\"\">#albertobokos</a>\r\n");
      out.write("                                            <p>Superman & Wonder Woman by Bart Sears\r\n");
      out.write("                                            </p>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"repin\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">624</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <i class=\"like-icon\"></i>\r\n");
      out.write("                                                <span class=\"social-meta-count\">100</span>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </article>\r\n");
      out.write("                                        <div class=\"credit-item\">\r\n");
      out.write("                                            <img src=\"img/avt.jpg\" alt=\"\">\r\n");
      out.write("                                            <div class=\"credit-infor\">\r\n");
      out.write("                                                <p class=\"credit-name\">Sylvia Maurer</p>\r\n");
      out.write("                                                <p class=\"credit-type-img\">Insects</p>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <button class=\"credit-button\"></button>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"footer-card\">\r\n");
      out.write("                                            From Insects\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <script src=\"js/credit.js\"></script>\r\n");
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
