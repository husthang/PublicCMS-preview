-- 20170618 --
UPDATE `sys_moudle` SET `authorized_url` =  'cmsContent/push_content,cmsContent/push_content_list,cmsContent/push_to_content,cmsContent/push_page,cmsContent/push_page_list,cmsPlace/add,cmsPlace/save,cmsContent/related' WHERE  `sys_moudle`.`id` =23;
UPDATE `sys_moudle` SET `authorized_url` =  'cmsPlace/push,cmsPlace/add,cmsPlace/save' WHERE  `sys_moudle`.`id` =29;
UPDATE `sys_moudle` SET `url` =  null,`authorized_url` =  null WHERE  `sys_moudle`.`id` =30;
UPDATE `sys_moudle` SET `authorized_url` =  'cmsTemplate/save,cmsTemplate/chipLookup,cmsWebFile/lookup,placeTemplate/form,cmsWebFile/contentForm,cmsTemplate/demo,cmsTemplate/help,cmsTemplate/upload,cmsTemplate/doUpload' WHERE  `sys_moudle`.`id` =41;
UPDATE `sys_moudle` SET name = '页面片段模板',attached = '<i class="icon-list-alt icon-large"></i>',`url` =  'placeTemplate/list',`authorized_url` =  NULL,`menu` = 1,`parent_id` = 38 WHERE  `sys_moudle`.`id` =42;
UPDATE `sys_moudle` SET `authorized_url` =  'cmsPage/save,file/doUpload,cmsPage/clearCache' WHERE  `sys_moudle`.`id` =48;
UPDATE `sys_moudle` SET `url` =  'cmsPlace/add',`authorized_url` =  'cmsContent/lookup,cmsPlace/lookup,cmsPlace/lookup_content_list,file/doUpload,cmsPlace/save',`parent_id` = 107 WHERE  `sys_moudle`.`id` =49;
UPDATE `sys_moudle` SET `parent_id` = 112 WHERE  `sys_moudle`.`id` in(47,48);
UPDATE `sys_moudle` SET `authorized_url` =  '',`parent_id` = 107 WHERE  `sys_moudle`.`id` in(50,51,52,53,54);
UPDATE `sys_moudle` SET `url` =  'sysDomain/domainList' WHERE  `sys_moudle`.`id` = 84;
UPDATE `sys_moudle` SET `url` =  'sysDomain/config',`authorized_url` =  'sysDomain/saveConfig,cmsTemplate/directoryLookup,cmsTemplate/lookup' WHERE  `sys_moudle`.`id` =100;
UPDATE `sys_moudle` SET name = '页面片段管理',attached = '<i class="icon-list-alt icon-large"></i>',`url` =  'cmsPlace/list',`authorized_url` =  'sysUser/lookup,cmsPlace/data_list',`menu` = 1,`parent_id` = 30,`sort` = 1 WHERE  `sys_moudle`.`id` =107;
INSERT INTO `sys_moudle` VALUES ('110', '修改模板元数据', 'placeTemplate/metadata', 'cmsTemplate/savePlaceMetaData', NULL, '42', '1', '0');
INSERT INTO `sys_moudle` VALUES ('111', '修改模板', 'placeTemplate/content', 'cmsTemplate/help,cmsTemplate/chipLookup,cmsWebFile/lookup,cmsWebFile/contentForm,placeTemplate/form', NULL, '42', '1', '0');
INSERT INTO `sys_moudle` VALUES ('112', '页面管理', 'cmsPage/list', 'cmsPage/metadata,sysUser/lookup,cmsContent/lookup,cmsContent/lookup_list,cmsCategory/lookup', '<i class=\"icon-globe icon-large\"></i>', '30', '1', '0');
INSERT INTO `sys_moudle` VALUES ('113', '刷新缓存', NULL, 'clearCache', '', NULL, '0', '1');