package com.Sunnygarden.repository;

import com.Sunnygarden.entity.SideBarEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SideBarRepository extends JpaRepository<SideBarEntity, Long> {

	@Query("SELECT s FROM SideBarEntity s WHERE s.roleId =?1 AND s.status = ?2")
    List<SideBarEntity> findByRoleIdAndStatus(Long roleId,boolean status);
}
