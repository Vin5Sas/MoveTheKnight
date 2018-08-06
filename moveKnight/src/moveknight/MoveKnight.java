package moveknight;

import java.io.*;
import java.util.*;

enum COLOR{B,W};

class Cell
{
    public COLOR cellColor;     //'B'-Black or 'W'-White
}

class ChessBoard
{
    Cell[][] grid;
    
    ChessBoard()
    {
        grid = new Cell[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                grid[i][j] = new Cell();
                if((i%2==0))
                {   if(j%2==0)
                        grid[i][j].cellColor = COLOR.B;
                    else
                        grid[i][j].cellColor = COLOR.W;
                }
                else
                {
                    if(!(j%2==0))
                        grid[i][j].cellColor = COLOR.B;
                    else
                        grid[i][j].cellColor = COLOR.W;
                }    
            }
        }
    }
    
    public void displayGrid(Knight knight)
    {
        for(int i=7;i>=0;i--)
        {
            for(int j=0;j<8;j++)
            {
                if(((i==knight.currentPosition.row)&&(j==knight.currentPosition.column)) || ((i==knight.destination.row)&&(j==knight.destination.column)))
                    System.out.print('K' + " ");  //'K' - Knight
                else
                    System.out.print(grid[i][j].cellColor + " ");
            }
            System.out.println();
        }
    }
}

class Coin
{
    public COLOR coinColor;
}

class Position
{
    public int row,column;
    
    Position(int row,int column)
    {
        this.row = row;
        this.column = column;
    }
    
    public static void printIndex(int rowIndex1,int columnIndex1,int rowIndex2,int columnIndex2,int rowIndex3,int columnIndex3,int rowIndex4,int columnIndex4)
    {
        System.out.println("[" + rowIndex1 + ',' + columnIndex1 + "]" + "-->" + '[' + rowIndex2 + ',' + columnIndex2 + ']' + "-->" + '[' + rowIndex3 + ',' + columnIndex3 + ']' + "-->" + '[' + rowIndex4 + ',' + columnIndex4 + ']');
    }        
}

class Knight extends Coin
{
    
    Position currentPosition;
    Position destination;
    
    Knight(char color, int row, int column)
    {
        currentPosition =  new Position(row,column);
        coinColor = COLOR.valueOf(String.valueOf(color));
    }
    
    public void setDestination(int row,int column)
    {
        destination = new Position(row,column);
    }
    
    public int move2Forward1Left()  //increase row by 2, decrease column by 1
    {
        try
        {
            if((currentPosition.row+2)==destination.row && (currentPosition.column-1)==destination.column)
            {
                
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row+1), currentPosition.column, (currentPosition.row+2), currentPosition.column, (currentPosition.row+2), (currentPosition.column-1));
                Position.printIndex(currentPosition.row, currentPosition.column, currentPosition.row, (currentPosition.column-1), (currentPosition.row+1), (currentPosition.column-1), (currentPosition.row+2), (currentPosition.column-1));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move2Forward1Right() //increase row by 2, increase column by 1
    {
        try
        {
            if((currentPosition.row+2)==destination.row && (currentPosition.column+1)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row+1), currentPosition.column, (currentPosition.row+2), currentPosition.column, (currentPosition.row+2), (currentPosition.column+1));
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row), (currentPosition.column+1), (currentPosition.row+1), (currentPosition.column+1), (currentPosition.row+2), (currentPosition.column+1));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move1Forward2Left()  //increase row by 1, decrease column by 2
    {
        try
        {
            if((currentPosition.row+1)==destination.row && (currentPosition.column-2)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row+1), currentPosition.column, (currentPosition.row+1), (currentPosition.column-1), (currentPosition.row+1), (currentPosition.column-2));
                Position.printIndex(currentPosition.row, currentPosition.column, currentPosition.row, (currentPosition.column-1), currentPosition.row, (currentPosition.column-2), (currentPosition.row+1), (currentPosition.column-2));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move1Forward2Right() //increase row by 1, increase column by 2
    {
        try
        {
            if((currentPosition.row+1)==destination.row && (currentPosition.column+2)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row+1), currentPosition.column, (currentPosition.row+1), (currentPosition.column+1), (currentPosition.row+1), (currentPosition.column+2));
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row), (currentPosition.column+1), currentPosition.row, (currentPosition.column+2), (currentPosition.row+1), (currentPosition.column+2));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move2Backward1Left() //decrease row by 2, decrease column by 1
    {
        try
        {
            if((currentPosition.row-2)==destination.row && (currentPosition.column-1)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row-1), currentPosition.column, (currentPosition.row-2), currentPosition.column, (currentPosition.row-2), (currentPosition.column-1));
                Position.printIndex(currentPosition.row, currentPosition.column, currentPosition.row, (currentPosition.column-1), (currentPosition.row-1), (currentPosition.column-1), (currentPosition.row-2), (currentPosition.column-1));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move2Backward1Right()  //decrease row by 2, increase column by 1
    {
        try
        {
            if((currentPosition.row-2)==destination.row && (currentPosition.column+1)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row-1), currentPosition.column, (currentPosition.row-2), currentPosition.column, (currentPosition.row-2), (currentPosition.column+1));
                Position.printIndex(currentPosition.row, currentPosition.column, currentPosition.row, (currentPosition.column+1), (currentPosition.row-1), (currentPosition.column+1), (currentPosition.row-2), (currentPosition.column+1));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move1Backward2Left() //decrease row by 1, decrease column by 2
    {
        try
        {
            if((currentPosition.row-1)==destination.row && (currentPosition.column-2)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row-1), currentPosition.column, (currentPosition.row-1), (currentPosition.column-1), (currentPosition.row-1), (currentPosition.column-2));
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row), (currentPosition.column-1), currentPosition.row, (currentPosition.column-2), (currentPosition.row-1), (currentPosition.column-2));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    
    public int move1Backward2Right()  //decrease row by 1, increase column by 2
    {
        try
        {
            if((currentPosition.row-1)==destination.row && (currentPosition.column+2)==destination.column)
            {   
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row-1), currentPosition.column, (currentPosition.row-1), (currentPosition.column+1), (currentPosition.row-1), (currentPosition.column+2));
                Position.printIndex(currentPosition.row, currentPosition.column, (currentPosition.row), (currentPosition.column+1), currentPosition.row, (currentPosition.column+2), (currentPosition.row-1), (currentPosition.column+2));
                return 1;
            }
            else return 0;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
}

public class MoveKnight {

    public static void moveKnight(ChessBoard chessBoard,Knight knight)
    {
        int possibility = 0;
        
        possibility+= knight.move1Forward2Left();
        possibility+= knight.move1Forward2Right();
        possibility+= knight.move2Forward1Left();
        possibility+= knight.move2Forward1Right();
        
        possibility+= knight.move1Backward2Left();
        possibility+= knight.move1Backward2Right();
        possibility+= knight.move2Backward1Left();
        possibility+= knight.move2Backward1Right();
        
        if(possibility==0)
        {
            System.out.println("Cannot Reach Destination");
        }
        else
        {
            System.out.println("After Moving the Knight: ");
            chessBoard.displayGrid(knight);
        }
    }
    
    public static void main(String[] args) {
       
        ChessBoard chessBoard = new ChessBoard();
        char colorChoice;
        int row,column;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the color of the Knight (B/W): ");
        colorChoice = input.next().charAt(0);
        
        //Index range from 0-7
	System.out.println("Enter Initial Row Position: ");
        row = input.nextInt();
        
        System.out.println("Enter Initial Column Position: ");
        column = input.nextInt();
        
        Knight knight = new Knight(colorChoice,row,column);
        
        System.out.println("Enter Destination Row Position: ");
        row = input.nextInt();
        
        System.out.println("Enter Destination Column Position: ");
        column = input.nextInt();
        
        knight.setDestination(row, column);
        moveKnight(chessBoard,knight);
    }      
}