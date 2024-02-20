package net.bhart.interviewtracker.service;

import net.bhart.interviewtracker.dto.IntervieweeDto;

import java.util.List;

public interface InterviewService {

    IntervieweeDto createInterviewee(IntervieweeDto dto);

    List<IntervieweeDto> getInterviewee(String lastName);
}
