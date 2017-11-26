package ro.pub.lmn.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.pub.lmn.controller.HistoryController;
import ro.pub.lmn.entity.dto.HistoryDTO;
import ro.pub.lmn.service.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryApiController {

    private final HistoryService historyService;

    @Autowired
    public HistoryApiController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("")
    public List<HistoryDTO> getAllHistory(@RequestParam String lang){
        return historyService.findAll(lang);
    }
}
