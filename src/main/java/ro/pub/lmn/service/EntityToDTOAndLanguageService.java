package ro.pub.lmn.service;

import org.springframework.stereotype.Component;
import ro.pub.lmn.annotations.Language;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Created by radug on 11/2/2017.
 */
@Component
public class EntityToDTOAndLanguageService {
    public Object DTOToEntity(Object DTO, Object entity){
        for(Field field : entity.getClass().getDeclaredFields()){
            try {
                if(DTO.getClass().getDeclaredField(field.getName()) != null && !field.isAnnotationPresent(Id.class)){
                    Field fieldDTO = DTO.getClass().getDeclaredField(field.getName());
                    field.setAccessible(true);
                    fieldDTO.setAccessible(true);
                    field.set(entity, fieldDTO.get(DTO));
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }
    public void setLanguageForDTO(Object entity, Class DTO){
        for(Field field : entity.getClass().getDeclaredFields()){
//            if(field.isAnnotationPresent(Language.class)){
            try {
                if(DTO.getDeclaredField(field.getName()) != null) {

                        Field field1 = DTO.getDeclaredField(field.getName());
                        field1.setAccessible(true);
                        field.setAccessible(true);
                        field.set(entity, field.get(entity));

                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
//            }
        }
    }


}
