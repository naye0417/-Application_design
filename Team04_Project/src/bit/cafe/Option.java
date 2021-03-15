package bit.cafe;

import java.util.Scanner;

public class Option {
	static int sum;
	static int total;
	Scanner sc = new Scanner(System.in);

	public void size() {
		sum = 0;

		System.out.println("  사이즈를 선택하세요");
		System.out.println("[1] S    [2] M (+500추가)");
		int size = sc.nextInt();

		if (size == 1) {
			System.out.println("사이즈 s입니다");
			System.out.println();
		} else if (size == 2) {
			System.out.println("사이즈 m입니다.");
			System.out.println();
			sum += 500;
		}
	}

	public void shot() {
		System.out.println("  샷 추가 하시겠나요? ");
		System.out.println("[1] 예(+500추가)  [2] 아니요");
		
		int shot = sc.nextInt();
		if (shot == 1) {
			System.out.println("샷 추가 입니다");
			System.out.println();
			sum += 500;
		} else if (shot == 2) {
			System.out.println("샷 추가 안합니다.");
			System.out.println();
		}
	}

	public void ice() {
		System.out.println("  아이스로 하시겠습니까?");
		System.out.println("[1] 예 (+500추가)   [2] 아니요");
		int ice = sc.nextInt();
		if (ice == 1) {
			sum += 500;
		} else if (ice == 2) {
		}
	}

}
