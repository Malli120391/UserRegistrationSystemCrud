package com.javacodes.usersystem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacodes.usersystem.bean.User;
import com.javacodes.usersystem.dao.UserDao;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		
		userDao = new UserDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String action = request.getServletPath();
	     
		 switch (action) {
		  case "/newuser":
			  shownewform(request, response);
			break;
			
		  case "/insertuser":
			  insertUser(request, response);
				break;
				
		  case "/deleteuser":
			  deleteUser(request, response);
				break;
				
		  case "/edituser":
			  showEditForm(request, response);
				break;
				
		  case "/updateuser":
			  updateUser(request, response);
				break;
				
				default:
			try {
				listUser(request, response);
			} catch (SQLException | ServletException | IOException e) {
				
				e.printStackTrace();
			}
					break;
		}
	}
	
	private void shownewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
		 
		 dispatcher.forward(request, response);
		
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		String phoneNo = request.getParameter("phoneNo");
		User newUser = new User(name,email,country,state,city,pincode,phoneNo);
		
		userDao.insertUser(newUser);
		response.sendRedirect("list");
		
		
	}

	  private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	  {
		  int id = Integer.parseInt(request.getParameter("id"));
		  try {
			userDao.deleteUser(id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  response.sendRedirect("list");
		  
	  }
	  
	  private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	  {
		  int id = Integer.parseInt(request.getParameter("id"));
		 
		  User existingUser;
		  try {
		  existingUser = userDao.selectUser(id);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
		  request.setAttribute("user", existingUser);
		  
		  dispatcher.forward(request, response);
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  
	  }
	  
	  private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
		  int id = Integer.parseInt(request.getParameter("id"));
		  
		    String name = request.getParameter("name");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String phoneNo = request.getParameter("phoneNo");
			
			User user = new User(id,name,email,country,state,city,pincode,phoneNo);
			try {
				userDao.updateUser(user);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			response.sendRedirect("list");
		  
	  }
	  
	  private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	  {
		  try {
		  List<User> listUser = userDao.selectAllUsers();
		  request.setAttribute("listUser", listUser);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("userlist.jsp");
		  dispatcher.forward(request, response);
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  
	  }
	  
	  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}