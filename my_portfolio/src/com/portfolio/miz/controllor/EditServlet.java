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
import com.portfolio.miz.model.Items;
import com.portfolio.miz.model.ItemsDao;
import com.portfolio.miz.model.ItemsDaoImpl;
import com.portfolio.miz.model.users.entity.Users;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Users userSession = (Users) session.getAttribute("login_info");
        if (userSession == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        String mode = request.getParameter("mode");
        String status = "処理に失敗しました";

        Items beans = new Items(request);

        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.connect();
            ItemsDao dao = new ItemsDaoImpl(conn);

            switch (mode) {

            case "insert":
                boolean isInsertResult = dao.doInsert(beans);
                if (isInsertResult) {
                    status = "処理に成功しました";
                }
                break;

            case "delete":
                boolean isDeleteResult = dao.doDelete(beans.getItemId());
                if (isDeleteResult) {
                    status = "処理に成功しました";
                }
                break;

	}

            case "doUpdate":
                boolean isUpdateResult = dao.doUpdate(beans);
                if (isUpdateResult) {
                    status = "処理に成功しました";
                }
                break;
            }
            // DBの切断
            connector.destory(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("resultMessage", status);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

}
