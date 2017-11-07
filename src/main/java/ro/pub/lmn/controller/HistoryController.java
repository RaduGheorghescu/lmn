package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.pub.lmn.service.HistoryService;

/**
 * Created by radug on 11/7/2017.
 */
@Controller
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/history")
    public String getHistory(Model model){
        model.addAttribute("history",historyService.findAll());
        return "history";
    }
}
