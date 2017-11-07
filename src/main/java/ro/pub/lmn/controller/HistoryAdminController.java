package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.pub.lmn.entity.History;
import ro.pub.lmn.service.HistoryService;

/**
 * Created by radug on 11/7/2017.
 */

@Controller
@RequestMapping("/admin/history")
public class HistoryAdminController {

    private final HistoryService historyService;

    @Autowired
    public HistoryAdminController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/add")
    public String addHistory(Model model){
        History history =  new History();
        model.addAttribute("history", history);
        return "addHistory";
    }

    @PostMapping("/add")
    public String addHistory(@ModelAttribute("history") History history){
        historyService.save(history);
        return "redirect:/history";
    }
}
