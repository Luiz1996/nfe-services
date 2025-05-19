package com.lfp.nfe_services.repository;

import com.lfp.nfe_services.model.NfeBasicDataEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfeBasicDataRepository extends CrudRepository<NfeBasicDataEntity, UUID> { }
