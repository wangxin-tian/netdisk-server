package com.dhx.mapper;

import com.dhx.pojo.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogMapper {
    @Delete("delete from log where id = #{id}}")
    void delete(String id);

    @Insert("insert into log (userid,fileid,remark,filelocation) values (#{log.userid},#{log.fileid},#{log.remark},#{log.filelocation})")
    void add(@Param("log") Log log);

    @Select("select * from log where userid = #{userid}} limit #{pageNum}, 10")
    List<Log> getAllLogsByUserId(Long userid, long pageNum);
}
