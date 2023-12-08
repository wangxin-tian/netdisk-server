#

## 网盘后台

```sql
CREATE TABLE `user` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `username` varchar(32) COLLATE utf8_bin NOT NULL,
  `password` varchar(64) COLLATE utf8_bin NOT NULL,
  `createTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `avator` blob,
  `userinfo` text COLLATE utf8_bin,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
```

folder 文件夹实体

```sql

CREATE TABLE `folder` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文件夹id',
  `folder_name` varchar(50) NOT NULL,
  `parent` bigint(20) NOT NULL DEFAULT '0' COMMENT '上一级文件夹id，默认0',
  `userid` bigint(20) NOT NULL COMMENT '所属用户',
  `createTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `isDel` smallint(6) DEFAULT '0' COMMENT '是否删除 1为删除0没删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

file 文件实体

```sql
CREATE TABLE `file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户文件ID',
  `filename` varchar(100) NOT NULL COMMENT '用户对应文件的名字',
  `userid` bigint(255) unsigned NOT NULL COMMENT '所属用户',
  `filetype` char(2) DEFAULT NULL COMMENT '文件类型，1图片2音频3视频4文档5其他',
  `filesize` decimal(10,2) DEFAULT NULL COMMENT '文件大小',
  `folderid` bigint(255) unsigned NOT NULL COMMENT '文件所属文件夹',
  `createTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `isDel` smallint(6) DEFAULT '0' COMMENT '是否删除,1为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

log 日志实体

```sql
CREATE TABLE `log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
    `userid` bigint(255) NOT NULL COMMENT '记录人',
    `fileid` bigint(20) DEFAULT NULL COMMENT '操作的文件',
    `remark` varchar(255) DEFAULT NULL COMMENT '消息',
    `filelocation` varchar(255) DEFAULT NULL COMMENT '文件的位置',
    `createTime` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```