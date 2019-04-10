#!/usr/bin/bash

echo "Ile liczb Fibonacciego mam wyznaczyc?:"
read x

fib = (0,1);

i=2
while (i < x)  { 
fib[i] = fib[i-1] + fib[i-2];
i++;
}


for (z = 0; z < x; z++) {

    echo fib[z]

}
