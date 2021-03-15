package bit.cafe;

public class Ade extends Option {

	int price = 5000;

	public void price() {
		super.size();

		System.out.println("기본 에이드 금액 : " + price + "원" );
		total += price;
	}

}
