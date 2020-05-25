package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Admin;
import pwr.zpi.hrapp.persistance.entities.AdminEntity;
import pwr.zpi.hrapp.persistance.repositories.AdminRepository;
import pwr.zpi.hrapp.service.AdminService;
import pwr.zpi.hrapp.service.BaseCrudService;
import pwr.zpi.hrapp.service.mapper.AdminMapper;

@Service
public class AdminServiceImpl extends BaseCrudService<Admin, AdminEntity, Integer, AdminRepository>
    implements AdminService {

  public AdminServiceImpl(AdminRepository repository, AdminMapper mapper) {
    super(repository, mapper);
  }
}
