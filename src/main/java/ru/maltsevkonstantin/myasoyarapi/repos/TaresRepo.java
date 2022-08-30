package ru.maltsevkonstantin.myasoyarapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.TareType;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaresRepo extends JpaRepository<Tare, Integer> {
    List<Tare> findByType(TareType type);
    Optional<Tare> findByIdAndWeightsDateLessThanEqual(int id, Date date);
}
