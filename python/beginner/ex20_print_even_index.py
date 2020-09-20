def print_even_index(string):
    for i in range(len(string)):
        if i%2 == 0:
            print(string[i])

def print_even_index_v2(string):
    for i in range(0, len(string), 2):
        print(string[i])

def main():
    print_even_index('pynactive')
    print('Ver 2')
    print_even_index_v2('pynactive')

main()