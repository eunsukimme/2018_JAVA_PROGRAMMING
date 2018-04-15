// ����Ʈ 5.2 : Student.java
// Person�� ��ӹ��� Student Ŭ������ Person Ŭ������ ��� ��� ������ ��� �޽�带 ������
// ������ ���ο� ������(grade, studentNo, major)�� �����ϰ� ������ �� �ִ� �޽�� ����

class Student extends Person{
    private int grade; 			// �г�
    private int studentNo; 		// �й�
    private String major; 		// ����
    // $
    Course myCoursev[] = new Course[6];		// ���� ���� �迪
    int nCourses = 0;			// ��û ���� ����
    // �پ��� ������
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

    // ���� �迭�� ��û�� ���� ����
    void registerCourse(Course c) 
    {
    	if(check() == true) 		// ���� ���� �ʰ��ϸ� ��û �ȵ�
    		return;
    	myCoursev[nCourses++] = c;
    	c.register(this);
    }
    // ���� ��û �ʰ� ����
    boolean check() 
    {
    	if(nCourses >= 6) 
    		System.out.println("no more courses");
    	return nCourses >= 6;
    }
    // i��° ���Ǹ� ����
    Course getCourse(int i) 
    { 
    	return myCoursev[i];
    }
    // ������ ������ ���� �޽���
    public void setGrade(int grade){
        this.grade = grade;						// �г� ����
    }
    public int getGrade(){
        return grade;							// �г� ����
    }
    public void setStudentNo(int studentNo){
        this.studentNo = studentNo;				// �й� ����
    }
    public int getStudentNo(){
        return studentNo;						// �й� ����
    }
    public void setMajor(String major){
        this.major = major;						// ���� ����
    }
    public String getMajor(){
        return major;							// ���� ����
    }
	
    // ��ü ���� ǥ��
    public void info(){
        super.info();
        System.out.println("�г� : " + grade);
        System.out.println("�й� : " + studentNo);
        System.out.println("���� : " + major);
    }
}
