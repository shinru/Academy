package academy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import academy.dto.CourseDTO;


public interface ImpCourseDAO {
	// 수강 과목 추가
	public int insert(CourseDTO cdto) throws SQLException; 
	
	// 수강 과목 수정
	public int update(CourseDTO cdto) throws SQLException;
	
	// 수강 과목 삭제
	public int delete(String subjectCode) throws SQLException;
	
	// 모든 수강 과목 조회
	public ArrayList<CourseDTO> selectAll() throws SQLException;
	
	// 키워드로 수강 과목 조회
	public ArrayList<CourseDTO> selectByKeyword(Map<String, String> map, int skip, int max) throws SQLException;
	
	// 과목 코드로 수강 과목 조회
	public CourseDTO selectBySubjectCode(String subjectCode) throws SQLException;
}
