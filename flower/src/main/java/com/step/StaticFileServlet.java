package com.step;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StaticFileServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(req.getRequestURL());
    String filePath = "/Users/shubhaj/IdeaProjects/flower/src/main/webapp/"+req.getRequestURL();
    if (Files.exists(Paths.get(filePath))) {
      List<String> content = Files.readAllLines(Paths.get(filePath));
      String guestBookPage = String.join(" ", content);
      resp.getWriter().write(guestBookPage);
    }
  }
}
