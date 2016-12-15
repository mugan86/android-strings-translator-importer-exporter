<?php

	include '../constants/sql.php';

	//Get SQL instruction to get all apps info (default limit 10 result)
	function getAppsInfo($con, $current_page, $limit_per_page, $id)
	{
		return mysqli_query($con, getAllAppsInfoSQL($current_page, $limit_per_page, $id));
	}

	//Get SQL instruction to get all apps info (default limit 10 result)
	function getSelectAppTranslateText($con, $current_page, $limit_per_page, $translations_texts_filt)
	{
		return mysqli_query($con, getSelectAppTexts($current_page, $limit_per_page, $translations_texts_filt));
	}

	//Get Translate Items total to select app
	function getSelectAppTranslateTextsRows($con, $translations_texts_filt)
	{
		return mysqli_num_rows(mysqli_query($con, getSelectAppTextsWithoutLimit($translations_texts_filt)));
	}
?>