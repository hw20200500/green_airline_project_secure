package com.green.airline.handler.exception;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ErrorReportValve;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;

public class CustomErrorReportValve extends ErrorReportValve {

    @Override
    protected void report(Request request, Response response, Throwable throwable) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the HTTP status is 400
        if (httpResponse.getStatus() == HttpServletResponse.SC_BAD_REQUEST) {
            try {
                System.out.println("CustomErrorReportValve: Handling 400 error for URI: " + request.getRequestURI());

                // Set the HTTP status code and content type
                httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                System.out.println("1");
                httpResponse.setContentType("text/html; charset=UTF-8");
                System.out.println("2");
                // Define the path to the JSP file to be rendered
                // Write the error page content directly
                StringBuilder errorPageContent = new StringBuilder();
                errorPageContent.append("<html>");
                errorPageContent.append("<head><title>Bad Request</title></head>");
                errorPageContent.append("<body>");
                errorPageContent.append("<h1>Bad Request</h1>");
                errorPageContent.append("<p>Your request could not be understood by the server.</p>");
                errorPageContent.append("</body>");
                errorPageContent.append("</html>");

                // Write the content to the response
                httpResponse.getWriter().write(errorPageContent.toString());
                httpResponse.getWriter().flush();

                System.out.println("Custom 400 error page rendered successfully for URI: " + request.getRequestURI());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Call the default error reporting method for other errors
            super.report(request, response, throwable);
        }
    }
}
