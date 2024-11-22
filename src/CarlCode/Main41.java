package CarlCode;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main41 {
    static int[] dRow={1,-1,0,0};
    static int[] dCol={0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int opeations=sc.nextInt();
        int[][] arr=new int[rows][cols];
        UnionFind uf=new UnionFind();
        for(int i=0;i<opeations;i++){
            int updateRow=sc.nextInt();
            int updateCol=sc.nextInt();
            if(updateRow<0 || updateRow>=rows || updateCol<0 || updateCol>=cols){
                System.out.println(getIslands(arr,rows,cols,uf));
            }else{
                arr[updateRow][updateCol]=1;
                System.out.println(getIslands(arr,rows,cols,uf));
            }
        }
    }
    public static int getIslands(int[][] arr,int rows,int cols,UnionFind uf){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]==1){
                    int pos=i*cols+j;
                    uf.add(pos);
                    for(int k=0;k<4;k++){
                        int newRow=i+dRow[k];
                        int newCol=j+dCol[k];
                        if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && arr[newRow][newCol]==1){
                            uf.add(newRow*cols+newCol);
                            uf.merge(pos,newRow*cols+newCol);
                        }
                    }
                }

            }
        }
        return uf.getNumsOfIslands();
    }

}
class UnionFind{
    private Map<Integer,Integer> father;
    private int numsOfIslands;
    public UnionFind(){
        father=new HashMap<Integer,Integer>();
        numsOfIslands=0;
    }
    public void add(int x){
        if(!father.containsKey(x)){
            father.put(x,null);
            numsOfIslands++;
        }
    }
    public int find(int x){
        int root=x;
        while(father.get(root)!=null){
            root=father.get(root);
        }
        while(x!=root){
            int originalFather=father.get(x);
            father.put(x,root);
            x=originalFather;
        }
        return root;
    }
    public void merge(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            father.put(rootX,rootY);
            numsOfIslands--;
        }
    }
    public int getNumsOfIslands(){
        return numsOfIslands;
    }
}
