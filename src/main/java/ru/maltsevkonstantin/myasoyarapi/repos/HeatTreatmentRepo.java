package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.HeatTreatment;

import java.util.List;

public interface HeatTreatmentRepo extends JpaRepository<HeatTreatment, Integer> {
    List<HeatTreatment> findByBundleStatus(BundleOfProductAndTareStatus status);
}
