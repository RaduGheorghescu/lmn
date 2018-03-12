package ro.pub.lmn.entity;

import ro.pub.lmn.annotations.Language;
import ro.pub.lmn.enumm.NewsState;

import javax.persistence.*;
import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private Date publicationDate;

    private NewsState newsState;

    @ManyToOne
    private User author;

    @Language(language = "ro", DTOField = "title")
    private String titleRO;

    @Language(language = "ro", DTOField = "content")
    private String contentRo;

    public News() {
    }

    public News(String title, String content, Date publicationDate, NewsState newsState, User author, String titleRO, String contentRo) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.newsState = newsState;
        this.author = author;
        this.titleRO = titleRO;
        this.contentRo = contentRo;
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

    public String getTitleRO() {
        return titleRO;
    }

    public void setTitleRO(String titleRO) {
        this.titleRO = titleRO;
    }

    public String getContentRo() {
        return contentRo;
    }

    public void setContentRo(String contentRo) {
        this.contentRo = contentRo;
    }
}