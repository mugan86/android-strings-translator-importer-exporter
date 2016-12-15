<?php
	/****************************************************************************************************************************************
	File with contains sql instructions. Call from sql/manage.php file and return instruction string to use in query
	@author: Anartz Mugika
	@email: mugan86@gmail.com
	@update: 2016/12/15 10:45
	****************************************************************************************************************************************/


	/****************************************************************************************
	$page = current_page.
	$limit_per_page = elements per page. Maximun 20 results
	$id= 'id' of select app to show only filt id app
	*****************************************************************************************/
	function getAllAppsInfoSQL($page, $limit_per_page, $id)
	{
		if ($limit_per_page > 20) $limit_per_page = 20;
		if ($id == "") return "SELECT * FROM `app` LIMIT " . $page. ",". $limit_per_page;
		return "SELECT * FROM `app` WHERE id = '". $id . "' LIMIT " . $page. ",". $limit_per_page;
	} 
	/****************************************************************************************
	$page = current_page.
	$limit_per_page = elements per page. Maximun 20 results
	$translations_texts_filt= 'id' of select app to show relational translate texts
	*****************************************************************************************/
	function getSelectAppTexts($page, $limit_per_page, $translations_texts_filt)
	{
		return "SELECT * FROM `translations` T, `app` A WHERE A.id = T.app_id AND T.app_id = '". $translations_texts_filt."' ORDER BY `T`.`id` ASC LIMIT " . $page. ",". $limit_per_page;
	} 

	/****************************************************************************************
	$translations_texts_filt= 'id' of select app to show relational translate texts (Without LIMIT)
	*****************************************************************************************/
	function getSelectAppTextsWithoutLimit($translations_texts_filt)
	{

		return "SELECT * FROM `translations` T, `app` A WHERE A.id = T.app_id AND T.app_id = '". $translations_texts_filt."'";
	} 

?>