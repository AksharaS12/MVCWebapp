package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.BookDAO;
import models.Book;


/**
 * Servlet implementation class BooksController
 */
@WebServlet("/books")
public class BooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int pageId = Integer.parseInt(request.getParameter("page"));
//		int total = 256;
//		if(pageId == 1) {}
//		else {
//			pageId = pageId-1;
//			pageId = pageId * total +1;
//		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BookDAO dao = new BookDAO();
		
		//call getAllBooks (in DAO) to get all the books listed in database(table) and store it in an ArrayList named "allBooks"
		ArrayList<Book> allBooks = dao.getAllBooks();
		
		//to pass data (object) from servlet to jsp page, where it can be accessed using attribute name "books".
		request.setAttribute("books", allBooks);
		
		//request to be dispatched to books.jsp page 
		RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
		
		// to include content of resource (servlet) in response
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
