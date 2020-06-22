package com.portfolio.miz.controllor;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.miz.model.DBConnector;
import com.portfolio.miz.model.users.dao.UsersDao;
import com.portfolio.miz.model.users.dao.UsersDaoImpl;
import com.portfolio.miz.model.users.entity.Users;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");

	    DBConnector connector = new DBConnector();
	    Connection conn = connector.connect();
	    Users users = new Users(request);
	    UsersDao dao = new UsersDaoImpl(conn);

	    List<String> resultMessages = new ArrayList<>();
	    resultMessages.add("登録に失敗しました");

	    if(dao.registrationCheck(users)) {
	        if(dao.doInsert(users)) {
	            String resultMessage = "登録に成功しました";
	            request.setAttribute("resultMessage", resultMessage);
//	            HttpSession session = request.getSession();
//	            session.setAttribute("registerUserInfo", users);
	            request.getRequestDispatcher("/RegisterResult.jsp").forward(request, response);
	            connector.destory(conn);
	            return;
	        }

	        resultMessages.add("再度ログイン情報を確認してください");
	    }else {
	        resultMessages.add("既にこのメールアドレスは登録があります");
	    }

	    connector.destory(conn);
	    request.setAttribute("messages", resultMessages);
	    request.getRequestDispatcher("/LoginFailed.jsp").forward(request, response);
	}

}
