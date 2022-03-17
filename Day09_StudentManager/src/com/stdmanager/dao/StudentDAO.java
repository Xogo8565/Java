package com.stdmanager.dao;

import com.stdmanager.dto.StudentDTO;

public class StudentDAO {
    private StudentDTO[] students = new StudentDTO[10];
    private int index = 0;

    public void insert(StudentDTO std){
        students[index++] = std;
    }

    public StudentDTO[] selectAll(){
        return students;
    }

    public void delete(int deleteNum){
        for(int i = 0; i< students.length; i++){
            if(students[deleteNum]!=null && students[deleteNum]== students[i]){
                students[deleteNum ]= null;
                System.out.println("삭제가 완료되었습니다.");
                break;
            } else if(students[deleteNum]==null) {
                System.out.println("존재하지 않는 학생입니다.");
                break;
            }
        }
    }

    public void modify(StudentDTO std){
        for(int i = 0; i< students.length; i++){
            if(students[i].getNo()== std.getNo()&& students[i]!=null){
                students[i].setName(std.getName());
                students[i].setAge(std.getAge());
                students[i].setGender(std.getGender());
                break;
            }
        }
    }
}
