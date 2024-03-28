package br.com.joaogabriel.bookstore.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.joaogabriel.bookstore.entity.User;
import br.com.joaogabriel.bookstore.enumerations.Role;
import br.com.joaogabriel.bookstore.service.UserService;
import br.com.joaogabriel.bookstore.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserService userService;

    public ListUserServlet() {
      this.userService = new UserServiceImpl();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = this.userService.findAll();
		
		User user = new User("João Gabriel", "27.joaogabriel@gmail.com", "joao", "123456789", "14 998045007", Role.ROLE_ADMIN);
		user.setId(UUID.randomUUID());
		users.add(user);
		
		request.setAttribute("users", users);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("user_list.jsp");
		requestDispatcher.forward(request, response);
	}

}
