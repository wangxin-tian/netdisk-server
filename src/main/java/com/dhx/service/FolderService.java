package com.dhx.service;

import com.dhx.pojo.Folder;

import java.util.List;

public interface FolderService {
    void add(String folderName, Long parent, Long userid);
    void delete(Long id);
    void update(Folder folder);
    List<Folder> get(Folder folder);
    List<Folder> share(Folder folder);
}
