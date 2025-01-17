using System.Collections.Generic;

namespace desafio;

public class Cube(List<Colors> data)
{
    public Colors top = data[0];
    public Colors back = data[1];
    public Colors right = data[2];
    public Colors front = data[3];
    public Colors left = data[4];
    public Colors bottom = data[5];

    public void rotateX()
    {
        Colors temp;
        temp = front;
        front = left;
        left = back;
        back = right;
        right = temp;
    }
    public void rotateY()
    {
        Colors temp;
        temp = front;
        front = bottom;
        bottom = back;
        back = top;
        top = temp;
    }
    public void rotateZ()
    {
        Colors temp;
        temp = left;
        left = back;
        back = right;
        right = top;
        top = temp;
    }
}