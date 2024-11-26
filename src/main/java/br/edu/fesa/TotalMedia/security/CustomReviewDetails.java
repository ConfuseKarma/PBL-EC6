/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.security;

/**
 *
 * @author kauem
 */
public class CustomReviewDetails {

    private Integer reviewId;
    private Integer rating;
    private String comment;
    private String movieTitle;
    private String movieDescription;
    private String userName;
    private String userEmail;

    // Construtor
    public CustomReviewDetails(Integer reviewId, Integer rating, String comment, String movieTitle, String movieDescription, String userName, String userEmail) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters and setters

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}