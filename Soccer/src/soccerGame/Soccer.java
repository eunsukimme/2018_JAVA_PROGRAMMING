package soccerGame;

public class Soccer {
	Field field;		// 축구 게임의 경기장
	Ball ball;			// 경기에 사용되는 공
	Player p, q, r;		// 플레이어
	boolean timeout, goal;		// 각각 term과 골인 여부 판단
	int clock;					// term을 체크하는 변수
	int leftScore = 0, rightScore = 0;		// 왼쪽, 오른쪽 팀의 골 수
	public static void main(String a[]) 
	{
		new Soccer();			// 한 경기 주최
	}
	
	Soccer()
	{
		field = new Field(128, 96);		// 가로 128, 세로 96인 필드 생성
		ball = new Ball(field);			// 필드 중앙에 공 생성
		p = new Player("손", "P", field, -50, 10);	// (-50, 10)에 선수 생성
		q = new Player("기", "Q", field, 50, -10);	// (50, 10)에 선수 생성
		Start();
	}
	void Start() 
	{
		System.out.println(" * START * ");
		timeout = false;
		Run();
	}
	void Stop() 
	{
		timeout = true;
	}
	void Run() 
	{
		int clock = 0;
		while(!timeout) 
		{
			clock++;			// 1term씩 증가
			System.out.println("["+clock+"]");
			int dist = p.Move(ball);		// p선수와 공의 거리 구함
			int distq = q.Move(ball);		// q선수와 공의 거리 구함
			r = p;							// 공과 가까운 선수(r)를 default로 p로 설정
			if(distq < dist) 
			{ 
				r = q; dist = distq;
			}
			if(dist < 5) 
			{			// 공과의 거리가 5 이하이면
				r.Kick(ball);		// 공을 찬다
				System.out.print(" -> " + r.name + "kicks -> ");
			}
			goal = ball.Move();		// 공이 움직이면서 골인 여부 판단
			ShowScore();
			Show();					// 게임 출력
			if(goal) 
			{ 
				// 어디로 들어갔느냐에 따라 점수 부여
				if(ball.GetX() > field.GetRight()-1)
					leftScore++;
				else if(ball.GetX() < field.GetLeft()+1)
					rightScore++;
				System.out.println("*골 인*");
				// 공 및 선수의 상태를 초기화시킴
				ball.InitBall();
				p.InitPlayerState(-50, 10);
				q.InitPlayerState(50, -10);
			}
			
			try 
			{
				Thread.sleep(300);		// 0.3초의 간격으로 게임 진행
			} catch(Exception e) {}
			
			if(clock> 45)
				Stop();				// 45텀을 넘기면 게임 종료
		}
		System.out.println(" * TIME OUT * ");
	}
	void Show() 
	{							/* member variables: {field, b, p, q} */
		int dH = 10, dW = 3;	/* 운동장 cell dimension: dHxdW */
		int bx = ball.GetX() / dW;
		int by = ball.GetY() / dH;
		int px = p.GetX() / dW;
		int py = p.GetY() / dH;
		int qy = q.GetY() / dH;
		int qx = q.GetX() / dW;

		Hline(field.GetRight()/dW - field.GetLeft()/dW + 1);
		for(int r = field.GetTop()/dH; r <= field.GetBottom()/dH; r ++) 
		{
		    Tpr("|");
		    for(int i = field.GetLeft()/dW; i<= field.GetRight()/dW; i ++) 
		    {
				if (r == by && i == bx) 
				{
					Tpr("*");
					if (r == py && i == px) 
					{
						Tpr("p"); i++;
						if (r == qy && i == qx) 
						{ 
							Tpr("q"); i++; 
						}
					} 
					else if (r == qy && i == qx) 
					{ 
						Tpr("q"); i++; 
					}
				} 
				else if (r == py && i == px) 
				{
					Tpr("p");
					if (r == qy && i == qx) 
					{ 
						Tpr("q"); i++; 
					}
				} 
				else if (r == qy && i == qx) 
				{ 
					Tpr("q");
				} 
				else 
				{ /* if (r == 0 && i == 0) Tpr("+"); else  */
					Tpr(" ");
				}
		    }
		    Tprl("|"+r);
		}
		Hline(field.GetRight()/dW - field.GetLeft()/dW + 1);
	}
	void Hline(int n) 
	{
		Tpr("+");
		for(int i = 1; i<=n; i++)  Tpr("-");
		Tprl("+");
	}
	void Tpr(String s) 
	{ 
		System.out.print(s); 
	}
	void Tprl(String s) 
	{ 
		System.out.println(s); 
	}
	void ShowScore() 
	{
		System.out.println("점수( " + leftScore + " : " + rightScore + "). ");
	}
}

class Field {
	int x0, x1, y0, y1, w, h;		// 각각 왼쪽, 오른쪽, 위쪽, 아래쪽, 가로, 세로 길이
	Field(int wide, int high)
	{
		w = wide; h = high;
		x1 = w/2; y1 = h/2;
		x0 = -x1; y0 = -y1;
	}
	int GetLeft() 
	{
		return x0;
	}
	int GetRight() 
	{
		return x1;
	}
	int GetTop() 
	{
		return y0;
	}
	int GetBottom() 
	{
		return y1;
	}
}

class Ball {
	private int x, y, diameter;
	private double vx, vy;		// 가속도
	Field field;
	Ball(Field f)
	{
		x = 0; vx= 0; y = 0; vy = 0; this.field = f;
	}
	void Fly(double kx, double ky) 
	{
		vx += kx; vy += ky;		// 선수가 공을 찬 정도 만큼 가속도 증가
	}
	boolean Move() 
	{
		x = x + (int)vx; y = y + (int)vy;		// 가속도만큼 더함
		System.out.print("공(" + x + ", " + y + ") ");
		vx = vx * 0.8; vy = vy * 0.8;		// 가속도 줄어듬
		CheckBounds();						// 밖에 나간지 여부
		// 왼쪽 및 오른쪽 벽에 닿으면 골인 인정
		return(x > field.GetRight()-1 || x < field.GetLeft()+1);
	}
	int GetX() 
	{
		return x;
	}
	int GetY() 
	{
		return y;
	}
	// 공 상태 초기화
	void InitBall() 
	{
		x = 0; y = 0;
		vx= 0; vy = 0;
	}
	// 위, 아래는 밖으로 나가면 튕긴다
	void CheckBounds() 
	{
		//if(x < field.GetLeft()) { vx = -vx; x = 2*field.GetLeft() - x;}
		//if(x > field.GetRight()) { vx = -vx; x = 2*field.GetRight() - x;}
		if(y > field.GetBottom()) { vy = -vy; y = 2*field.GetBottom() - y;}
		if(y < field.GetTop()) {vy = -vy; y = 2*field.GetTop() - y;}
	}
}


class Player {
	int x, y;		// 플레이어 좌표
	double dx, dy, speed;		// 가로축, 세로축 가속도 그리고 스피드
	Field field;
	String name, team;			// 선수명, 팀명
	
	Player(String 이름, String 팀, Field f, int x0, int y0)
	{
		name = 이름; team = 팀; this.field = f; x = x0; y = y0;
	}
	
	void Kick(Ball b) 
	{
		// 가속도와 난수값을 적절히 더한 값이 공의 가속도
		double kx = dx*2 + RandM(5) -3;
		double ky = dy*2 + RandM(4) -2;
		b.Fly(kx, ky);		// 공에게 가속도 부여
		speed = speed/2;	// 차고 나면 선수 힘들어서 속도 준다
	}
	double RandM(int M) 
	{
		return Math.random() * M;
	}
	int Move(Ball b) 
	{
		Dash(b);		// 공을 향해 뛴다
		x = x + (int)dx; y = y + (int)dy;	// 가속도 더해서 위치 이동
		int dist = (int) Distance(b);		// 공과의 거리 dist에 저장
		System.out.print(name +" " + dist + " ");
		return dist;
	}
	// 선수와 공 사이의 거리
	double Distance(Ball b) 
	{
		double x2x = x - b.GetX();
		double y2y = y - b.GetY();
		return Math.sqrt(x2x*x2x + y2y*y2y);
	}
	void Dash(Ball b) 
	{
		double dist = Distance(b) +1;
		speed = speed*0.8 + RandM(4);
		// 방향 벡터 구하고 스피드 크기 만큼 곱한다.
		dx = (b.GetX() -x )/ dist * speed;
		dy = (b.GetY() - y)/ dist * speed;
	}
	int GetX() 
	{
		return x;
	}
	int GetY() 
	{
		return y;
	}
	// 선수 상태 초기화
	void InitPlayerState(int X, int Y) 
	{
		x = X; y = Y;
		dx = 0; dy = 0;
	}
}







