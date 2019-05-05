# python version 3.7.2
import math
def calculateArea(width):
    return width**2

def getWidthFromSquareArea(squareArea):
    return math.sqrt(squareArea)

def calculatePerimeter(width):
    return width*4

def getWidthFromSquarePerimeter(squarePerimeter):
    return squarePerimeter/4

def calculateVolumeCube(width):
    return width**3

def getWidthFromCubeVolume(cubeVolume):
    return cubeVolume**(1/3)

def calculateAreaAround(width):
    return calculateArea(width)*4

def getWidthFromFourSurfaceAreaCube(surfaceAreaCube):
    return math.sqrt(surfaceAreaCube/4)

def calculateFullArea(width):
    return calculateArea(width)*6

def getWidthFromSurfaceAreaCube(surfaceAreaCube):
    return math.sqrt(surfaceAreaCube/6)

def main():
    setRedColor()
    print("This is the list that you to solve some problems relate to Square:\n")
    print("\t1. Calculate all things relate to Sqare known width\n")
    print("\t2. Get width when you have square area\n")
    print("\t3. Get width when you have square perimeter\n")
    print("\t4. Get width when you have cube volume\n")
    print("\t5. Get width when you have 4 surface area of cube\n")
    print("\t6. Get width when you have surface area of cube\n")
    option = int(input("Please choose your option (1 to 6): "))
    setGreenColor()
    if option == 1:
        width = int(input("Please enter the width of Square: "))
        print("Square area:", calculateArea(width))
        print("Square perimeter:", calculatePerimeter(width))
        print("Cube volume:", calculateVolumeCube(width))
        print("Cube area around:", calculateAreaAround(width))
        print("Cube full area:", calculateFullArea(width))
    elif option == 2:
        squareArea = int(input("Please enter the square area: "))
        print("Width:", getWidthFromSquareArea(squareArea))
    elif option == 3:
        squarePerimeter = int(input("Please enter the square perimeter: "))
        print("Width:", getWidthFromSquarePerimeter(squarePerimeter))
    elif option == 4:
        cubeVolume = int(input("Please enter the cube volume: "))
        print("Width:", getWidthFromCubeVolume(cubeVolume))
    elif option == 5:
        surfaceAreaCube = int(input("Please enter the 4 surface area of cube: "))
        print("Width:", getWidthFromFourSurfaceAreaCube(surfaceAreaCube))
    elif option == 6:
        surfaceAreaCube = int(input("Please enter the surface area of cube: "))
        print("Width:", getWidthFromSurfaceAreaCube(surfaceAreaCube))
    setRedColor()
    input("Press any key to exit.")

def setRedColor():
    print('\033[31m')


def setGreenColor():
    print('\033[32m')


main()