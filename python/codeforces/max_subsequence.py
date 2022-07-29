import sys

def input():
    [n] = [int(x) for x in sys.stdin.readline().split()]
    a = [int(x) for x in sys.stdin.readline().split()]
    return a

def algo1(a):
    n = len(a)
    ans = a[0]
    for i in range(n):
        for j in range(i, n):
            s = 0
            for k in range(i, j+1):
                s = s + a[k]
            if s > ans:
                ans = s
    print(ans)

# a = input()
a = [2, 3, -5, 7]
print('a = ', a)

algo1(a)
