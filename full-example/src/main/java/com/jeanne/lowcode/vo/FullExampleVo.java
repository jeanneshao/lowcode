package com.jeanne.lowcode.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeanne.lowcode.common.annotations.LowcodeAssociation;
import com.jeanne.lowcode.dto.OneToManyExampleDto;
import com.jeanne.lowcode.dto.OneToOneExampleDto;
import com.jeanne.lowcode.entity.LowcodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * entry resource
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullExampleVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @LowcodeAssociation(associationType = LowcodeAssociation.AssociationType.ONE_TO_ONE,associtedResource="one_to_one_resource")
    private String oneToOneResourceName;
    private Long oneToOneResource;


    /**
     * 时分
     */
    private LocalTime timeExample;

    /**
     * 时分秒
     */
    private LocalTime timeSecondExample;

    /**
     * 时间段-起始-时分秒
     */
    private LocalTime timeRangeBegin;

    /**
     * 时间段-结束-时分秒
     */
    private LocalTime timeRangeEnd;

    /**
     * 日期段-起始-年月
     */
    private LocalDate monthRangeBegin;

    /**
     * 日期段-结束-年月
     */
    private LocalDate monthRangeEnd;

    /**
     * 日期段-起始-年月日
     */
    private LocalDate dateRangeBegin;

    /**
     * 日期段-结束-年月日
     */
    private LocalDate dateRangeEnd;

    /**
     * 日期段-起始-年月日时分秒
     */
    private LocalDateTime datetimeRangeBegin;

    /**
     * 日期段-结束-年月日时分秒
     */
    private LocalDateTime datetimeRangeEnd;

    /**
     * 年
     */
    private LocalDateTime dateYearExample;

    /**
     * 年月
     */
    private LocalDateTime dateMonthExample;

    /**
     * 年月日
     */
    private LocalDateTime dateExample;

    /**
     * 年月日时分秒
     */
//    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeExample;

    /**
     * 数字
     */
    @OrderBy(asc = true,sort = 5)
    /**
     * @Version - 乐观锁标记
     */
    @Version
    private Long numberExample;

    /**
     * 小数
     */
    @OrderBy(asc = false,sort = 10)
    private Long doubleExample;

    /**
     * 横向多选框
     */
    private String checkboxOptionGroup;

    /**
     * 横向多选框
     */

    private Long cogWithEnumOptions;
    private String cogWithEnumName;
    /**
     * 横向多选框
     */
    private String cogWithBackendOptions;

    /**
     * 横向单选框
     */
    private String radioOptionGroup;

    /**
     * 横向单选框
     */
    private Long rogWithEnumOptions;
    private String rogWithEnumName;

    /**
     * 横向单选框
     */
    private String rogWithBackendOptions;

    /**
     * 输入框
     */
    private String inputExample;

    /**
     * 邮箱
     */
    private String emailExample;

    /**
     * 输入框
     */
    private String name;

    /**
     * 下拉框-固定选项
     */
    private String selectWithFixedOptions;

    /**
     * 下拉框-查枚举选项
     */

    private Long selectWithEnumOptions;
    private String selectWithEnumName;
    /**
     * 下拉框-查接口选项
     */
    private String selectWithBackendOptions;

    /**
     * 级联下拉框-固定选项
     */
    private String cascadeWithFixedOptions;

    /**
     * 级联下拉框-查枚举选项
     */
    private String cascadeWithBackendOptions;

    /**
     * 级联下拉框-查接口选项
     */
    private Long cascadeWithEnumOptions;
    private String enumCascadeName;

    /**
     * 级联下拉框-多选-固定选项
     */
    private String cascademultiWithFixedOptions;

    /**
     * 级联下拉框-多选-查枚举选项
     */
    private String cascademultiWithBackendOptions;

    /**
     * 级联下拉框-多选-查接口选项
     */
    private String cascademultiWithEnumOptions;

    /**
     * 图片上传
     */
    private String imageUploadExample;

    /**
     * 文件上传
     */
    private String fileUploadExample;

    /**
     * 多个文件上传
     */
    private String multiFileExample;

    /**
     * 勾选框
     */
    private Boolean checkboxExample;

    /**
     * 多行输入
     */
    @TableField(insertStrategy=FieldStrategy.NOT_NULL)
    private String textAreaExample;

//    @TableLogic
//    private Integer deleted;

    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(value = "UPDATE_TIME",fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
