package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class BoardMain {

	private IBoardService boardService;

	private Scanner scan = new Scanner(System.in);


	public BoardMain() {
		boardService = BoardServiceImpl.getInstance();
	}

	/**
	 *   작업 출력
	 */
	public void boardMenu() {
		System.out.println();
		System.out.println("*******************************************");
		System.out.println(" 게시판 작업 선택 ");
		System.out.println("*******************************************");
		System.out.println("1.새로운 게시판 작성");
		System.out.println("2.게시판 수정");
		System.out.println("3.게시판 삭제");
		System.out.println("4.게시판 검색");
		System.out.println("5.전체 목록 출력");
		System.out.println("6.원하는 작업 종료");
		System.out.println("*******************************************");
		System.out.print(" 원하는 작업 선택 >> ");
	}

	public void startBoard() {

		int choice;

		do {
			boardMenu();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				newBoard();
				break;
			case 2:
				editBoard();
				break;
			case 3:
				deleteBoard();
				break;
			case 4:
				searchBoard();
				break;
			case 5:
				listUpAll();
				break;
			case 6:
				closeBoard();
				break;

			default:
				System.out.println("잘못된 선택입니다.");
				System.out.println("다시 선택해주세요.");

			}
		} while (choice != 6);
	}

	private void closeBoard() {
		System.out.println();
		System.out.println("게시판 작성을 종료합니다.");

	}

	private void listUpAll() {
		System.out.println("---------------------------------------------------");
		System.out.println(" No\t제 목\t작성자\t\t내 용");
		System.out.println("---------------------------------------------------");

		List<BoardVO> bdList = boardService.listUpAll();

		if (bdList.size() == 0) {
			System.out.println("작성된 게시물이 없습니다.");
		} else {
			for (BoardVO bv : bdList) {
				System.out.println(bv.getBdNo() + "\t" + bv.getBdTtl() + "\t" + bv.getBdWtr() + "\t\t" + bv.getBdCnt());
			}
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("작업을 완료합니다.");

	}

	private void searchBoard() {
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.println();
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("게시판번호 >> ");
		int bdNo = scan.nextInt();

		System.out.print("게시판 제목 >> ");
		String bdTtl = scan.nextLine().trim();

		System.out.print("게시판 작성자 >> ");
		String bdWtr = scan.nextLine().trim();

		System.out.print("게시판 내용 >> ");
		String bdCnt = scan.nextLine().trim();

		BoardVO bv = new BoardVO();
		bv.setBdNo(bdNo);
		bv.setBdTtl(bdTtl);
		bv.setBdWtr(bdWtr);
		bv.setBdCnt(bdCnt);

		List<BoardVO> bdList = boardService.searchBoard(bv);

		System.out.println("-----------------------------------------");
		System.out.println(" No\t제 목\t작성자\t\t내 용");
		System.out.println("-----------------------------------------");

		if (bdList.size() == 0) {
			System.out.println("검색된 게시판이 없습니다.");
		} else {
			for(BoardVO bv2 : bdList) {
				System.out.println(bv2.getBdNo() + "\t" + bv2.getBdTtl() + "\t" + bv2.getBdWtr() + "\t\t" + bv2.getBdCnt());
			}
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("검색 작업을 완료합니다.");
	}

	private void deleteBoard() {
		
		System.out.println();
		System.out.println("삭제할 게시판 정보를 입력하세요.");
		System.out.print("게시판 번호 >> ");

		int bdNo = scan.nextInt();

		int cnt = boardService.deleteBoard(bdNo);

		if (cnt > 0) {
			System.out.println(bdNo + "게시판 삭제를 성공했습니다.");
		} else {
			System.out.println(bdNo + "게시판 삭제를 실페했습니다.");
		}

	}

	
	private void editBoard() {
		System.out.println("게시판 번호를 입력해주세여");
		int bdNo = scan.nextInt();
		scan.nextLine(); // 입력 버퍼 비우기

		System.out.print("게시판 제목>> ");
		String bdTtl = scan.nextLine().trim();

		
		System.out.print("작성자 >> ");
		String bdWtr = scan.nextLine().trim();

		System.out.print("게시판 내용 >> ");
		String bdCnt = scan.nextLine().trim();

		BoardVO bv = new BoardVO();
		bv.setBdNo(bdNo);
		bv.setBdTtl(bdTtl);
		bv.setBdWtr(bdWtr);
		bv.setBdCnt(bdCnt);

		int cnt = boardService.editBoard(bv);

		if (cnt > 0) {
			System.out.println(bdNo + "게시판 수정을 완료했습니다.");
		} else {
			System.out.println(bdNo + "게시판 수정을 완료했습니다.");
		}
	}

	private void newBoard() {

		scan.nextLine(); // 입력버퍼 비우기

		System.out.print("게시판 제목>> ");
		String bdTtl = scan.nextLine();

		System.out.print("작성자 >> ");
		String bdWtr = scan.nextLine();

		System.out.print("게시판 내용 >> ");
		String bdCnt = scan.nextLine();

		BoardVO bv = new BoardVO();
		bv.setBdTtl(bdTtl);
		bv.setBdWtr(bdWtr);
		bv.setBdCnt(bdCnt);

		int cnt = boardService.registerBoard(bv);

		if (cnt > 0) {
			System.out.println(bv.getBdWtr() + "님의 게시판 등록을 성공하였습니다.");
		} else {
			System.out.println(bv.getBdWtr() + "님의 게시판 등록을 실패하였습니다.");

		}

	}

	private boolean checkBoard(int bdNo) {

		boolean isExist = boardService.checkBoard(bdNo);

		return isExist;
	}

	public static void main(String[] args) {
		BoardMain bm = new BoardMain();
		bm.startBoard();

	}

}
