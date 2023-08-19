package dsa.map;

/**
 * TODO
 *
 * @author kepler
 * @date 2023-08-13 15:23
 */

public class Edge {
    //表示边的一种办法就是将边定义为对象,并且存储在java.util.ArrayList中
    int u;
    int v;

    public Edge(int u, int v){
        this.u = u;
        this.v = v;
    }

    public boolean equals(Object o){
        return u == ((Edge)o).u && v == ((Edge)o).v;
    }
}
