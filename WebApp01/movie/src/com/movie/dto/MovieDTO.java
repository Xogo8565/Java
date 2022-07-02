package com.movie.dto;

public class MovieDTO {
   private String movieCd;
   private String movieNm;
   private String movieNmEn;
   private String prdtYear;
   private String nationAlt;
   private String genreAlt;
   private String directors;

   public MovieDTO() {
   }

   public MovieDTO(String movieCd, String movieNm, String movieNmEn, String prdtYear, String nationAlt, String genreAlt, String directors) {
      this.movieCd = movieCd;
      this.movieNm = movieNm;
      this.movieNmEn = movieNmEn;
      this.prdtYear = prdtYear;
      this.nationAlt = nationAlt;
      this.genreAlt = genreAlt;
      this.directors = directors;
   }

   public String getMovieCd() {
      return movieCd;
   }

   public void setMovieCd(String movieCd) {
      this.movieCd = movieCd;
   }

   public String getMovieNm() {
      return movieNm;
   }

   public void setMovieNm(String movieNm) {
      this.movieNm = movieNm;
   }

   public String getMovieNmEn() {
      return movieNmEn;
   }

   public void setMovieNmEn(String movieNmEn) {
      this.movieNmEn = movieNmEn;
   }

   public String getPrdtYear() {
      return prdtYear;
   }

   public void setPrdtYear(String prdtYear) {
      this.prdtYear = prdtYear;
   }

   public String getNationAlt() {
      return nationAlt;
   }

   public void setNationAlt(String nationAlt) {
      this.nationAlt = nationAlt;
   }

   public String getGenreAlt() {
      return genreAlt;
   }

   public void setGenreAlt(String genreAlt) {
      this.genreAlt = genreAlt;
   }

   public String getDirectors() {
      return directors;
   }

   public void setDirectors(String directors) {
      this.directors = directors;
   }
}
