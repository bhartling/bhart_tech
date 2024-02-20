package net.bhart.interviewtracker.repository;

import net.bhart.interviewtracker.entity.Interviewee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntervieweeRepository extends JpaRepository<Interviewee, Integer> {

    List<Interviewee> findByLastName(String lastName);

}
