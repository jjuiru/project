package com.team1.mohaji.controller.ipController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.model.model;
import com.team1.mohaji.service.myPage.imple.MyPCSericeImple;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class IPController {

    @Autowired
    MyPCSericeImple myPCSericeImple;

    @PostMapping("/registerPC")
    public String registerPC(HttpServletRequest request, @AuthenticationPrincipal CustomUserDetails customUserDetails, RedirectAttributes redirectAttributes) {
        System.out.println("등록컨트롤러 도착");
        int memberId = customUserDetails.getMemberId();
        String mipName = request.getParameter("mipName");
        List<MyPCDto> myPCList = myPCSericeImple.selectIP(customUserDetails.getMemberId());
        String ipAddress = request.getHeader("X-Forwarded-For");

        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }

        if (myPCList.size() >= 3) {
            redirectAttributes.addFlashAttribute("message", "PC는 최대 3개까지 등록 가능합니다.");
            return "redirect:/myPage/myPC";
        }

        for (MyPCDto myPCDto : myPCList) {
            System.out.println("포문시작" + myPCDto.getMipIp() + ipAddress);
            if (myPCDto.getMipIp().equals(ipAddress)) {
                redirectAttributes.addFlashAttribute("message", "이미 등록된 PC입니다.");
                return "redirect:/myPage/myPC";
            }
        }

        myPCSericeImple.insertIP(mipName, memberId, ipAddress);
        redirectAttributes.addFlashAttribute("message", "등록이 완료되었습니다.");
        return "redirect:/myPage/myPC";
    }

    @PostMapping("/deletePC")
    public String deletePC(HttpServletRequest request, @RequestParam("mipId") int mipId, @AuthenticationPrincipal CustomUserDetails customUserDetails, RedirectAttributes redirectAttributes) {
        List<MyPCDto> myPCList = myPCSericeImple.selectIP(customUserDetails.getMemberId());
        System.out.println(myPCList);
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        System.out.println(ipAddress);
        for (MyPCDto myPCDto : myPCList) {
            System.out.println("포문시작" + myPCDto.getMipIp() + ipAddress);
            if (myPCDto.getMipIp().equals(ipAddress)) {
                int memberId = customUserDetails.getMemberId();
                List<MyPCDto> list = myPCSericeImple.selectIP(memberId);
                if (list.size() > 0) {
                    myPCSericeImple.deleteIP(mipId);
                    redirectAttributes.addFlashAttribute("message", "삭제가 완료되었습니다.");
                    return "redirect:/myPage/myPC";
                }
            }
        }
        redirectAttributes.addFlashAttribute("message", "등록된 PC에서 삭제해야 합니다.");
        return "redirect:/myPage/myPC";
    }
}