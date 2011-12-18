<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>과목 상세 보기</title>
<script type="text/javascript">
	function checkForm(btn) {
		var form = document.btnForm;
		
		// 수정 버튼 클릭 처리
		if(btn.name == "modify") {
			form.action = "/ProjectAcademy/AdminGetCourseDetailController?subject_code=" + "${requestScope.cdto.subjectCode}" + "&page=" + "${requestScope.page}" + "&type=modify";
			form.submit();
		}
		// 삭제 버튼 클릭 처리
		else if(btn.name == "delete") {
			form.action = "/ProjectAcademy/AdminDeleteCourseController?subject_code=" + "${cdto.subjectCode}" + "&page=" + "${requestScope.page}";
			form.submit();
			window.close();
			window.opener.refreshList();		// 부모창 출력 내용 갱신
		}
		// 닫기 버튼 처리
		else {
			window.close();
		}
	}
</script>
</head>
<body>
<form name="btnForm" method="post">
	<table border="1" cellspacing="-2" bordercolor="6b6868" cellpadding="3">
		<tr height="20">
			<Td bgcolor="6b6868"></Td>
			<td align="center" bgcolor="e0dcdc" width="140"><b>전공명</b></td>
			<td align="center" bgcolor="e0dcdc" width="140" ><b>과목명</b></td>
			<td align="center" bgcolor="e0dcdc" width="90"><b>지도교수</b></td>
			<td align="center" bgcolor="e0dcdc" width="130"><b><font color="19067c">신청자수</font><font color="121b72">/</font><font color="ad0c0c">정원</font></b></td>
			<td align="center" bgcolor="e0dcdc" width="130"><b>강의시간</b></td>
			<td align="center" bgcolor="e0dcdc" width="45"><b>학점</b></td>
			<td align="center" bgcolor="e0dcdc" width="90"><b>과목코드</b></td>
		</tr>
		<tr height="20">
			<Td bgcolor="6b6868"></Td>
			<td align="center"><b>${requestScope.cdto.majorName }</b></td>
			<td align="center" ><b>${requestScope.cdto.subjectName }</b></td>
			<td align="center" width="90"><b>${requestScope.cdto.professorName }</b></td>
			<td align="center"  width="130"><b><font color="19067c">${requestScope.cdto.applicant }</font><font color="121b72">/</font><font color="ad0c0c">${requestScope.cdto.capacity }</font></b></td>
			<td align="center"  width="130"><b>${requestScope.cdto.lectureTime }</b></td>
			<td align="center"  width="45"><b>${requestScope.cdto.credit }</b></td>
			<td align="center" width="90"><b>${requestScope.cdto.subjectCode }</b></td>
		</tr>
		<tr height="20">
			<td colspan="1" align="center" bgcolor="e0dcdc"><b>과목 소개</b></td>
			<td colspan="7" align="center" width="90" height="200"><b>${requestScope.cdto.subjectDetail }</b></td>
		</tr>
		<tr bgcolor="gray">
			<td colspan="8" align="right">
				<input type="button" value="수정" name="modify" onclick="checkForm(this)" >
				<input type="button" value="삭제" name="delete" onclick="checkForm(this)">
				<input type="button" value="닫기" name="close"  onclick="checkForm(this)">
			</td>
		</tr>
	</table>
</form>
</body>
</html>