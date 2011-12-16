package academy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import academy.dto.CourseDTO;


public interface ImpCourseService {
	// 수강 과목 추가
	public int AddCourse(CourseDTO cdto) throws SQLException;
	
	// 수강 과목 수정
	public int modifyCourse(CourseDTO cdto) throws SQLException;
	
	// 수강 과목 삭제
	public int deleteCourse(String subjectCode) throws SQLException;
	
	// 모든 수강 과목 조회
	public ArrayList<CourseDTO> getAllCourses() throws SQLException;
	
	// 키워드로 수강 과목 조회
	public ArrayList<CourseDTO> getCoursesByKeyword(Map<String, String> map, int page) throws SQLException;
	
	// 과목 코드로 수강 과목 조회
	public CourseDTO getCourseBySubjectCode(String subjectCode) throws SQLException;
}
