def main():
    number = 5
    number1 = number*10 + number
    number2 = number*100 + number1
    print('Result:', number + number1 + number2)
    string1 = str(number)
    string2 = string1 + string1
    string3 = string2 + string1
    print('Result 2', int(string1) + int(string2) + int(string3))
main()