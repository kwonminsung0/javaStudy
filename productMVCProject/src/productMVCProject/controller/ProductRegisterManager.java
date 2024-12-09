package productMVCProject.controller;

import java.util.ArrayList;
import java.util.Scanner;
import productMVCProject.model.ProductVO;

public class ProductRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 목록출력(select)
	public void selectManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
			return;
		}
	}

	// 정보입력(insert)
	public void insertManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();

		// 전체재고출력
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
		}

		System.out.println();
		System.out.println("재고 정보 입력[제품코드:01, 02, 03, 04, 05] [제품종류:01(전자제품),02(의류), 03(생필품), 04(식품),05(가구)]");
		System.out.print("제품코드 >> ");
		String code = sc.nextLine();
		System.out.print("제품명 >> ");
		String name = sc.nextLine();
		System.out.print("제품종류 : ");
		String type = sc.nextLine();
		System.out.print("제품가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("수량 : ");
		int stock = Integer.parseInt(sc.nextLine());

		pvo = new ProductVO(code, name, type, price, stock);
		boolean successFlag = pdao.productInsert(pvo);

		if (successFlag == true) {
			System.out.println(name + "재고를 등록하였습니다.");
		} else {
			System.out.println(name + "재고를 등록 실패하였습니다.");
		}
	}

	// 정보수정(update)
	public void updateManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();

		// 전체재고출력
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
			return;
		}

		// 수정할 정보 입력
		System.out.print("수정할 제품 번호를 입력하세요: ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		System.out.println("[제품코드:01, 02, 03, 04, 05] [제품종류:01(전자제품),02(의류), 03(생필품), 04(식품),05(가구)]");
		System.out.print("수정할 제품 코드를 입력하세요: ");
		String code = (sc.nextLine()).trim();
		System.out.print("새로운 제품명을 입력하세요: ");
		String name = (sc.nextLine()).trim();
		System.out.print("새로운 제품 종류를 입력하세요: ");
		String type = (sc.nextLine()).trim();
		System.out.print("새로운 제품 가격을 입력하세요: ");
		int price = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("새로운 재고량을 입력하세요: ");
		int stock = Integer.parseInt((sc.nextLine()).trim());

		pvo = new ProductVO(no, code, name, type, price, stock);
		boolean successFlag = pdao.productUpdate(pvo);

		if (successFlag == true) {
			System.out.println(no + "번 제품을 수정하였습니다.");
		} else {
			System.out.println(no + "번 제품을 수정 실패하였습니다.");
		}
	}

	// 정보삭제(delete)
	public void deleteManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();

		// 전체재고출력
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
			return;
		}

		System.out.print("삭제할 재고 번호를 입력하세요>>");
		int no = Integer.parseInt((sc.nextLine()).trim());

		pvo = new ProductVO();
		pvo.setNo(no);
		boolean successFlag = pdao.productDelete(pvo);

		if (successFlag == true) {
			System.out.println(no + "번 재고 삭제성공");
		} else {
			System.out.println(no + "번 재고 삭제실패");
		}
	}

	// 목록정렬(sort)
	public void sortManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();
		ArrayList<ProductVO> productList = pdao.productSort(pvo);
		if (productList.size() != 0) {
			printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
			return;
		}
	}

	// 전체 재고리스트를 출력진행
	public static void printProductList(ArrayList<ProductVO> productList) {
		System.out.println();
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s\n",
				"제품번호", "제품코드", "제품명", "제품종류", "가격", "재고량");
		System.out.println("=============================================================================================================");
		for (ProductVO sv : productList) {
			System.out.println(sv);
		}
		System.out.println();
	}
}
