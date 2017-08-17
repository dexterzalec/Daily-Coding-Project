<?php
require 'vendor/autoload.php';
//use guzzle
use GuzzleHttp\Client;
use GuzzleHttp\Cookie\CookieJarInterface;
$jar = new \GuzzleHttp\Cookie\CookieJar();
//set header information including cookies, referer, etc. 
$client = new GuzzleHttp\Client([
'cookies' => true,
'headers' => [
'Host'=> 'fpt-api.XXXXX.com',
'User-Agent' => 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0',
'Accept'=> '*/*',
'Accept-Language'=> 'en-US,en;q=0.5',
'Accept-Encoding'=> 'gzip, deflate, br',
'Referer'=> 'https://tools.XXXXX.com/',
'Cookie'=> '__cfduid=XXXXXX; optimizelyEndUserId=oeu1498769689109r0.32368438346411443; optimizelySegments=%7XX; _vis_opt_test_cookie=1; _vwo_uuid=AF15229BDFDAB8BA12asdasB9561E984147AE; _vis_opt_exp_163_combi=2; optimizelyPendingLogEvents=%5B%22n%3Dhttps%253asdasdA%252F%252Ftools.XXXXX.com%252F%26u%3Doeu1498769689109r0.32368438346411443%26wxhr%3Dtrue%26time%3D1asd501859409.619%26asd345435f%3D8430845asd915%26g%3D%22%5D',
'Connection'=> 'keep-alive'
]
]
);
//finally call the url with the correct headers
$response = $client->get('https://fpt-api.XXXXX.com/api/0.1/tests?callback=jQuery224004950846138043652_1501859409649&limit=1000&_=1501859409650');
$body = (string) $response->getBody()->getContents();
echo $body;
echo "<br /><br /><br />";
//use regex to only collect the urls within the code
$regex ='#,"url":"https?:\/\/(\w+.\w*-?\.?\w*\.?\w*)#';
//save all matched urls into a array called $matches
preg_match_all($regex,$body,$matches);
 
 
//connect to database
 $conn = new mySQLI('localhost','root','','scrapeping');
	 if ($conn->connect_error){
		 echo "error";
	 }
	//input all matches into the database 
	 for ($i =0; $i< count($matches[1])-1; $i++){
		 $j=$matches[1][$i];
	
		 $query= "INSERT INTO results2 (url) VALUES ('$j')";
		 if(mysqli_query($conn, $query)){
			 echo " Value Added to Database: ". $j . "<br />";
		 }
		 else{
			 echo "error";
		 }
		 
	 }
	 
 
?>
