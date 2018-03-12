package ro.pub.lmn.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import ro.pub.lmn.controller.HistoryController;
import ro.pub.lmn.entity.History;
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
    public List<HistoryDTO> getAllHistory(){
        return historyService.findAll();
    }

    @PostMapping("")
    public History saveHistory(@RequestBody History history){
        return historyService.save(history);
    }
}
