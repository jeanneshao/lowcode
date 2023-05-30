use low_code_configuration;

INSERT INTO `ui_project`(`id`, `asset_id`, `project_code`, `project_name`, `future_enhance`) VALUES (1, UNHEX(REPLACE('81d04ad1-242b-4e13-be06-722ba8cd2c80', '-', '')), 'veris-lite-agentview', 'Veris Lite AgentView', NULL);

INSERT INTO `ui_project_theme`(`id`, `project_id`, `login_img_name`, `title_img_name`, `frame_img_name`, `logo_img_name`, `q_primary`, `q_secondary`, `veris_primary`, `veris_secondary`, `veris_third`, `veris_primary_contrast`, `veris_secondary_contrast`, `veris_bg_secondary`, `veris_text_primary`, `veris_text_secondary`, `veris_text_third`, `veris_text_fourth`, `veris_tooltip_color`, `veris_textsize_primary`, `veris_textsize_secondary`, `veris_textsize_third`, `veris_btn_width`, `future_enhance`) VALUES (2, 1, NULL, NULL, NULL, NULL, '#666888', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO `ui_table`(`id`, `project_id`, `table_code`, `table_name`, `future_enhance`) VALUES (1, 1, 'order-task', '批量订单', NULL);
INSERT INTO `ui_table`(`id`, `project_id`, `table_code`, `table_name`, `future_enhance`) VALUES (2, 1, 'resource-operation-history', '操作历史', NULL);

INSERT INTO `ui_table_api`(`id`, `table_id`, `api_type`, `api_path`, `path_variable`, `query_param`, `text_search`, `pagination_type`) VALUES (1, 1, '独立列表查询', '/resetful/order_manage/order/batch', NULL, '{key:\'page\'}, {key:\'pageSize\'}, {key:\'sortOrder\'},{key:\'sortProperty\',defaultValue:\'uploadDate\'}, {key:\'textSearch\'}', NULL, '后台分页');
INSERT INTO `ui_table_api`(`id`, `table_id`, `api_type`, `api_path`, `path_variable`, `query_param`, `text_search`, `pagination_type`) VALUES (2, 1, '详情查询', '/resetful/order_manage/order/batch/{id}', NULL, NULL, NULL, NULL);
INSERT INTO `ui_table_api`(`id`, `table_id`, `api_type`, `api_path`, `path_variable`, `query_param`, `text_search`, `pagination_type`) VALUES (3, 1, '增删改接口', '/resetful/order_manage/order/batch', NULL, NULL, NULL, NULL);

INSERT INTO `ui_table_labels`(`id`, `table_id`, `label_position`, `label`) VALUES (1, 1, '独立列表标题', '订单任务列表');

INSERT INTO `ui_table_buttons`(`id`, `table_id`, `button_position`, `custom_button`, `integrated_button`, `button_name`, `button_icon`, `click_action`, `show_button`) VALUES (1, 1, '外层表格右上角', 0, 'commonCreate', NULL, NULL, NULL, NULL);
INSERT INTO `ui_table_buttons`(`id`, `table_id`, `button_position`, `custom_button`, `integrated_button`, `button_name`, `button_icon`, `click_action`, `show_button`) VALUES (2, 1, '外层表格右上角', 0, 'commonRefresh', NULL, NULL, NULL, NULL);
INSERT INTO `ui_table_buttons`(`id`, `table_id`, `button_position`, `custom_button`, `integrated_button`, `button_name`, `button_icon`, `click_action`, `show_button`) VALUES (3, 1, '外层表格行内', 0, 'goToDetailPage', NULL, NULL, NULL, NULL);
INSERT INTO `ui_table_buttons`(`id`, `table_id`, `button_position`, `custom_button`, `integrated_button`, `button_name`, `button_icon`, `click_action`, `show_button`) VALUES (4, 1, '详情页右上角', 1, 'commonBatchDelete', 'Stop Process', NULL, NULL, NULL);
INSERT INTO `ui_table_buttons`(`id`, `table_id`, `button_position`, `custom_button`, `integrated_button`, `button_name`, `button_icon`, `click_action`, `show_button`) VALUES (5, 1, '详情页右上角', 1, 'commonBatchDelete', 'Start Process', NULL, NULL, NULL);


INSERT INTO `ui_table_tabs`(`id`, `table_id`, `associated_table`, `tab_title`, `tab_component`, `future_enhance`) VALUES (1, 1, '2', '订单操作历史', NULL, NULL);
INSERT INTO `ui_table_tabs`(`id`, `table_id`, `associated_table`, `tab_title`, `tab_component`, `future_enhance`) VALUES (2, 1, NULL, NULL, 'approvalProcess', NULL);
INSERT INTO `ui_table_tabs`(`id`, `table_id`, `associated_table`, `tab_title`, `tab_component`, `future_enhance`) VALUES (3, 1, NULL, NULL, 'teams', NULL);
use low_code_configuration;
INSERT INTO `ui_column`(`id`, `table_id`, `column_field`,`display_name`, `column_span`, `component`, `value_type`, `default_value`, `suffix`, `tooltip`, `associated_table_id`, `physical_column`, `future_enhance`) VALUES (1, 1, 'uploadDate', 'Example Related', 6, 9, 6, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ui_column`(`id`, `table_id`, `column_field`,`display_name`, `column_span`, `component`, `value_type`, `default_value`, `suffix`, `tooltip`, `associated_table_id`, `physical_column`, `future_enhance`) VALUES (2, 1, 'exampleRelated','Example Related', 6, 8, 6, NULL, NULL, NULL, 2, NULL, NULL);

INSERT INTO `ui_column_displays`(`id`, `table_id`, `column_id`, `sequence`, `group_name`, `display_positions`) VALUES (1, 1, 1, 200, '', 'TableStandAlone');
INSERT INTO `ui_column_displays`(`id`, `table_id`, `column_id`, `sequence`, `group_name`, `display_positions`) VALUES (2, 1, 2, 30, '', 'TableStandAlone');
INSERT INTO `ui_column_displays`(`id`, `table_id`, `column_id`, `sequence`, `group_name`, `display_positions`) VALUES (3, 1, 1, 12, '', 'TableAssociated');
INSERT INTO `ui_column_displays`(`id`, `table_id`, `column_id`, `sequence`, `group_name`, `display_positions`) VALUES (4, 1, 2, 3, '', 'EditDialog');


INSERT INTO `ui_column_attribute`(`id`, `table_id`, `column_id`, `attribute_type`, `attribute_name`, `attribute_value`) VALUES (1, 1, 1, 'date', 'dateFormat', 'YYYYMM');
INSERT INTO `ui_column_attribute`(`id`, `table_id`, `column_id`, `attribute_type`, `attribute_name`, `attribute_value`) VALUES (2, 1, 1, 'defaultValue', 'defaultValue', 'now');

INSERT INTO `ui_column_query_mapping`(`id`, `column_id`, `table_id`, `source`, `target`) VALUES (1, 2, 1, 'userId', 'id');

# INSERT INTO `ui_column_validations`(`id`, `table_id`, `column_id`, `validation_type`, `error_message`, `parameters`, `custom_validation_script`) VALUES (1, 1, 1, 'required', NULL, NULL, NULL);

INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (1, 'fileUploader', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (2, 'multiFileUploader', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (3, 'select', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (4, 'radioOptionGroup', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (5, 'checkboxOptionGroup', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (6, 'cascade', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (7, 'imageUploader', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (8, 'dialog', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (9, 'date', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (10, 'checkbox', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (11, 'input', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (12, 'decimal', NULL);
INSERT INTO `ui_column_component`(`id`, `component_name`, `component_addition_configuration`) VALUES (13, 'currency', NULL);
