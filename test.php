<?php
$_fp = fopen("php://stdin", "r");
$s = fgets($_fp);
$size=strlen($s)-1;
$h = ceil(sqrt($size));
$w = floor(sqrt($size));
if ($h*$w<$size)
    $w++;
$ar = array(array());
$x=0;
$y=0;
for ($i=0;$i<$size;$i++) {
    $ar[$x][$y]=$s[$i];
    $y++;
    if (($y)%$h==0) {
        $x++;
        $y=0;
    }
}
for ($i=0;$i<$h;$i++) {
    for ($j=0;$j<$w;$j++) {
        if (!empty($ar[$j][$i]))
            echo $ar[$j][$i];
    }
    echo " ";
}
