package com.iotimc.domain;

import javax.persistence.*;

@Entity
@Table(name = "lwm2m_mapping", schema = "elsi-trunk", catalog = "")
public class Lwm2MMappingEntity {
    private int id;
    private String product;
    private String dsid;
    private String mapper;
    private String type;
    private String name;
    private Integer insid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "dsid")
    public String getDsid() {
        return dsid;
    }

    public void setDsid(String dsid) {
        this.dsid = dsid;
    }

    @Basic
    @Column(name = "mapper")
    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lwm2MMappingEntity that = (Lwm2MMappingEntity) o;

        if (id != that.id) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (dsid != null ? !dsid.equals(that.dsid) : that.dsid != null) return false;
        if (mapper != null ? !mapper.equals(that.mapper) : that.mapper != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (dsid != null ? dsid.hashCode() : 0);
        result = 31 * result + (mapper != null ? mapper.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "insid")
    public Integer getInsid() {
        return insid;
    }

    public void setInsid(Integer insid) {
        this.insid = insid;
    }
}
