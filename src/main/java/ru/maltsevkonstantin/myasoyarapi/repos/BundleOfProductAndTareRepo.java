package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;

public interface BundleOfProductAndTareRepo extends JpaRepository<BundleOfProductAndTare, Integer> {
}
