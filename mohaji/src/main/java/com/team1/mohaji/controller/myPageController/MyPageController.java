package com.team1.mohaji.controller.myPageController;



import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.myPage.CreditDto;
import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import com.team1.mohaji.dto.myPage.regEmailDto;
import com.team1.mohaji.model.model;
import com.team1.mohaji.service.myPage.imple.MyPCSericeImple;
import com.team1.mohaji.service.myPage.imple.RegInfoServiceImple;
import com.team1.mohaji.service.myPage.imple.RegListServiceImple;
import com.team1.mohaji.service.myPage.imple.UpEmailServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;


@Controller
@RequestMapping("/myPage")
public class MyPageController {
    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }


    @Autowired
    private RegListServiceImple regListServiceImple;
    @Autowired
    private MyPCSericeImple myPCSericeImple;
    @Autowired
    private RegInfoServiceImple regInfoServiceImple;
    @Autowired
    private UpEmailServiceImple upEmailServiceImple;

    @GetMapping("/regList")
    public String myList(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        if (userDetails != null) {
            int memberId = userDetails.getMemberId();
            List<RegListDto> regList = regListServiceImple.regListInProgress(memberId);
            CreditDto creditDto = regListServiceImple.selectCredits(memberId);
            model.addAttribute("regList", regList);
            model.addAttribute("credit", creditDto);
            System.out.println(regList);
            return "view/myPage/regList";
        }
        return "redirect:/login/login";
    }


    @GetMapping("/myPC")
    public String showRegistrationPage(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        List<MyPCDto> myPCList = myPCSericeImple.selectIP(customUserDetails.getMemberId());
        model.addAttribute("myPCList", myPCList);
        System.out.println("여기도착완료" + myPCList);
        return "view/myPage/myPC2";
    }

    @RequestMapping("/regInfo")
    public String regInfo(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        if (customUserDetails != null) {
            int memberId = customUserDetails.getMemberId();
            //신청기간중인 것
            model.addAttribute("regInfo", regInfoServiceImple.selectRegInfoBF(memberId));
            //신청기간 지난것
            model.addAttribute("regInfo2", regInfoServiceImple.selectRegInfoAT(memberId));

            model.addAttribute("memberId", memberId);
            return "view/myPage/regInfo";
        }
        return "redirect:/login";
//        log.info("컨트롤러 서비스완료 ");

    }

    @GetMapping("/regStudy")
    public String regStudy() {
        return "view/myPage/regStudy";
    }

    @GetMapping("/regResult")
    public String regResult() {
        return "view/myPage/regResult";
    }

    //    내정보
    @RequestMapping("/userInfo")
    public String userInfo(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {


        String name= customUserDetails.getName(); // 이름
        String email= upEmailServiceImple.selectEmail(customUserDetails.getMemberId()); //이메일
        String userNum ="20240522"+(customUserDetails.getMemberId()); // 일련번호(학번)
        String userId = customUserDetails.getUsername(); // 로그인아이디

        // 이메일을 @를 기준으로 분리
        String[] emailParts = email.split("@");

        // 앞부분과 뒷부분을 각각 변수에 저장
        String bemail = emailParts[0];
        String aemail = emailParts[1];

        model.addAttribute("name",name);
        model.addAttribute("bemail", bemail);
        model.addAttribute("aemail",aemail);
        model.addAttribute("userNum",userNum);
        model.addAttribute("userId",userId);

        return "view/myPage/userInfo";
    }

    @PostMapping("/ReEmail")
    public String reEmail(regEmailDto regEmailDto, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        String email= (regEmailDto.getBemail())+"@"+(regEmailDto.getAemail());
        int memberId=customUserDetails.getMemberId();
        upEmailServiceImple.updateEmail(memberId, email);
        return "redirect:/myPage/userInfo";
    }
}
