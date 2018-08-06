# MoveTheKnight
A Chess board is made up of 8x8 Cells. A Knight, on the Chess Board stands on a given cell [i , j]. Given a destination cell [k , l], list all the possible ways it can reach the destination in ONE move. If the destination can’t be reached in one move, print “Not Possible!”.
The valid moves of a Knight are (L-shape moves)

Sample Input: (Assume that 0,0 starts at bottom-left corner of the Chess Board)
Current Position: 	[0,2]
Destination:		    [1,4]

Expected Output:
Possibility 1: 	[0,2]-->[1,2]-->[1,3]-->[1,4]
Possibility 2:	[0,2]-->[0,3]-->[0,4]-->[1,4]
