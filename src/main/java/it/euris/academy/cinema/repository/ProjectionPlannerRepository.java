package it.euris.academy.cinema.repository;

import it.euris.academy.cinema.data.model.ProjectionPlanner;
import it.euris.academy.cinema.data.model.keys.ProjectionPlannerKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionPlannerRepository extends JpaRepository<ProjectionPlanner,ProjectionPlannerKey> {

}
