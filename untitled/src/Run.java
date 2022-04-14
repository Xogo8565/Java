
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LaptopDAO dao = new LaptopDAO();

        // 노트북 재고관리 프로그램
        while (true) {
            System.out.println("◎◎◎ 노트북 재고 관리 프로그램 ◎◎◎");
            System.out.println("① 노트북 등록");
            System.out.println("② 노트북 조회");
            System.out.println("③ 프로그램 종료");
            System.out.print("메뉴 선택 ▶ ");
            String menu = sc.nextLine();

            if (menu.equals("1")) { // 노트북 등록
                while (true) {
                    System.out.println("● 노트북 등록 ●");
                    System.out.print("노트북 이름 입력 ▶ ");
                    String name = sc.nextLine();

                    try {
                        if (!dao.checkName(name)) { // 중복된 이름이면 false
                            System.out.println("이미 등록된 이름이 존재합니다. 다시 입력하세요.");
                            continue;
                        }
                        // 사용 가능한 이름이면 true
                        System.out.print("노트북 가격 입력 ▶ ");
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.print("노트북 제조년월 입력 (99/01/01 형식) ▶ ");
                        String mfd = sc.nextLine(); // mfd : manufacture date

                        int rs = dao.register(new LaptopDTO(0, name, price, mfd));
                        if (rs <= 0) { // 노트북 정상 등록 안됨.
                            continue;
                        }
                        System.out.println("노트북이 정상적으로 등록되었습니다.");
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("에러가 발생하였습니다. 잠시 후 다시 시도해주세요.");
                    }
                }
            } else if (menu.equals("2")) { // 노브툭 조회
                System.out.println("① 노트북 no로 조회");
                System.out.println("② 노트북 전체 조회");
                menu = sc.nextLine();

                if (menu.equals("1")) { // 노트북 no 입력받아 조회
                    while (true) {
                        System.out.print("노트북 no 입력 ▶ ");
                        int no = Integer.parseInt(sc.nextLine());

                        try {
                            LaptopDTO dto = dao.selectByNo(no);
                            if (dto == null) {
                                System.out.println("입력한 번호에 해당하는 노트북이 없습니다.");
                                continue;
                            }

                            System.out.println("번호\t이름\t가격\t제조일자");
                            System.out.println(dto.toString());
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("에러가 발생하였습니다. 잠시 후 다시 시도해주세요.");
                        }
                    }
                } else if (menu.equals("2")) {
                    try {
                        ArrayList<LaptopDTO> list = dao.selectAll();

                        if(list.size() == 0) {
                            System.out.println("등록된 노트북이 없습니다.");
                            continue;
                        }
                        System.out.println("번호\t이름\t가격\t제조일자");
                        for (LaptopDTO dto : list) {
                            System.out.println(dto.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("에러가 발생하였습니다. 잠시 후 다시 시도해주세요.");
                    }
                }
            } else if (menu.equals("3")) { // 프로그램 종료
                System.out.println("프로그램을 종료합니다 B-Y-E");
                break;
            }
        }
    }
}