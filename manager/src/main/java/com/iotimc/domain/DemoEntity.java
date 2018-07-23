package com.iotimc.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * DemoEntity
 *
 * @author lieber
 * @create 2018/2/9
 **/
@Entity
@Table(name = "DEMO", schema = "elsi-trunk", catalog = "")
public class DemoEntity {
    private int id;
    private String name;
    private Timestamp demodate;
    private String notes;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "demodate")
    public Timestamp getDemodate() {
        return demodate;
    }

    public void setDemodate(Timestamp demodate) {
        this.demodate = demodate;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoEntity that = (DemoEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(demodate, that.demodate) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, demodate, notes);
    }
}
