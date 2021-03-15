package bit.cafe;


public class Latte extends Option {
	int price = 4000;

	public void price() {

		super.size();
		super.shot();
		super.ice();
		System.out.println("기본 라떼 금액 : " + price + "원" );
		total += price;
	}

}
