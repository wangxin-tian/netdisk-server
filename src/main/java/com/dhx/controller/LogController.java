package com.dhx.controller;

import com.dhx.config.Result;
import com.dhx.pojo.Log;
import com.dhx.pojo.User;
import com.dhx.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService service;

    @PostMapping
    public Result<List<Log>> get(@RequestBody Log log) {
        try {
            List<Log> list = service.getAllLogsByUserId(log.getUserid(), log.pageNum);
            return Result.suc(list);
        } catch (Exception e) {
            return Result.fail("");
        }
    }

    @DeleteMapping("/:id")
    public Result<Log> delete(@RequestParam String id) {
        return Result.fail("");
    }
}
