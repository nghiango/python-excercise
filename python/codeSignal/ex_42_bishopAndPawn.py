# https://app.codesignal.com/arcade/intro/level-9/6M57rMTFB9MeDeSWo


class Location:
    def __init__(self, location):
        self.location = location
        self.char_location = location[0]
        self.num_location = location[1]


def bishopAndPawn(bishop, pawn):
    location_bishop = Location(bishop)
    location_pawn = Location(pawn)

    num_distance = abs(int(location_bishop.num_location) - int(location_pawn.num_location))
    print(num_distance)
    if (ord(location_bishop.char_location) + num_distance) == ord(location_pawn.char_location):
        return True
    if (ord(location_bishop.char_location) - num_distance) == ord(location_pawn.char_location):
        return True
    return False


print(bishopAndPawn('a1', 'b3'))
