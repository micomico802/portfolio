package com.portfolio.miz.controllor;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.miz.model.DBConnector;
import com.portfolio.miz.model.ItemDao;
import com.portfolio.miz.model.Items;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");

        String mode = request.getParameter("mode");
	    String status = "処理に成功しました";

	    Items beans = new Items(request);

	    try{
	        DBConnector connector = new DBConnector();
	        Connection conn = connector.connect();
	        ItemDao dao = new ItemDao(conn);

	        switch (mode) {

	        case "insert":
	            int resultInsertCounter = dao.doInsert(beans);
                if(resultInsertCounter == 0) {
                      status = "処理に失敗しました";
                    }
                break;

	        case "delete":
	            int resultDeleteCounter = dao.doDelete(beans.getItemId());
	            if(resultDeleteCounter == 0) {
	                  status = "処理に失敗しました";
	                }
	            break;

	        case "setUpdate":
	            request.setAttribute("beans", beans);
	            request.getRequestDispatcher("/EditInput.jsp").forward(request, response);
	            return;


	        case "doUpdate":
	        int resultUpdateCounter = dao.doUpdate(beans);
            if(resultUpdateCounter == 0) {
                  status = "処理に失敗しました";
                }
            break;
	        }
	        // DBの切断
	        connector.destory(conn);
	    }catch(Exception e) {
	          e.printStackTrace();
	      }

	    request.setAttribute("resultMessage", status);
	    request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

	   /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

}
