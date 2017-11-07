package ro.pub.lmn.entity;

import ro.pub.lmn.annotations.Language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by radug on 11/2/2017.
 */
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int start;

    private int stop;

    @Language(DTOField = "Title")
    private String Title;

    @Language(DTOField = "Description")
    private String Description;

    @Language(language = "ro",DTOField = "Title")
    private String TitleRO;

    @Language(language = "ro",DTOField = "Description")
    private String DescriptionRO;

    public History() {
    }

    public History(int start, int stop, String title, String description, String titleRO, String descriptionRO) {
        this.start = start;
        this.stop = stop;
        Title = title;
        Description = description;
        TitleRO = titleRO;
        DescriptionRO = descriptionRO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitleRO() {
        return TitleRO;
    }

    public void setTitleRO(String titleRO) {
        TitleRO = titleRO;
    }

    public String getDescriptionRO() {
        return DescriptionRO;
    }

    public void setDescriptionRO(String descriptionRO) {
        DescriptionRO = descriptionRO;
    }
}
