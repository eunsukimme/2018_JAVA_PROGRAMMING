package carRaceGame;
import java.util.Scanner;
import carRaceGame.CarStringDB;		// 자동차의 이름이 담김

public class CarRace {
	int N = 10;
	static int carIndex;			// 배팅을 위한 인덱스번호
	boolean isCorrect;				// 배팅 결과
	Car[] cars = new Car[N];		// N개의 차량을 저장
	
	// 한 게임당 자동차 N대 생성
	CarRace()
	{
		for(int i =0 ;i < N ; i++) {
			cars[i] = new Car(carRaceGame.CarStringDB.carName[i], 2000, 4, 0, i * 10);
		}
	}
	// 각 차량의 모델을 출력
	void rollcall() 
	{
		for(int i = 0 ; i < N ;i++) {
			cars[i].info();
		}
	}
	// 각 차량 엔진 점화
	public void start()
	{
		for(int i = 0 ; i < N ; i++) {
			cars[i].start();
		}
	}
	// 달리기 시작
	public void run()
	{
		Car winner = null;		// 승자는 일단 NULL
		int t= 0;				// 각 term을 카운트함
		do
		{
			System.out.println(++t);;
			for(int i = 0 ; i < N ; i++) {
				if(cars[i].move()== true) {		// x값이 200 넘는 차량 있으면 winner
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
		System.out.println("축! 오늘의 승자는 "); winner.info();		// 이긴 차량 모델명 출력
		if(isCorrect)
			System.out.println("축하합니다! 배팅에 성공하셨습니다!");
		else
			System.out.println("배팅에 실패하셨습니다...");
	}
	public static void main(String a[])
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("게임을 시작하시겠습니까?(y: 1)");		// 숫자 1 눌러야 시작함
		int ans = scn.nextInt();
		if(ans == 1) {
			System.out.println("몇 번 차량에 배팅하시겠습니까?");
			carIndex = scn.nextInt();
			System.out.println("게임을 시작합니다.");
			CarRace firstCarRace = new CarRace();
			firstCarRace.rollcall();
			firstCarRace.start();
			firstCarRace.run();
		}
	}
}
