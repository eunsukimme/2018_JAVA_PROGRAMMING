import java.util.*;

public class InheritanceDemo {
    int npp = 0;			// 사람 수
    Person[] ppv;			// 사람 저장하는 배열
    Student[] stv;			// 학생 저장하는 배열
    Vector<Faculty> profv;	// 교수 저장하는 배열
    Staff  jigwon;			// 직원
    Course crsv[];			// 강의 저장하는 배열
    
    public static void main(String[] args)
    {
		InheritanceDemo pcis = new InheritanceDemo();				// 대학 만듬
		pcis.recruit_employees();									// 직원 채용
		pcis.run_school();											// 학교 운영
		pcis.report();												// 출력
    }
    
    // 처음 대학을 만들면 정원은 100명으로 설정
    InheritanceDemo() 
    {
        ppv = new Person[100]; npp = 0;
    }
    
    // 직원을 채용(교수, 직원)
    void recruit_employees() 
    {
    	profv = new Vector(6);
    	profv.add(new Faculty("권기룡", 50, "부산시 남구", 5000000, "공과대학"));
    	profv.add(new Faculty("권오흠", 48, "부산시 해운대구", 4000000, "공과대학"));
    	profv.add(new Faculty("조경연", 56, "부산시 북구", 4500000, "공과대학"));
    	profv.add(new Faculty("신봉기", 50, "부산시 중구", 6000000, "공과대학"));
    	profv.add(new Faculty("김영봉", 52, "부산시 부산진구", 4000000, "공과대학"));
    	profv.add(new Faculty("김호진", 50, "부산시 동구", 4500000, "공과대학"));
    	jigwon = new Staff("박과장", 42, 4000000, "대학본부");
    	jigwon.setDepartment("서무과");
    	for(int i =0 ; i < profv.size() ; i++)
    	{
    		ppv[npp++] = profv.get(i);
    	}
    	ppv[npp++] = jigwon;
    }
    
    // 구성원 소개, 수강편람, 과목출석부, 개인 시간표
    void report() 
    {
    	print_people();		// 교내 사람들을 모두 출력
    	print_수강편람();
    	System.out.println(" - 전 과목 출석부 - ");
    	for(int i = 0 ;i < crsv.length; i++) 
    	{
    		print_출석부(crsv[i]);		// 각 강의의 시간표를 출석부를 출력
    	}
    	System.out.println("\n - 전 학생 시간표  - ");
    	for(int i = 0 ; i < stv.length; i++)
    	{
    		print_학생시간표(stv[i]);
    	}
    	System.out.println("\n - 전 교수 강의시간표 - ");
    	for(int i = 0 ;i < profv.size(); i++)
    	{
    		print_교수시간표(profv.get(i));
    	}
    }
    // 학교를 본격적으로 운영함. 학생을 모으고, 강좌를 개설하고, 수강신청을 시킴(강제로 넣음)
    void run_school() 
    {	
    	recruit_학생();
    	open_강좌();
    	register_수강과목();
    }
    // 학생들을 모집하고, 학생들 배열 및 사람 배열에 저장
    void recruit_학생() 
    {	// (1)'
    	// 15명 학생
        String namev[] = {"강", "김", "고", "류", "박", "백", "서", "신", "심", "오", "이", "유", "조", "최", "황"};
        int agev[] = {21, 24, 22, 19, 21, 21, 21, 21, 23, 21, 22, 23, 21, 22, 20};
        stv = new Student[namev.length];
        for(int i = 0 ; i < namev.length; i++) 
        {
        	stv[i] = new Student(namev[i], agev[i], 3, 201612345 + i, "IT융합응용공학과");
        	ppv[npp++] = stv[i];
        }
    }
    // 강의를 개설한다
    void open_강좌() 
    {
    	crsv = new Course[6];
    	crsv[0] = new Course("디지털신호처리	", profv.get(0), "Mon 2-3, Wed 6-7", "A12-325");
    	crsv[1] = new Course("알고리즘		", profv.get(1), "Mon 6-7, Wed 2", "A13-226");
    	crsv[2] = new Course("컴퓨터구조		", profv.get(2), "Tue 2-3, Thu 5-6", "A15-302");
    	crsv[3] = new Course("JAVA응용프로그래밍	", profv.get(3), "Tue 6-7, Thu 2-3", "A12-320");
    	crsv[4] = new Course("컴퓨터그래픽스	", profv.get(4), "Tue 8-9, Fri 2-3", "A12-322");
    	crsv[5] = new Course("운영체제		", profv.get(5), "Thu 3-5", "A12-320");
    }

    // 각 학생들이 강의를 수강신청 하게 함
    void register_수강과목() 
    {
    	Course DSP = crsv[0];
    	Course ALGORITHM = crsv[1];
    	Course COMPUTER = crsv[2];
    	Course JAVA = crsv[3];
    	Course GRAPHICS = crsv[4];
    	Course OS = crsv[5];
    	int DSP_list[] = {0, 1, 3, 4, 5, 7, 8, 10, 13};
    	int ALG_list[] = {2, 3, 5, 6, 8, 9, 11, 12, 14};
    	int COM_list[] = {3, 4, 5, 6, 7, 8, 9, 10, 13};
    	int JAV_list[] = {0, 2, 5, 7, 10, 11, 12, 13, 14};
    	int GRA_list[] = {0, 1, 4, 6, 9, 10, 11, 12, 14};
    	int OS_list[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    	// OS 만 전필이라 모두 수강해야함
    	for(int i = 0 ; i < OS_list.length ; i++)
    		stv[OS_list[i]].registerCourse(OS);
    	// 나머지는 그냥 8명이 수강함
    	for(int i = 0 ;i < DSP_list.length; i++) 
    	{
    		stv[DSP_list[i]].registerCourse(DSP);
    		stv[ALG_list[i]].registerCourse(ALGORITHM);
    		stv[COM_list[i]].registerCourse(COMPUTER);
    		stv[JAV_list[i]].registerCourse(JAVA);
    		stv[GRA_list[i]].registerCourse(GRAPHICS);
    	}
    	System.out.println("수강신청: " + (OS_list.length)+ "명 - 성공." );
    }

    // 모든 사람들의 정보를 출력
    void print_people() {
        for(int i = 0; i < npp; i++)
        {
            System.out.println("<" + (i + 1) + ">---------------------------");
            ppv[i].info();
        }
    }
    // 각 강의의 정보를 출력
    void print_수강편람() 
    {
    	System.out.println("\n - 수강 편람 -");
    	for(int i = 0 ;i < crsv.length; i++)
    		crsv[i].info();
    }
    // 각 강의의 출석부를 출력한다
    void print_출석부(Course cs) 
    {
    	System.out.println("--------------------------------------------------------");
    	System.out.println("과목: " + cs.getTitle() + "(" + cs.getTP() + ")" + " 담당교수: " + cs.lecturer.getName());
    	System.out.print("   ");
    	for(int n = 1; n <= 16 ; n++)
    		System.out.printf("%3d", n);
    	System.out.println();
    	cs.listRegistrants();
    }
    // 각 학생의 강의시간표를 출력
    void print_학생시간표(Student st) 
    {
    	System.out.println("\n << 수강과목/시간표 >>");
    	System.out.println("이름: " + st.getName());
    	for(int i = 0 ;i < st.nCourses; i++) 
    	{
    		Course c = st.getCourse(i);
    		System.out.println(c.getTitle() + " (" + c.getTP() + ") by " + c.lecturer.getName());
    	}
    }   
    // 각 교수의 강의시간표를 출력
    void print_교수시간표(Faculty prof)
    {
    	System.out.println("\n << 강의과목/시간표 >>");
    	System.out.println("이름: " + prof.getName());
    	for(int i = 0 ; i < prof.coursev.size(); i++)
    	{
    		Course c = prof.coursev.get(i);
    		System.out.println(c.getTitle() + " (" + c.getTP() + ")");
    	}
    }
}

