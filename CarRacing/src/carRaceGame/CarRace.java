package carRaceGame;
import java.util.Scanner;
import carRaceGame.CarStringDB;		// �ڵ����� �̸��� ���

public class CarRace {
	int N = 10;
	static int carIndex;			// ������ ���� �ε�����ȣ
	boolean isCorrect;				// ���� ���
	Car[] cars = new Car[N];		// N���� ������ ����
	
	// �� ���Ӵ� �ڵ��� N�� ����
	CarRace()
	{
		for(int i =0 ;i < N ; i++) {
			cars[i] = new Car(carRaceGame.CarStringDB.carName[i], 2000, 4, 0, i * 10);
		}
	}
	// �� ������ ���� ���
	void rollcall() 
	{
		for(int i = 0 ; i < N ;i++) {
			cars[i].info();
		}
	}
	// �� ���� ���� ��ȭ
	public void start()
	{
		for(int i = 0 ; i < N ; i++) {
			cars[i].start();
		}
	}
	// �޸��� ����
	public void run()
	{
		Car winner = null;		// ���ڴ� �ϴ� NULL
		int t= 0;				// �� term�� ī��Ʈ��
		do
		{
			System.out.println(++t);;
			for(int i = 0 ; i < N ; i++) {
				if(cars[i].move()== true) {		// x���� 200 �Ѵ� ���� ������ winner
					winner = cars[i];
					if(i == carIndex) {
						isCorrect = true;
					}else {
						isCorrect = false;
					}
				}
			}
			try
			{
				Thread.sleep(400);
			}
			catch(Exception e) { }
		} while(winner == null);
		System.out.println("��! ������ ���ڴ� "); winner.info();		// �̱� ���� �𵨸� ���
		if(isCorrect)
			System.out.println("�����մϴ�! ���ÿ� �����ϼ̽��ϴ�!");
		else
			System.out.println("���ÿ� �����ϼ̽��ϴ�...");
	}
	public static void main(String a[])
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("������ �����Ͻðڽ��ϱ�?(y: 1)");		// ���� 1 ������ ������
		int ans = scn.nextInt();
		if(ans == 1) {
			System.out.println("�� �� ������ �����Ͻðڽ��ϱ�?");
			carIndex = scn.nextInt();
			System.out.println("������ �����մϴ�.");
			CarRace firstCarRace = new CarRace();
			firstCarRace.rollcall();
			firstCarRace.start();
			firstCarRace.run();
		}
	}
}
