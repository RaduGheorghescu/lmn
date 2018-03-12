package ro.pub.lmn.entity;

import ro.pub.lmn.annotations.Language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SiteComponents {
    @Id
    private String component;
    private String content;

    @Language(language = "ro", DTOField = "content")
    private String contentRo;

    public SiteComponents() {
    }

    public SiteComponents(String component, String content, String contentRo) {
        this.component = component;
        this.content = content;
        this.contentRo = contentRo;
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

    public String getContentRo() {
        return contentRo;
    }

    public void setContentRo(String contentRo) {
        this.contentRo = contentRo;
    }
}
