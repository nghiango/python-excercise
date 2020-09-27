def main():
    number_list = [1, 2, 33, 4]
    print('Result:', concatenate(number_list))

    number_list2 = [1, 2, 33, 4, 5, 66, 77]
    print('Result:', concatenate(number_list2))

def concatenate(my_list):
    my_string = ''
    for el in my_list:
        my_string += str(el)
    return my_string

main()

