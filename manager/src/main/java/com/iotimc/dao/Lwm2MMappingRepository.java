package com.iotimc.dao;

import com.iotimc.domain.Lwm2MMappingEntity;
import com.slyak.spring.jpa.GenericJpaRepository;
import com.slyak.spring.jpa.TemplateQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Lwm2MMappingRepository extends GenericJpaRepository<Lwm2MMappingEntity, Integer> {
    @TemplateQuery
    List<Lwm2MMappingEntity> getList(@Param("mappingtype") String mappingtype);
}
