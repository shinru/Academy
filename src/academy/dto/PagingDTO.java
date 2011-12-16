package academy.dto;

import academy.util.Utilities;

/**
 * 페이징 처리위한 bean <br>
 * page : 게시물 묶음
 * page group : page 묶음
 * @author kgmyh
 *
 */
public class PagingDTO {
	/**
	 * 총 데이터(게시물)의 개수
	 */
	private int totalContent;
	/**
	 * 현재 페이지
	 */
	private int currentPage;
	/**
	 * 한 페이지에 보여질 데이터(게시물)개수
	 */
	private int contentsPerPage = Utilities.CONTENT_PER_PAGE;
	/**
	 * Page Group 내 Page 수.  페이지 그룹에 들어갈 페이지 개수
	 */
	private int pagePerPagegroup = Utilities.PAGE_PER_PAGEGROUP;
	
	/**
	 * 총 데이터(게시물) 개수, 현재 페이지를 받아 member variable에 할당
	 * @param totalContent
	 * @param currentPage
	 */
	public PagingDTO(int totalContent, int nowPage){
		this.totalContent = totalContent;
		this.currentPage = nowPage;
	}
	/**
	 * 현재 페이지 return
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 현재 페이지 setting
	 * @param nowPage
	 */
	public void setCurrentPage(int nowPage) {
		this.currentPage = nowPage;
	}

/***************************************************************************
* 아래 메소드들을 구현하시오.
****************************************************************************/

	/**
	 * 총 페이지 수를 return한다.<br>
	 * 1. 전체 데이터(게시물) % 한 페이지에 보여줄 데이터 개수 => 0 이면 둘을 /  값이 총 페이지 수<br>
	 * 2. 전체 데이터(게시물) % 한 페이지에 보여줄 데이터 개수 => 0보다 크면 둘을 /  값에 +1을 한 값이 총 페이지 수
	 * @return
	 */
	public int getTotalPage(){
		int totalPage = totalContent / contentsPerPage;
		
		if(totalContent % contentsPerPage != 0) {
			totalPage++;
		}
		return totalPage;
	}
	
	/**
	 * 총 페이지 그룹의 수를 return한다.<br>
	 * 1. 총 페이지수 %  Page Group 내 Page 수.  => 0 이면 둘을 /  값이 총 페이지 수<br>
	 * 2. 총 페이지수 %  Page Group 내 Page 수.  => 0보다 크면 둘을 /  값에 +1을 한 값이 총 페이지 수
	 * @return
	 */
	public int getTotalPageGroup(){
		int totalPageGroup = getTotalPage() / pagePerPagegroup;
		
		if(getTotalPage() % pagePerPagegroup != 0) {
			totalPageGroup++;
		}
		
		return totalPageGroup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹 번호(몇 번째 페이지 그룹인지) 을 return 하는 메소드
	 * 1. 현재 페이지 %  Page Group 내 Page 수 => 0 이면 둘을 / 값이 현재 페이지 그룹. 
	 * 2. 현재 페이지 %  Page Group 내 Page 수 => 0 크면 둘을 /  값에 +1을 한 값이 현재 페이지 그룹
	 * @return
	 */
	public int getCurrentPageGroup(){
		
		int currentPageGroup = getCurrentPage() / pagePerPagegroup;
		
		if(getCurrentPage() % pagePerPagegroup != 0) {
			currentPageGroup++;
		}
		
		return currentPageGroup;
	}
	
	/**
	 * 현재 페이지가 속한 페이지 그룹의 시작 페이지 번호를 return 한다.<br>
	 * 1. Page Group 내 Page 수*(현재 페이지 그룹 -1) + 1을 한 값이 첫 페이지이다.(페이지 그룹*페이지 그룹 개수 이 그 그룹의 마지막 번호이므로)
	 * 2. 위의 계산 결과가 0인 경우는 첫페이지 이므로 1을 return 한다. 
	 * @return
	 */
	public int getStartPageOfPageGroup(){
		return pagePerPagegroup * (getCurrentPageGroup() - 1) + 1;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 마지막 페이지 번호를 return 한다.<br>
	 * 1. 현재 페이지 그룹 * 페이지 그룹 개수 가 마지막 번호이다.
	 * 2. 그 그룹의 마지막 페이지 번호가 전체 페이지의 마지막 페이지 번호보다 큰 경우는 전체 페이지의 마지막 번호를 return 한다. 
	 * @return
	 */
	public int getEndPageOfPageGroup(){
		int endPage = pagePerPagegroup * getCurrentPageGroup();
		
		if(endPage > getTotalPage()) {
			endPage = getTotalPage();
		}
		
		return endPage;
	}

	/**
	 * 이전 페이지 그룹이 있는지 체크
	 * 현재 페이지가 속한 페이지 그룹이 1보다 크면 true
	 * @return
	 */
	public boolean isPreviousPageGroup(){
		return getCurrentPageGroup() > 1;
	}
	/**
	 * 다음 페이지 그룹이 있는지 체크
	 * 현재 페이지 그룹이 마지막 페이지 그룹(마지막 페이지 그룹 == 총 페이지 그룹 수) 보다 작으면 true
	 * @return
	 */
	public boolean isNextPageGroup(){
		return getCurrentPageGroup() < getTotalPageGroup();
	}
}