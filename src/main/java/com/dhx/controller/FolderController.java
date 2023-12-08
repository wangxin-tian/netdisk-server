package com.dhx.controller;

import com.dhx.config.Result;
import com.dhx.pojo.Folder;
import com.dhx.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {
    @Autowired
    FolderService service;

    @PostMapping
    public Result<List<Folder>> selectFoldersList(@RequestBody Folder body) {
        List<Folder> list = service.get(body);
        if (body.getUserid() == null) {
            body.setUserid(1l);
            body.setIsShare(1);
            list = service.share(body);
            return Result.suc(list);
        }

        if (list.size() > 0) {
            return Result.suc(list);
        }

        return Result.fail("没有查询到结果");
    }

    @PostMapping("/add")
    public Result<String> addFolder(@RequestBody Folder body) {
        try {
            service.add(body.getFolderName(), body.getParent(), body.getUserid());
            return Result.suc("success add folder");
        } catch (Exception e) {
            return Result.fail("wrong add folder");
        }
    }

    @PostMapping("/edit")
    public  Result<String> editFolder(@RequestBody Folder folder) {
        try {
            service.update(folder);
            return Result.suc("success edit folder");
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail("wrong edit folder");
        }
    }
}
