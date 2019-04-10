#!/usr/bin/perl

print "Ile liczb Fibonacciego mam wyznaczyc?:";
$x = <>;

@fib = (0,1);

$i=2;
while ($i < $x)  { 
$fib[$i] = $fib[$i-1] + $fib[$i-2];
$i++;
}


for ($z = 0; $z < $x; $z++) {

    print $fib[$z];

}
print "\n";
