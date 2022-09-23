package practice;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    boolean check = false;
                  if(i-1>=0 && grid[i-1][j]==1)
                      check = true;
                  else if(i+1<n && grid[i+1][j]==1)
                      check = true;
                  else if(j-1>=0 && grid[i][j-1]==1)
                        check = true;
                    else if(j+1<m && grid[i][j+1]==1)
                        check = true;
                    if(!check)
                        c++;
                }
            }
        }
        return c;
    }

}
