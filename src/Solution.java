
public class Solution {
    public result find(int[][] block){
        result res=null;
        int[][] temp = new int[10][10];
        for(int i =0;i<10;i++){
            int count = 0;
            for(int j = 0;j<10;j++){
                if(block[i][j]==1){
                    temp[i][j]=count+1;
                    count++;
                }
                else {
                    count = 0;
                    temp[i][j] = 0;
                }
            }
        }
        int maxsize = 0;
        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                int up = searchUp(temp,i,j);
                int down = searchDown(temp,i,j);
                int size = temp[i][j]*(up+down+1);
                if(size>maxsize){
                    maxsize=size;
                    res=new result(i,j,up,down,temp[i][j]);
                }
            }
        }
        return res;
    }
    private int searchUp(int[][] temp,int row,int col){
        int count = 0,size = temp[row][col];
        for(int i = row-1;i>=0;i--){
            if(temp[row][i]>=size)
                count++;
            else
                break;
        }
        return count;
    }
    private int searchDown(int[][] temp,int row,int col){
        int count = 0,size = temp[row][col];
        for(int i = row+1;i<10;i++){
            if(temp[row][i]>=size)
                count++;
            else
                break;
        }
        return count;
    }
}