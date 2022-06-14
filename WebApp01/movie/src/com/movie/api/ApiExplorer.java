package com.movie.api;/* Java 샘플 코드 */


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movie.dto.MovieDTO;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ApiExplorer {
    public ArrayList<MovieDTO> run(int no) throws IOException {
        // 1. URL
        String urlBuilder = "https://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json" + "?key=bd9be97f79ac9419f55520a622db6761" + "&itemPerPage=10" + "&curPage=" + no;
        URL url = new URL(urlBuilder);
        // 2. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 3. 통신을 위한 메소드 SET.
        connection.setRequestMethod("GET");
        // 4. 통신을 위한 Content-type SET.
        connection.setRequestProperty("Content-type", "application/json");
        // 5. 통신 응답 코드 확인.
        System.out.println("Response code: " + connection.getResponseCode());
        // 6. 전달받은 데이터를 BufferedReader 객체로 저장.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String result = bufferedReader.readLine();
        JsonParser jsonParser = new JsonParser();
        // 7. JsonObject 로 result -> parse
        JsonObject jsonObject = (JsonObject) jsonParser.parse(result);
        JsonObject movieInfoResult = (JsonObject) jsonObject.get("movieListResult");
        JsonArray movieInfo = (JsonArray) movieInfoResult.get("movieList");

        // 반환할 arrayList
        ArrayList<MovieDTO> arrayList = new ArrayList<>();

        //8. JsonArray 에서 값 가져오기
        for(int i = 0; i<movieInfo.size(); i++){
            JsonObject movies = (JsonObject) movieInfo.get(i);
            String movieCd = String.valueOf(movies.get("movieCd"));
            String movieNm = String.valueOf(movies.get("movieNm"));
            String movieNmEn = String.valueOf(movies.get("movieNmEn"));
            String prdtYear = String.valueOf(movies.get("prdtYear"));
            String openDt = String.valueOf(movies.get("openDt"));
//            String typeNm = String.valueOf(movies.get("typeNm"));
//            String prdtStatNm = String.valueOf(movies.get("prdtStatNm"));
//            String nationAlt = String.valueOf(movies.get("nationAlt"));
            String genreAlt = String.valueOf(movies.get("genreAlt"));
//            String repNationNm = String.valueOf(movies.get("repNationNm"));
//            String repGenreNm = String.valueOf(movies.get("repGenreNm"));
            JsonArray directors = (JsonArray) movies.get("directors");
//            JsonArray companys = (JsonArray) movies.get("companys");

            String peopleNm = "";
//            String companyCd = "";
//            String companyNm = "";

            for(int j = 0; j<directors.size(); j++){
                JsonObject directorObject = (JsonObject) directors.get(j);
                if(j < directors.size()-1){
                    peopleNm += quotesRemover(String.valueOf(directorObject.get("peopleNm")))+", ";
                } else {
                    peopleNm += quotesRemover(String.valueOf(directorObject.get("peopleNm")));
                }
            }
//            for(int j = 0; j<companys.size(); j++){
//                JsonObject compantObject = (JsonObject) companys.get(j);
//                companyCd += quotesRemover(String.valueOf(compantObject.get("companyCd")))+"\n";
//                companyNm += quotesRemover(String.valueOf(compantObject.get("companyNm")))+"\n";
//            }

            //"" 따옴표 제거
            movieCd = quotesRemover(movieCd);
            movieNm = quotesRemover(movieNm);
            movieNmEn = quotesRemover(movieNmEn);
            prdtYear = quotesRemover(prdtYear);
            openDt = quotesRemover(openDt);
//            typeNm = quotesRemover(typeNm);
//            prdtStatNm = quotesRemover(prdtStatNm);
//            nationAlt = quotesRemover(nationAlt);
            genreAlt = quotesRemover(genreAlt);
//            repNationNm = quotesRemover(repNationNm);
//            repGenreNm = quotesRemover(repGenreNm);

            arrayList.add(new MovieDTO(movieCd, movieNm, movieNmEn, prdtYear, openDt, genreAlt, peopleNm));
        }
        return arrayList;
    }

    public String quotesRemover(String str){
        return str.substring(1, str.length()-1);
    }
}