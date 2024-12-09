//package productMVCProject;
//
//import java.util.Scanner;
//import productMVCProject.controller.CustomerRegisterManager;
//import productMVCProject.controller.OrderRegisterManager;
//import productMVCProject.controller.ProductRegisterManager;
//import productMVCProject.view.CUSTOMER_CHOICE;
//import productMVCProject.view.MENU_CHOICE;
//import productMVCProject.view.MenuViewer;
//import productMVCProject.view.ORDER_CHOICE;
//import productMVCProject.view.PRODUCT_CHOICE;
//
//public class ProductMain {
//	public static Scanner sc = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		int no;
//		boolean exitFlag = false;
//		while (!exitFlag) {
//			try {
//				MenuViewer.mainMenuView();
//				no = Integer.parseInt(sc.nextLine());
//				switch (no) {
//				case MENU_CHOICE.PRODUCT:
//					productMenu();
//					break;
//				case MENU_CHOICE.ORDER:
//					orderMenu();
//					break;
//				case MENU_CHOICE.CUSTOMER:
//					customerMenu();
//					break;
//				case MENU_CHOICE.EXIT:
//					System.out.println("프로그램을 종료합니다.");
//					exitFlag = true;
//					break;
//				default:
//					System.out.println("해당 메뉴 번호만 입력하세요.");
//				}
//			} catch (NumberFormatException e) {
//				System.out.println("숫자 형식으로 입력해주세요.");
//			} catch (Exception e) {
//				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
//			}
//		} // end of file
//	}
//
//	// 재고정보
//	public static void productMenu() {
//		int no;
//		ProductRegisterManager prm = new ProductRegisterManager();
//		MenuViewer.productMenuView();
//		no = Integer.parseInt(sc.nextLine());
//		switch (no) {
//		case PRODUCT_CHOICE.LIST:
//			System.out.println("");
//			prm.selectManager();
//			break;
//		case PRODUCT_CHOICE.INSERT:
//			System.out.println("");
//			prm.insertManager();
//			break;
//		case PRODUCT_CHOICE.UPDATE:
//			System.out.println("");
//			prm.updateManager();
//			break;
//		case PRODUCT_CHOICE.DELETE:
//			System.out.println("");
//			prm.deleteManager();
//			break;
//		case PRODUCT_CHOICE.SORT:
//			System.out.println("");
//			prm.sortManager();
//			break;
//		case PRODUCT_CHOICE.MAIN:
//			return;
//		default:
//			System.out.println("해당 메뉴 번호만 입력하세요.");
//		}
//	}
//
//	// 주문정보
//	public static void orderMenu() {
//		int no;
//		OrderRegisterManager orm = new OrderRegisterManager();
//		MenuViewer.orderMenuView();
//		no = Integer.parseInt(sc.nextLine());
//		switch (no) {
//		case ORDER_CHOICE.LIST_ALL:
//			System.out.println("");
//			orm.selectAllManager();
//			break;
//		case ORDER_CHOICE.INSERT:
//			System.out.println("");
//			orm.insertManager();
//			break;
//		case ORDER_CHOICE.UPDATE:
//			System.out.println("");
//			orm.updateManager();
//			break;
//		case ORDER_CHOICE.DELETE:
//			System.out.println("");
//			orm.deleteManager();
//			break;
//		case ORDER_CHOICE.SORT:
//			System.out.println("");
//			orm.sortManager();
//			break;
//		case ORDER_CHOICE.MAIN:
//			return;
//		default:
//			System.out.println("해당 메뉴 번호만 입력하세요.");
//		}
//	}
//
//	// 고객정보
//	public static void customerMenu() {
//		int no;
//		CustomerRegisterManager crm = new CustomerRegisterManager();
//		MenuViewer.customerMenuView();
//		no = Integer.parseInt(sc.nextLine());
//		switch (no) {
//		case CUSTOMER_CHOICE.LIST_ALL:
//			System.out.println("");
//			crm.selectAllManager();
//			break;
//		case CUSTOMER_CHOICE.INSERT:
//			System.out.println("");
//			crm.insertManager();
//			break;
//		case CUSTOMER_CHOICE.UPDATE:
//			System.out.println("");
//			crm.updateManager();
//			break;
//		case CUSTOMER_CHOICE.DELETE:
//			System.out.println("");
//			crm.deleteManager();
//			break;
//		case CUSTOMER_CHOICE.SORT:
//			System.out.println("");
//			crm.sortManager();
//			break;
//		case CUSTOMER_CHOICE.MAIN:
//			return;
//		default:
//			System.out.println("해당 메뉴 번호만 입력하세요.");
//		}
//	}
//}
package productMVCProject;

import java.util.Scanner;

import productMVCProject.controller.CustomerRegisterManager;
import productMVCProject.controller.OrderRegisterManager;
import productMVCProject.controller.ProductRegisterManager;
import productMVCProject.view.CUSTOMER_CHOICE;
import productMVCProject.view.MENU_CHOICE;
import productMVCProject.view.MenuViewer;
import productMVCProject.view.ORDER_CHOICE;
import productMVCProject.view.PRODUCT_CHOICE;

public class ProductMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MENU_CHOICE.PRODUCT:
					productMenu();
					break;
				case MENU_CHOICE.ORDER:
					orderMenu();
					break;
				case MENU_CHOICE.CUSTOMER:
					customerMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		} // end of file
	}

	// 재고정보
	public static void productMenu() {
		int no;
		ProductRegisterManager prm = new ProductRegisterManager();
		MenuViewer.productMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case PRODUCT_CHOICE.LIST:
			System.out.println("");
			prm.selectManager();
			break;
		case PRODUCT_CHOICE.INSERT:
			System.out.println("");
			prm.insertManager();
			break;
		case PRODUCT_CHOICE.UPDATE:
			System.out.println("");
			prm.updateManager();
			break;
		case PRODUCT_CHOICE.DELETE:
			System.out.println("");
			prm.deleteManager();
			break;
		case PRODUCT_CHOICE.SORT:
			System.out.println("");
			prm.sortManager();
			break;
		case PRODUCT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// 주문정보
	public static void orderMenu() {
		int no;
		OrderRegisterManager orm = new OrderRegisterManager();
		MenuViewer.orderMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case ORDER_CHOICE.LIST:
			System.out.println("");
			orm.selectAllManager();
			break;
		case ORDER_CHOICE.INSERT:
			System.out.println("");
			orm.insertManager();
			break;
		case ORDER_CHOICE.UPDATE:
			System.out.println("");
			orm.updateManager();
			break;
		case ORDER_CHOICE.DELETE:
			System.out.println("");
			orm.deleteManager();
			break;
		case ORDER_CHOICE.SORT:
			System.out.println("");
			orm.sortManager();
			break;
		case ORDER_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// 고객정보
	public static void customerMenu() {
		int no;
		CustomerRegisterManager crm = new CustomerRegisterManager();
		MenuViewer.customerMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case CUSTOMER_CHOICE.LIST:
			System.out.println("");
			crm.selectAllManager();
			break;
		case CUSTOMER_CHOICE.INSERT:
			System.out.println("");
			crm.insertManager();
			break;
		case CUSTOMER_CHOICE.UPDATE:
			System.out.println("");
			crm.updateManager();
			break;
		case CUSTOMER_CHOICE.DELETE:
			System.out.println("");
			crm.deleteManager();
			break;
		case CUSTOMER_CHOICE.SORT:
			System.out.println("");
			crm.sortManager();
			break;
		case CUSTOMER_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
}