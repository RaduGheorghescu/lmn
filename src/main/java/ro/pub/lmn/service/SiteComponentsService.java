package ro.pub.lmn.service;

import ro.pub.lmn.entity.SiteComponents;
import ro.pub.lmn.entity.dto.SiteComponentsDTO;

import java.util.List;

public interface SiteComponentsService {
    List<SiteComponentsDTO> findAll();
    SiteComponents save(SiteComponents siteComponents);
}
