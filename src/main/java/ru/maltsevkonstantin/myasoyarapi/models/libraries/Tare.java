package ru.maltsevkonstantin.myasoyarapi.models.libraries;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tares")
public class Tare {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @OneToMany(mappedBy = "tare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Weight> weights;
    @Enumerated(EnumType.STRING)
    TareType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weight> getWeights() {
        return weights;
    }

    public void setWeights(List<Weight> weights) {
        this.weights = weights;
    }

    public TareType getType() {
        return type;
    }

    public void setType(TareType type) {
        this.type = type;
    }

    @Entity
    @Table(name = "tare_weights")
    public static class Weight {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        @Column(name = "date")
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "dd.MM.yyyy")
        Date date;
        @ManyToOne
        @JoinColumn(name = "tare_id", referencedColumnName = "id")
        Tare tare;
        @Column(name = "weight")
        float weight;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public Tare getTare() {
            return tare;
        }

        public void setTare(Tare tare) {
            this.tare = tare;
        }
    }
}
