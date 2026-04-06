class Solution {
    public int numIslands(char[][] grid) {
        int numberIsland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numberIsland++;
                    deleteIsland(grid, i,j);
                }
            }
        }
        return numberIsland;
    }

    private void deleteIsland(char[][] grid, int row,int col){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        deleteIsland(grid, row+1,col);
        deleteIsland(grid, row-1,col);
        deleteIsland(grid, row, col+1);
        deleteIsland(grid, row, col -1);
    }
}
