package com.Sunnygarden.repository;

import com.Sunnygarden.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {


	@Query("SELECT se FROM ServiceEntity se order by se.createDate desc")
	List<ServiceEntity> findAllSortByCreateDate();


}
