package academy.admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminDeleteCourseController
 */
public class AdminDeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			// 요청 파라미터 조회 page, subject_code
			String subjectCode = request.getParameter("subject_code");
			
			//B.L
			CourseService cs = CourseService.getInstance();
			cs.deleteCourse(subjectCode);
			
			// 성공
			url = "/AdminGetCourseListController?page=" + request.getParameter("page");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_message", "삭제오류발생"+e.getMessage());
			url = "/common/error.jsp";
		}
		Utilities.forward(request, response, url, false);
	}

}
