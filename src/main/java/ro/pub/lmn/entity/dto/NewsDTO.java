package ro.pub.lmn.entity.dto;

import ro.pub.lmn.entity.User;
import ro.pub.lmn.enumm.NewsState;

import java.util.Date;

public class NewsDTO {
    private Long id;

    private String title;

    private String content;

    private Date publicationDate;

    private NewsState newsState;

    private User author;

    public NewsDTO() {
    }

    public NewsDTO(Long id, String title, String content, Date publicationDate, NewsState newsState, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.newsState = newsState;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public NewsState getNewsState() {
        return newsState;
    }

    public void setNewsState(NewsState newsState) {
        this.newsState = newsState;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
