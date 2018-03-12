package ro.pub.lmn.service;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import ro.pub.lmn.annotations.IgnoreEntityToDTO;
import ro.pub.lmn.annotations.Language;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by radug on 11/2/2017.
 */
@Component
public class EntityToDTOAndLanguageService {
    public Object DTOToEntity(Object DTO, Object entity){
        for(Field field : entity.getClass().getDeclaredFields()){
            try {
                if(DTO.getClass().getDeclaredField(field.getName()) != null && !field.isAnnotationPresent(Id.class) && !field.isAnnotationPresent(IgnoreEntityToDTO.class)){
                    Field fieldDTO = DTO.getClass().getDeclaredField(field.getName());
                    field.setAccessible(true);
                    fieldDTO.setAccessible(true);
                    field.set(entity, fieldDTO.get(DTO));
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println(field.getName() + " nu a fost gasit in DTO!");
            }
        }
        return entity;
    }
    public Object setLanguageForDTO(Object entity, Class DTO){
        String language = LocaleContextHolder.getLocale().getLanguage();
        Object DTOReturn = null;
        try {
            DTOReturn = DTO.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for(Field field : entity.getClass().getDeclaredFields()){
            try {
//                if(DTO.getDeclaredField(field.getName()) != null || field.isAnnotationPresent(Language.class)){
                    Field dtoField = null;
                    if(!field.isAnnotationPresent(Language.class)){
                        dtoField =  DTO.getDeclaredField(field.getName());
                    }else {
                        String dtoFieldName = field.getAnnotation(Language.class).DTOField();
                        if(dtoFieldName.equals(null)){
                            dtoFieldName = field.getName();
                        }
                        dtoField = DTO.getDeclaredField(dtoFieldName);
                    }
                    if(field.isAnnotationPresent(Language.class)){
                        if(Objects.equals(field.getAnnotation(Language.class).language(), language)){
                            field.setAccessible(true);
                            dtoField.setAccessible(true);
                            dtoField.set(DTOReturn, field.get(entity));
                        }
                    }else{
                        field.setAccessible(true);
                        dtoField.setAccessible(true);
                        dtoField.set(DTOReturn, field.get(entity));
                    }
//                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.println(field.getName() + " nu a fost gasit in DTO!");
            }
        }
        return DTOReturn;
    }


}
