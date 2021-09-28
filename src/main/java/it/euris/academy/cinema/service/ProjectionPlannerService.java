package it.euris.academy.cinema.service;

import it.euris.academy.cinema.data.dto.ProjectionPlannerDto;
import java.text.ParseException;
import java.util.List;

public interface ProjectionPlannerService {
  List<ProjectionPlannerDto> getAll();

  ProjectionPlannerDto get(Long id);

  ProjectionPlannerDto add(ProjectionPlannerDto projectionPlannerDto) throws ParseException;

  ProjectionPlannerDto update(ProjectionPlannerDto projectionPlannerDto);

  Boolean delete(Long id);
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
