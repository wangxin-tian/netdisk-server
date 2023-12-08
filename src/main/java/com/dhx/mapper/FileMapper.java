package com.dhx.mapper;

import com.dhx.pojo.File;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface FileMapper {
    @Insert("insert into file (filename,userid,filetype,filesize,folderid) values (#{file.filename},#{file.userid},#{file.filetype},#{file.filesize},#{file.folderid})")
    @Options(useGeneratedKeys = true, keyProperty = "file.id")
    void add(@Param("file") File file);

    @Delete("delete from file where id = #{id}")
    void delete(Long id);

    @Update("update file set filename=#{file.filename}, filetype=#{file.filetype}, filesize=#{file.filesize}, folderid=#{file.folderid}, isDel=#{file.isDel}, isShare=#{file.isShare} where id=#{file.id}")
    void update(@Param("file") File file);

    @Select("select * from file where userid=#{file.userid} and folderid=#{file.folderid} and isDel=#{file.isDel}")
    List<File> get(@Param("file") File file);

    @Select("select * from file where userid=#{file.userid} and folderid=#{file.folderid} and isDel=#{file.isDel} and isShare=#{file.isShare}")
    List<File> share(@Param("file") File file);

}
