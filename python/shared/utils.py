def swap(string, current_index, changed_index):
    string[current_index], string[changed_index] = string[changed_index], string[current_index]


def permute(string, start_index, end_index):
    if start_index == end_index:
        print(string)
    else:
        for i in range(start_index, end_index + 1):
            swap(string, i, start_index)
            permute(string, start_index + 1, end_index)
            swap(string, i, start_index)

