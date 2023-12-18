package website_project_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import website_project_dao.UsersDAO;
import website_project_model.Users;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	//parameters
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDao = new UsersDAO();
	private Users user = new Users();
	
	
	//methods       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 
		//response.sendRedirect("/WEB-INF/views/login.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("urlAccess", false);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user.setUsername(username);
		user.setPassword(password);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getUsername());
		session.setAttribute("password", user.getPassword());
		
		boolean checkLogin = usersDao.authenticateLogin(user);
		
		if(checkLogin) {
			session.setAttribute("urlAccess", true);
			response.sendRedirect("/website_project/welcome");
			return;
			
		} else {
			String message = "Wrong username or password.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); //<p>${message}</p> in login.jsp;
			
		}
		
	}

}
