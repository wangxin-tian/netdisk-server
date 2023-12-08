package com.dhx.service.impl;

import com.dhx.mapper.FileMapper;
import com.dhx.pojo.File;
import com.dhx.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FileMapperImpl implements FileService {
    @Autowired
    FileMapper mapper;

    @Override
    public void add(File file) {
        mapper.add(file);
//        mapper.add(filename, userid, filetype, filesize, folderid);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public void update(File file) {
        mapper.update(file);
    }

    @Override
    public List<File> get(File file) {
        return mapper.get(file);
    }

    @Override
    public List<File> share(File file) {
        return mapper.share(file);
    }
}
