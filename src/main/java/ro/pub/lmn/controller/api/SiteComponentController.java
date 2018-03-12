package ro.pub.lmn.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.pub.lmn.entity.dto.SiteComponentsDTO;
import ro.pub.lmn.service.SiteComponentsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/siteComponents")
public class SiteComponentController {
    private final SiteComponentsService siteComponentsService;

    public SiteComponentController(SiteComponentsService siteComponentsService) {
        this.siteComponentsService = siteComponentsService;
    }

    @GetMapping("/all")
    private List<SiteComponentsDTO> findAll(){
        return siteComponentsService.findAll();
    }
}
