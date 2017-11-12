package ro.pub.lmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ro.pub.lmn.service.HistoryService;

import javax.websocket.server.PathParam;

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
    public String getHistory(Model model, @CookieValue(value = "lang", defaultValue = "en") String language, @RequestParam(value = "lang", required = false) String paramLang){
        if(!language.equals(paramLang) && paramLang != null){
            language = paramLang;
        }
        model.addAttribute("history",historyService.findAll(language));
        return "history";
    }
}
