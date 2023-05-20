package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BookDAO;

import models.Book;


/**
 * Servlet implementation class AddBooksController
 */
@WebServlet("/add")
public class AddBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String date = request.getParameter("date");
		String genres = request.getParameter("genres");
		String characters = request.getParameter("characters");
		String synopsis = request.getParameter("synopsis");
		
		
		Book book = new Book(title, author, date, genres, characters, synopsis);
		BookDAO dao = new BookDAO();
		String strMessage ="";
		try {
			dao.insertBook(book);
			strMessage = "Book added successfully!";
//			System.out.println(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			PrintWriter out = response.getWriter();
			out.write("Book not added");
			strMessage = "Book not added, please try again :(";
			e.printStackTrace();
			
			
		}
		request.setAttribute("message", strMessage);
		RequestDispatcher rd = request.getRequestDispatcher("message.jsp");
		rd.include(request, response);
		//response.sendRedirect("books");
		
		//doGet(request, response);
	}

}
