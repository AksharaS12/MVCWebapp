package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;

import models.Book;



/**
 * Servlet implementation class EditBooksController
 */
@WebServlet("/edit")
public class EditBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO dao = new BookDAO();
		
		Book b = dao.getBookByID(id);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("updateBook.jsp");
		request.setAttribute("books", b);
		reqDispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id" + id);
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");
		BookDAO dao = new BookDAO();
		
		Book b = new Book(title, author, date, genres, characters, synopsis);
		b.setId(id);
		System.out.println(b.getId());
		String strMessage="";
		try {
			dao.updateBook(b);
			strMessage = "Book updated successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			strMessage = "Book not updated, please try again :(";
			e.printStackTrace();
		}
		request.setAttribute("message", strMessage);
		RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
		rd.include(request, response);
//		response.sendRedirect("books");
	}

}
