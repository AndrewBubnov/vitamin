package servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/reverse")
public class myFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("one");
        resp.getWriter().write("<html>" +
                "<head></head><body>" +
                "Reversed string is: " + ((req.getParameter("one") == null) ? "" : reverseString(s)) +
                "<form action='/reverse' method='get'>" +
                "<p><b>Enter the string here:</b></p>" +
                "<p><textarea rows='3' cols='45' name='one'></textarea></p>" +
                "<p><input type='submit' value='Reverse'></p>" +
                "</form>" +
                "</body></html>");
    }

    private String reverseString(String s) {
        String[] array = s.split(" +");
        String out = "";
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder(array[i]).reverse();
            out = out + sb.toString() + " ";
        }
        return out;
    }
}
