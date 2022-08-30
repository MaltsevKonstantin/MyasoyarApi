package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.TareType;
import ru.maltsevkonstantin.myasoyarapi.repos.TaresRepo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TaresService {

    private TaresRepo taresRepo;

    @Autowired
    public TaresService(TaresRepo taresRepo) {
        this.taresRepo = taresRepo;
    }

    public List<Tare> findAll() {
        return taresRepo.findAll();
    }

    public List<Tare> findByType(TareType type) {
        return taresRepo.findByType(type);
    }

    public Tare findById(int id) {
        Optional<Tare> optTare = taresRepo.findById(id);
        if (optTare.isEmpty()) throw new NotFoundException("Тара не найдена");
        return optTare.get();
    }

    public Tare findByIdAndWeightDateLessThanCurrent(int id) {
        Optional<Tare> optTare = taresRepo.findByIdAndWeightsDateLessThanEqual(id, new Date());
        if (optTare.isEmpty()) throw new NotFoundException("Тара не найдена");
        return optTare.get();
    }

    @Transactional
    public void save(Tare tare) {
        taresRepo.save(tare);
    }
}
