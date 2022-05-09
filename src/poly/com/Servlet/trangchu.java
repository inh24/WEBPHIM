package poly.com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.com.DAO.userDAO;
import poly.com.DAO.videoDAO;
import poly.com.JPA.sharehelper;
import poly.com.model.Users;
import poly.com.model.Videos;

/**
 * Servlet implementation class trangchu
 */
@WebServlet("/trangchu")
public class trangchu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trangchu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	if (sharehelper.users == null ) {
			request.getRequestDispatcher("/Giaodien/login.jsp").forward(request, response);
		}else {
			nguoidung(request, response);
			findAll(request, response);
			danhsachyeuthich(request,response,sharehelper.users.getUsid());
			request.getRequestDispatcher("/Giaodien/trangchu.jsp").forward(request, response);
		}
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			videoDAO viDao = new videoDAO();
			List <Videos> videos = viDao.findAll();
			request.setAttribute("vid", videos);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void nguoidung(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = sharehelper.users.getUsid();
			userDAO dao = new userDAO();
			Users user = dao.findByID(id);
			request.setAttribute("user",user);
			request.setAttribute("vaitro",sharehelper.users.isVaitro());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void danhsachyeuthich(HttpServletRequest request, HttpServletResponse response,String name) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			videoDAO dao = new videoDAO();
			List<Videos> videos = dao.videoyeuthichuserid(name);
			request.setAttribute("yeu",videos);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
