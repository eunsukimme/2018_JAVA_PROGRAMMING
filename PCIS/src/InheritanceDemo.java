import java.util.*;

public class InheritanceDemo {
    int npp = 0;			// ��� ��
    Person[] ppv;			// ��� �����ϴ� �迭
    Student[] stv;			// �л� �����ϴ� �迭
    Vector<Faculty> profv;	// ���� �����ϴ� �迭
    Staff  jigwon;			// ����
    Course crsv[];			// ���� �����ϴ� �迭
    
    public static void main(String[] args)
    {
		InheritanceDemo pcis = new InheritanceDemo();				// ���� ����
		pcis.recruit_employees();									// ���� ä��
		pcis.run_school();											// �б� �
		pcis.report();												// ���
    }
    
    // ó�� ������ ����� ������ 100������ ����
    InheritanceDemo() 
    {
        ppv = new Person[100]; npp = 0;
    }
    
    // ������ ä��(����, ����)
    void recruit_employees() 
    {
    	profv = new Vector(6);
    	profv.add(new Faculty("�Ǳ��", 50, "�λ�� ����", 5000000, "��������"));
    	profv.add(new Faculty("�ǿ���", 48, "�λ�� �ؿ�뱸", 4000000, "��������"));
    	profv.add(new Faculty("���濬", 56, "�λ�� �ϱ�", 4500000, "��������"));
    	profv.add(new Faculty("�ź���", 50, "�λ�� �߱�", 6000000, "��������"));
    	profv.add(new Faculty("�迵��", 52, "�λ�� �λ�����", 4000000, "��������"));
    	profv.add(new Faculty("��ȣ��", 50, "�λ�� ����", 4500000, "��������"));
    	jigwon = new Staff("�ڰ���", 42, 4000000, "���к���");
    	jigwon.setDepartment("������");
    	for(int i =0 ; i < profv.size() ; i++)
    	{
    		ppv[npp++] = profv.get(i);
    	}
    	ppv[npp++] = jigwon;
    }
    
    // ������ �Ұ�, �������, �����⼮��, ���� �ð�ǥ
    void report() 
    {
    	print_people();		// ���� ������� ��� ���
    	print_�������();
    	System.out.println(" - �� ���� �⼮�� - ");
    	for(int i = 0 ;i < crsv.length; i++) 
    	{
    		print_�⼮��(crsv[i]);		// �� ������ �ð�ǥ�� �⼮�θ� ���
    	}
    	System.out.println("\n - �� �л� �ð�ǥ  - ");
    	for(int i = 0 ; i < stv.length; i++)
    	{
    		print_�л��ð�ǥ(stv[i]);
    	}
    	System.out.println("\n - �� ���� ���ǽð�ǥ - ");
    	for(int i = 0 ;i < profv.size(); i++)
    	{
    		print_�����ð�ǥ(profv.get(i));
    	}
    }
    // �б��� ���������� ���. �л��� ������, ���¸� �����ϰ�, ������û�� ��Ŵ(������ ����)
    void run_school() 
    {	
    	recruit_�л�();
    	open_����();
    	register_��������();
    }
    // �л����� �����ϰ�, �л��� �迭 �� ��� �迭�� ����
    void recruit_�л�() 
    {	// (1)'
    	// 15�� �л�
        String namev[] = {"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ȳ"};
        int agev[] = {21, 24, 22, 19, 21, 21, 21, 21, 23, 21, 22, 23, 21, 22, 20};
        stv = new Student[namev.length];
        for(int i = 0 ; i < namev.length; i++) 
        {
        	stv[i] = new Student(namev[i], agev[i], 3, 201612345 + i, "IT����������а�");
        	ppv[npp++] = stv[i];
        }
    }
    // ���Ǹ� �����Ѵ�
    void open_����() 
    {
    	crsv = new Course[6];
    	crsv[0] = new Course("�����н�ȣó��	", profv.get(0), "Mon 2-3, Wed 6-7", "A12-325");
    	crsv[1] = new Course("�˰���		", profv.get(1), "Mon 6-7, Wed 2", "A13-226");
    	crsv[2] = new Course("��ǻ�ͱ���		", profv.get(2), "Tue 2-3, Thu 5-6", "A15-302");
    	crsv[3] = new Course("JAVA�������α׷���	", profv.get(3), "Tue 6-7, Thu 2-3", "A12-320");
    	crsv[4] = new Course("��ǻ�ͱ׷��Ƚ�	", profv.get(4), "Tue 8-9, Fri 2-3", "A12-322");
    	crsv[5] = new Course("�ü��		", profv.get(5), "Thu 3-5", "A12-320");
    }

    // �� �л����� ���Ǹ� ������û �ϰ� ��
    void register_��������() 
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
    	// OS �� �����̶� ��� �����ؾ���
    	for(int i = 0 ; i < OS_list.length ; i++)
    		stv[OS_list[i]].registerCourse(OS);
    	// �������� �׳� 8���� ������
    	for(int i = 0 ;i < DSP_list.length; i++) 
    	{
    		stv[DSP_list[i]].registerCourse(DSP);
    		stv[ALG_list[i]].registerCourse(ALGORITHM);
    		stv[COM_list[i]].registerCourse(COMPUTER);
    		stv[JAV_list[i]].registerCourse(JAVA);
    		stv[GRA_list[i]].registerCourse(GRAPHICS);
    	}
    	System.out.println("������û: " + (OS_list.length)+ "�� - ����." );
    }

    // ��� ������� ������ ���
    void print_people() {
        for(int i = 0; i < npp; i++)
        {
            System.out.println("<" + (i + 1) + ">---------------------------");
            ppv[i].info();
        }
    }
    // �� ������ ������ ���
    void print_�������() 
    {
    	System.out.println("\n - ���� ��� -");
    	for(int i = 0 ;i < crsv.length; i++)
    		crsv[i].info();
    }
    // �� ������ �⼮�θ� ����Ѵ�
    void print_�⼮��(Course cs) 
    {
    	System.out.println("--------------------------------------------------------");
    	System.out.println("����: " + cs.getTitle() + "(" + cs.getTP() + ")" + " ��米��: " + cs.lecturer.getName());
    	System.out.print("   ");
    	for(int n = 1; n <= 16 ; n++)
    		System.out.printf("%3d", n);
    	System.out.println();
    	cs.listRegistrants();
    }
    // �� �л��� ���ǽð�ǥ�� ���
    void print_�л��ð�ǥ(Student st) 
    {
    	System.out.println("\n << ��������/�ð�ǥ >>");
    	System.out.println("�̸�: " + st.getName());
    	for(int i = 0 ;i < st.nCourses; i++) 
    	{
    		Course c = st.getCourse(i);
    		System.out.println(c.getTitle() + " (" + c.getTP() + ") by " + c.lecturer.getName());
    	}
    }   
    // �� ������ ���ǽð�ǥ�� ���
    void print_�����ð�ǥ(Faculty prof)
    {
    	System.out.println("\n << ���ǰ���/�ð�ǥ >>");
    	System.out.println("�̸�: " + prof.getName());
    	for(int i = 0 ; i < prof.coursev.size(); i++)
    	{
    		Course c = prof.coursev.get(i);
    		System.out.println(c.getTitle() + " (" + c.getTP() + ")");
    	}
    }
}

