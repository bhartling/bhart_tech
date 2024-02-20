package net.bhart.interviewtracker.service.impl;

import lombok.AllArgsConstructor;
import net.bhart.interviewtracker.dto.IntervieweeDto;
import net.bhart.interviewtracker.entity.Interviewee;
import net.bhart.interviewtracker.helpers.IntervieweeMapper;
import net.bhart.interviewtracker.repository.IntervieweeRepository;
import net.bhart.interviewtracker.service.InterviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InterviewServiceImpl implements InterviewService {


    private IntervieweeRepository intervieweeRepository;

    @Override
    public IntervieweeDto createInterviewee(IntervieweeDto dto) {

        Interviewee interviewee = IntervieweeMapper.mapToInterviewee(dto);
        Interviewee saved = this.intervieweeRepository.save(interviewee);

        return IntervieweeMapper.mapToIntervieweeDto(saved);
    }

    @Override
    public List<IntervieweeDto> getInterviewee(String lastName) {

        List<Interviewee> entities = this.intervieweeRepository.findByLastName(lastName);

        List<IntervieweeDto> dtos = new ArrayList<IntervieweeDto>();

        // This converts all of the entities to dtos
        dtos = entities.stream().map(IntervieweeMapper::mapToIntervieweeDto).toList();

        return dtos;
    }
}
