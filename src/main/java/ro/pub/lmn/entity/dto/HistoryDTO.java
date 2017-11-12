package ro.pub.lmn.entity.dto;

/**
 * Created by radug on 11/7/2017.
 */
public class HistoryDTO {

    private Long id;

    private String Title;

    private String Description;

    private int start;

    private int stop;

    public HistoryDTO() {
    }

    public HistoryDTO(Long id, String title, String description, int start, int stop) {
        this.id = id;
        Title = title;
        Description = description;
        this.start = start;
        this.stop = stop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
