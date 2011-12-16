package academy.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import academy.dto.CourseDTO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class CourseDAO implements ImpCourseDAO {
	private static CourseDAO instance = null;
	private SqlMapClient client;

	private CourseDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("academy/admin/config/SqlMapConfig.xml");
			this.client = SqlMapClientBuilder.buildSqlMapClient(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static CourseDAO getInstance() {
		if (instance == null) {
			instance = new CourseDAO();
		}
		return instance;
	}

	@Override
	public int insert(CourseDTO cdto) throws SQLException {
		client.insert("insertCourse", cdto);
		return 1;
	}

	@Override
	public int update(CourseDTO cdto) throws SQLException {
		return client.update("updateCourse", cdto);
	}

	@Override
	public int delete(String subjectCode) throws SQLException {
		return client.delete("deleteCourse", subjectCode);
	}

	@Override
	public ArrayList<CourseDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return (ArrayList<CourseDTO>) client.queryForList("selectAll");
	}

	@Override
	public ArrayList<CourseDTO> selectByKeyword(Map<String, String> map, int skip, int max) throws SQLException {
		return (ArrayList<CourseDTO>) client.queryForList("selectByKeyword", map, skip, max);
	}

	@Override
	public CourseDTO selectBySubjectCode(String subjectCode) throws SQLException {
		return (CourseDTO) client.queryForObject("selectBySubjectCode", subjectCode);
	}
	
	public int selectCourseCount() throws SQLException {
		return (Integer)client.queryForObject("selectCourseCount");
	}
	
	public int selectSearchResultCount(Map<String, String> map) throws SQLException {
		return (Integer)client.queryForObject("selectSearchResultCount", map);
	}
	
	public ArrayList<CourseDTO> selectByPage(int skip, int max) throws SQLException {
		return (ArrayList<CourseDTO>)client.queryForList("selectAll", null, skip, max);
	}
}
