package academy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import academy.dao.CourseDAO;
import academy.dto.CourseDTO;
import academy.util.Utilities;

public class CourseService implements ImpCourseService {
	private static CourseService instance;
	private CourseDAO dao;
	
	private CourseService() {
		dao = CourseDAO.getInstance();
	}
	
	public static CourseService getInstance() {
		if(instance == null) {
			instance = new CourseService();
		}
		return instance;
	}
	
	@Override
	public int AddCourse(CourseDTO cdto) throws SQLException {
		// subjectDetail을 DB저장 형식으로 변환
		cdto.setSubjectDetail(Utilities.changeContentForDB(cdto.getSubjectDetail()));
		
		// CourseDAO.insert() 호출
		return dao.insert(cdto);
	}

	@Override
	public int modifyCourse(CourseDTO cdto) throws SQLException {
		// subjectDetail을 DB저장 형식으로 변환
		cdto.setSubjectDetail(Utilities.changeContentForDB(cdto.getSubjectDetail()));
		
		// CourseDAO.update() 호출
		return dao.update(cdto);
	}

	@Override
	public int deleteCourse(String subjectCode) throws SQLException {
		// CourseDAO.delete() 호출
		return dao.delete(subjectCode);
	}
	
	@Override
	public ArrayList<CourseDTO> getAllCourses() throws SQLException {
		// CourseDAO.selectAll() 호출
		return dao.selectAll();
	}
	
	public ArrayList<CourseDTO> getCoursesByPage(int page) throws SQLException {
		int skip = (page - 1) * Utilities.CONTENT_PER_PAGE;
		int max = Utilities.CONTENT_PER_PAGE;
		
		return dao.selectByPage(skip, max);
	}

	@Override
	public ArrayList<CourseDTO> getCoursesByKeyword(Map<String, String> map, int page) throws SQLException {
		int skip = (page - 1) * Utilities.CONTENT_PER_PAGE;
		int max = Utilities.CONTENT_PER_PAGE;
		
		return dao.selectByKeyword(map, skip, max);
	}
	
	public int getSearchResultCount(Map<String, String> map) throws SQLException {
		return dao.selectSearchResultCount(map);
	}

	@Override
	public CourseDTO getCourseBySubjectCode(String subjectCode) throws SQLException {
		CourseDTO cdto = dao.selectBySubjectCode(subjectCode);
		
		// subjectDetail을 TextArea 출력 형식으로 변환
		cdto.setSubjectDetail(Utilities.changeContentForTA(cdto.getSubjectDetail()));
		return cdto;
	}
	
	public int getCourseCount() throws SQLException {
		return dao.selectCourseCount();
	}
	
}
