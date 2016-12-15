 <?php
 	#Connect to BBDD
	include '../connect_db.php';
	include '../active_cors.php';

	error_reporting(E_ERROR);

	// Check connection
	if (mysqli_connect_errno())
	{
	  echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	$app_id = $_GET['id'] ? $_GET['id'] : '';
	$page = $_GET['page'] ? $_GET['page']: 0;
	$limit_per_page = $_GET['limit'] ? $_GET['limit']: 20;
	
	$rawdata = array(); //creamos un array

	include '../sql/manage.php';
	$results= getAppsInfo($con, $page, $limit_per_page, $app_id);//mysqli_query($con,"SELECT * FROM `app`");
	
	if (mysqli_num_rows($results)>0)
	{

		while($row = mysqli_fetch_array($results, MYSQL_NUM ))
		{
			$row_array['id'] = $row [0];
			$row_array['name'] = $row [1];
			$row_array['description'] = $row [2];
			$row_array['first_published'] = $row [3];
			$row_array['last_update'] = $row [4];
			$row_array['original_language'] = $row [5];
			
			$row_array['status'] = "1";
			
			array_push($rawdata,$row_array);
			unset($row_array);
		}
	}
	else
	{
			$row_array['id'] = "";
			$row_array['name'] = "";
			$row_array['description'] = "";
			$row_array['first_published'] = "";
			$row_array['last_update'] = "";
			$row_array['original_language'] = $row [5];
			
			$row_array['status'] = "0";
			array_push($rawdata,$row_array);
	}
	

	
	echo json_encode($rawdata);

	mysqli_close($con);

?>