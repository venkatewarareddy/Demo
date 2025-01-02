 package com.adobe.aem.guides.demo.core.servlets;
 import org.apache.sling.api.SlingHttpServletRequest;
 import org.apache.sling.api.SlingHttpServletResponse;
 import org.apache.sling.api.resource.ModifiableValueMap;
 import org.apache.sling.api.resource.PersistenceException;
 import org.apache.sling.api.resource.Resource;
 import org.apache.sling.api.servlets.SlingAllMethodsServlet;
 import org.osgi.service.component.annotations.Component;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 import javax.servlet.Servlet;
 import javax.servlet.ServletException;
 import java.io.IOException;

 @Component(
         service = Servlet.class,
         property = {
                 "sling.servlet.paths=/bin/saveSingleArticle",
                 "sling.servlet.methods=GET"
         }
 )
 public class SaveSingleArticleServlet extends SlingAllMethodsServlet {

     private static final Logger LOG = LoggerFactory.getLogger(SaveSingleArticleServlet.class);

     @Override
 protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
     // Get parameters from request
     String pagePath = request.getParameter("pagePath");  // Get pagePath
     String enablePiiParam = request.getParameter("enablePii");
     String cssClass = request.getParameter("cssClass");

     // Validate parameters
     if (pagePath == null || enablePiiParam == null || cssClass == null) {
         LOG.error("Missing parameters. pagePath={}, enablePii={}, cssClass={}", pagePath, enablePiiParam, cssClass);
         response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
         response.getWriter().write("Missing parameters: pagePath, enablePii or cssClass");
         return;
     }

     // Parse the boolean value for enablePii
     boolean enablePii = Boolean.parseBoolean(enablePiiParam);

     LOG.info("Received parameters: pagePath={}, enablePii={}, cssClass={}", pagePath, enablePii, cssClass);

     // Your logic to save the properties to the page resource...
     // Example: Updating the page's jcr:content node

     try {
         // Get the resource for the page
         Resource pageResource = request.getResourceResolver().getResource(pagePath);
         if (pageResource != null) {
             Resource jcrContentResource = pageResource.getChild("jcr:content");
             if (jcrContentResource != null) {
                 // Save the properties
                 ModifiableValueMap properties = jcrContentResource.adaptTo(ModifiableValueMap.class);
                 if (properties != null) {
                     properties.put("enablePii", enablePii);
                     properties.put("cssClass", cssClass);

                     // Commit the changes
                     request.getResourceResolver().commit();
                     response.setStatus(SlingHttpServletResponse.SC_OK);
                     response.getWriter().write("Page properties updated successfully");
                 }
             } else {
                 LOG.error("jcr:content node not found for page: {}", pagePath);
                 response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
                 response.getWriter().write("jcr:content node not found");
             }
         } else {
             LOG.error("Page not found: {}", pagePath);
             response.setStatus(SlingHttpServletResponse.SC_NOT_FOUND);
             response.getWriter().write("Page not found");
         }
     } catch (PersistenceException e) {
         LOG.error("Error saving properties", e);
         response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
         response.getWriter().write("Error saving properties");
     }
 }

 }
