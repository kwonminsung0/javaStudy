package com.kh.subjectMVCProject.controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.subjectMVCProject.model.LandPriceVO;


public class SubjectRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학과리스트를 출력요청
	public void selectManager() {
		ArrayList<LandPriceVO> subjectList = new ArrayList<LandPriceVO>();
		SubjectDAO subDAO = new SubjectDAO(); 
		subjectList = subDAO.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printSubjectList(subjectList); 
	}

	public void insertManager() {
		SubjectDAO sd = new SubjectDAO();
		ArrayList<LandPriceVO> subjectList = null;
		String num; // 학과 번호
		String name; // 학과명

		System.out.println("학과 전체 리스트");
		subjectList = sd.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		}else {
			printSubjectList(subjectList);			
		}

		System.out.println();
		System.out.println("학과 정보 입력(학과번호:01,02,03,04,05)학과명01(IT학과),02(정보학과), 03(보안), 04(프런트),05(백엔드)");
		System.out.print("학과번호>>");
		num = sc.nextLine();
		System.out.print("학과명>>");
		name = sc.nextLine();

		LandPriceVO svo = new LandPriceVO(num,name);
		boolean successFlag = sd.subjectInsert(svo);

		if(successFlag == false) {
			System.out.println("입력처리 실패");
			return;
		}
		System.out.println();
		System.out.println("학과 전체 리스트");
		subjectList = sd.subjectSelect();
		if(subjectList == null) {
			System.out.println("학과정보가 없습니다.");
			return;
		}
		printSubjectList(subjectList); 
	}

	public void updateManager() {
		SubjectDAO sd = new SubjectDAO();
		// 전체 학과리스트를 보여준다.
		ArrayList<LandPriceVO> subjectList = sd.subjectSelect();
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		printSubjectList(subjectList);
		// 학과번호, 수정할 학과 이름을 입력
		System.out.print("수정할 학과의 번호를 입력하세요: ");
		String num = (sc.nextLine()).trim();
		System.out.print("수정할 학과의이름을 입력하세요: ");
		String name = (sc.nextLine()).trim();
		
		LandPriceVO svo = new LandPriceVO(num, name);
		
		boolean successFlag = sd.subjectUpdate(svo);
		
		if(successFlag == true) {
			System.out.println("수정처리 성공");
		}else {
			System.out.println("수정처리 실패");
		}
	}

	public void deleteManager() {
		SubjectDAO sd = new SubjectDAO();
		System.out.print("삭제할 학과 번호를 입력하세요: ");
		String num = (sc.nextLine()).trim();
		LandPriceVO svo = new LandPriceVO();
		svo.setNum(num);
		boolean successFlag = sd.subjectDelete(svo);
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	public void sortManager() {
		SubjectDAO sd = new SubjectDAO();
		ArrayList<LandPriceVO> subjectList = null;
		subjectList =sd.subjectSort(); 
		if(subjectList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printSubjectList(subjectList); 
	}

	//전체 학생리스트를 출력진행
	public static void printSubjectList(ArrayList<LandPriceVO> subjectList) {
		System.out.println("============================================");
		for( LandPriceVO sv :  subjectList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}