package bit.cafe;

public class Americano extends Option {
   int price = 3000;


   public void price() {
      this.size();
      super.shot();
      super.ice();
      System.out.println("기본 아메리카노 금액 : " + price + "원" );
      total += price;
   }

   public void size() {
      sum = 0;

      System.out.println("  사이즈를 선택하세요");
      System.out.println("[1] S    [2] M (+500추가)  [3] L (+800추가)");
      int size = sc.nextInt();

      if (size == 1) {
         System.out.println("사이즈 s입니다");
         System.out.println();
      } else if (size == 2) {
         System.out.println("사이즈 m입니다.");
         System.out.println();
         sum += 500;
      } else if (size == 3) {
         System.out.println("사이즈 L입니다.");
         System.out.println();
         sum += 800;
      }
   }
}
   