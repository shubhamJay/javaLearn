package com.step;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class LoginManager extends HttpServlet {
  private HashSet<Person>

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if(request.getParameter("userId").equals("shubham") && request.getParameter("password").equals("shubham")){
      System.out.println(request.getParameter("userId"));
      response.addCookie(new Cookie("name","shubham"));
      response.sendRedirect("guestBook.jsp");
    }
  }
}
