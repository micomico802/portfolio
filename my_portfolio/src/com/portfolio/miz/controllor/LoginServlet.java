package com.portfolio.miz.controllor;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.miz.model.DBConnector;
import com.portfolio.miz.model.users.dao.UsersDao;
import com.portfolio.miz.model.users.dao.UsersDaoImpl;
import com.portfolio.miz.model.users.entity.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("user_id");
        String password = request.getParameter("password");

        DBConnector connector = new DBConnector();
        Connection conn = connector.connect();
        UsersDao dao = new UsersDaoImpl(conn);
        Users users = dao.fetch(userId, password);

        if (users.getLoginAddress() != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("login_info", users);

            request.getRequestDispatcher("/WorkChoiceView.jsp").forward(request, response);

        } else {

            request.getRequestDispatcher("/LoginFailed.jsp").forward(request, response);
        }
    }

}
