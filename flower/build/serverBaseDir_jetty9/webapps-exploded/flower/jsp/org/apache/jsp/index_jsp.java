package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>folwer Catalog</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    const hideVessel = function() {\n");
      out.write("      let vessel = document.getElementById(\"waterVessel\");\n");
      out.write("      vessel.style.visibility = \"hidden\";\n");
      out.write("      setTimeout(() => vessel.style.visibility = \"visible\", 1000);\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    const parsekeyVal = function(text){\n");
      out.write("      return text.split(\";\").reduce((parsedKeyVals,ele)=>{\n");
      out.write("        let keyValPairs = ele.trim().split('=');\n");
      out.write("        parsedKeyVals[keyValPairs[0]] = keyValPairs[1];\n");
      out.write("        return parsedKeyVals;\n");
      out.write("      },{});\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    const showLogOutDiaolg = function(){\n");
      out.write("      let logOutBox = document.getElementById(\"logOutBox\");\n");
      out.write("      logOutBox.style.visibility = \"visible\";\n");
      out.write("    };\n");
      out.write("    const hideLogInDialog = function(){\n");
      out.write("      let logInBox = document.getElementById(\"logInBox\");\n");
      out.write("      logInBox.style.visibility = \"hidden\";\n");
      out.write("    };\n");
      out.write("    const actionOnLogIn = function(){\n");
      out.write("      let cookies = parsekeyVal(document.cookie);\n");
      out.write("      if(+cookies.logInStatus){\n");
      out.write("        showLogOutDiaolg();\n");
      out.write("        hideLogInDialog();\n");
      out.write("      };\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"actionOnLogIn()\">\n");
      out.write("  <h1 id=\"subHeading\">Flower Catalog</h1>\n");
      out.write("  <img id=\"flowerImage\" src=\"img/freshorigins.jpg\">\n");
      out.write("  <form action=\"logIn\" method=\"POST\" id=\"logInBox\" class=\"dialogBox\">\n");
      out.write("    <h3>Log In</h3>\n");
      out.write("    User Id : <input type=\"text\" name=\"userId\"><br><br>\n");
      out.write("    Password : <input type=\"password\" name=\"password\"><br><br>\n");
      out.write("    <button >LogIn</button>\n");
      out.write("  </form>\n");
      out.write("  <form id=\"logOutBox\" action=\"logOut\" method=\"post\" class=\"dialogBox\">\n");
      out.write("    <button>logOut</button>\n");
      out.write("  </form>\n");
      out.write("  <div id=\"catalogOptions\">\n");
      out.write("    <li>\n");
      out.write("      <a href=\"abeliophyllum.jsp\">Abeliophyllum</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("      <a href=\"agerantum.jsp\">Agerantum</a>\n");
      out.write("    </li>\n");
      out.write("    <a href=\"guestBook.jsp\">Guest Book</a>\n");
      out.write("    <img id=\"waterVessel\" src=\"img/wateringVessel.gif\" onclick=\"hideVessel()\">\n");
      out.write("  </div>\n");
      out.write("</body>\n");
      out.write("\n");
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
