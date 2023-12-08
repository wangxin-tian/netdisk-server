package com.dhx.service.impl;

import com.dhx.mapper.FolderMapper;
import com.dhx.pojo.Folder;
import com.dhx.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderMapperImpl implements FolderService {
    @Autowired
    FolderMapper mapper;

    @Override
    public void add(String folderName, Long parent, Long userid) {
        mapper.add(folderName, parent, userid);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public void update(Folder folder) {
        mapper.update(folder);
    }

    @Override
    public List<Folder> get(Folder folder) {
        return mapper.get(folder);
    }

    @Override
    public List<Folder> share(Folder folder) {
        return mapper.share(folder);
    }
}
