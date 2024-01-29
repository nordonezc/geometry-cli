# Geometry CLI

## Description of the problem
Given two figures, find:
![](https://i.stack.imgur.com/KAhiV.png)
- Determine if it is adjacent, contained or intersected
- Return the shared sides and points
> *Note: Initial scope consider two rectangles*

## Technologies used
- Java 17 taking advantage of switch expressions and record classes
- Implementation was done in Spring Boot and picoCLI for client interaction
- Lombok to avoid boilerplate code

## Usage

Execute the program with the following parameters
`rectangle -r1 X1 Y1 X2 Y2 -r2 X1 Y1 X2 Y2`
where `X1 Y1 X2 Y2` represents the position in the plane as double