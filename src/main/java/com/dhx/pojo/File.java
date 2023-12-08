package com.dhx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.sql.Timestamp;

@TableName(value = "file")
public class File {
    private Long id;
    private String filename;
    private Long userid;
    private String filetype;
    private BigDecimal filesize;
    private Long folderid;
    private Timestamp createTime;
    private int isDel;
    private int isShare;

    // 省略getter和setter方法

    public int getIsShare() {
        return isShare;
    }

    public void setIsShare(int isShare) {
        this.isShare = isShare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public BigDecimal getFilesize() {
        return filesize;
    }

    public void setFilesize(BigDecimal filesize) {
        this.filesize = filesize;
    }

    public Long getFolderid() {
        return folderid;
    }

    public void setFolderid(Long folderid) {
        this.folderid = folderid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", userid=" + userid +
                ", filetype='" + filetype + '\'' +
                ", filesize=" + filesize +
                ", folderid=" + folderid +
                ", createTime=" + createTime +
                ", isDel=" + isDel +
                ", isShare=" + isShare +
                '}';
    }
}