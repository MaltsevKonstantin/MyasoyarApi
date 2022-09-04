package ru.maltsevkonstantin.myasoyarapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.repos.BundleOfProductAndTareRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BundleOfProductAndTareService {
    private final BundleOfProductAndTareRepo repo;

    @Autowired
    public BundleOfProductAndTareService(BundleOfProductAndTareRepo repo) {
        this.repo = repo;
    }

    public List<BundleOfProductAndTare> findAll() {
        return repo.findAll();
    }

    public List<BundleOfProductAndTare> findByStatus(BundleOfProductAndTareStatus status) {
        return repo.findByStatus(status);
    }

    public BundleOfProductAndTare findByTareId(int tareId) {
        Optional<BundleOfProductAndTare> optBundle = repo.findByTareId(tareId);
        if (optBundle.isEmpty()) throw new NotFoundException("Не найдено");
        return optBundle.get();
    }

    public Optional<BundleOfProductAndTare> findById(int id) {
        return repo.findById(id);
    }

    @Transactional
    public void save(BundleOfProductAndTare bundleOfProductAndTare) {
        repo.save(bundleOfProductAndTare);
    }
}
