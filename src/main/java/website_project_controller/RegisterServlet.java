package website_project_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import website_project_dao.UsersDAO;
//import website_project_model.Users;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private UsersDAO usersDao = new UsersDAO();
	//private Users user = new Users();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Redirected to User Registration Page :)");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		user.setUsername(username);
		user.setPassword(password);
		
		//For easier debugging
		System.out.println(user.getUsername() + " " + user.getPassword());
		
		boolean checkRegister = usersDao.registerUser(user);
		
		if(checkRegister) {			
			//request.getRequestDispatcher("/welcome").forward(request, response);
			response.sendRedirect("/website_project/welcome");
			return;
			
		} else {
			String message = "User already exists.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response); //<p>${message}</p> in register.jsp;
		}*/
	}

}
