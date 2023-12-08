package com.dhx.mapper;

import com.dhx.pojo.Folder;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface FolderMapper {
    @Insert("insert into folder (folder_name, parent, userid) values (#{folderName},#{parent},#{userid})")
    void add(String folderName, Long parent, Long userid);

    @Delete("delete from folder where id = #{id}")
    void delete(Long id);

    @Update("update folder set folder_name=#{folder.folderName}, parent=#{folder.parent}, userid=#{folder.userid}, isDel=#{folder.isDel}, isShare=#{folder.isShare} where id=#{folder.id}")
    void update(@Param("folder") Folder folder);

    @Select("select * from folder where parent=#{folder.id} and userid=#{folder.userid} and isDel=#{folder.isDel}")
    List<Folder> get(@Param("folder") Folder folder);

    @Select("select * from folder where parent=#{folder.id} and userid=#{folder.userid} and isDel=#{folder.isDel} and isShare=#{folder.isShare}")
    List<Folder> share(@Param("folder") Folder folder);
}
