package com.example.assignment2kyled_seongwonc.model;

public class MovieModel {
    String Title;
    String Year;
    String Type;
    String Poster;

public MovieModel(String Title, String Year, String Type, String Poster){

    this.Title = Title;
    this.Year = Year;
    this.Type = Type;
    this.Poster = Poster;

}


    public String getTitle() { return Title; }
    public void setTitle(String title){this.Title = title;}
    public String getYear() { return Year; }
    public void setYear(String year){this.Year = year;}
    public String getType() { return Type; }
    public void setType(String type) { this.Type = type; }
    public String getPoster() { return Poster; }
    public void setPoster(String poster){ this.Poster = poster;}




}
