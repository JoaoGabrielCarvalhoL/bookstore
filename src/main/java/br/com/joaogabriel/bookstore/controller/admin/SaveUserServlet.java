package br.com.joaogabriel.bookstore.controller.admin;

import java.io.IOException;

import br.com.joaogabriel.bookstore.entity.Address;
import br.com.joaogabriel.bookstore.entity.User;
import br.com.joaogabriel.bookstore.entity.UserInformations;
import br.com.joaogabriel.bookstore.enumerations.AddressType;
import br.com.joaogabriel.bookstore.enumerations.Role;
import br.com.joaogabriel.bookstore.service.UserService;
import br.com.joaogabriel.bookstore.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserService userService;

    public SaveUserServlet() {
        this.userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = populateFromUserFormRequest(request);
		this.userService.save(user);
		response.sendRedirect(request.getContextPath() + "/admin/ListUserServlet");
		
	}
	
	private User populateFromUserFormRequest(HttpServletRequest httpServletRequest) {
		String name = httpServletRequest.getParameter("name");
		String email = httpServletRequest.getParameter("email");
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		Role role = Role.valueOf(httpServletRequest.getParameter("role"));
		String cellphone = httpServletRequest.getParameter("cellphone");
		String zipCode = httpServletRequest.getParameter("zipCode");
		String publicPlace = httpServletRequest.getParameter("publicPlace");
		String complement = httpServletRequest.getParameter("complement"); 
		String neighborhood = httpServletRequest.getParameter("neighborhood");
		String city = httpServletRequest.getParameter("city");
		String federativeUnit = httpServletRequest.getParameter("federativeUnit");
		String houseNumber = httpServletRequest.getParameter("houseNumber");
		AddressType addressType = AddressType.valueOf(httpServletRequest.getParameter("addressType"));
		String agent = httpServletRequest.getHeader("User-Agent");
		String ip = httpServletRequest.getRemoteAddr();
		String locale = httpServletRequest.getLocale().toString();
		
		Address address = new Address(addressType, zipCode, publicPlace, complement, neighborhood, city, federativeUnit, houseNumber);
		UserInformations informations = new UserInformations(agent, ip, locale);
		return new User(name, email, username, password, cellphone, role, informations, address);

	}

}
