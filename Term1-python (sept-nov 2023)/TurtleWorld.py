import turtle
import math
'''
bk,fd,rt,lt,pu,pd
'''
bob = turtle.Turtle()
bob.pu()
bob.fd(200)
bob.pd()

def polyline(t, length, angle, n):
    for i in range(n):
        t.fd(length)
        t.lt(angle)

def square(t, length, angle):
    polyline(t, length, angle, 4)
    
def line(t):
    for i in range(6):
        t.pu()
        t.bk(70)
        t.pd()
        t.fd(70)
        t.lt(100)

def polygon(t, length, n):
    t.pu()
    t.lt(180)
    t.fd(100)
    t.lt(90)
    t.fd(30)
    t.lt(30)
    t.fd(170)
    t.pd()
    angle = 360/n
    polyline(t, length, angle, n)

def star(t):
    t.pu()
    t.fd(300)
    t.lt(300)
    t.pd()
    for i in range(20):
        t.bk(150)
        t.lt(170)

def circle(t, r):
    t.pu()
    t.lt(100)
    t.bk(100)
    t.pd()
    arc(t, r, 360)

def arc(t, r, angle):
    circumference = 2 * math.pi * r
    arc_length = circumference * (angle / 360.0) #to get pixels of side
    n = int(arc_length / 3) + 1

    step_length = arc_length / n
    step_angle = float(angle) /n

    t.pu()
    t.lt(100)
    t.bk(100)
    t.pd()
    polyline(t, step_length, step_angle, n)


square(bob, 100, 90)

line(bob)

polygon(bob, 80, 7)

star(bob)

circle(bob, 50)

arc(bob, 30, 180)

turtle.mainloop()