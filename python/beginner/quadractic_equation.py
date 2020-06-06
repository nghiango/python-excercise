import math
print('Please enter a, b, c to solve ax^2 + bx + c = 0')
a = int(input('Enter a: '))
b = int(input('Enter b: '))
c = int(input('Enter c: '))

delta = b**2 - 4*a*c

if delta < 0:
    print('Quadratic equatiton has no linear equation')
elif delta == 0:
    x = -b/(2*a)
    print('Quadratic equatiton has couple linear equations are', x)
else:
    x1 = (-b + math.sqrt(delta))/(2*a)
    x2 = (-b - math.sqrt(delta))/(2*a)
    print('Quadratic equation has two distiguish linear equationns')
    print('First degree equation', x1)
    print('Second degree equation', x2)
