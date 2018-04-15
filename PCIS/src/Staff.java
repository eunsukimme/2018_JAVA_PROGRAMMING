// 리스트 5.5 : Staff.java
// Staff 클래스는 Employee 클래스를 상속받는데 Employee 클래스의 멤버 변수와 멤버 메쏘드 
// 를 가지고 있으며 Employee 클래스의 슈퍼 클래스의 멤버 변수와 멤버 메쏘드를 가지고 있다. 
// 또한 새로운 변수(department)를 정의하고 그 변수에 접근 가능한 메쏘드가 있다.

class Staff extends Employee{

    private String department; 		// 부서
	
    // 다양한 생성자
    Staff()
    {
        super();
        department = "Not yet";
    }
    Staff(String name, int age, int salary, String position)
    {
        super(name, age, salary, position);
        department = "Not yet";
    }
    Staff(String name, int age, String address, int salary, String position)
    {
        super(name, age, address, salary, position);
        department = "Not yet";
    }
    Staff(String name, int age, int salary, String position, Employee supervisor)
    {
        super(name, age, salary, position, supervisor);
        department = "Not yet";
    }
    Staff(String name, int age, String address, int salary, String position, Employee supervisor)
    {
        super(name, age, address, salary, position, supervisor);
        department = "Not yet";
    }
	
    // 데이터 접근을 위한 메쏘드
    public void setDepartment(String department)
    {
        this.department = department;				// 부서 변경
    }
    public String getDepartment()
    {
        return department;							// 부서 리턴
    }

    // 객체 정보 표시
    public void info()
    {
        super.info();
        System.out.println("부서 : " + department);
    }
}
