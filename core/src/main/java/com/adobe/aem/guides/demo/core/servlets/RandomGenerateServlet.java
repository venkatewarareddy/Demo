package com.adobe.aem.guides.demo.core.servlets;

import com.day.cq.wcm.api.WCMMode;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Random;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Random Generator Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/random-generator"
})
public class RandomGenerateServlet extends SlingAllMethodsServlet {

    private static final Random RANDOM = new Random();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("text/plain");

        String parameter = request.getParameter("type");
        if (parameter == null) {
            response.getWriter().write("Please provide a valid parameter: Number, Letters, or Random.");
            return;
        }

        switch (parameter.toLowerCase()) {
            case "number":
                response.getWriter().write(generateRandomNumbers(6));
                break;
            case "letters":
                response.getWriter().write(generateRandomLetters(6));
                break;
            case "random":
                response.getWriter().write(generateRandomAlphanumeric(6));
                break;
            default:
                response.getWriter().write("Invalid parameter. Use 'Number', 'Letters', or 'Random'.");
                break;
        }
    }

    private String generateRandomNumbers(int count) {
        StringBuilder numbers = new StringBuilder();
        for (int i = 0; i < count; i++) {
            numbers.append(RANDOM.nextInt(10)); // Generate a digit between 0-9
        }
        return numbers.toString();
    }

    private String generateRandomLetters(int count) {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char letter = (char) (RANDOM.nextInt(26) + 'A'); // Generate a letter between A-Z
            letters.append(letter);
        }
        return letters.toString();
    }

    private String generateRandomAlphanumeric(int totalCount) {
        int numCount = totalCount / 2;
        int letterCount = totalCount - numCount;
        return generateRandomNumbers(numCount) + generateRandomLetters(letterCount);
    }
}
