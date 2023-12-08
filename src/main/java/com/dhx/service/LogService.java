package com.dhx.service;

import com.dhx.pojo.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogService {
    void delete(String id);
    void add(Log log);
    List<Log> getAllLogsByUserId(Long userid, long pageNum);
}
