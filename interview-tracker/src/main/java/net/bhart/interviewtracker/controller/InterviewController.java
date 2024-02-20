package net.bhart.interviewtracker.controller;

import lombok.AllArgsConstructor;
import net.bhart.interviewtracker.dto.IntervieweeDto;
import net.bhart.interviewtracker.service.InterviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/interviewees")
public class InterviewController {

    private InterviewService svc;

    // Build add API
    @PostMapping("/create")
    public ResponseEntity<IntervieweeDto> createInterviewee(@RequestBody IntervieweeDto dto) {

        IntervieweeDto saved = svc.createInterviewee(dto);
        System.out.println("Successfully created interviewee");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<IntervieweeDto>> getInterviewee(@PathVariable String lastName) {

        List<IntervieweeDto> dtos = svc.getInterviewee(lastName);
        System.out.println("Successfully found interviewees");
        return new ResponseEntity<List<IntervieweeDto>>(dtos, HttpStatus.OK);
    }

}
