package servlets;


import alg.LetterFrequency;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LetterFrequencyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        String inputText = request.getParameter("inputText");

        System.out.println("TEXT:" + inputText);

        LetterFrequency letterFrequency = new LetterFrequency(inputText);
        JSONObject jsonInputText = letterFrequency.getFrequencyText();
        JSONObject jsonRotate13 = letterFrequency.getFrequencyRotatedText();

        // test json
        System.out.println("JSON object content: for input text:\n" + jsonInputText);
        System.out.println("JSON object content for rotated text:" + jsonRotate13);

        JSONObject responseJSON = new JSONObject();
        responseJSON.put("input", inputText);
        responseJSON.put("freq_bef", jsonInputText);
        responseJSON.put("rot13", jsonRotate13);

        System.out.println("\nFinal json:\n" + responseJSON);

        response.setContentType("application/json");
        response.getWriter().print(responseJSON);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}