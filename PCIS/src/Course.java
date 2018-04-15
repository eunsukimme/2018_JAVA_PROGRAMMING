import java.util.*;

public class Course {
	String title, time, room;		// ���� ����, �ð�, ���ǽ�
	Faculty lecturer;				// ������
	Vector vregist;		// -> Vector<Student> regist; ������ ���
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
	// ������ ������ ���� �޽��
	String getTitle() 
	{
		return title;					// ���Ǹ� ����
	}
	Faculty getLecturer() 
	{ 
		return lecturer;				// ������ ����	
	}
	String getTP() 
	{ 
		return time + " #" + room;		// ���ǽð� �� ���ǽ� ����
	}
	int numRegist() 
	{ 
		return vregist.size();			// ������ �� ����
	}
	void register(Student st) 
	{ 
		vregist.add(st);				// �л� �������(������ ��Ͽ� �߰�)
	}
	void dropme(Student st) 
	{ 
		vregist.removeElement(st);		// ���� ���
	}
	
	// �⼮�θ� ���
	void listRegistrants() 
	{
		for(int i = 0 ;i < vregist.size(); i++) 
		{
			Student st = (Student) vregist.elementAt(i);		// i��° �л� ����
			System.out.print(st.getName());
			System.out.print("     ");
			for(int j =0; j < 16 ; j++)
				System.out.print("  .");
			if((i + 1) %5 == 0) 								// 5�� ������ ���� �ߴ´�
			{
				System.out.print("\n   ");
				for(int k = 0 ; k < 16 ; k++)
					System.out.print(" --");
			}
			System.out.println();
		}
	}
	// ���� ��� ��½� ���� ���
	void info() 
	{
		System.out.println(title + "��米��: " + lecturer.getName() + ", �ð�: " + time + ", ���ǽ� : " + room);
	}
}
