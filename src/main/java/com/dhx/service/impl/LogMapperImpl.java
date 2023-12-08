package com.dhx.service.impl;

import com.dhx.mapper.LogMapper;
import com.dhx.pojo.Log;
import com.dhx.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogMapperImpl implements LogService {

    @Autowired
    LogMapper mapper;

    @Override
    public void delete(String id) {
        mapper.delete(id);
    }

    @Override
    public void add(Log log) {
        mapper.add(log);
    }

    @Override
    public List<Log> getAllLogsByUserId(Long userid, long pageNum) {
        return mapper.getAllLogsByUserId(userid, pageNum);
    }
}
