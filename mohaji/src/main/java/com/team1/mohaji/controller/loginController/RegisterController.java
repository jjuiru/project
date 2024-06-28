package com.team1.mohaji.controller.loginController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Member;
import com.team1.mohaji.entity.Professor;
import com.team1.mohaji.entity.Student;
import com.team1.mohaji.model.model;
import com.team1.mohaji.repository.MemberRepository;
import com.team1.mohaji.repository.ProfRepository;
import com.team1.mohaji.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class RegisterController {

    private MemberRepository memberRepository;
    private StudentRepository studentRepository;
    private ProfRepository profRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(MemberRepository memberRepository, StudentRepository studentRepository, ProfRepository profRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.studentRepository = studentRepository;
        this.profRepository = profRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String register(){

        return "view/register";
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody Member member) {
        Member savedUser = null;
        ResponseEntity response = null;
        try {
            String hashPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(hashPassword);

            savedUser = memberRepository.save(member);
            if (savedUser.getMemberId() > 0) {

                switch(member.getRole()){
                    case STUDENT:
                        Student student = new Student();
                        student.setMember(member);
                        Student savedStudent = studentRepository.save(student);
                        if (savedStudent.getStudentId() > 0) {
                            response = ResponseEntity.status(HttpStatus.CREATED).body("구성원(학생) 등록 성공");
                        }
                        break;
                    case PROFESSOR:
                        Professor professor = new Professor();
                        professor.setMember(member);
                        Professor savedProfessor = profRepository.save(professor);
                        if (savedProfessor.getProfId() > 0) {
                            response = ResponseEntity.status(HttpStatus.CREATED).body("구성원(교수) 등록 성공");
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            memberRepository.delete(savedUser);
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception 발생 " + ex.getMessage());
        }
        return response;
    }

}
