/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Brandon Gonzalez
 */

import info.gridworld.actor.Bug;

/**
 * A <code>BoxBug</code> traces out a circle<br />
 */
public class GonzalezBug extends Bug
{
    private int steps;
    private int length;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public GonzalezBug(int initLength)
    {
        steps = 0;
        length = initLength;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
      if (steps < length && canMove()) {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
   }
    
    
}


class DancingBug extends Bug {
   int[] myMoves;
   
   public DancingBug(int[] myInts) {
      myMoves = myInts;
    }  
    
   public void dance() {
      for(int turnAmount: myMoves) {
         for(int i = 0; i < turnAmount; ++i) {
            turn();
         }
         move();
         move();
      }
   }     
      
}
      

   