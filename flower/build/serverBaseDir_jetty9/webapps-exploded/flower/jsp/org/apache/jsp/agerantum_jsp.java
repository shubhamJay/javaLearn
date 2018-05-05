package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agerantum_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Agerantum</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"headings\">\n");
      out.write("      <h1 id=\"flowerHeading\"><a href=\"index.jsp\"> << </a> Agerantum</h1>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("      <img src=\"img/agerantum.jpg\" id=\"agerantumImage\">\n");
      out.write("    </div>\n");
      out.write("    <div id=\"flowerInfo\">\n");
      out.write("    <p >\n");
      out.write("      <b>Ageratum</b> (/ÉËdÊÉrÉtÉm/),[2] (<b>whiteweed </b>in the USA), is a genus of 40[3] to 60\n");
      out.write("      tropical and warm temperate flow- ering annuals and perennials from the family\n");
      out.write("      Asteraceae, tribe Eupatorieae. Most species are native to Central America and\n");
      out.write("       Mexico but four are native to the United States.\n");
      out.write("    </p>\n");
      out.write("    They form tussocks or small hills. They grow to a height of 30 in. The opposite\n");
      out.write("     leaves are cordate or oval, hairy or tomentose. The margins are ssolidly toothed\n");
      out.write("      or serrate. The leaves form compact clusters.\n");
      out.write("      <p>\n");
      out.write("        The fluffy flowers are lavender-blue, pink, lilac, or white; and spread\n");
      out.write("         in small compound umbels. They give small, dry fruits.\n");
      out.write("     </p>\n");
      out.write("\n");
      out.write("    </p>\n");
      out.write("    </div>\n");
      out.write("    <a href=\"pdf/agerantum.pdf\" download>Download as Book</a>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
