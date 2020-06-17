package com.portfolio.miz.controllor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolio.miz.model.ItemBeans;
import com.portfolio.miz.model.ItemDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/ItemsSearcherServlet")
public class ItemsSearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<ItemBeans> list = new ArrayList<ItemBeans>();
    private ServletContext context;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsSearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
        context = getServletContext();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");

		try {
		    ItemBeans itemBeans = new ItemBeans(request);
 
		    ItemDao dao = new ItemDao();
		    list = dao.fetch(itemBeans);


		    request.setAttribute("result", list);

//		    HttpSession session = request.getSession();
//		    session.setAttribute("result", list);

		    request.getRequestDispatcher("/SearchResult.jsp").forward(request, response);

		}catch(Exception e){
            e.printStackTrace();

//            String status ="検索に失敗しました。管理者に連絡してください。";
//          request.setAttribute("status", status);
//          request.getRequestDispatcher("/result.jsp").forward(request, response);

		}
	}

}