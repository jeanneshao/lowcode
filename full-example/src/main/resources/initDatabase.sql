use low_code_configuration;
DROP TABLE if exists low_code_configuration.ui_project;
CREATE TABLE IF NOT EXISTS `ui_project`
(
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    asset_id       binary(16) comment '资产表里对应项目的ID',
    `project_code` VARCHAR(255) NOT NULL COMMENT '项目编码',
    `project_name` VARCHAR(255) NOT NULL COMMENT '项目名称',
    future_enhance json default null comment '预留字段',
    UNIQUE asset_id (asset_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='项目信息表';

DROP TABLE if exists low_code_configuration.ui_project_theme;
CREATE TABLE IF NOT EXISTS `ui_project_theme`
(
    id                       bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    project_id               bigint(20) NOT NULL COMMENT '项目ID,ui_project',
    login_img_name           varchar(255) DEFAULT NULL COMMENT '登录页左侧图片所在的部署地址',
    title_img_name           varchar(255) DEFAULT NULL COMMENT '浏览器Tab页图标所在的部署地址',
    frame_img_name           varchar(255) DEFAULT NULL COMMENT '页面导航栏图标所在的部署地址',
    logo_img_name            varchar(255) DEFAULT NULL COMMENT '登录页右侧项目图标所在的部署地址',
    q_primary                varchar(30)  DEFAULT NULL COMMENT '按钮颜色',
    q_secondary              varchar(30)  DEFAULT NULL COMMENT '高亮字段颜色',
    veris_primary            varchar(30)  DEFAULT NULL COMMENT '顶部栏颜色',
    veris_secondary          varchar(30)  DEFAULT NULL COMMENT '菜单栏底色',
    veris_third              varchar(30)  DEFAULT NULL COMMENT '详情页标题栏底色',
    veris_primary_contrast   varchar(30)  DEFAULT NULL COMMENT '菜单高亮色',
    veris_secondary_contrast varchar(30)  DEFAULT NULL COMMENT '详情页图标色',
    veris_bg_secondary       varchar(30)  DEFAULT NULL COMMENT '主背景色',
    veris_text_primary       varchar(30)  DEFAULT NULL COMMENT '字段文字颜色',
    veris_text_secondary     varchar(30)  DEFAULT NULL COMMENT '字段标题颜色',
    veris_text_third         varchar(30)  DEFAULT NULL COMMENT '表格右上角按钮颜色',
    veris_text_fourth        varchar(30)  DEFAULT NULL COMMENT '表格文字颜色',
    veris_tooltip_color      varchar(30)  DEFAULT NULL COMMENT 'Tooltip背景色',
    veris_textsize_primary   varchar(10)  DEFAULT NULL COMMENT '表格文字/表单标题字号大小',
    veris_textsize_secondary varchar(10)  DEFAULT NULL COMMENT '详情页正文字号大小',
    veris_textsize_third     varchar(10)  DEFAULT NULL COMMENT '正文最小高度、表格业务名、详情页实体名字',
    veris_btn_width          varchar(10)  DEFAULT NULL COMMENT '按钮默认宽度',
    future_enhance           json         default null comment '预留字段',

    UNIQUE project_id (project_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前台主题表';

DROP TABLE if exists low_code_configuration.ui_table;
CREATE TABLE IF NOT EXISTS `ui_table`
(
    id             bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    project_id     bigint(20)   NOT NULL COMMENT '项目主键ID',
    project_code   varchar(255)   NOT NULL COMMENT '项目编码',
    table_code     varchar(255) NOT NULL COMMENT '实体编号',
    table_name     varchar(255) NOT NULL COMMENT '实体名称',
    future_enhance json default null comment '预留字段',

    index project_id (project_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='项目资源表';

# DROP TABLE if exists low_code_configuration.ui_table_api;
# CREATE TABLE IF NOT EXISTS `ui_table_api`
# (
#     id              bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
#     table_id        bigint(20) NOT NULL COMMENT '接口对应的表的id',
#     api_type        ENUM ('独立列表查询', '详情查询', '关联列表查询', '待关联列表查询', '增删改接口'),
#     api_path        varchar(255) comment '接口路径',
#     path_variable   varchar(255) comment '路径参数',
#     query_param     varchar(255) comment '查询参数',
#     text_search     varchar(255) comment '后端约定查询条件',
#     pagination_type ENUM ('前台分页','后台分页','不展示分页'),
#
#     index table_id (table_id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8 COMMENT ='资源接口表';
#
# DROP TABLE if exists low_code_configuration.ui_table_labels;
# CREATE TABLE IF NOT EXISTS `ui_table_labels`
# (
#     id             bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增主键',
#     table_id       bigint(20)   NOT NULL COMMENT '',
#     label_position enum ('独立列表标题','详情页标题','被关联列表标题','待关联列表标题'),
#     label          varchar(255) NOT NULL COMMENT '',
#
#     PRIMARY KEY (`id`),
#     index table_id (table_id)
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8 COMMENT ='资源标题表';

DROP TABLE if exists low_code_configuration.ui_table_buttons;
CREATE TABLE IF NOT EXISTS `ui_table_buttons`
(
    id                bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    table_id          bigint(20) NOT NULL COMMENT 'asset表 type为tableResConf的表记录的id',
    button_position   enum ('外层表格右上角','外层表格右下角','外层表格行内','被关联表格右上角','被关联表格右下角','被关联表格行内','详情页右上角','详情页右下角'),
    custom_button     TINYINT(1) NOT NULL DEFAULT '0' comment '0-内嵌按钮 1-特殊按钮',
    integrated_button enum ('commonBatchDelete','commonRefresh','commonCreate','commonDetails','commonSingleDelete','commonSingleAssociationDelete','commonBatchAssociationDelete','openEditDialog','goToDetailPage'),
    button_name       varchar(255) comment '自定义按钮的名称',
    button_icon       varchar(255) comment '自定义按钮的icon',
    click_action      varchar(255) comment '调用的方法',
    show_button       varchar(255) comment '是否展示的逻辑',
    index table_id (table_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='资源按钮表';

DROP TABLE if exists low_code_configuration.ui_table_tabs;
CREATE TABLE IF NOT EXISTS `ui_table_tabs`
(
    id               bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    table_id         bigint(20) NOT NULL COMMENT 'asset表 type为tableResConf的表记录的id',
    associated_table varchar(255) comment '详情页嵌套资源',
    tab_title        varchar(255) comment '嵌套资源标题',
    tab_component    varchar(255) comment 'Tab页组件',
    future_enhance   json default null comment '预留字段',

    index table_id (table_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='资源Tab页展示的子资源表';

# DROP TABLE if exists low_code_configuration.ui_column_component;
# CREATE TABLE IF NOT EXISTS `ui_column_component`
# (
#     id                               bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
#     component_name                   varchar(255) comment '组件类型',
#     component_addition_configuration varchar(255) comment '附加表,如select是ui_column_select'
# ) ENGINE = InnoDB
#   AUTO_INCREMENT = 1
#   DEFAULT CHARSET = utf8 COMMENT ='前台组件类型配置表';

/*DROP TABLE if exists low_code_configuration.ui_column_value_type;
CREATE TABLE IF NOT EXISTS `ui_column_value_type`
(
    id              bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    value_type_name varchar(255) not null comment '组件原生类型'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前台组件原生类型配置表';
*/

DROP TABLE if exists low_code_configuration.ui_column;
CREATE TABLE IF NOT EXISTS `ui_column`
(
    id                  bigint(20)          NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    table_id            bigint(20)          NOT NULL COMMENT '字段所属的表ID',
    column_field        varchar(255) comment '字段',
    display_name        varchar(255) comment '字段展示名称',
    column_span         TINYINT(1) UNSIGNED NOT NULL DEFAULT 6 comment '宽度（1-12）',
    component           varchar(255)                 DEFAULT 'input' comment '组件类型', #enum('fileUploader','select','radioOptionGroup','checkboxOptionGroup','cascade','imageUploader','fileUploader','dialog','date','switch','checkbox','input','decimal','currency') comment '页面展示的组件类型',
    value_type          varchar(255)                 DEFAULT 'text' comment '组件原生类型',
    default_value       varchar(255) comment '页面默认值',
    suffix              varchar(255) comment '后缀',
    tooltip             varchar(255) comment '提示信息',
    associated_table_id bigint(20)                   default null comment '关联资源编码,若不为null，需要根据表和字段查询ui_column_query_mapping，组一个数组',
    physical_column     varchar(255)                 default null comment '若不为null，表示该字段是一个虚字段，physical_column指向实际字段',
    future_enhance      json                         default null comment '为后续新增字段及功能预留',

    index table_id (table_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前台资源字段表';

/*
DROP TABLE if exists low_code_configuration.ui_column_select;
CREATE TABLE IF NOT EXISTS `ui_column_select`
(
    id                bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
#     table_id         bigint(20) NOT NULL COMMENT '表',
    column_id         bigint(20) NOT NULL COMMENT '字段',
    source            enum ('Fixed','EnumerationTable','Api' ) comment '枚举来源',
    static_options    json comment '静态枚举选项',
    enum_type         varchar(255) DEFAULT NULL comment 'low_code_configuration.sys_enum type字段',
    source_api        varchar(255) DEFAULT NULL comment '选项来源接口',
    label_column      varchar(255) default 'label',
    value_column      varchar(255) default 'value',
    parent_column     varchar(255) default 'parentValue',
    supports_multiple tinyint      default 0 comment '0-false 1-true',

    index column_id (column_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前台资源字段表附属表-select类型字段';

DROP TABLE if exists low_code_configuration.ui_column_file;
CREATE TABLE IF NOT EXISTS `ui_column_file`
(
    id                bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
#     table_id          bigint(20) NOT NULL COMMENT '表',
    column_id         bigint(20) NOT NULL COMMENT '字段',
    upload_api        varchar(255) DEFAULT NULL comment '上传地址',
    ui_template_path  varchar(255) DEFAULT NULL comment '模板文件路径',
    ui_template_label varchar(255) DEFAULT NULL comment '模板文件名称',
    uploaded_template json         default null comment '已上传的模板文件信息',

    index column_id (column_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前台资源字段表附属表-file类型字段';
*/
use low_code_configuration;
DROP TABLE if exists low_code_configuration.ui_column_displays;
CREATE TABLE IF NOT EXISTS `ui_column_displays`
(
    id                bigint(20)          NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    table_id          bigint(20)          NOT NULL COMMENT '表',
    column_id         bigint(20)          NOT NULL COMMENT '字段',
    display_sequence  TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 comment '字段第几个展示',
    group_name        varchar(255)                 default '' comment '字段分组', #enum('fileUploader','select','radioOptionGroup','checkboxOptionGroup','cascade','imageUploader','fileUploader','dialog','date','switch','checkbox','input','decimal','currency') comment '页面展示的组件类型',
    group_icon        json comment '分组的图标',
    display_positions enum ('TableStandAlone','TableAssociated','Table2Associate','EditDialog','FormGroupEdit','DetailPage','DetailPageGroup','TitleLane','TableStandAloneQueryCriteria','TableAssociatedQueryCriteria','Table2AssociateQueryCriteria','NameKey') comment '字段分组位置',

    index table_id (table_id, display_positions)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='不同位置要展示哪些字段，以及字段顺序';


DROP TABLE if exists low_code_configuration.ui_column_query_mapping;
CREATE TABLE IF NOT EXISTS `ui_column_query_mapping`
(
    id        bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    column_id bigint(20)   NOT NULL,
    table_id  bigint(20)   NOT NULL COMMENT '表',
    source    varchar(255) NOT NULL COMMENT '当前表字段',
    target    varchar(255) NOT NULL COMMENT '关联表字段',

    index column_id (column_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用于配置表单中需要关联其他表的字段，查询条件需要传过去的字段值';

DROP TABLE if exists low_code_configuration.ui_column_attribute;
CREATE TABLE IF NOT EXISTS `ui_column_attribute`
(
    id              bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '自增主键',
    table_id        bigint(20)   NOT NULL COMMENT '表',
    column_id       bigint(20)   NOT NULL,
    attribute_type  varchar(255) NOT NULL COMMENT '校验项',
    attribute_name  varchar(255) default null COMMENT '错误信息',
    attribute_value text         default null COMMENT '不能为空',
    index column_id (table_id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='前端字段属性表';












