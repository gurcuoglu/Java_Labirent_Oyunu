/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirinleroyunu;

import java.util.LinkedList;
 
public class Dijkstra {
    public LinkedList<Cell> path = new LinkedList<>();
    public static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int dist;
        Cell prev;
 
        Cell(int x, int y, int dist, Cell prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
 
        @Override
        public int compareTo(Cell o) {
            return dist - o.dist;
        }
        
        @Override
        public String toString(){
        	return "("+x+ ","+y+")";
        }
    }
    //Time O(n^2), Space O(n^2)
    public  void print(int[][] matrix, int[] start, int[] end) {
	   if (matrix[start[0]][start[1]] ==0 || matrix[end[0]][end[1]] ==0)
		   return;
	   
        Cell[][] cells = new Cell[matrix.length][matrix[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (matrix[i][j] != 0) {
                    cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
                }
            }
        }
 
        LinkedList<Cell> queue = new LinkedList<>();
        Cell src = cells[start[0]][start[1]];
        src.dist = 0;
        queue.add(src);
        Cell dest = null;
        Cell curr;
        while ((curr = queue.poll()) != null) {
            if (curr.x==end[0] && curr.y == end[1]) {
                dest = curr;
            }
            visit(cells, queue, curr.x - 1, curr.y, curr);
            visit(cells, queue, curr.x + 1, curr.y, curr);
            visit(cells, queue, curr.x, curr.y - 1, curr);
            visit(cells, queue, curr.x, curr.y + 1, curr);
        }
 
        if (dest == null) {
            return;
        } else {
            LinkedList<Cell> path = new LinkedList<>();
            curr = dest;
            do {
                path.addFirst(curr);
            } while ((curr = curr.prev) != null);
            System.out.println(path+" "+dest.dist);///sksssss
        }
    }
    
     public  LinkedList<Cell> getPath(int[][] matrix, int[] start, int[] end) {
          if (matrix[start[0]][start[1]] ==0 || matrix[end[0]][end[1]] ==0)
		           System.out.println("bir sıkıntı var shortt 75 ***");
	   
        Cell[][] cells = new Cell[matrix.length][matrix[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (matrix[i][j] != 0) {
                    cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
                }
            }
        }
 
        LinkedList<Cell> queue = new LinkedList<>();
        Cell src = cells[start[0]][start[1]];
        src.dist = 0;
        queue.add(src);
        Cell dest = null;
        Cell curr;
        while ((curr = queue.poll()) != null) {
            if (curr.x==end[0] && curr.y == end[1]) {
                dest = curr;
            }
            visit(cells, queue, curr.x - 1, curr.y, curr);
            visit(cells, queue, curr.x + 1, curr.y, curr);
            visit(cells, queue, curr.x, curr.y - 1, curr);
            visit(cells, queue, curr.x, curr.y + 1, curr);
        }
 
        if (dest == null) {
            System.out.println("bir sıkıntı var!!!  shortt 103");
        } else {
            LinkedList<Cell> path = new LinkedList<>();
            curr = dest;
            do {
                path.addFirst(curr);
            } while ((curr = curr.prev) != null);
            //System.out.println(path+" "+dest.dist);///sksssss
            return path;
        }
        return null;
        
        
     }
    
 
    static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
        int dist = parent.dist + 1;
        if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
            return;
        }
        Cell curr = cells[x][y];
        if (dist < curr.dist) {
            curr.dist = dist;
            curr.prev = parent;
            queue.add(curr);
        }
    }
 
	
}