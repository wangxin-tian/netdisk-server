package com.dhx.controller;

import com.dhx.config.HashNode;
import com.dhx.config.Md5Utils;
import com.dhx.config.Result;
import com.dhx.pojo.File;
import com.dhx.service.FileService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService service;

    @PostMapping
    public Result<List<File>> getAll(@RequestBody File body) {
        List<File> list = service.get(body);
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

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file, @RequestParam("file-data") String body) {

        // 检查文件是否为空
        if (file.isEmpty()) {
            // 处理空文件的情况
        } else {
            Gson gson = new Gson();
            File data = gson.fromJson(body, File.class);

            service.add(data);
            String origin = file.getOriginalFilename();
            String node = HashNode.getNode(String.valueOf(data.getId()));
            String position_name = Md5Utils.md5(String.valueOf(data.getId()));
            String[] nameParam = origin.split("\\.");

            String resourcePath = System.getProperty("user.dir");
            String url = resourcePath + "\\static" + "\\" + node + "\\" + position_name + "." + nameParam[nameParam.length - 1];

            System.out.println("------------------------");
            System.out.println(url);
            java.io.File localFile = new java.io.File(url);

            if (!localFile.getParentFile().exists()) {
                localFile.mkdirs();
            }

            if (localFile.exists()) {
                localFile.delete();
            }

            try {
                file.transferTo(localFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Result.suc("上传成功！");
        }

        return Result.fail("出错啦！");
    }

    @PostMapping("/play")
    public byte[] auditionMusic(@RequestBody File file) throws IOException {
        // 获取文件

        String position_name = Md5Utils.md5(String.valueOf(file.getId()));
        String node = HashNode.getNode(String.valueOf(file.getId()));
        String[] nameParam = file.getFilename().split("\\.");
        String resourcePath = System.getProperty("user.dir");
        String url = resourcePath + "\\static" + "\\" + node + "\\" + position_name + "." + nameParam[nameParam.length - 1];

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(url));
            return bytes;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    @PutMapping("/edit")
    public Result<String> editFile(@RequestBody File file) {
        try {
            service.update(file);
            return Result.suc("success edit file");
        } catch (Exception e) {
            System.out.println("--------------\n出错啦！\n--------------");
            System.out.println(e);
            return Result.fail("wrong edit file");
        }
    }

    @PostMapping("/save")
    public Result<String> saveFile(@RequestParam("file") MultipartFile file, @RequestParam("file-data") String body) {

        // 检查文件是否为空
        if (file.isEmpty()) {
            // 处理空文件的情况
        } else {
            Gson gson = new Gson();
            File data = gson.fromJson(body, File.class);

            service.update(data);
            String origin = file.getOriginalFilename();
            String node = HashNode.getNode(String.valueOf(data.getId()));
            String position_name = Md5Utils.md5(String.valueOf(data.getId()));
            String[] nameParam = origin.split("\\.");

            String resourcePath = System.getProperty("user.dir");
            String url = resourcePath + "\\static" + "\\" + node + "\\" + position_name + "." + nameParam[nameParam.length - 1];

            java.io.File localFile = new java.io.File(url);

            if (!localFile.getParentFile().exists()) {
                localFile.mkdirs();
            }

            if (localFile.exists()) {
                localFile.delete();
            }

            try {
                file.transferTo(localFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Result.suc("编辑成功！");
        }

        return Result.fail("出错啦！");
    }

    @PostMapping("/add")
    public Result<File> addFile(@RequestBody File file) {
        try {
            service.add(file);
            return Result.suc(file);
        } catch (Exception e) {
            System.out.println(e);
            return Result.fail("出错啦！");
        }
    }
}

