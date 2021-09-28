package it.euris.academy.cinema.controller;

import io.swagger.annotations.Api;
import it.euris.academy.cinema.data.dto.ProjectionPlannerDto;
import it.euris.academy.cinema.service.ProjectionPlannerService;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ProjectionsPlannerController")
@RestController
@RequestMapping("/projectionsPlanner")
public class ProjectionPlannerController {
  
  @Autowired
  private ProjectionPlannerService projectionPlannerService;

  @GetMapping("/v1")
  public List<ProjectionPlannerDto> getAll() {
    return projectionPlannerService.getAll();
  }

  @GetMapping("/v1/{id}")
  public ProjectionPlannerDto get(@PathVariable("id") Long id) {
    return projectionPlannerService.get(id);
  }

  @PostMapping("/v1")
  public ProjectionPlannerDto add(@RequestBody ProjectionPlannerDto projectionPlannerDto)
      throws ParseException {
    return projectionPlannerService.add(projectionPlannerDto);
  }

  @PutMapping("/v1")
  public ProjectionPlannerDto update(@RequestBody ProjectionPlannerDto projectionPlannerDto) {
    return projectionPlannerService.update(projectionPlannerDto);
  }

  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return projectionPlannerService.delete(id);
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
}
