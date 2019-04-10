####fibonacci_sequence

x = input("How many Fibonacci numbers:")
x = int(x)

fib = [0, 1]

i = 2
while i < x:
    fib.append(fib[i-1] + fib[i-2])
    i += 1

print("Fibonacci numbers:", fib[:x])
