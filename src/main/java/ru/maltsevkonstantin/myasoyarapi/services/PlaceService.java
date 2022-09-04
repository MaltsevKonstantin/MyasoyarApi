package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Cell;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.CellAssignment;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Place;
import ru.maltsevkonstantin.myasoyarapi.repos.PlaceRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PlaceService {

    private final PlaceRepo repo;

    @Autowired
    public PlaceService(PlaceRepo repo) {
        this.repo = repo;
    }

    public List<Place> findAll() {
        return repo.findAllByOrderByName();
    }

    public List<Place> findByCellsAssignmentOrderByName(CellAssignment cellAssignment) {
        return repo.findByCellsAssignmentOrderByName(cellAssignment);
    }

    public List<Place> findAllFilterByCellAssigment(CellAssignment cellAssignment) {
        List<Place> placeList = repo.findAll();
        List<Place> filteredPlaceList = new ArrayList<>();
        for (Place place: placeList) {
            for (Cell cell: place.getCells()) {
                if (cell.getAssignment() == cellAssignment) {
                    boolean notFound = true;
                    for (Place filteredPlace: filteredPlaceList) {
                        if (filteredPlace.getId() == place.getId()) {
                            filteredPlace.getCells().add(cell);
                            notFound = false;
                            break;
                        }
                    }
                    if (notFound) {
                        Place filteredPlace = new Place();
                        filteredPlace.setId(place.getId());
                        filteredPlace.setName(place.getName());
                        filteredPlace.setCells(new ArrayList<>());
                        filteredPlace.getCells().add(cell);
                        filteredPlaceList.add(filteredPlace);
                    }
                }
            }
        }
        return filteredPlaceList;
    }

    public Place findById(int id) {
        Optional<Place> optPlace = repo.findById(id);
        if (optPlace.isEmpty()) throw new NotFoundException("Не найдено");
        return optPlace.get();
    }

    @Transactional
    public void save(Place place) {
        for (Cell cell : place.getCells()) {
            cell.setPlace(place);
        }
        repo.save(place);
    }

    public Optional<Place> findByName(String name) {
        return repo.findByName(name);
    }
}
