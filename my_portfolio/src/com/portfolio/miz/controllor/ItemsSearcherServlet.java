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
import com.portfolio.miz.model.Items;
import com.portfolio.miz.model.ItemsDao;
import com.portfolio.miz.model.ItemsDaoImpl;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/ItemsSearcherServlet")
public class ItemsSearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<Items> list = new ArrayList<Items>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsSearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");

		    Items itemBeans = new Items(request);
		    DBConnector connector = new DBConnector();
            Connection conn = connector.connect();
		    ItemsDao dao = new ItemsDaoImpl(conn);
		    list = dao.fetch(itemBeans);
		 // DBの切断
            connector.destory(conn);

		    request.setAttribute("result", list);

//		    HttpSession session = request.getSession();
//		    session.setAttribute("result", list);

		    request.getRequestDispatcher("/SearchResult.jsp").forward(request, response);

		}
	}

}
