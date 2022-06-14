package com.movie.dto;

public class MovieDTO {
   private String movieCd;
   private String movieNm;
   private String movieNmEm;
   private String prdtStartYear;
   private String openDt;
   private String genreAlt;
   private String directors;

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

   public String getMovieNmEm() {
      return movieNmEm;
   }

   public void setMovieNmEm(String movieNmEm) {
      this.movieNmEm = movieNmEm;
   }

   public String getPrdtStartYear() {
      return prdtStartYear;
   }

   public void setPrdtStartYear(String prdtStartYear) {
      this.prdtStartYear = prdtStartYear;
   }

   public String getOpenDt() {
      return openDt;
   }

   public void setOpenDt(String openDt) {
      this.openDt = openDt;
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

   public MovieDTO() {
   }

   public MovieDTO(String movieCd, String movieNm, String movieNmEm, String prdtStartYear, String openDt, String genreAlt, String directors) {
      this.movieCd = movieCd;
      this.movieNm = movieNm;
      this.movieNmEm = movieNmEm;
      this.prdtStartYear = prdtStartYear;
      this.openDt = openDt;
      this.genreAlt = genreAlt;
      this.directors = directors;
   }

   @Override
   public String toString() {
      return "MovieDTO{" +
              "movieCd='" + movieCd + '\'' +
              ", movieNm='" + movieNm + '\'' +
              ", movieNmEm='" + movieNmEm + '\'' +
              ", prdtStartYear='" + prdtStartYear + '\'' +
              ", openDt='" + openDt + '\'' +
              ", genreAlt='" + genreAlt + '\'' +
              ", directors='" + directors + '\'' +
              '}';
   }
}
