package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.service.myPage.imple.RegInfoServiceImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class RegInfoController {
    @Autowired
    private RegInfoServiceImple regInfoServiceImple;
    @GetMapping("/RegCancel")
    public  String RegCancel(@RequestParam int memberId, @RequestParam int subId){
        regInfoServiceImple.deleteRegInfo(memberId, subId);
        return "redirect:/myPage/regInfo";
    }


}
