/*
자바에서의 메서드 = 오라클에서는 함수
- 단일 행 함수 : 각 행마다 반복적으로 적용돼서 입력받은 행의 개수 만큼 결과를 반환

ex) length() -> 데이터의 길이값 반환

- 그룹 함수 : 특정한 행들의 집합으로 그룹이 형성되어 -> 그룹 당 1개의 결과를 반환

*/

-- 문자형 함수
-- lengthb() : 주어진 컬럼/ 문자열에 대한 길이(byte)로 변환해주는 함수
select emp_name, length(emp_name), lengthb(emp_name) from employee;

-- instr(컬럼/문자열, 찾고자 하는 문자(열), 시작 인덱스, 검색된 문자(열)의 순번) : 특정 문자열에서 찾고자 하는 문자열 위치를 찾아주는 함수 
-- 시작 인덱스에 음수값을 넣으면 뒤에서부터 탐색
-- dual 테이블 : 오라클에서 제공해주는 연산, 함수 실행 용도로 사용하는 특수한 테이블

select instr('Hello World Hi High', 'H', 1, 3) from dual;

-- employee 테이블에서 email, email  컬럼의 @ 위치를 조회

select email,instr(email, '@', 1, 1) from employee;

-- lpad() / rpad() : 주어진 컬럼/ 문자열을 대상으로 해서 임의의 문자열을 왼쪽 / 오른쪽에 덧붙여서 길이 N의 문자열을 반환하는 함수
select lpad(email, 20, '#') from employee;

-- ltrim(대상이 되는 컬럼/문자열, 제거하고 싶은 문자(열)) / rtrim()
-- 주어진 컬럼/ 문자열을 대상으로 제거하고 싶은 문자를 제거한 후 나머지를 반환하는 함수
-- 제거하고 싶은 문자열이 왼쪽(문자열의 시작)에 있을 때 rtrim 문자열의 오른쪽에 제거하고 싶은 문자열이 있을 때
select rtrim(email, 'kh.or.kr') from employee;
select ltrim(email, 'kh.or.kr') from employee;