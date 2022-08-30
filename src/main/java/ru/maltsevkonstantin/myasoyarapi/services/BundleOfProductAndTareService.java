package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.repos.BundleOfProductAndTareRepo;

@Service
@Transactional(readOnly = true)
public class BundleOfProductAndTareService {
    private final BundleOfProductAndTareRepo repo;

    @Autowired
    public BundleOfProductAndTareService(BundleOfProductAndTareRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public void save(BundleOfProductAndTare bundleOfProductAndTare) {
        repo.save(bundleOfProductAndTare);
    }
}
