package com.example.obrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad de nombre book
 * atributos:
 * id
 * title
 * author
 * page
 * price
 * releaseDate
 * online
 */
@Entity
@Table(name = "books")
@ApiModel("BOOK: entidad libro que respensenta un elemento hecho de papel y tinta con portada de plastico")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty("Nombre del libro")
    private String title;
    @ApiModelProperty("Nombre del autor del libro")
    private String author;
    private Integer numPages;
    private Double price;
    private LocalDate releaseDate;
    private Boolean online;

//    CONSTRUCTORS

    public Book() {
    }

    public Book(Integer id, String title, String author, Integer numPages, Double price, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

//    GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

//    TO STRING

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}

