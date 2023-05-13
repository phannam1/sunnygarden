package com.Sunnygarden.repository;

import com.Sunnygarden.entity.ServiceDetailEntity;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetailEntity,Long> {

    @Query("SELECT sdt FROM ServiceDetailEntity sdt WHERE sdt.service.Id = :serviceId order by sdt.Id ")
    List<ServiceDetailEntity> findAllByServiceSortById(@Param("serviceId") Long serviceId);
}
