package academy.admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.dto.CourseDTO;
import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminGetCourseDetailController
 */
public class AdminGetCourseDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetCourseDetailController() {
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
			// 요청 파라미터 조회
			String subjectCode = request.getParameter("subject_code");
			
			// 해당 코드의 과목 정보 조회
			CourseService service = CourseService.getInstance();
			CourseDTO cdto = service.getCourseBySubjectCode(subjectCode);
			
			// 조회 성공
			// request scope에 조회된 정보 binding
			request.setAttribute("cdto", cdto);
			request.setAttribute("page", request.getParameter("page"));
			
			//  요청 url 지정
			// 상세 정보 표시 화면으로
			if(request.getParameter("type") == null) {
				url = "/admin/admin_detail_view.jsp";
			}
			// 수정 폼 표시 화면으로
			else {
				url = "/admin/admin_input_form.jsp";
			}
		} catch(Exception e) {
			// 조회 실패
			// request scope에 오류 내용 binding
			request.setAttribute("error_message", "과목 상세정보 조회 도중 오류 발생" + e.getMessage());
			
			// 요청 url 지정
			url = "/common/error.jsp";
		}
		Utilities.forward(request, response, url, false);
	}
}
