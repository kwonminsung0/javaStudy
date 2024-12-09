package productMVCProject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import productMVCProject.model.OrderAllVO;
import productMVCProject.model.OrderVO;
import productMVCProject.model.ProductVO;

public class OrderRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 주문리스트를 출력요청
	public void selectManager() {
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();
		ArrayList<OrderVO> orderList = odao.orderSelect(ovo);

		if (orderList.size() != 0) {
			printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
			return;
		}
	}

	public void insertManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();
		
		ArrayList<OrderVO> orderList = odao.orderSelect(ovo);
		if (orderList.size() != 0) {
			printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
		}

		System.out.println("주문 정보 입력");
		System.out.print("성명 >>");
		String c_name = sc.nextLine();

		// 재고정보출력
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			ProductRegisterManager.printProductList(productList);
		} else {
			System.out.println("주문 가능한 제품이 없습니다.");
			return;
		}
		// 제품번호입력
		System.out.print("제품번호[제품코드:01(전자제품),02(의류), 03(생필품), 04(식품),05(가구)] : ");
		String p_code = (sc.nextLine()).trim();

		// 주문 번호는 8자리로 생성한다. (연도2자리+제품번호2자리+일련번호 - 예로24110001)
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(new Date());
		ovo.setP_code(p_code);

		String result = odao.getOrderCount(ovo);
		if (result == null) {
			System.out.println("주문ID 생성부분에 문제가 발생했습니다.");
			// return;
		} else {
			System.out.println("주문번호 생성");
		}
		// String num = year + s_num + "0001";
		String id = year + p_code + result;

		System.out.print("주문수량 : ");
		int quantity = Integer.parseInt(sc.nextLine());

		ovo = new OrderVO(0, id, c_name, p_code, quantity, null);
		boolean successFlag = odao.orderInsert(ovo);

		if (successFlag == true) {
			System.out.println(id + " 주문을 입력하였습니다.");
		} else {
			System.out.println(id + " 주문을 입력 실패하였습니다.");
		}
	}

	public void updateManager() {
		ProductDAO pdao = new ProductDAO();
		ProductVO pvo = new ProductVO();
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();

		// 전체 주문리스트 출력
		ArrayList<OrderVO> orderList = odao.orderSelect(ovo);
		if (orderList.size() != 0) {
			printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
			return;
		}
		// 수정할 주문번호, 이름, 제품번호, 주문 수량을 입력
		System.out.print("수정할 주문ID를 입력하세요: ");
		String id = (sc.nextLine()).trim();
		System.out.print("수정할 주문자 이름을 입력하세요: ");
		String c_name = (sc.nextLine()).trim();

		// 재고정보출력
		ArrayList<ProductVO> productList = pdao.productSelect(pvo);
		if (productList.size() != 0) {
			ProductRegisterManager.printProductList(productList);
		} else {
			System.out.println("재고가 존재하지 않습니다.");
			return;
		}
		System.out.print("수정할 제품번호를 입력하세요: ");
		String p_code = (sc.nextLine()).trim();

		System.out.print("수정할 주문 수량을 입력하세요: ");
		int quantity = Integer.parseInt((sc.nextLine()).trim());

		ovo = new OrderVO(id, c_name, p_code, quantity);
		boolean successFlag = odao.orderUpdate(ovo);

		if (successFlag == true) {
			System.out.println(id + "주문을 수정하였습니다.");
		} else {
			System.out.println(id + "주문을 수정 실패하였습니다.");
		}
	}

	public void deleteManager() {
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();

		// 전체 주문리스트 출력
		ArrayList<OrderVO> orderList = odao.orderSelect(ovo);
		if (orderList.size() != 0) {
			printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
			return;
		}
		System.out.print("삭제할 주문번호를 입력하세요: ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		ovo.setNo(no);
		boolean successFlag = odao.orderDelete(ovo);

		if (successFlag == true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public void sortManager() {
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> orderList = odao.orderSort();
		if (orderList.size() != 0) {
			printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
			return;
		}
	}

	public void selectAllManager() {
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderAllVO> orderAllList = odao.orderAllSelect();
		if (orderAllList.size() != 0) {
			printOrderList2(orderAllList);
		}else {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
	}

	public void printOrderList2(ArrayList<OrderAllVO> orderAllList) {
		System.out.println();
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
				"주문번호", "주문ID", "주문자이름", "제품번호", "제품명", "주문수량", "주문날짜");
		System.out.println("=============================================================================================================");
		for (OrderAllVO sav : orderAllList) {
			System.out.println(sav.toString());
		}
		System.out.println();
	}

	// 전체 주문리스트를 출력진행
	public static void printOrderList(ArrayList<OrderVO> orderList) {
		System.out.println();
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s\n",
				"주문번호", "주문ID", "주문자이름", "제품번호", "주문수량", "주문날짜");
		System.out.println("=============================================================================================================");
		for (OrderVO ovo : orderList) {
			System.out.println(ovo.toString());
		}
		System.out.println();
	}
}
