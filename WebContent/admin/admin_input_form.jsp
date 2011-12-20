<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function checkform(){
		var form = document.registform;
		if(form.major_name.value == ""){
			alert("전공명을 입력하세요");
			i.major_name.focus();
			return false;
		}
		if(form.subject_code.value ==""){
			alert("과목코드를 입력하세요");
			form.subject_code.focus();
			return false;
		}
		if(form.subject_name.value ==""){
			alert("과목명을 입력하세요");
			form.subject_name.focus();
			return false;
		}
		if(form.professor_name.value ==""){
			alert("교수명을 입력하세요");
			form.professor_name.focus();
			return false;
		}
		if(form.applicant.value ==""){
			alert("신청자수를 입력하세요");
			form.applicant.focus();
			return false;
		}
		if(form.capacity.value ==""){
			alert("정원을 입력하세요");
			form.capacity.focus();
			return false;
		}
		if(form.lecture_time.value ==""){
			alert("강의시간을 입력하세요");
			form.lecture_time.focus();
			return false;
		}
		if(form.credit.value ==""){
			alert("학점을 입력하세요");
			form.credit.focus();
			return false;
		}
		
		window.opener.refreshList();		// 부모창 출력 내용 갱신
		window.close();
	}
</script>
<title>Insert title here</title>
</head>
<body bgcolor="" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="registform" action="/ProjectAcademy/AdminAddCourseController" method="post"  onsubmit="return checkform()">
<table border="1" width="300">
	<tr>
		<td bgcolor="baf4a6" width="150">전공명</td>
		<td bgcolor="e8e8e8" width="150"><input type="text" name="major_name"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">과목코드</td>
		<td bgcolor="e8e8e8"><input type="text" name="subject_code"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">과목명</td>
		<td bgcolor="e8e8e8"><input type="text" name="subject_name"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">지도교수</td>
		<td bgcolor="e8e8e8"><input type="text" name="professor_name"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6"><b><font color="19067c">신청자수</font><font color="121b72">/</font><font color="ad0c0c">정원</font></td>
		<td bgcolor="e8e8e8"><input type="text" name="applicant" size="8">&nbsp;/&nbsp;<input type="text" name="capacity" size="8"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">강의시간</td>
		<td bgcolor="e8e8e8"><input type="text" name="lecture_time"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">학점</td>
		<td bgcolor="e8e8e8"><input type="text" name="credit"></td>
	</tr>
	<tr>
		<td bgcolor="baf4a6">과목소개</td>
		<td bgcolor="e8e8e8"><textarea name="subject_detail"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="등록">&nbsp; </td>
	</tr>
</table>
</form>
</body>
</html>