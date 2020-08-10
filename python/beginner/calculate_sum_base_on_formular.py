number = int(input('Enter a number: '))
def firstFormular(number):
    total = 0
    for x in range(1, number + 1):
        total += x
    print('1 + 2 + 3 + ... + n:', total)

def secondFormular(number):
    total = 0
    for x in range(1, number + 1):
        total += x**3
    print('1^3 + 2^3 + 3^3 + ... + n^3:', total)

def thirthFormular(number):
    total = 0
    for x in range(1, number + 1):
        total += 1/x
    print('1 + 1/2 + 1/3 + ... + 1/n:', total)

def fourthFormular(number):
    total = 0
    for x in range(1, number + 1):
        if (x != 1):
            total += 1/((x-1)*x)
        else:
            total += 1
    print('1+ 1/(1*2) + 1/(2*3) + ... + 1/((n-1)*n):', total)

firstFormular(number)
