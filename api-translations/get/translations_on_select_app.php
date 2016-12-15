 <?php
 	#Connect to BBDD
	include '../connect_db.php';

	error_reporting(E_ERROR);

	// Check connection
	if (mysqli_connect_errno())
	{
	  echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$translations_texts_filt = $_GET['id']? $_GET['id'] : 'com.amugika.servirace';
	$translations_texts_filt = mysql_real_escape_string($translations_texts_filt);
	
	$rawdata = array(); //creamos un array

	include '../sql/manage.php';

	//$app_info = getSe
	$results= getSelectAppTranslateText($con, 0, 10, $translations_texts_filt);//mysqli_query($con,"SELECT * FROM `app`");
	
	if (mysqli_num_rows($results)>0)
	{

		while($row = mysqli_fetch_array($results, MYSQL_NUM ))
		{
			if (sizeof($rawdata) == 0)
			{
				$row_array['app_name'] = $row[12];
				$row_array['id'] = $row [11];
				$row_array['original_language'] = $row[16];
				$row_array['status'] = "1";
				array_push($rawdata,$row_array);
				unset($row_array);
			}

			$row_array['name'] = $row [1];
			$row_array['text_eu'] = $row [2];
			$row_array['text_en'] = $row [3];
			$row_array['text_es'] = $row [4];
			$row_array['text_ca'] = $row [5];
			$row_array['text_ga'] = $row [6];
			$row_array['text_pt'] = $row [7];
			$row_array['text_it'] = $row [8];
			
			array_push($rawdata,$row_array);
			unset($row_array);
		}
	}
	else
	{
			$row_array['app_name'] = "";
			$row_array['id'] = "";
			$row_array['name'] = "";
			$row_array['text_eu'] = "";
			$row_array['text_en'] = "";
			$row_array['text_es'] = "";
			$row_array['text_ca'] = "";
			$row_array['text_ga'] = "";
			$row_array['text_pt'] = "";
			$row_array['text_it'] = "";
			$row_array['original_language'] = "";
			
			$row_array['status'] = "0";
			
			array_push($rawdata,$row_array);
			unset($row_array);
	}
	

	
	echo json_encode($rawdata);

	mysqli_close($con);

?>