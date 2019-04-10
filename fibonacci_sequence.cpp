#include <iostream>
#include <iomanip>
using namespace std;
 
long double fib[1000000]; int x;
 
int main()
{
    cout << "How many Fibonacci numbers: ";
    cin>>x;
 
    fib[0]=0;
    fib[1]=1;
 
    for (int i=2; i<x; i++)
    {
        fib[i] = fib[i-1] + fib[i-2];
    }
cout<<setprecision(1000000);

    for (int i=0; i<x; i++)
    {
        cout<<fib[i]<<"  ";
    }
cout<<endl;

    return 0;
}
