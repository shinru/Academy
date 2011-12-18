package academy.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academy.dto.CourseDTO;
import academy.dto.PagingDTO;
import academy.service.CourseService;
import academy.util.Utilities;

/**
 * Servlet implementation class AdminFindCourseController
 */
public class AdminFindCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFindCourseController() {
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
		// 요청 파라미터 조회
		String searchOption = request.getParameter("search_keyword");
		String keyword = request.getParameter("keyword");

		// DB 조회할 키워드를 넣기위한 Map 객체 생성
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(searchOption, keyword);
		
		String url = null;
		ArrayList<CourseDTO> list = null;
		
		try {
			CourseService service = CourseService.getInstance();
			
			// 검색 결과 레코드 수 조회
			int totalContent = service.getSearchResultCount(map);
			
			// 검색 결과 조회
			list = service.getCoursesByKeyword(map, 1);
			
			// 검색 성공
			PagingDTO pdto = new PagingDTO(totalContent, 1);
			
			request.setAttribute("list", list);
			request.setAttribute("paging", pdto);
			url = "/admin/admin_list_view.jsp";
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error_message", "검색 도중 오류 발생" + e.getMessage());
			url = "/common/error.jsp";
		}
		
		Utilities.forward(request, response, url, false);
	}
}
