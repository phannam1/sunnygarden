package com.Sunnygarden.repository;

import com.Sunnygarden.entity.ServiceDetailEntity;
import com.Sunnygarden.entity.ServiceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetailEntity,Long> {

    List<ServiceDetailEntity> findAllByService(ServiceEntity serviceEntities);
}
