package academy.dto;

public class CourseDTO {
	private String subjectCode;
	private String subjectName;
	private String majorName;
	private String professorName;
	private String subjectDetail;
	private int applicant;
	private int capacity;
	private String lectureTime;
	private int credit;

	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseDTO(String subjectCode, String subjectName, String majorName,
			String professorName, String subjectDetail, int applicant,
			int capacity, String lectureTime, int credit) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.majorName = majorName;
		this.professorName = professorName;
		this.subjectDetail = subjectDetail;
		this.applicant = applicant;
		this.capacity = capacity;
		this.lectureTime = lectureTime;
		this.credit = credit;
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getSubjectDetail() {
		return subjectDetail;
	}
	public void setSubjectDetail(String subjectDetail) {
		this.subjectDetail = subjectDetail;
	}
	public int getApplicant() {
		return applicant;
	}
	public void setApplicant(int applicant) {
		this.applicant = applicant;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLectureTime() {
		return lectureTime;
	}
	public void setLectureTime(String lectureTime) {
		this.lectureTime = lectureTime;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return "CourseDTO [subjectCode=" + subjectCode + ", subjectName="
				+ subjectName + ", majorName=" + majorName + ", professorName="
				+ professorName + ", subjectDetail=" + subjectDetail
				+ ", applicant=" + applicant + ", capacity=" + capacity
				+ ", lectureTime=" + lectureTime + ", credit=" + credit + "]";
	}
}
