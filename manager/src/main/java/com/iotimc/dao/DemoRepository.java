package com.iotimc.dao;

import com.iotimc.domain.DemoEntity;
import com.slyak.spring.jpa.GenericJpaRepository;
import com.slyak.spring.jpa.TemplateQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Dao
 *
 * @author lieber
 * @create 2018/2/9
 **/
public interface DemoRepository extends GenericJpaRepository<DemoEntity, Integer> {

    @TemplateQuery
    List<DemoEntity> findDemoListByName(@Param("name") String name);

    @TemplateQuery
    Page<DemoEntity> findPageDemoListByName(@Param("name") String name, Pageable pageable);

}
