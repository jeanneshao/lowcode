# create database if not exists low_code;

create table if not exists full_example
(
    id                                bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    one_to_one_resource               bigint       DEFAULT NULL COMMENT '关联实体',
    time_example                      TIME         DEFAULT NULL NULL COMMENT '时分',
    time_second_example               TIME(0)      DEFAULT NULL NULL COMMENT '时分秒',
    time_range_begin                  TIME         DEFAULT NULL NULL COMMENT '时间段-起始-时分秒',
    time_range_end                    TIME         DEFAULT NULL NULL COMMENT '时间段-结束-时分秒',
    month_range_begin                 DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月',
    month_range_end                   DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月',
    date_range_begin                  DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月日',
    date_range_end                    DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月日',
    datetime_range_begin              DATETIME     DEFAULT NULL NULL COMMENT '日期段-起始-年月日时分秒',
    datetime_range_end                DATETIME     DEFAULT NULL NULL COMMENT '日期段-结束-年月日时分秒',
    date_year_example                 DATETIME     DEFAULT NULL NULL COMMENT '年',
    date_month_example                DATETIME     DEFAULT NULL NULL COMMENT '年月',
    date_example                      DATETIME     DEFAULT NULL NULL COMMENT '年月日',
    date_time_example                 DATETIME     DEFAULT NULL NULL COMMENT '年月日时分秒',
    number_example                    bigint       DEFAULT NULL NULL COMMENT '数字',
    double_example                    DECIMAL      DEFAULT NULL NULL COMMENT '小数',
    checkbox_option_group             varchar(256) default null null comment '横向多选框',
    cog_with_enum_options             varchar(256) default null null comment '横向多选框',
    cog_with_backend_options          varchar(256) default null null comment '横向多选框',
    radio_option_group                varchar(256) default null null comment '横向单选框',
    rog_with_enum_options             varchar(256) default null null comment '横向单选框',
    rog_with_backend_options          varchar(256) default null null comment '横向单选框',
    input_example                     varchar(256) default null null comment '输入框',
    email_example                     varchar(256) default null null comment '邮箱',
    name                              varchar(256) default null null comment '输入框',
    select_with_fixed_options         varchar(256) default null null comment '下拉框-固定选项',
    select_with_enum_options          varchar(256) default null null comment '下拉框-查枚举选项',
    select_with_backend_options       varchar(256) default null null comment '下拉框-查接口选项',
    cascade_with_fixed_options        varchar(256) default null null comment '级联下拉框-固定选项',
    cascade_with_backend_options      varchar(256) default null null comment '级联下拉框-查枚举选项',
    cascade_with_enum_options         varchar(256) default null null comment '级联下拉框-查接口选项',
    cascadeMulti_with_fixed_options   varchar(256) default null null comment '级联下拉框-多选-固定选项',
    cascadeMulti_with_backend_options varchar(256) default null null comment '级联下拉框-多选-查枚举选项',
    cascadeMulti_with_enum_options    varchar(256) default null null comment '级联下拉框-多选-查接口选项',
    image_upload_example              varchar(256) default null null comment '图片上传',
    file_upload_example               varchar(256) default null null comment '文件上传',
    multi_file_example                varchar(256) default null null comment '多个文件上传',
    checkbox_example                  bool         default false comment '勾选框',
    text_area_example                 longtext     default null comment '多行输入'

)
    ENGINE = InnoDB comment 'entry resource'
    CHARACTER SET = utf8
    COLLATE = utf8_general_ci;

create table if not exists one_to_one_example
(
    id                                bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    time_example                      TIME         DEFAULT NULL NULL COMMENT '时分',
    time_second_example               TIME(0)      DEFAULT NULL NULL COMMENT '时分秒',
    time_range_begin                  TIME         DEFAULT NULL NULL COMMENT '时间段-起始-时分秒',
    time_range_end                    TIME         DEFAULT NULL NULL COMMENT '时间段-结束-时分秒',
    month_range_begin                 DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月',
    month_range_end                   DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月',
    date_range_begin                  DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月日',
    date_range_end                    DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月日',
    datetime_range_begin              DATETIME     DEFAULT NULL NULL COMMENT '日期段-起始-年月日时分秒',
    datetime_range_end                DATETIME     DEFAULT NULL NULL COMMENT '日期段-结束-年月日时分秒',
    date_year_example                 DATETIME     DEFAULT NULL NULL COMMENT '年',
    date_month_example                DATETIME     DEFAULT NULL NULL COMMENT '年月',
    date_example                      DATETIME     DEFAULT NULL NULL COMMENT '年月日',
    date_time_example                 DATETIME     DEFAULT NULL NULL COMMENT '年月日时分秒',
    number_example                    bigint       DEFAULT NULL NULL COMMENT '数字',
    double_example                    DECIMAL      DEFAULT NULL NULL COMMENT '小数',
    checkbox_option_group             varchar(256) default null null comment '横向多选框',
    cog_with_enum_options             varchar(256) default null null comment '横向多选框',
    cog_with_backend_options          varchar(256) default null null comment '横向多选框',
    radio_option_group                varchar(256) default null null comment '横向单选框',
    rog_with_enum_options             varchar(256) default null null comment '横向单选框',
    rog_with_backend_options          varchar(256) default null null comment '横向单选框',
    input_example                     varchar(256) default null null comment '输入框',
    email_example                     varchar(256) default null null comment '邮箱',
    name                              varchar(256) default null null comment '输入框',
    select_with_fixed_options         varchar(256) default null null comment '下拉框-固定选项',
    select_with_enum_options          varchar(256) default null null comment '下拉框-查枚举选项',
    select_with_backend_options       varchar(256) default null null comment '下拉框-查接口选项',
    cascade_with_fixed_options        varchar(256) default null null comment '级联下拉框-固定选项',
    cascade_with_backend_options      varchar(256) default null null comment '级联下拉框-查枚举选项',
    cascade_with_enum_options         varchar(256) default null null comment '级联下拉框-查接口选项',
    cascadeMulti_with_fixed_options   varchar(256) default null null comment '级联下拉框-多选-固定选项',
    cascadeMulti_with_backend_options varchar(256) default null null comment '级联下拉框-多选-查枚举选项',
    cascadeMulti_with_enum_options    varchar(256) default null null comment '级联下拉框-多选-查接口选项',
    image_upload_example              varchar(256) default null null comment '图片上传',
    file_upload_example               varchar(256) default null null comment '文件上传',
    multi_file_example                varchar(256) default null null comment '多个文件上传',
    checkbox_example                  bool         default false comment '勾选框',
    text_area_example                 longtext     default null comment '多行输入'

)
    ENGINE = InnoDB comment '一对一的关联表'
    CHARACTER SET = utf8
    COLLATE = utf8_general_ci;
create table if not exists one_to_many_example
(
    id                                bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    time_example                      TIME         DEFAULT NULL NULL COMMENT '时分',
    time_second_example               TIME(0)      DEFAULT NULL NULL COMMENT '时分秒',
    time_range_begin                  TIME         DEFAULT NULL NULL COMMENT '时间段-起始-时分秒',
    time_range_end                    TIME         DEFAULT NULL NULL COMMENT '时间段-结束-时分秒',
    month_range_begin                 DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月',
    month_range_end                   DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月',
    date_range_begin                  DATE         DEFAULT NULL NULL COMMENT '日期段-起始-年月日',
    date_range_end                    DATE         DEFAULT NULL NULL COMMENT '日期段-结束-年月日',
    datetime_range_begin              DATETIME     DEFAULT NULL NULL COMMENT '日期段-起始-年月日时分秒',
    datetime_range_end                DATETIME     DEFAULT NULL NULL COMMENT '日期段-结束-年月日时分秒',
    date_year_example                 DATETIME     DEFAULT NULL NULL COMMENT '年',
    date_month_example                DATETIME     DEFAULT NULL NULL COMMENT '年月',
    date_example                      DATETIME     DEFAULT NULL NULL COMMENT '年月日',
    date_time_example                 DATETIME     DEFAULT NULL NULL COMMENT '年月日时分秒',
    number_example                    bigint       DEFAULT NULL NULL COMMENT '数字',
    double_example                    DECIMAL      DEFAULT NULL NULL COMMENT '小数',
    checkbox_option_group             varchar(256) default null null comment '横向多选框',
    cog_with_enum_options             varchar(256) default null null comment '横向多选框',
    cog_with_backend_options          varchar(256) default null null comment '横向多选框',
    radio_option_group                varchar(256) default null null comment '横向单选框',
    rog_with_enum_options             varchar(256) default null null comment '横向单选框',
    rog_with_backend_options          varchar(256) default null null comment '横向单选框',
    input_example                     varchar(256) default null null comment '输入框',
    email_example                     varchar(256) default null null comment '邮箱',
    name                              varchar(256) default null null comment '输入框',
    select_with_fixed_options         varchar(256) default null null comment '下拉框-固定选项',
    select_with_enum_options          varchar(256) default null null comment '下拉框-查枚举选项',
    select_with_backend_options       varchar(256) default null null comment '下拉框-查接口选项',
    cascade_with_fixed_options        varchar(256) default null null comment '级联下拉框-固定选项',
    cascade_with_backend_options      varchar(256) default null null comment '级联下拉框-查枚举选项',
    cascade_with_enum_options         varchar(256) default null null comment '级联下拉框-查接口选项',
    cascadeMulti_with_fixed_options   varchar(256) default null null comment '级联下拉框-多选-固定选项',
    cascadeMulti_with_backend_options varchar(256) default null null comment '级联下拉框-多选-查枚举选项',
    cascadeMulti_with_enum_options    varchar(256) default null null comment '级联下拉框-多选-查接口选项',
    image_upload_example              varchar(256) default null null comment '图片上传',
    file_upload_example               varchar(256) default null null comment '文件上传',
    multi_file_example                varchar(256) default null null comment '多个文件上传',
    checkbox_example                  bool         default false comment '勾选框',
    text_area_example                 longtext     default null comment '多行输入'

)
    ENGINE = InnoDB comment '一对多的关联表'
    CHARACTER SET = utf8
    COLLATE = utf8_general_ci;


create table if not exists select_with_backend
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '下拉框选项列表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists cog_with_backend
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '横向多选框选项列表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists rog_with_backend
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '横向单选框选项列表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists cascade_with_backend
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '级联单选选项列表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists cascadeMulti_with_backend
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '级联多选选项列表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists association_full_example_to_many
(
    id              bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    full_example_id bigint not null,
    one_to_many_id  bigint not null

) ENGINE = InnoDB comment '关联关系维护表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;
create table if not exists association_full_example_to_file
(
    id bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    entity_id bigint not null COMMENT '实体主键',
    file_id bigint not null  COMMENT '文件主键',
    deleted_flag bool default false comment '删除标识'

) ENGINE = InnoDB comment '实体和文件关联表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;
create table if not exists association_full_example_to_cog
(
    id bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    entity_id bigint not null COMMENT '实体主键',
    cog_id bigint not null  COMMENT '选项id',
    deleted_flag bool default false comment '删除标识'

) ENGINE = InnoDB comment '实体和文件关联表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;
create table if not exists association_full_example_to_cascade
(
    id bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    entity_id bigint not null COMMENT '实体主键',
    cascade_id bigint not null  COMMENT '文件主键',
    deleted_flag bool default false comment '删除标识'

) ENGINE = InnoDB comment '实体和文件关联表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;
create table if not exists association_full_example_to_enum
(
    id bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    entity_id bigint not null COMMENT '实体主键',
    enum_id bigint not null  COMMENT '文件主键',
    deleted_flag bool default false comment '删除标识'

) ENGINE = InnoDB comment '实体和文件关联表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;


create table if not exists uploaded_file
(
    id                bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    storage_directory varchar(256) default null,
    file_name         varchar(256) default null,
    file_suffix       varchar(256) default null,
    file_size         bigint       default null,
    comment           text         default null,
    deleted_flag      bool         default false
) ENGINE = InnoDB comment '上传文件管理表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;

create table if not exists lowcode_enum
(
    id    bigint AUTO_INCREMENT primary key COMMENT '自增主键',
    type  varchar(256) default null,
    value varchar(256) default null,
    label varchar(256) default null
) ENGINE = InnoDB comment '枚举表'
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci;