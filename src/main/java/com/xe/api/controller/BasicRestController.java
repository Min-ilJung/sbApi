package com.xe.api.controller;

import com.xe.api.application.user.service.BasicService;
import com.xe.api.util.ReturnMessage;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/basic")
public class BasicRestController {

    @Resource
    private BasicService basicService;

    /**
     * @title    - 사용자 이름 조회
     * @desc    - 사용자의 이름을 조회한다. (기본 테스트)
     * @author    - wnguds
     * @date    - 2023.03.20
     * @param    -
     * @return    - 결과 코드
     */
    @GetMapping()
    public ReturnMessage findUser() {
      log.info("findUser >>>>>>>>>>>>>> start");
        try {
            return new ReturnMessage(basicService.findUser());
        } catch (Exception e) {
            return new ReturnMessage("9999", "사용자 이름 조회 API 에러(테스트)", e);
        }
    }
}
