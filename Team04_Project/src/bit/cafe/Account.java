package bit.cafe;

public class Account {



	public String phoneNum;			// 폰번호
	public String name;				// 이름
	public double accumulatedPoint; // 누적포인

	
	public Account(String phoneNum, String name, double accumulatedPoint){
		this.phoneNum= phoneNum;
		this.name=name;
		this.accumulatedPoint=accumulatedPoint;
	}

	
}