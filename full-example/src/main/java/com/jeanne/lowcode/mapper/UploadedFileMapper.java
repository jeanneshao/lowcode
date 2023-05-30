package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.entity.UploadedFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 上传文件管理表 Mapper 接口
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Mapper
public interface UploadedFileMapper extends BaseMapper<UploadedFile> {

}
