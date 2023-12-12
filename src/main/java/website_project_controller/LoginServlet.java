package website_project_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.getRequestDispatcher("/WEB-INF/views/loginPage.jsp").forward(request, response); 
		//response.sendRedirect("/WEB-INF/views/loginPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		
		System.out.println(user.getUsername() + " " + user.getPassword());
		
		boolean check = usersDao.authenticateLogin(user);
		
		if(check) {			
			//request.getRequestDispatcher("/welcome").forward(request, response);
			response.sendRedirect("/website_project/welcome");
			return;
			
		} else {
			String message = "Wrong username or password.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/loginPage.jsp").forward(request, response); //<p>${message}</p> in loginPage.jsp;
			
		}
		
	}

}
