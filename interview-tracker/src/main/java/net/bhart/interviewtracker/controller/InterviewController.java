package net.bhart.interviewtracker.controller;

import lombok.AllArgsConstructor;
import net.bhart.interviewtracker.dto.IntervieweeDto;
import net.bhart.interviewtracker.service.InterviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/interviewees")
public class InterviewController {

    private InterviewService svc;

    private static final Logger logger = LoggerFactory.getLogger(InterviewController.class);


    // Build add API
    @PostMapping("/create")
    public ResponseEntity<IntervieweeDto> createInterviewee(@RequestBody IntervieweeDto dto) {

        IntervieweeDto saved = svc.createInterviewee(dto);
        logger.info("Successfully created interviewee");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<IntervieweeDto>> getInterviewee(@PathVariable String lastName) {

        List<IntervieweeDto> dtos = svc.getInterviewee(lastName);
        logger.info("Successfully found interviewees");
        return new ResponseEntity<List<IntervieweeDto>>(dtos, HttpStatus.OK);
    }

}
