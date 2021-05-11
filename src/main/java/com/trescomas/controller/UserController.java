package com.trescomas.controller;

import com.trescomas.config.Routes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = Routes.USER)
public class UserController {
}
