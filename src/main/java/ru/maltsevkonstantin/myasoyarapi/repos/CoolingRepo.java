package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.Cooling;

import java.util.List;

public interface CoolingRepo extends JpaRepository<Cooling, Integer> {
    List<Cooling> findByBundleStatus(BundleOfProductAndTareStatus status);
}
