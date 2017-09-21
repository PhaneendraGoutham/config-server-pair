package com.example.config_server.auth.controller;

import com.example.config_server.auth.dto.AuthData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    void notify(@RequestBody AuthData data) {
        log.trace(
                String.format(
                        "AuthController:: received data: user=%s password=%s",
                        data.getUser(), data.getPassword()
                )
        );
    }

}
