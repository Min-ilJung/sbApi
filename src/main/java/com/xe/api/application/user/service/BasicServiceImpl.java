package com.xe.api.application.user.service;

import com.xe.api.application.user.dto.BasicDto;
import com.xe.api.mapper.BasicMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

    @Resource
    private BasicMapper basicMapper;

    @Override
    public BasicDto findUser() {
        return basicMapper.selectUser();
    }
}
