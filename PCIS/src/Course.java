import java.util.*;

public class Course {
	String title, time, room;		// 강의 제목, 시간, 강의실
	Faculty lecturer;				// 교수명
	Vector vregist;		// -> Vector<Student> regist; 수강자 목록
	Course()
	{
		//regist = new Student[10];		// not used
		vregist = new Vector();
	}
	Course(String nam, Faculty prof, String tim, String rum)
	{
		this();
		title = nam; time = tim; room = rum;
		lecturer = prof;
		prof.openCourse(this);
	}
	// 데이터 접근을 위한 메쏘드
	String getTitle() 
	{
		return title;					// 강의명 리턴
	}
	Faculty getLecturer() 
	{ 
		return lecturer;				// 교수명 리턴	
	}
	String getTP() 
	{ 
		return time + " #" + room;		// 강의시간 및 강의실 리텅
	}
	int numRegist() 
	{ 
		return vregist.size();			// 수강자 수 리턴
	}
	void register(Student st) 
	{ 
		vregist.add(st);				// 학생 수강등록(수강자 목록에 추가)
	}
	void dropme(Student st) 
	{ 
		vregist.removeElement(st);		// 수강 취소
	}
	
	// 출석부를 출력
	void listRegistrants() 
	{
		for(int i = 0 ;i < vregist.size(); i++) 
		{
			Student st = (Student) vregist.elementAt(i);		// i번째 학생 참조
			System.out.print(st.getName());
			System.out.print("     ");
			for(int j =0; j < 16 ; j++)
				System.out.print("  .");
			if((i + 1) %5 == 0) 								// 5명 단위로 선을 긋는다
			{
				System.out.print("\n   ");
				for(int k = 0 ; k < 16 ; k++)
					System.out.print(" --");
			}
			System.out.println();
		}
	}
	// 수강 편람 출력시 정보 출력
	void info() 
	{
		System.out.println(title + "담당교수: " + lecturer.getName() + ", 시간: " + time + ", 강의실 : " + room);
	}
}
