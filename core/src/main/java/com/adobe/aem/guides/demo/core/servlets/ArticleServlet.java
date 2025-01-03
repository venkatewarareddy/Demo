package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class,immediate = true,enabled = true)
//@SlingServletPaths(value = "/bin/venkat/article")
@SlingServletResourceTypes(resourceTypes="demo/venkat/articleservlet")
public class ArticleServlet extends SlingAllMethodsServlet{

  @Override
  protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
      throws ServletException, IOException {
        response.getWriter().write("Response data from ArticleServlet ResourceType---Get");
  }
  @Override
  protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().write("Response data from ArticleServlet ResourceType---Post");
  }
  @Override
  protected void doPut(SlingHttpServletRequest request, SlingHttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().write("Response data from ArticleServlet ResourceType---Put");
  }
  @Override
  protected void doDelete(SlingHttpServletRequest request, SlingHttpServletResponse response)
      throws ServletException, IOException {
    response.getWriter().write("Response data from ArticleServlet ResourceType---Delete");
  }

}
