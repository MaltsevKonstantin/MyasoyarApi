package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;

import java.util.List;
import java.util.Optional;

public interface BundleOfProductAndTareRepo extends JpaRepository<BundleOfProductAndTare, Integer> {
    List<BundleOfProductAndTare> findByStatus(BundleOfProductAndTareStatus status);
    Optional<BundleOfProductAndTare> findByTareId(int tareId);
}
