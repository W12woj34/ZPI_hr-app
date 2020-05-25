package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Login;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;

@Mapper
public interface LoginMapper extends BaseMapper<Login, LoginEntity> {}
