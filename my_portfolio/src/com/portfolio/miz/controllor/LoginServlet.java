package com.portfolio.miz.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
           // 変数の初期設定
        String status = "ログインに失敗しました";
        String name = null;

        request.setCharacterEncoding("UTF-8");
        String id =request.getParameter("id");
        String pass = request.getParameter("pass");

        if(id.equals("test") && pass.equals("xxxx")) {
            status = "ログイン成功";
            name = "ぽん";

            request.setAttribute("login", status);

            HttpSession session = request.getSession(true);
            session.setAttribute("name", name);

            request.getRequestDispatcher("/TopView.jsp").forward(request, response);
        }else {

        request.setAttribute("login", status);

        request.getRequestDispatcher("/LoginFailed.jsp").forward(request, response);
        }
    }

}
