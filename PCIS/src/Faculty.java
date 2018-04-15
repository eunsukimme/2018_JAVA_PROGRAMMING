// 리스트 5.4 : Faculty.java
// Faculty 클래스는 Employee 클래스를 상속받는데 Employee 클래스의 멤버 변수와 멤버 메쏘
// 드를 가지고 있으며 Employee 클래스의 슈퍼 클래스들의 멤버 변수와 멤버 메쏘드를 가지고 
// 있다. 또한 새로운 변수(course)를 정의하고 그 변수에 접근 가능한 메쏘드를 가지고 있다.
import java.util.*;

class Faculty extends Employee{
    private String course; 				// 강의
    // $
	//Course coursev[]= new Course[2];	// 최대 2개의 강의 가르칠 수 있음
	Vector<Course> coursev = new Vector();
	int nCourses = 0;					// 강의 수
    // 다양한 생성자
    Faculty()
    {
        super();
        course = "Not yet";
    }
    Faculty(String name, int age, int salary, String position)
    {
        super(name, age, salary, position);
        course = "Not yet";
    }
    Faculty(String name, int age, String address, int salary, String position)
    {
        super(name, age, address, salary, position);
        course = "Not yet";
    }
    Faculty(String name, int age, int salary, String position, Employee supervisor)
    {
        super(name, age, salary, position, supervisor);
        course = "Not yet";
    }
    Faculty(String name, int age, String address, int salary, String position, Employee supervisor)
    {
        super(name, age, address, salary, position, supervisor);
        course = "Not yet";
    }

    // $$
    // 강좌 개설
	void openCourse(Course c) 
	{
		// anycheck?
		//coursev[nCourses++] = c;
		coursev.add(c);
		nCourses++;
	}
    // 데이터 접근을 위한 메쏘드
    public void setCourse(String course)
    {
        this.course = course;					// 강의 변경
    }
    public String getCourse()
    {
        return course;							// 강의 리턴
    }

    // 객체의 정보 표시
    public void info()
    {
        super.info();
        System.out.println("강의 : " + course);
    }
}
