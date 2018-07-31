package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.UserDao;
import org.study.model.Country;
import org.study.model.User;


@WebServlet("/idcheck")
public class IdCheckController extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		String id = request.getParameter("id");
		
		
		User user = new User();
		user.setId(id);
		
		
		//System.out.println(user);
		UserDao dao = new UserDao();
		if (dao.existUserId(id) == 1) {	// 사용자 중복 일때
			request.setAttribute("error", "중복된 아이디 입니다");
			
		} else if (dao.existUserId(id) == 0 ) {	// 사용자 중복이 아닐 때
			request.setAttribute("msg", "사용 가능한 아이디 입니다");
		
		} else {
			request.setAttribute("error", "서버가 문제가 있습니다");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
	}
}