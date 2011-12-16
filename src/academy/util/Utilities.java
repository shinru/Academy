package academy.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utilities {
	public static final int CONTENT_PER_PAGE = 10;		// 한 페이지에 보여질 글의 갯수
	public static final int PAGE_PER_PAGEGROUP = 3;		// 한 페이지 그룹에 포함될 페이지 수
	public static final int MAX_TITLE_LENGTH = 20;		// 최대 제목 길이
	
	/**
	 * textarea에서 입력 받은 내용이 html로 출력될 때 같은 형식으로 출력되도록 변경
	 * DB에 넣을 때(글 쓰기, 수정 완료후 등록) 
	 * \n -> <br>
	 * > -> &gt;
	 * < -> &lt;
	 * 공백 -> &nbsp;
	 * @param content
	 * @return
	 */
	public static String changeContentForDB(String oldContent){
		String newContent = oldContent.replace("<","&lt;");
		newContent = newContent.replace(">","&gt;");
		newContent = newContent.replace("\n", "<br>");
		newContent = newContent.replace(" ","&nbsp;");
		
		return newContent;
	}
	
	/**
	 * DB에 저장된 contents를 TextArea에 출력할 형식으로 변경
	 * 글 수정 전에 TextArea에 원래 내용을 보여줄 때
	 * <br> -> \n
	 * &gt; -> >
	 * &lt; -> <
	 * &nbsp; -> 공백
	 * @param content
	 * @return
	 */
	public static String changeContentForTA(String oldContent){
		String newContent = oldContent.replace("&lt;","<");
		newContent = newContent.replace("&gt;",">");
		newContent = newContent.replace("<br>", "\n");
		newContent = newContent.replace("&nbsp;"," ");
		
		return newContent;
		
	}
	
	/**
	 * 월, 일 들어왔을때 10이하일 경우 0을 붙이는 메소드
	 * @return
	 */
	public static String changeSinglePlusZero(int old){
		if(old<10){
			return("0"+old);
		}else{
			return ""+old;
		}
		
	}
	/**
	 * 현재 일시를 yyyymmddhh24miss 형태로 리턴
	 * @return
	 */
	public static String getNow(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	/**
	 * yyyymmddhh24miss 형태로 받아
	 * 년.월.일 형태로 리턴
	 * @param time
	 * @return
	 */
//			"201112121212" "2011.12.12"
	public static String changeDayFormat(String time){
		 String year = time.substring(0,4);
		 String mon = time.substring(4,6);
		 String day = time.substring(6,8);
		 return year+"."+mon+"."+day;
	}
	/**
	 *  yyyymmddhh24miss 형태로 받아
	 *  년.월.일 시:분:초 형태로 리턴
	 * @return
	 */
	public static String changeDayTimeFormat(String time){
		 String year = time.substring(0,4);
		 String mon = time.substring(4,6);
		 String day = time.substring(6,8);
		 String hour = time.substring(8,10);
		 String min = time.substring(10,12);
		 String sec = time.substring(12,14);
		 return year+"."+mon+"."+day+" "+hour+":"+min+":"+sec;
	}
	
	/**
	 * 수행 이동 처리
	 * @param request
	 * @param response
	 * @param url : 이동할 url
	 * @param isRedirect : 요청 방식 설정
	 * 			true - 리다이렉트
	 * 			false - 요청 디스패치
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void forward(HttpServletRequest request, HttpServletResponse response, String url, boolean isRedirect) throws ServletException, IOException {
		if(isRedirect) {		// 리다이렉트 방식으로 수행 이동
			response.sendRedirect(url);
		} else {
			RequestDispatcher rdp = request.getRequestDispatcher(url);
			rdp.forward(request, response);
		}
	}
}
