from graphics import *


def print_the_graphic(array):
    win = GraphWin("My Window", 500, 500)
    win.setBackground(color_rgb(255, 255, 255))
    current_x = 0
    current_y = 0
    rec = MyRectangle(current_x, current_y)
    count = 0
    current_column = 0
    limit_height_col = 6
    for index, item in enumerate(array):
        if index == 0:
            rec.draw(win, item)
        elif array[index] == array[index-1]:
            draw_in_same_winner(rec, win, count, limit_height_col, item)
            count += 1
        else:
            rec.coordinate_x = current_column
            rec.draw_in_next_column(win, item)
            current_column = rec.coordinate_x
            if count >= limit_height_col:
                limit_height_col -= 1
            count = 1
    win.getMouse()
    win.close()


def draw_in_same_winner(rec, win, count, limit_height_col, item):
    if count < limit_height_col:
        rec.draw_in_same_column(win, item)
    else:
        rec.draw_in_same_row(win, item)


class MyRectangle:
    next_coordinate = 25

    def __init__(self, coordinate_x, coordinate_y):
        self.coordinate_x = coordinate_x
        self.coordinate_y = coordinate_y

    @staticmethod
    def set_color_rec(rec, item):
        if item:
            rec.setFill(color_rgb(255, 0, 0))
        else:
            rec.setFill(color_rgb(0, 0, 255))

    def draw(self, win, item):
        start_point = Point(self.coordinate_x, self.coordinate_y)
        end_point = Point(self.coordinate_x + self.next_coordinate, self.coordinate_y + self.next_coordinate)
        rec = Rectangle(start_point, end_point)
        self.set_color_rec(rec, item)
        rec.draw(win)

    def draw_in_same_row(self, win, item):
        self.coordinate_x += self.next_coordinate
        self.draw(win, item)

    def draw_in_same_column(self, win, item):
        self.coordinate_y += self.next_coordinate
        self.draw(win, item)

    def draw_in_next_column(self, win, item):
        self.coordinate_y = 0
        self.coordinate_x += self.next_coordinate
        self.draw(win, item)


def main():
    graphics = [True, True, False, False, False, False, False, False, False, False, False, True, True, True, True, True, True, True, True, True, False, False, False, False, False, False, False, False, False]
    print_the_graphic(graphics)


main()
