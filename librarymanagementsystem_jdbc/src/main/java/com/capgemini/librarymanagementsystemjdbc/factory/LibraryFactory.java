package com.capgemini.librarymanagementsystemjdbc.factory;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminUserDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.AdminUserService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminUserServiceImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImplementation;

public class LibraryFactory {
	public static UserDAO getUsersDao() {
		return new UserDAOImplementation();
	}
	public static UserService getUsersService() {
		return new UserServiceImplementation();
	}
	public static AdminDAO getAdminsDao() {
		return new AdminDAOImplementation();
	}
	public static AdminService getAdminsService() {
		return new AdminServiceImplementation();
	}
	public static AdminUserDAO getAdminUserDao() {
		return new AdminUserDAOImplementation();
	}
	public static AdminUserService getAdminUserService() {
		return new AdminUserServiceImplementation();
	}
}
