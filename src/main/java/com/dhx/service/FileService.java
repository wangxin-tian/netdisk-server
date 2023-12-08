package com.dhx.service;

import com.dhx.pojo.File;

import java.math.BigDecimal;
import java.util.List;

public interface FileService {
    void add(File file);
    void delete(Long id);
    void update(File file);
    List<File> get(File file);
    List<File> share(File file);
}
