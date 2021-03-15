package bit.cafe;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* <카페pos기 프로젝트>
기능 정의                  
1) 메뉴 주문  : 반복문 
2) 메뉴 선택  : 상속 & 오버라이딩
3) 회원 정보 입력 : Account 객체 리스트화 
4) 유효성 검사 & 누적포인트적립 : Account getPoint();
5) 결제방법   : if 조건문
6) 프로그램 종료 

*/

public class Cafe {
	static List<Account> list = new ArrayList<Account>();  // 모든 클래스 이 리스트에 접근할 수 있게 접근자를 스태틱으로   

	public static void main(String[] args) {	
		
//		회원정보를 담고인는 객체		phoneNum	name   accumulatedPoint
		list.add(new Account("01031013004","정*희",10.0));
		list.add(new Account("01067113081","김*예",11.0));
		list.add(new Account("01042848162","이*민",12.0));
		list.add(new Account("01024680469","김*정",13.0));
//--------------------------------------------------------------------------	
		 int cost = 0;
		double point = 0;
		boolean result = true;
		boolean money = false;
		
		while (result) {
			System.out.println("-------------------------------------");
			System.out.println("            비  트  카  페           ");
			System.out.println("-------------------------------------");
			System.out.println("               < Menu >              ");
			System.out.println("1.아메리카노 , 2.카페라떼 , 3.에이드 ");
			System.out.println("Hot) 3,000   ,   4,000    ,          ");
			System.out.println("Ice) 3,500   ,   4,500    ,   5,000  ");
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("메뉴를 선택해 주세요>");
			Scanner sc = new Scanner(System.in);
			int su = sc.nextInt();
			if (su == 1) {
				Americano americano = new Americano();
				americano.price();
			} else if (su == 2) {
				Latte latte = new Latte();
				latte.price();

			} else if (su == 3) {
				Ade ade = new Ade();
				ade.price();
			}
			
			
			System.out.println("추가금액 : " + Option.sum + "원" );
			Option.total += Option.sum;
			System.out.println();

			System.out.println("  추가주문 하시겠습니까?");
			System.out.println("[1] 예    [2] 아니요");
			int menu1 = 0;
			menu1 = sc.nextInt();
			if (menu1 == 1) {
				continue;
			}

			else if (menu1 == 2) {
				System.out.println("*2만원 이상 구매시 포인트0.5%적립(기본0.1%)*");
				System.out.println();
				System.out.println("총 결제 금액 : " + (Option.total) + "원");

				System.out.println("1.카드   2.현금");
	            int pay=sc.nextInt();
	            if(pay==2){
	                   
	                   while(money=true){
	                   System.out.println("받은 금액");            
	                   int cash=sc.nextInt();
	                   cost += cash;
	                   
	                   if(cash>=Option.total){
	                      System.out.println("거스름돈 : "+(cost-Option.total)+"원");
	                      break;
	                      // 거스름돈
	                   }else if(cash<Option.total){
	                      if(cost<Option.total){
	                         System.out.println("잔액이 부족합니다."+"\n");
	                      }else if(cost>=Option.total){
	                         System.out.println("거스름돈 : "+(cost-Option.total)+"원");
	                      break;
	                      }
	                      System.out.println("현재 받은 금액 : " + cost + "원"+"\n");
	                   } // 결제불가
                        
	               money=false;            
	               } // while2 end
	            }else if(pay==1){
	            	System.out.println(Option.total+"원 결제되었습니다.");
	            	}
	            
	            
//------------------------------------  누적포인트적립 & 해당객체 유효성 검사	-----------------------------------------	            
	            
				if (Option.total >= 20000)		// 만약 결제 총금액이 2만원이 넘으면 
					point = (double) Option.total * 0.005;	//      0.5% 적립 
				else point = (double) Option.total * 0.001; // 아니면 0.1% 적립 

				System.out.println( "적립 포인트 : " + point +"점"  );
				System.out.println();
				System.out.println( "적립하시겠습니까?");
				System.out.println("[1] 예    [2] 아니요");	// 적립 할때 필요한 것 : 핸드폰번호, 누적포인트 
				int ap = 0;
				ap = sc.nextInt();
				if (ap == 1) {	  // [1]예 
					System.out.println("핸드폰 번호를 입력하세요");
					String phone = "";
					phone = sc.next();
					//폰번호를 받아서 Account클래스의 객체 중 입력받은 폰번호를 갖고있는 해당고객(객체)의 누적포인트에 더해준다.  
					Account phonePoint = getPoint(phone);  // * getPoint메소드를 이용하여  
					
					phonePoint.accumulatedPoint+=point;   // 누적포인트에 누적해야할 값을 더해준다.
					System.out.println("***** 적  립  완  료 *****");
					System.out.println(phonePoint.name+"님 현재 누적 포인트 : "+(phonePoint.accumulatedPoint)+"점");    
					System.out.println();
				} 
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
		}// while end
	} // main end

	public static Account getPoint(String phone) {  
		for (int i = 0; i < list.size(); i++) { 
			Account account = list.get(i);		// 리스트 순서 대로 
			if (account.phoneNum.equals(phone)) // 입력받은 폰번호와 고객들의 폰번호를 비교 
				return account;		//   double accumulatedPoint 뿐만아니라 
		}							//   Stirng name 도 같이 리턴 되었음 좋겠다. ->객체 자체를 리턴하는 걸로 해결.
		return null; // 같은 폰번호 찾지 못하였을 경우 리턴 . 이 메소드의 반환타입은 클래스 타입이니까 null을 반환해야한다.
	} // getPoint end
} // class end
