package net.bhart.interviewtracker.helpers;

import net.bhart.interviewtracker.dto.IntervieweeDto;
import net.bhart.interviewtracker.entity.Interviewee;

public class IntervieweeMapper {

    public static IntervieweeDto mapToIntervieweeDto(Interviewee interviewee) {

        return new IntervieweeDto(
                interviewee.getId(),
                interviewee.getFirstName(),
                interviewee.getLastName(),
                interviewee.getEmail()
        );
    }

    public static Interviewee mapToInterviewee(IntervieweeDto dto) {
        return new Interviewee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}
