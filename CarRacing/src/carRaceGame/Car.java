package carRaceGame;

public class Car {
	int nDoors = 4, nSeats = 5, cc;
	double x, y, vx, vy;
	String model, ������;  boolean ngin = false;
	
	// �ڵ��� ������
	Car(String �𵨸�, int ��ⷮ, int ��¦��, float x0, float y0)
	{
		model = �𵨸�; cc = ��ⷮ; nDoors = ��¦��;
		x = x0; y = y0;
	}
	// ������ �Ÿ��� ���
	void display()
	{
		for(int i = 0  ; i < x ; i++)
			System.out.print('-');
		System.out.print(" :=:- ");
	}
	// �𵨸� ���
	void info() 
	{ 
		System.out.println(model+"�Դϴ�.");
	}
	// ������ȭ
	void start() 
	{ 
		ngin = true; System.out.println("~ �θ� ~");
	}
	// ��������ŭ x���� ����.
	boolean move() 
	{
		vx = spurt();
		x = x+vx;
		display();
		System.out.println(model + "at" + (int)x);
		return ingoal();
	}
	double spurt() 
	{
		return (Math.random() - 0.3) * 30;		// ������ ����ŭ ������(������ ����)
	}
	boolean ingoal()
	{
		return x > 200;		// x���� 200 ������ Ʈ��
	}
}
