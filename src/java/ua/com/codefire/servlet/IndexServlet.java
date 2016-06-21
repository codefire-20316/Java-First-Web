/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//https://www.google.com.ua/search?q=qwerqwe&spell=1&sa=X&ved=0ahUKEwjd3vPFy7nNAhXJjiwKHUw6CIIQvwUIGSgA&biw=1165&bih=1048
/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("Hello World!");
        String message = req.getParameter("msg");
        
        if (message == null || message.isEmpty()) {
            message = "Hello from servlet!";
        }
        
        req.setAttribute("message", message);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String fullname = req.getParameter("fullname");
        
        if (fullname != null && !fullname.isEmpty()) {
            req.getSession().setAttribute("fullname", fullname);
        }
        
        resp.sendRedirect(req.getContextPath().concat("/index"));
    }
}
