package com.xe.api.mapper;

import com.xe.api.application.user.dto.BasicDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasicMapper {
    BasicDto selectUser();
}
