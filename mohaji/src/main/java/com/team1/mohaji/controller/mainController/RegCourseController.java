package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.RegCourseDetailDto;
import com.team1.mohaji.dto.RegCourseDto;
import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.model.model;
import com.team1.mohaji.service.main.RegCourseService;

import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class RegCourseController {
    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

    @Autowired
    RegCourseServiceImple regCourseServiceImple;

    @RequestMapping("/regCourse")
    public  String regCourse(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails){
        System.out.println(customUserDetails.getName());
//        model.addAttribute("regCourseList",regCourseServiceImple.selectAllSubject());
        if(customUserDetails != null) {
            int memberId = customUserDetails.getMemberId();
            model.addAttribute("regCourseList", regCourseServiceImple.selectSubjectByRegStat(memberId));
            model.addAttribute("memberId", memberId);
            System.out.println(regCourseServiceImple.selectSubjectByRegStat(memberId));
            return "view/regCourse";
        }
        return"redirect:/login";
//        log.info("컨트롤러 서비스완료 ");

    }

    @GetMapping("/reg")
    public String reg(@RequestParam int memberId, @RequestParam int subId, RedirectAttributes redirectAttributes, Model model) {
        String rcStat = "신청중";
        String stat = regCourseServiceImple.selectRegCourseByRegStat(memberId, subId);
        int creditSum = regCourseServiceImple.selectCreditSum(memberId);

        if (creditSum > 21) {
            redirectAttributes.addAttribute("message", "수강최대학점을 초과했습니다.");
            return "redirect:/regCourse";
        } else if (stat != null && stat.equals("취소")) {
            regCourseServiceImple.updateRegCourse(memberId, subId);
            return "redirect:/regCourse";
        }
        regCourseServiceImple.insertReg(memberId, subId, rcStat);
        return "redirect:/regCourse";
    }

    @PostMapping("/search")
    @ResponseBody
    public List<SubjectDto> regCourseSearch(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails,@RequestParam("category") String category, @RequestParam("keyword") String keyword){
       String memberId = String.valueOf(customUserDetails.getMemberId());
        System.out.println("검색으로 오긴왔다"+category+keyword);
        List<SubjectDto> list;
        // 카테고리가 "all"이거나 키워드가 없는 경우
        if ("all".equals(category) && (keyword == null || keyword.isEmpty())) {
            System.out.println("1번"+category+keyword);
            list = regCourseServiceImple.selectAllSubject(memberId);
            return list;
        }
        // 카테고리가 "all"이 아니고 키워드가 없는경우
        else if (!"all".equals(category) && (keyword == null || keyword.isEmpty())){
            System.out.println("2번"+category+keyword);
            list = regCourseServiceImple.selectCategory(category, memberId);
            return list;
        }
        // 카테고리가 모두 존재할때
        else if(category !=null && !"all".equals(category)&& keyword !=null) {
            System.out.println("3번" + category + keyword);
            list = regCourseServiceImple.selectAllSearch(category, keyword, memberId);
            System.out.println(list);
            return list;
        }
        else if("all".equals(category) && (keyword != null )) {
            list = regCourseServiceImple.selectKeyword (keyword, memberId);
            System.out.println(list);
            return list;
        }
        // 모델에 추가된 속성을 이용하여 검색 결과를 표시할 뷰로 리다이렉트합니다.
        return new ArrayList<>();
    }

    @GetMapping("/courseDetail/{subId1}")
    @ResponseBody
    public RegCourseDetailDto getCourseDetail(@PathVariable("subId1") String subId1) {
        RegCourseDetailDto courseDetail= regCourseServiceImple.regCourseDetail(Integer.parseInt(subId1));
        return courseDetail;
    }
}

