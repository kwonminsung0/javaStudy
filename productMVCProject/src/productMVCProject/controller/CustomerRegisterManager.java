package productMVCProject.controller;

import java.util.ArrayList;
import java.util.Scanner;
import productMVCProject.model.CustomerAllVO;
import productMVCProject.model.CustomerVO;
import productMVCProject.model.OrderVO;

public class CustomerRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 고객리스트를 출력요청
	public void selectManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();
		ArrayList<CustomerVO> customerList = cdao.customerSelect(cvo);

		if (customerList.size() != 0) {
			printCustomerList(customerList);
		} else {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
	}

	public void insertManager() {
		OrderDAO odao = new OrderDAO();
		OrderVO ovo = new OrderVO();
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();

		System.out.println("고객 정보 입력");
		// 전체 주문리스트 출력
		ArrayList<OrderVO> orderList = odao.orderSelect(ovo);
		if (orderList.size() != 0) {
			OrderRegisterManager.printOrderList(orderList);
		} else {
			System.out.println("주문이 존재하지 않습니다.");
			return;
		}
		System.out.print("성명 >>");
		String name = (sc.nextLine()).trim();
		String id = null;
		do {
			System.out.print("아이디(8자 이상 12자 이내) : ");
			id = (sc.nextLine()).trim();
			// id 체크
			cvo.setId(id);
			boolean idCheck = cdao.customerIdCheck(cvo);
			if (idCheck == false) {
				System.out.println("중복된 아이디 없습니다.");
				break;
			}
			System.out.println("중복된 아이디입니다. 다시 입력하세요");
		} while (true);

		System.out.print("비밀번호(12자 이내) : ");
		String passwd = (sc.nextLine()).trim();

		System.out.print("생년월일(8자리: 20000918) : ");
		String birthday = (sc.nextLine()).trim();

		System.out.print("전화번호(010-xxxx-xxxx):");
		String phone = (sc.nextLine()).trim();

		System.out.print("주문ID:");
		String o_id = (sc.nextLine()).trim();

		CustomerVO customerVO = new CustomerVO(0, name, id, passwd, birthday, phone, o_id);
		boolean successFlag = cdao.customerInsert(customerVO);

		if (successFlag == true) {
			System.out.println(name + "고객 정보를 입력했습니다.");
		} else {
			System.out.println(name + "고객 정보를 입력을 실패했습니다.");
		}
	}

	public void updateManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();

		// 전체 고객리스트 출력
		ArrayList<CustomerVO> customerList = cdao.customerSelect(cvo);
		if (customerList.size() != 0) {
			printCustomerList(customerList);
		} else {
			System.out.println("고객정보가 존재하지 않습니다.");
			return;
		}
		// 수정할 고객번호, 이름, 개인정보를 입력
		System.out.print("수정할 고객의 고객번호를 입력하세요: ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("수정할 고객이름을 입력하세요: ");
		String name = (sc.nextLine()).trim();
		String id = null;
		do {
			System.out.print("수정할 고객ID를 입력하세요(8자 이상 12자 이내) : ");
			id = (sc.nextLine()).trim();
			// id 체크
			cvo.setId(id);
			boolean idCheck = cdao.customerIdCheck(cvo);
			if (idCheck == false) {
				System.out.println("중복된 아이디 없습니다.");
				break;
			}
			System.out.println("중복된 아이디입니다. 다시 입력하세요");
		} while (true);
		System.out.print("수정할 비밀번호를 입력하세요(12자 이내) : ");
		String passwd = (sc.nextLine()).trim();
		System.out.print("수정할 생년월일을 입력하세요: ");
		String birthday = (sc.nextLine()).trim();
		System.out.print("수정할 전화번호를 입력하세요: ");
		String phone = (sc.nextLine()).trim();

		CustomerVO customerVO = new CustomerVO(no, name, id, passwd, birthday, phone);

		boolean successFlag = cdao.customerUpdate(customerVO);

		if (successFlag == true) {
			System.out.println(no + "번 고객정보 수정성공");
		} else {
			System.out.println(no + "번 고객정보 수정실패");
		}
	}

	public void deleteManager() {
		CustomerDAO cdao = new CustomerDAO();
		CustomerVO cvo = new CustomerVO();

		// 전체 고객리스트 출력
		ArrayList<CustomerVO> customerList = cdao.customerSelect(cvo);
		if (customerList.size() != 0) {
			printCustomerList(customerList);
		} else {
			System.out.println("고객정보가 존재하지 않습니다.");
			return;
		}
		System.out.print("삭제할 고객 번호를 입력하세요: ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		cvo.setNo(no);
		boolean successFlag = cdao.customerDelete(cvo);

		if (successFlag == true) {
			System.out.println("고객정보 삭제성공");
		} else {
			System.out.println("고객정보 삭제실패");
		}
	}

	public void sortManager() {
		CustomerDAO cdao = new CustomerDAO();
		ArrayList<CustomerVO> customerList = cdao.customerSort();
		if (customerList.size() != 0) {
			printCustomerList(customerList);
		} else {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
	}

	public void selectAllManager() {
		CustomerDAO cdao = new CustomerDAO();
		ArrayList<CustomerAllVO> customerAllList = cdao.customerAllSelect();
		if (customerAllList.size() != 0) {
			printStudentList2(customerAllList);
		} else {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
	}

	public void printStudentList2(ArrayList<CustomerAllVO> customerAllList) {
		System.out.println();
		System.out.printf(
				"%-7s %-13s %-13s %-10s %-12s %-13s %-12s %-10s\n",
				"고객번호", "고객이름", "ID", "PW", "생년월일", "전화번호", "주문번호", "주문수량");
		System.out.println("=============================================================================================================");
		for (CustomerAllVO cav : customerAllList) {
			System.out.println(cav.toString());
		}
		System.out.println();
	}

	// 전체 주문리스트를 출력진행
	public void printCustomerList(ArrayList<CustomerVO> customerList) {
		System.out.println();
		System.out.printf("%-7s %-13s %-13s %-10s %-12s %-13s %-10s\n",
				"고객번호", "고객이름", "ID", "PW", "생년월일", "전화번호", "주문번호");
		System.out.println("=============================================================================================================");
		for (CustomerVO cvo : customerList) {
			System.out.println(cvo.toString());
		}
		System.out.println();
	}
}
