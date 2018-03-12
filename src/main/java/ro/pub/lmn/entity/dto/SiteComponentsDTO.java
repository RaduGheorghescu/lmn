package ro.pub.lmn.entity.dto;

public class SiteComponentsDTO {

    private String component;
    private String content;

    public SiteComponentsDTO() {
    }

    public SiteComponentsDTO(Long id, String component, String content) {
        this.component = component;
        this.content = content;
    }


    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
