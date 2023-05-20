package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class DeleteBooksController
 */
@WebServlet("/delete")
public class DeleteBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		//System.out.println(id);
		BookDAO dao = new BookDAO();
		Book b = new Book();
		b.setId(id);
//		
		PrintWriter out = response.getWriter();
		String strMessage="";
		try {
			dao.deleteBook(b);
			response.sendRedirect("books");
			out.write("book deleted");
			strMessage="book deleted successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			strMessage="book not deleted, please try again :(";
			e.printStackTrace();
		}
		request.setAttribute("message", strMessage);
		RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
	}

}
