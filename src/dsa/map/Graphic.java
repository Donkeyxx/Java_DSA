package dsa.map;

import java.util.ArrayList;

/**
 * TODO 表示一个图就是在程序中存储它的顶点和边
 *      存储图的数据结构是数组或者线性表
 *
 * @author kepler
 * @date 2023-08-13 15:03
 */
public class Graphic {
    public static void main(String[] args) {
        //1.顶点可以存储在数组或者线性表中,例如
        String[] vertices = {"Seattle","San Francisco","Los Angeles",
                "Denver","Kansas City","Chicago","Boston","New York",
                "Atlanta","Miami","Dallas","Houston"
        };
        //2.
        Vertices v1 = new Vertices("Seattle",608660,"Mike McGinn");
        Vertices v2 = new Vertices("Houston",2099451,"Annise Parker");
        Vertices[] vertices1 = {v1,v2};


        //3.边也可以用二维数组来表示
        int[][] edges = {
                {0,1},{0,3},{0,5},
                {1,0},{1,2},{1,3},
                {2,1},{2,3},{2,4},{2,10},
                {3,0},{3,1},{3,2},{3,4},{3,5},
                {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                {5,0},{5,3},{5,4},{5,6},{5,7},
                {6,5},{6,7},
                {7,4},{7,5},{7,6},{7,8},
                {8,4},{8,7},{8,9},{8,10},{8,11},
                {9,8},{9,11},
                {10,2},{10,4},{10,8},{10,11},
                {11,8},{11,9},{11,10}
        };

        //4.边也可以用对象来表示,如果事先不知道所有的边,那么将Edge对象存储在一个ArrayList中是很有用的
        ArrayList<Edge> list = new ArrayList<>();
        list.add(new Edge(0,1));
        list.add(new Edge(0,3));
        list.add(new Edge(0,5));


    }
}


