def main():
    number1 = int(input('Enter first number: '))
    number2 = int(input('Enter second number: '))

    product = number1 * number2

    if (product <= 1000):
        print(product)
    else:
        print(number1 + number2)

main()