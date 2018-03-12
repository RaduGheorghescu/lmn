package ro.pub.lmn.entity.dto;

import java.util.Date;

public class ProjectDTO {
    private Long id;

    private String title;

    private String shortDescription;

    private Date startDate;

    private Date endDate;

    private Double budget;

    private String projectWebsite;

    private String description;

    public ProjectDTO(Long id, String title, String shortDescription, Date startDate, Date endDate, Double budget, String projectWebsite, String description) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.projectWebsite = projectWebsite;
        this.description = description;
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
}
