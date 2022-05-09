import java.io.*;
import java.util.StringTokenizer;

public class Buffer {
    public static void main(String[] args) throws IOException {
        //IOException 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //버퍼를 통해 입력값을 묶어서 한 번에 보내는 방식
        String str1 = br.readLine(); // 엔터단위로 인식
        int i = Integer.parseInt(br.readLine()); //int 형변환
        System.out.println(str1);
        System.out.println(i);

//
//      공백단위로 인식할 때

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str2 = st.nextToken();
        System.out.println(str2);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(str1);
        bw.newLine(); // 안하면 1줄로 이어져서 출력됨.
        bw.flush(); // 버퍼에 남아있는 것들 내보내는 과정
        bw.close();
    }
}
