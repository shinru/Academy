<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	// 검색 폼
	function checkSearchForm() {
		var form = document.searchForm;	
		
		//검색어 입력확인
		if(form.keyword.value.length < 2) {
			alert("검색어는 2글자 이상을 입력하세요.");
			form.keyword.focus();
			return false;
		}
	}
	
	// 과목 리스트 재조회
	function refreshList() {
		var form = document.searchForm;
		form.action = "/ProjectAcademy/AdminFindCourseController?page=" + ${requestScope.paging.currentPage};
		form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body bgcolor="">
<form name="searchForm" method="post" action="/ProjectAcademy/AdminFindCourseController" onSubmit="return checkSearchForm()">
	<table border="2" width="1000" cellpadding="1" cellspacing="1" bordercolor="gray">
		<tr bgcolor="8bbafa">
			<td align="right">
			<select name="search_keyword">
				<option value="subject_name">과목명</option>
				<option value="subject_code">과목코드</option>
				<option value="major_name">전공명</option>
				<option value="professor_name">지도 교수</option>
				<option value="credit">단위</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
			<!--  2개 빠졌음 -->
			<!-- 체크박스 -->
			<!--  한번에 표시할 게시물 갯수 -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</form>
<table border="1" bordercolor="black" width="1000" height="260">
	<tr height="20">
		<td align="center" bgcolor="e0dcdc" width="130"><b>전공명</b></td>
		<td align="center" bgcolor="e0dcdc"><b>과목명</b></td>
		<td align="center" bgcolor="e0dcdc" width="90"><b>지도교수</b></td>
		<td align="center" bgcolor="e0dcdc" width="130"><b><font color="19067c">신청자수</font><font color="121b72">/</font><font color="ad0c0c">정원</font></b></td>
		<td align="center" bgcolor="e0dcdc" width="130"><b>강의시간</b></td>
		<td align="center" bgcolor="e0dcdc" width="45"><b>학점</b></td>
		<td align="center" bgcolor="e0dcdc" width="90"><b>과목코드</b></td>
	</tr>
	<c:forEach var="cdto" items="${requestScope.list }">
	<tr height="15" valign="middle">
		<!-- 게시물 뿌려짐 -->
		<td align="center" bgcolor="ffbbbb">${cdto.majorName}</td>
		<td align="center" bgcolor="ffd9bb">
			<a href="#" onclick="window.open('/ProjectAcademy/AdminGetCourseDetailController?subject_code=${cdto.subjectCode }&page=${requestScope.paging.currentPage }', '_blank', 'width=1000, height=400')">${cdto.subjectName}</a>
		</td>
		<td align="center" bgcolor="fffebb">${cdto.professorName}</td>
		<td align="center" bgcolor="c1f9bb"><font color="19067c">${cdto.applicant}</font> / <font color="ad0c0c">${cdto.capacity}</font></td>
		<td align="center" bgcolor="c8d9f9">${cdto.lectureTime}</td>
		<td align="center" bgcolor="99a1eb">${cdto.credit}</td>
		<td align="center" bgcolor="f2aff1">${cdto.subjectCode}</td>
	</tr>
	</c:forEach>
	<tr>
	<td colspan="7"></td>
	</tr>
</table>
<form action="/ProjectAcademy/admin_input_form.jsp">
	<table>
		<tr>
			<td width="450" align="left">
				<a href="/ProjectAcademy/AdminGetCourseListController">모든 목록</a>
			</td>
			<td width="450"align="left">
				<c:choose>
					<c:when test="${requestScope.paging.previousPageGroup == true}">
						<a href="/ProjectAcademy/AdminGetCourseListController?page=${requestScope.paging.currentPage-1}">◁</a>
					</c:when>
					<c:otherwise>
					◁
					</c:otherwise>
				</c:choose>
				<c:forEach var="cnt" step="1" begin="${requestScope.paging.startPageOfPageGroup}" end="${requestScope.paging.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${cnt == requestScope.paging.currentPage }">
						<font color="blue">[${cnt}]</font>
						</c:when>
						<c:otherwise>
						 <a href="/ProjectAcademy/AdminGetCourseListController?page=${cnt}">[${cnt}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.paging.nextPageGroup == true}">
						<a href="/ProjectAcademy/AdminGetCourseListController?page=${requestScope.paging.currentPage+1}">▷</a>
					</c:when>
					<c:otherwise>▷</c:otherwise>
				</c:choose>
				
			</td>
			<td align="right"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>
</body>
</html>