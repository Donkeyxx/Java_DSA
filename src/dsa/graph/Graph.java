package dsa.graph;

/**
 * TODO
 *  1. 数据结构的常用特征在接口中定义
 *  2. 定义一个Graph接口来包含图的所有常规操作
 *  3.
 *
 * @author kepler
 * @date 2023-08-16 17:12
 */
public interface Graph<V>{
    /**
     * 返回图中的顶点数
     * @return the number of vertices in the graph
     */
    public int getSize();

    /**
     * 返回图中的顶点
     * @return the vertices in the graph
     */
    public java.util.List<V> getVertices();

    /**
     * 返回指定顶点下标的顶点对象
     * @param index
     * @return the object for the specified vertex object
     */
    public V getVertex(int index);

    /**
     * 返回指定顶点的下标,如果该顶点不在图中,则返回-1
     * @param v
     * @return the index for the specified vertex object
     */
    public int getIndex(V v);

    /**
     * 返回指定下标顶点的邻居
     * @param index
     * @return the neighbors of vertex with the specified index
     */
    public java.util.List<Integer> getNeighbors(int index);


    /**
     * 返回指定顶点下标的度
     * @param v
     * @return the degree for a specified vertex
     */
    public int getDegree(int v);

    /**
     * 打印边
     * print the edges
     */
    public void printEdges();


    /**
     * 清除图
     * clear the graph
     */
    public void clear();

    /**
     * 如果v添加到图中,返回true;如果v已经在图中,返回false
     * add a vertex to the graph
     */
    public boolean addVertex(V vertex);

    /**
     * 添加从u到v的边到图中,如果u或者v是无效的,则抛出IllegalArgumentException异常
     * 如果边添加成功返回true,如果(u,v)已经在图中则返回false
     * @param u a vertex
     * @param v a vertex
     * @return add an edge to the graph by vertices
     */
    public boolean addEdge(int u,int v);

    /**
     * 添加一条边到邻接线性表
     * @param e an edge
     * @return add an edge to the graph
     */
    public boolean addEdge(Edge e);

    /**
     * 从图中移除一个顶点
     * @param v the vertex you want to remove
     * @return remove a vertex v from the graph,return true if succeed
     */
    public boolean removeVertex(V v);

    /**
     * 从图中移除一条边
     * @param u  a vertex
     * @param v  a vertex
     * @return  remove an edge(u,v) from the graph,return true if succeed
     */
    public boolean removeEdge(int u,int v);

    /**
     * 得到一个从v开始的深度优先搜索树
     * @param v
     * @return Obtain a depth-first search tree
     */
    public UnweightedGraph<V>.SearchTree dfs(int v);

    /**
     * 得到一个从v开始的广度优先搜索树
     * @param v
     * @return Obtain a breadth-first search tree
     */
    public UnweightedGraph<V>.SearchTree bfs(int v);
}

