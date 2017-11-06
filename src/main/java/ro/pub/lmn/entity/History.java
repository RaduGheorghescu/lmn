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

    @Language(DTOField = "Title")
    private String Title;

    @Language(DTOField = "Description")
    private String Description;

    @Language(language = "RO",DTOField = "Title")
    private String TitleRO;

    @Language(language = "RO",DTOField = "Description")
    private String DescriptionRO;
}
