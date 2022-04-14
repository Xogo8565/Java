package com.fb;

import java.util.ArrayList;
import java.util.Scanner;

import com.fb.comment.CommentDAO;
import com.fb.comment.CommentDTO;
import com.fb.member.MemberDAO;
import com.fb.member.MemberDTO;
import com.fb.post.PostDAO;
import com.fb.post.PostDTO;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //객체 연결
        MemberDAO memberDAO = MemberDAO.getInstance();
        PostDAO postDAO = PostDAO.getInstance();
        CommentDAO commentDAO = CommentDAO.getInstance();

        //회원가입
        while (true) {
            System.out.println("==FACE  BOOK==");
            System.out.println("Wlecome !!");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.print("3. 프로그램 종료\n>> ");
            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {//로그인
                System.out.print("id입력 >>");
                String id = sc.nextLine();
                System.out.print("pw입력 >>");
                String pw = sc.nextLine();
                try { //로그인 가능 여
                    if (memberDAO.login(id,pw)) {
                        String nickname = memberDAO.getNickname(id);
                        System.out.println("*** 환영합니다 ***");
                        while (true) {
                            System.out.println("\n1. 포스트 등록\n2. 포스트 목록\n3. 포스트 확인\n4. 포스트 수정\n5. 포스트 삭제\n6. 로그아웃");
                            menu = Integer.parseInt(sc.nextLine());
                            if (menu == 1) {
                                System.out.println("===포스트 등록===");
                                String title;
                                String content;

                                while (true) {
                                    System.out.println("타이틀을 입력해주세요(10자 이내) >> ");
                                    title = sc.nextLine();
                                    if (title.length() > 10) {
                                        System.out.println("타이틀은 10자 이내로 입력해주세요");
                                    } else break;
                                }

                                while (true) {
                                    System.out.println("내용을 입력해주세요(100자 이내) >>");
                                    content = sc.nextLine();
                                    if (content.length() > 100) {
                                        System.out.println("내용은 100자 이내로 입력해주세요");
                                    } else break;
                                }

                                int rs = postDAO.createPost(new PostDTO(0, title, content, nickname, null));
                                if (rs > 0) System.out.println("포스트 등록 완료");
                                else System.out.println("포스트 등록에 실패했습니다.");

                            } else if (menu == 2) {
                                System.out.println("===포스트 목록 ===\n글번호\t타이틀\t닉네임\t등록일");
                                ArrayList<PostDTO> arrayList = postDAO.postList();

                                for (PostDTO postDTO : arrayList) {
                                    System.out.println(postDTO.toStringlist());
                                }

                            } else if (menu == 3) {

                                System.out.println("===포스트 목록 ===\n글번호\t타이틀\t닉네임\t등록일");

                                ArrayList<PostDTO> arrayList = postDAO.postList();
                                for (PostDTO postDTO : arrayList) {
                                    System.out.println(postDTO.toStringlist());
                                }

                                System.out.print("확인할 포스트의 번호를 입력하세요 >>");
                                int no = Integer.parseInt(sc.nextLine());

                                PostDTO rs = postDAO.readPost(no);

                                if (rs != null) {
                                    System.out.println(rs.toStringPost());
                                    System.out.println("\n=== 댓글 목록 ===\n댓글내용\t\t닉네임\t작성일");
                                    ArrayList<CommentDTO> commentDTOS = commentDAO.readComment(no);
                                    for (CommentDTO commentDTO : commentDTOS) {
                                        System.out.println(commentDTO.toString());
                                    }

                                    System.out.println("\n1.댓글 등록\n2.메뉴로 돌아가기\n>> ");
                                    menu = Integer.parseInt(sc.nextLine());

                                    if (menu == 1) {
                                        System.out.print("댓글 입력(50자 이내) >>");
                                        String comment = sc.nextLine();
                                        if (comment.length() > 50) System.out.println("댓글은 50자 이내로 입력해주세요");
                                        else {
                                            int commentRs = commentDAO.createComment(new CommentDTO(0, rs.getNo(), comment, nickname, null));
                                            if (commentRs > 0) System.out.println("댓글 등록에 성공했습니다.");
                                            else System.out.println("댓글 등록에 실패했습니다.");
                                        }
                                    } else if (menu == 2) {
                                        continue;
                                    }
                                } else System.out.println("존재하지 않는 포스트입니다.");

                            } else if (menu == 4) {
                                System.out.println("===포스트 목록 ===\n글번호\t타이틀\t닉네임\t등록일");

                                ArrayList<PostDTO> arrayList = postDAO.postList();
                                for (PostDTO postDTO : arrayList) {
                                    System.out.println(postDTO.toStringlist());
                                }

                                System.out.print("수정할 포스트 번호를 입력하세요 >>");
                                int no = Integer.parseInt(sc.nextLine());
                                String title;
                                String content;

                                while (true) {
                                    System.out.println("수정할 타이틀(10자 이내) >>");
                                    title = sc.nextLine();
                                    if (title.length() > 10) {
                                        System.out.println("타이틀은 10자 이내로 입력해주세요");
                                    } else break;
                                }

                                while (true) {
                                    System.out.println("내용을 입력해주세요(100자 이내) >>");
                                    content = sc.nextLine();
                                    if (content.length() > 100) {
                                        System.out.println("내용은 100자 이내로 입력해주세요");
                                    } else break;
                                }

                                int rs = postDAO.updatePost(new PostDTO(no, title, content, nickname, null));
                                if (rs > 0) System.out.println("포스트 수정 완료");
                                else System.out.println("포스트 수정에 실패했습니다.");


                            } else if (menu == 5) {
                                System.out.println("===포스트 목록 ===\n글번호\t타이틀\t닉네임\t등록일");

                                ArrayList<PostDTO> arrayList = postDAO.postList();
                                for (PostDTO postDTO : arrayList) {
                                    System.out.println(postDTO.toStringlist());
                                }

                                System.out.print("삭제할 포스트 번호를 입력하세요 >>");
                                int no = Integer.parseInt(sc.nextLine());
                                System.out.print("정말로 삭제하시겠습니까? >>");
                                String yn = sc.nextLine();
                                if (yn.equalsIgnoreCase("y")) {
                                    int rs = postDAO.deletePost(no);
                                    if (rs > 0) System.out.println("삭제가 완료되었습니다.");
                                    else System.out.println("삭제에 실패했습니다.");
                                } else if (yn.equalsIgnoreCase("n")) {
                                    System.out.println("삭제를 중단합니다.");
                                }

                            } else if (menu == 6) {
                                System.out.println("로그아웃합니다.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("아이디랑 비밀번호를 확인해주세요 ");
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (menu == 2) {//회원가입
                System.out.print("id입력  >>");
                String id = sc.nextLine();
                try {//아이디 체크
                    boolean idCheck = memberDAO.memberCheck(id);
                    if (idCheck = true) {//아이디 체크
                        System.out.println("사용가능한 아이디 입니다");
                        System.out.print("pw 입력>>");
                        String pw = sc.nextLine();
                        System.out.print("닉네임 입력>>");
                        String nickName = sc.nextLine();
                        boolean nickCheck = memberDAO.nicknameCheck(nickName);
                        if (nickCheck = true) {//닉네임 체크
                            System.out.println("사용가능한 닉네임 입니다");
                            MemberDTO dto = new MemberDTO(0, id, pw, nickName);
                            int rs = memberDAO.signUp(dto);
                            if (rs > 0) {//회원가입
                                System.out.println("회원가입에 성공하였습니다");
                            } else if (rs <= 0) {
                                System.out.println("회원가입에 실패하였습니다");
                            }
                        } else if (nickCheck = false) {
                            System.out.println("존재하는 닉네임입니다. 다른 닉네임을 입력해주세요.");
                        }
                    } else if (idCheck = true) {
                        System.out.println("존재하는 아이디 입니다. 다른 아이디를 입력해주세요");
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } else if (menu == 3) {
                break;

            } else {
                System.out.println("잘못된 조작입니다.");

            }

        }


    }
}