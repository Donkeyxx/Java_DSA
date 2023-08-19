package dsa.graph;

import java.util.List;

/**
 * TODO
 *      可以使用邻接表来表示边,具体为定义一个线性表数组,数组中的每个元素都是一个线性表
 *      其中邻接表又分为:
 *          1. 邻接顶点线性表
 *              顶点 i 的邻接顶点线性表包含了所有与顶点i 邻接的顶点j,其中顶点i和j之间有一条边
 *          2. 邻接边线性表
 *              顶点 i 的邻接边线性表包含了所有与顶点i 邻接的边
 *      如果图中存在大量的边,那么建议使用邻接矩阵,反之使用邻接线性表
 *      用邻接顶点线性表表示无权重图更加简单,但是邻接边线性表更加灵活
 *
 *
 * @author kepler
 * @date 2023-08-13 15:51
 */
public class AdjacencyList {
    public static void main(String[] args) {
        /**
         *  neighbors1[0]包含了顶点0的所有邻接顶点
         *  neighbors1[1]包含了顶点1的所有邻接顶点
         */
        List<Integer>[] neighbors1 = new List[12];

        /**
         * neighbors2[0]包含了顶点0的所有邻接边
         * neighbors2[1]包含了顶点1的所有邻接边
         */
        List<Edge>[] neighbors2 = new List[12];

    }
}
