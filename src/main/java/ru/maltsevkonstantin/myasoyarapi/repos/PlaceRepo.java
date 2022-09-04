package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.CellAssignment;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceRepo extends JpaRepository<Place, Integer> {
    List<Place> findAllByOrderByName();
    Optional<Place> findByName(String name);

    List<Place> findByCellsAssignmentOrderByName(CellAssignment cellAssignment);
}
