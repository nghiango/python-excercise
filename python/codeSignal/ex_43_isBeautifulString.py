def solution(inputString):
  int_char_a = 97
  array_ob = []
  for letter in inputString:
    index = ord(letter) - int_char_a
    print(letter)
    print(ord(letter))
    print(ord(letter) - int_char_a)

solution('abcdefgh')
