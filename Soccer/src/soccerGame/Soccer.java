package soccerGame;

public class Soccer {
	Field field;		// �౸ ������ �����
	Ball ball;			// ��⿡ ���Ǵ� ��
	Player p, q, r;		// �÷��̾�
	boolean timeout, goal;		// ���� term�� ���� ���� �Ǵ�
	int clock;					// term�� üũ�ϴ� ����
	int leftScore = 0, rightScore = 0;		// ����, ������ ���� �� ��
	public static void main(String a[]) 
	{
		new Soccer();			// �� ��� ����
	}
	
	Soccer()
	{
		field = new Field(128, 96);		// ���� 128, ���� 96�� �ʵ� ����
		ball = new Ball(field);			// �ʵ� �߾ӿ� �� ����
		p = new Player("��", "P", field, -50, 10);	// (-50, 10)�� ���� ����
		q = new Player("��", "Q", field, 50, -10);	// (50, 10)�� ���� ����
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
			clock++;			// 1term�� ����
			System.out.println("["+clock+"]");
			int dist = p.Move(ball);		// p������ ���� �Ÿ� ����
			int distq = q.Move(ball);		// q������ ���� �Ÿ� ����
			r = p;							// ���� ����� ����(r)�� default�� p�� ����
			if(distq < dist) 
			{ 
				r = q; dist = distq;
			}
			if(dist < 5) 
			{			// ������ �Ÿ��� 5 �����̸�
				r.Kick(ball);		// ���� ����
				System.out.print(" -> " + r.name + "kicks -> ");
			}
			goal = ball.Move();		// ���� �����̸鼭 ���� ���� �Ǵ�
			ShowScore();
			Show();					// ���� ���
			if(goal) 
			{ 
				// ���� �����Ŀ� ���� ���� �ο�
				if(ball.GetX() > field.GetRight()-1)
					leftScore++;
				else if(ball.GetX() < field.GetLeft()+1)
					rightScore++;
				System.out.println("*�� ��*");
				// �� �� ������ ���¸� �ʱ�ȭ��Ŵ
				ball.InitBall();
				p.InitPlayerState(-50, 10);
				q.InitPlayerState(50, -10);
			}
			
			try 
			{
				Thread.sleep(300);		// 0.3���� �������� ���� ����
			} catch(Exception e) {}
			
			if(clock> 45)
				Stop();				// 45���� �ѱ�� ���� ����
		}
		System.out.println(" * TIME OUT * ");
	}
	void Show() 
	{							/* member variables: {field, b, p, q} */
		int dH = 10, dW = 3;	/* ��� cell dimension: dHxdW */
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
		System.out.println("����( " + leftScore + " : " + rightScore + "). ");
	}
}

class Field {
	int x0, x1, y0, y1, w, h;		// ���� ����, ������, ����, �Ʒ���, ����, ���� ����
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
	private double vx, vy;		// ���ӵ�
	Field field;
	Ball(Field f)
	{
		x = 0; vx= 0; y = 0; vy = 0; this.field = f;
	}
	void Fly(double kx, double ky) 
	{
		vx += kx; vy += ky;		// ������ ���� �� ���� ��ŭ ���ӵ� ����
	}
	boolean Move() 
	{
		x = x + (int)vx; y = y + (int)vy;		// ���ӵ���ŭ ����
		System.out.print("��(" + x + ", " + y + ") ");
		vx = vx * 0.8; vy = vy * 0.8;		// ���ӵ� �پ��
		CheckBounds();						// �ۿ� ������ ����
		// ���� �� ������ ���� ������ ���� ����
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
	// �� ���� �ʱ�ȭ
	void InitBall() 
	{
		x = 0; y = 0;
		vx= 0; vy = 0;
	}
	// ��, �Ʒ��� ������ ������ ƨ���
	void CheckBounds() 
	{
		//if(x < field.GetLeft()) { vx = -vx; x = 2*field.GetLeft() - x;}
		//if(x > field.GetRight()) { vx = -vx; x = 2*field.GetRight() - x;}
		if(y > field.GetBottom()) { vy = -vy; y = 2*field.GetBottom() - y;}
		if(y < field.GetTop()) {vy = -vy; y = 2*field.GetTop() - y;}
	}
}


class Player {
	int x, y;		// �÷��̾� ��ǥ
	double dx, dy, speed;		// ������, ������ ���ӵ� �׸��� ���ǵ�
	Field field;
	String name, team;			// ������, ����
	
	Player(String �̸�, String ��, Field f, int x0, int y0)
	{
		name = �̸�; team = ��; this.field = f; x = x0; y = y0;
	}
	
	void Kick(Ball b) 
	{
		// ���ӵ��� �������� ������ ���� ���� ���� ���ӵ�
		double kx = dx*2 + RandM(5) -3;
		double ky = dy*2 + RandM(4) -2;
		b.Fly(kx, ky);		// ������ ���ӵ� �ο�
		speed = speed/2;	// ���� ���� ���� ���� �ӵ� �ش�
	}
	double RandM(int M) 
	{
		return Math.random() * M;
	}
	int Move(Ball b) 
	{
		Dash(b);		// ���� ���� �ڴ�
		x = x + (int)dx; y = y + (int)dy;	// ���ӵ� ���ؼ� ��ġ �̵�
		int dist = (int) Distance(b);		// ������ �Ÿ� dist�� ����
		System.out.print(name +" " + dist + " ");
		return dist;
	}
	// ������ �� ������ �Ÿ�
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
		// ���� ���� ���ϰ� ���ǵ� ũ�� ��ŭ ���Ѵ�.
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
	// ���� ���� �ʱ�ȭ
	void InitPlayerState(int X, int Y) 
	{
		x = X; y = Y;
		dx = 0; dy = 0;
	}
}







