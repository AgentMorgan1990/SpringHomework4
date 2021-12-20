package ru.gb.spring4.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.gb.spring4.entities.AccessPermission;

@Repository
public interface AccessPermissionRepository extends CrudRepository<AccessPermission, Long> {

}
