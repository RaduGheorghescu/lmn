package ro.pub.lmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pub.lmn.entity.SiteComponents;
import ro.pub.lmn.entity.dto.SiteComponentsDTO;
import ro.pub.lmn.repository.SiteComponentsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiteComponentsServiceImp implements SiteComponentsService{
    @Autowired
    SiteComponentsRepository siteComponentsRepository;
    
    @Autowired
    EntityToDTOAndLanguageService entityToDTOAndLanguageService;


    @Override
    public List<SiteComponentsDTO> findAll() {
        List<SiteComponents> siteComponentsList = siteComponentsRepository.findAll();
        List<SiteComponentsDTO> siteComponentsDTOList = new ArrayList<>();
        for(SiteComponents siteComponents : siteComponentsList){
            siteComponentsDTOList.add((SiteComponentsDTO) entityToDTOAndLanguageService.setLanguageForDTO(siteComponents, SiteComponentsDTO.class));
        }
        return siteComponentsDTOList;
    }

    @Override
    public SiteComponents save(SiteComponents siteComponents) {
        return siteComponentsRepository.save(siteComponents);
    }
}
