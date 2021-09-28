package it.euris.academy.cinema.service.impl;

import it.euris.academy.cinema.data.dto.ProjectionPlannerDto;
import it.euris.academy.cinema.repository.ProjectionPlannerRepository;
import it.euris.academy.cinema.service.ProjectionPlannerService;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionPlannerServiceImpl implements ProjectionPlannerService {

  @Autowired
  ProjectionPlannerRepository projectionPlannerRepository;

  @Override
  public List<ProjectionPlannerDto> getAll() {
    return projectionPlannerRepository.findAll()
        .stream().map(projectionPlanner -> projectionPlanner.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ProjectionPlannerDto get(Long id) {
    return null;
  }

  @Override
  public ProjectionPlannerDto add(ProjectionPlannerDto projectionPlannerDto) throws ParseException {
    return projectionPlannerRepository.save(projectionPlannerDto.toModel()).toDto();
  }

  @Override
  public ProjectionPlannerDto update(ProjectionPlannerDto projectionPlannerDto) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
