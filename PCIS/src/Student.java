// 리스트 5.2 : Student.java
// Person을 상속받은 Student 클래스는 Person 클래스의 모든 멤버 변수와 멤버 메쏘드를 가지고
// 있으며 새로운 변수들(grade, studentNo, major)을 설정하고 접근할 수 있는 메쏘드 정의

class Student extends Person{
    private int grade; 			// 학년
    private int studentNo; 		// 학번
    private String major; 		// 전공
    // $
    Course myCoursev[] = new Course[6];		// 강의 저장 배역
    int nCourses = 0;			// 신청 강의 개수
    // 다양한 생성자
    Student()
    {
        super();
        grade = 0;
        studentNo = 0;
        major = "Not yet";
    }
    Student(String name, int age, int grade, int studentNo, String major)
    {
        super(name, age);
        this.grade = grade;
        this.studentNo = studentNo;
        this.major = major;
    }
    Student(String name, int age, String address, int grade, int studentNo, String major)
    {
        super(name, age, address);
        this.grade = grade;
        this.studentNo = studentNo;
        this.major = major;
    }

    // 강의 배열에 신청한 강의 저장
    void registerCourse(Course c) 
    {
    	if(check() == true) 		// 강의 갯수 초과하면 신청 안됨
    		return;
    	myCoursev[nCourses++] = c;
    	c.register(this);
    }
    // 강의 신청 초과 여부
    boolean check() 
    {
    	if(nCourses >= 6) 
    		System.out.println("no more courses");
    	return nCourses >= 6;
    }
    // i번째 강의를 리턴
    Course getCourse(int i) 
    { 
    	return myCoursev[i];
    }
    // 데이터 접근을 위한 메쏘드들
    public void setGrade(int grade){
        this.grade = grade;						// 학년 변경
    }
    public int getGrade(){
        return grade;							// 학년 리턴
    }
    public void setStudentNo(int studentNo){
        this.studentNo = studentNo;				// 학번 변경
    }
    public int getStudentNo(){
        return studentNo;						// 학번 리턴
    }
    public void setMajor(String major){
        this.major = major;						// 전공 변경
    }
    public String getMajor(){
        return major;							// 전공 리턴
    }
	
    // 객체 정보 표시
    public void info(){
        super.info();
        System.out.println("학년 : " + grade);
        System.out.println("학번 : " + studentNo);
        System.out.println("전공 : " + major);
    }
}
