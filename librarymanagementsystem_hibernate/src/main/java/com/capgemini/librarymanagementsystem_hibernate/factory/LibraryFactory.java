package com.capgemini.librarymanagementsystem_hibernate.factory;

import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.AdminUserDAOImplementation;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserService;
import com.capgemini.librarymanagementsystem_hibernate.service.AdminUserServiceImplementation;
import com.capgemini.librarymanagementsystem_hibernate.service.UserService;
import com.capgemini.librarymanagementsystem_hibernate.service.UserServiceImplementation;

public class LibraryFactory {
	public static UserDAO getUserDao() {
		return new UserDAOImplementation();
	}
	public static UserService getUserService() {
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
