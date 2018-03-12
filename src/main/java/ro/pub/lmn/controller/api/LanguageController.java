package ro.pub.lmn.controller.api;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LanguageController {
    @GetMapping("/language")
    public LocaleContext changeLanguage(@RequestParam(value = "lang",required = false) String lang){
        return LocaleContextHolder.getLocaleContext();
    }
}
