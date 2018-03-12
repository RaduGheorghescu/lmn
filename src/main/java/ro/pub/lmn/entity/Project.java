package ro.pub.lmn.entity;

import ro.pub.lmn.annotations.Language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String shortDescription;

    private Date startDate;

    private Date endDate;

    private Double budget;

    private String projectWebsite;

    private String description;

    @Language(language = "ro", DTOField = "title")
    private String titleRO;

    @Language(language = "ro", DTOField = "shortDescription")
    private String shortDescriptionRO;

    @Language(language = "ro", DTOField = "description")
    private String descriptionRO;

    public Project(String title, String shortDescription, Date startDate, Date endDate, Double budget, String projectWebsite, String description, String titleRO, String shortDescriptionRO, String descriptionRO) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.projectWebsite = projectWebsite;
        this.description = description;
        this.titleRO = titleRO;
        this.shortDescriptionRO = shortDescriptionRO;
        this.descriptionRO = descriptionRO;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getProjectWebsite() {
        return projectWebsite;
    }

    public void setProjectWebsite(String projectWebsite) {
        this.projectWebsite = projectWebsite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleRO() {
        return titleRO;
    }

    public void setTitleRO(String titleRO) {
        this.titleRO = titleRO;
    }

    public String getShortDescriptionRO() {
        return shortDescriptionRO;
    }

    public void setShortDescriptionRO(String shortDescriptionRO) {
        this.shortDescriptionRO = shortDescriptionRO;
    }

    public String getDescriptionRO() {
        return descriptionRO;
    }

    public void setDescriptionRO(String descriptionRO) {
        this.descriptionRO = descriptionRO;
    }
}
