package carRaceGame;

public class Car {
	int nDoors = 4, nSeats = 5, cc;
	double x, y, vx, vy;
	String model, 제조사;  boolean ngin = false;
	
	// 자동차 생성자
	Car(String 모델명, int 배기량, int 문짝수, float x0, float y0)
	{
		model = 모델명; cc = 배기량; nDoors = 문짝수;
		x = x0; y = y0;
	}
	// 지나간 거리를 출력
	void display()
	{
		for(int i = 0  ; i < x ; i++)
			System.out.print('-');
		System.out.print(" :=:- ");
	}
	// 모델명 출력
	void info() 
	{ 
		System.out.println(model+"입니다.");
	}
	// 엔진점화
	void start() 
	{ 
		ngin = true; System.out.println("~ 부릉 ~");
	}
	// 랜덤값만큼 x값에 더함.
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
		return (Math.random() - 0.3) * 30;		// 랜덤한 값만큼 더해짐(음수도 가능)
	}
	boolean ingoal()
	{
		return x > 200;		// x값이 200 넘으면 트루
	}
}
