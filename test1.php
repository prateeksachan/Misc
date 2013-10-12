<?php
$_fp = fopen("php://stdin", "r");
$n = fgets($_fp);
$a = fgets($_fp);
$ar = str_replace(' ', ',', $a);
$ar = json_decode('[' . $ar . ']', true);
$arr = array_keys(array_count_values($ar));
$size = count($arr);
//var_dump($arr);
$sum=0;
for ($i=0;$i<$size-2;$i++) {
	for ($j=$i+1; $j<$size-1;$j++) {
		if ($arr[$i]>$arr[$j])
			continue;
		else {
			for ($k=$j+1; $k<$size;$k++) {
				if ($arr[$j]<$arr[$k])
					$sum++;
			}
		}
	}
}
echo $sum;
