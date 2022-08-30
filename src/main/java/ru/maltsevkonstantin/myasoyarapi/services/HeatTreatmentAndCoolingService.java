package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.Cooling;
import ru.maltsevkonstantin.myasoyarapi.models.documents.HeatTreatment;
import ru.maltsevkonstantin.myasoyarapi.repos.CoolingRepo;
import ru.maltsevkonstantin.myasoyarapi.repos.HeatTreatmentRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HeatTreatmentAndCoolingService {

    private final HeatTreatmentRepo heatTreatmentRepo;
    private final CoolingRepo coolingRepo;

    @Autowired
    public HeatTreatmentAndCoolingService(HeatTreatmentRepo heatTreatmentRepo, CoolingRepo coolingRepo) {
        this.heatTreatmentRepo = heatTreatmentRepo;
        this.coolingRepo = coolingRepo;
    }

    public List<HeatTreatment> findAllHeatTreatmentByBundleStatus(BundleOfProductAndTareStatus status) {
        if (status == null) return heatTreatmentRepo.findAll();
        return heatTreatmentRepo.findByBundleStatus(status);
    }

    public List<Cooling> findAllCoolingBundleStatus(BundleOfProductAndTareStatus status) {
        if (status == null) return coolingRepo.findAll();
        return coolingRepo.findByBundleStatus(status);
    }

    public HeatTreatment findHeatTreatmentById(int id) {
        Optional<HeatTreatment> optHeatTreatment = heatTreatmentRepo.findById(id);
        if (optHeatTreatment.isEmpty()) throw new NotFoundException("Не найдено");
        return optHeatTreatment.get();
    }

    public Cooling findCoolingById(int id) {
        Optional<Cooling> optCooling = coolingRepo.findById(id);
        if (optCooling.isEmpty()) throw new NotFoundException("Не найдено");
        return optCooling.get();
    }
}
