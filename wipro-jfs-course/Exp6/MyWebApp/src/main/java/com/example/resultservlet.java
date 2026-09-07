package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String regno = request.getParameter("regno");
        String name = request.getParameter("name");
        String department = request.getParameter("department");

        String[] markValues = request.getParameterValues("marks");

        int total = 0;
        boolean subjectPass = true;

        int[] marks = new int[5];

        for (int i = 0; i < 5; i++) {
            marks[i] = Integer.parseInt(markValues[i]);
            total = total + marks[i];

            if (marks[i] < 40) {
                subjectPass = false;
            }
        }

        double average = total / 5.0;

        double attendance =
                Double.parseDouble(request.getParameter("attendance"));

        boolean eligible = attendance >= 75;

        String grade;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";

        String result;

        if (subjectPass && average >= 40 && eligible)
            result = "PASS";
        else
            result = "FAIL";

        out.println("<html>");
        out.println("<head><title>Examination Result</title></head>");
        out.println("<body>");

        out.println("<h2>Student Examination Result</h2>");

        out.println("<table border='1' cellpadding='10'>");

        out.println("<tr><th>Register Number</th><td>"
                + regno + "</td></tr>");

        out.println("<tr><th>Student Name</th><td>"
                + name + "</td></tr>");

        out.println("<tr><th>Department</th><td>"
                + department + "</td></tr>");

        for (int i = 0; i < 5; i++) {
            out.println("<tr><th>Subject " + (i + 1)
                    + "</th><td>" + marks[i] + "</td></tr>");
        }

        out.println("<tr><th>Total</th><td>"
                + total + "</td></tr>");

        out.println("<tr><th>Average</th><td>"
                + average + "</td></tr>");

        out.println("<tr><th>Attendance</th><td>"
                + attendance + "%</td></tr>");

        out.println("<tr><th>Eligibility</th><td>"
                + (eligible ? "Eligible" : "Not Eligible")
                + "</td></tr>");

        out.println("<tr><th>Grade</th><td>"
                + grade + "</td></tr>");

        out.println("<tr><th>Result</th><td>"
                + result + "</td></tr>");

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}