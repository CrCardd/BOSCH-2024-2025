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
    Cube original = null;

    public void setOriginal(List<Colors> data) 
    => original = new(data);

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


    public void rotate(int setDown, int rotateX)
    {
        switch(setDown)
        {   
            // GREEN
            case 0:
                this.top = this.original.top;
                this.back = this.original.back;
                this.right = this.original.right;
                this.front = this.original.front;
                this.left = this.original.left;
                this.bottom = this.original.bottom;
                break;

            //BLUE
            case 1:
                this.top = this.original.bottom;
                this.back = this.original.back;
                this.right = this.original.left;
                this.front = this.original.front;
                this.left = this.original.right;
                this.bottom = this.original.top;
                break;
            
            //YELLOW
            case 2:
                this.top = this.original.front;
                this.back = this.original.top;
                this.right = this.original.right;
                this.front = this.original.bottom;
                this.left = this.original.left;
                this.bottom = this.original.back;
                break;

            //WHITE
            case 3:
                this.top = this.original.back;
                this.back = this.original.bottom;
                this.right = this.original.right;
                this.front = this.original.top;
                this.left = this.original.left;
                this.bottom = this.original.front;
                break;

            //ORANGE
            case 4:
                this.top = this.original.right; 
                this.back = this.original.back;
                this.right = this.original.bottom;
                this.front = this.original.front;
                this.left = this.original.top;
                this.bottom = this.original.left;
                break;

            //RED
            case 5:
                this.top = this.original.left;
                this.back = this.original.back;
                this.right = this.original.top;
                this.front = this.original.front;
                this.left = this.original.bottom;
                this.bottom = this.original.right;
                break;
        }

        for(int i=0; i<rotateX; i++)
            this.rotateX();
    }
}