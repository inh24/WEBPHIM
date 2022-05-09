package poly.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.com.DAO.userDAO;
import poly.com.DAO.videoDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Users;
import poly.com.model.Videos;

/**
 * Servlet implementation class qlvideo
 */
@WebServlet({ "/qlvideo", "/qlvideo/insert", "/qlvideo/update", "/qlvideo/edit", "/qlvideo/delete", "/qlvideo/reset" })
public class qlvideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public qlvideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (sharehelper.users == null ) {
			request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
		}else if(sharehelper.users.isVaitro() == false ) {
			request.getRequestDispatcher("/trangchu").forward(request, response);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String uri = request.getRequestURI().toString();

			if (uri.contains("edit")) {
				edit(request, response);
			}
			if (uri.contains("delete")) {
				delete(request, response);
			}
			if (uri.contains("reset")) {
				request.setAttribute("binh1", new Videos());
			}
			filltable(request, response);
			nguoidung(request, response);
			request.getRequestDispatcher("/Giaodien/video.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI().toString();
		if (uri.contains("insert")) {
			insert(request, response);
		}
		if (uri.contains("update")) {
			update(request, response);
		}
		filltable(request, response);
		nguoidung(request, response);
		request.getRequestDispatcher("/Giaodien/video.jsp").forward(request, response);
	}

	protected void filltable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			videoDAO dao = new videoDAO();
			List<Videos> Video = dao.findAll();
			request.setAttribute("Video", Video);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	protected void nguoidung(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String id = sharehelper.users.getUsid();
			userDAO dao = new userDAO();
			Users user = dao.findByID(id);
			request.setAttribute("user", user);
			request.setAttribute("vaitro", sharehelper.users.isVaitro());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Videos Videos = new Videos();
			BeanUtils.populate(Videos, request.getParameterMap());
			videoDAO dao = new videoDAO();
			dao.insert(Videos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Videos Videos = new Videos();
			BeanUtils.populate(Videos, request.getParameterMap());
			videoDAO dao = new videoDAO();
			dao.update(Videos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("vdid");
			videoDAO dao = new videoDAO();
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("vdid");
			videoDAO dao = new videoDAO();
			Videos us = dao.findByID(id);
			request.setAttribute("binh1", us);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
