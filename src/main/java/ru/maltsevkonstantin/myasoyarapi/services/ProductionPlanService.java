package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlan;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlanItem;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlanStatus;
import ru.maltsevkonstantin.myasoyarapi.repos.ProductionPlanRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductionPlanService {

    ProductionPlanRepo repo;

    @Autowired
    public ProductionPlanService(ProductionPlanRepo repo) {
        this.repo = repo;
    }

    public List<ProductionPlan> findAll() {
        return repo.findAllByOrderByDate();
    }

    public List<ProductionPlan> findByStatusOrderByDate(ProductionPlanStatus status) {
        return repo.findByStatusOrderByDate(status);
    }

    public ProductionPlan findById(int id) {
        Optional<ProductionPlan> optProductionPlan = repo.findById(id);
        if (optProductionPlan.isEmpty()) throw new NotFoundException("Не найден план производства");
        ProductionPlan productionPlan = optProductionPlan.get();
        productionPlan.getItemList().sort(Comparator.comparing(o -> o.getProduct().getName()));
        return productionPlan;
    }

    @Transactional
    public void save(ProductionPlan productionPlan) {
        for (ProductionPlanItem item : productionPlan.getItemList()) {
            item.setPlan(productionPlan);
        }
        repo.save(productionPlan);
    }
}
