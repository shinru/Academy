package academy.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.dto.CourseDTO;
import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminAddCourseController
 */
public class AdminAddCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCourseController() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		String url = null;
		try {
			// 요청 파라미터 조회
			String subjectCode = request.getParameter("subject_code");
			String subjectName = request.getParameter("subject_name");
			String majorName = request.getParameter("major_name");
			String professorName = request.getParameter("professor_name");
			String subjectDetail = request.getParameter("subject_detail");
			int applicant = Integer.parseInt(request.getParameter("applicant"));
			int capacity = Integer.parseInt(request.getParameter("capacity"));
			String lectureTime = request.getParameter("lecture_time");
			int credit = Integer.parseInt(request.getParameter("credit"));
			
			// DTO 객체 생성
			CourseDTO cdto = new CourseDTO(subjectCode, subjectName, majorName, professorName, subjectDetail, applicant, capacity, lectureTime, credit);
			System.out.println(cdto);
			// Business Logic 실행
			CourseService service = CourseService.getInstance();
			service.AddCourse(cdto);
			
			// 삽입 성공
			url = "/AdminGetCourseListController";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_message", "과목 추가 도중 오류 발생 : " + e.getMessage());
			url = "/common/error.jsp";
		}
		
		Utilities.forward(request, response, url, false);
	}
}
