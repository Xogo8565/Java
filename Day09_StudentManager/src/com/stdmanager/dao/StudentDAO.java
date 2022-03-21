package com.stdmanager.dao;

import com.stdmanager.dto.StudentDTO;

import java.util.ArrayList;

public class StudentDAO {
    private ArrayList students = new ArrayList<>();

    public void insert(StudentDTO std){
        students.add(std);
    }

    public ArrayList selectAll(){
        return students;
    }

    public void delete(int deleteNum){
        for(int i = 0; i<students.size(); i++){
            if(((StudentDTO)students.get(i)).getNo() == deleteNum){
                students.remove(i);
                break;
            }
        }
    }

    public void modify(int modifyNum, StudentDTO std){
        for(int i = 0; i<students.size(); i++){
            if(((StudentDTO)students.get(i)).getNo() == modifyNum){
//                students.set(modifyNum, std); // 새로운 StudentDTO 형 인스턴스로 갈아끼우는 작업
                ((StudentDTO)students.get(i)).setName(std.getName());
                ((StudentDTO)students.get(i)).setAge(std.getAge());
                ((StudentDTO)students.get(i)).setGender(std.getGender());
                break;
            }
        }
    }
}
