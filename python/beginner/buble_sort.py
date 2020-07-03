list = [6, 7, 5, 10, 8, 9]
for i in range(len(list)-1):
    for j in range(len(list) -1):
        if list[j] < list[j+1]:
            temp = list[j+1]
            list[j+1] = list[j]
            list[j] = temp

print(list)


'''
4.Nhập vào độ dài 3 cạnh a, b, c của 1 tam giác
    a)Cho biết 3 cạnh đó có lập thành một tam giác không
    b)Nếu có, cho biết loại tam giác này là loại nào
        (thường, cân, vuông, đều, vuông cân)
'''
