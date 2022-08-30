package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlan;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlanStatus;

import java.util.List;

public interface ProductionPlanRepo extends JpaRepository<ProductionPlan, Integer> {

    List<ProductionPlan> findAllByOrderByDate();
    List<ProductionPlan> findByStatusOrderByDate(ProductionPlanStatus status);
}
