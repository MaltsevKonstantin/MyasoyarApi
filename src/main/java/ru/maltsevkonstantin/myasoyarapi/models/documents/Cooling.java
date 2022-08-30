package ru.maltsevkonstantin.myasoyarapi.models.documents;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "cooling")
public class Cooling {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "start_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    Calendar startCalendar;
    @Column(name = "end_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    Calendar endCalendar;
    @ManyToOne
    @JoinColumn(name = "bundle_of_product_and_tare_id", referencedColumnName = "id")
    BundleOfProductAndTare bundle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getStartCalendar() {
        return startCalendar;
    }

    public void setStartCalendar(Calendar startCalendar) {
        this.startCalendar = startCalendar;
    }

    public Calendar getEndCalendar() {
        return endCalendar;
    }

    public void setEndCalendar(Calendar endCalendar) {
        this.endCalendar = endCalendar;
    }

    public BundleOfProductAndTare getBundle() {
        return bundle;
    }

    public void setBundle(BundleOfProductAndTare bundle) {
        this.bundle = bundle;
    }
}
