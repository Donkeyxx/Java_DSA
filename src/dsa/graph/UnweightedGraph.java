package dsa.graph;

import dsa.graph.Edge;
import dsa.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *  1.UnweightedGraph 没有引入任何新方法
 *  2.为了方便起见,假设图是简单图,即顶点没有连接到自身的边,并且没有从顶点u到v的平行边
 *
 * @author kepler
 * @date 2023-08-16 17:27
 */
public class UnweightedGraph<V> implements Graph<V> {
    //定义一个顶点的线性表
    protected List<V> vertices = new ArrayList<>(); // store vertices
    //定义一个顶点的邻接边线性表
    protected List<List<Edge>> neighbors = new ArrayList<>(); // Adjacency Edge list

    /**
     * 创建一个空的图
     * construct an empty graph
     */
    protected UnweightedGraph(){};

    /**
     * 从存储在数组中的指定的边和顶点创建一个图
     * @param vertices 存储在数组中的顶点
     * @param edges 存储在数组中的边
     */
    protected UnweightedGraph(V[] vertices, int[][] edges){
        for(int i = 0;i < vertices.length;i++){
            addVertex(vertices[i]);
        }
        createAdjacencyLists(edges,vertices.length);
    }

    /**
     * 从存储在线性表中的指定边和顶点创建一个图
     * @param vertices 存储在线性表中的顶点
     * @param edges 存储在线性表中的边
     */
    protected UnweightedGraph(List<V> vertices, List<Edge> edges){
        for(int i = 0;i < vertices.size();i++){
            addVertex(vertices.get(i));
        }
        createAdjacencyLists(edges,vertices.size());
    }

    /**
     * 从存储在线性表中的指定边和整数顶点值1,2,...创建一个图
     * @param edges 存储在线性表中的指定边
     * @param numberOfVertices 整数顶点值1,2,...
     */
    protected UnweightedGraph(List<Edge> edges, int numberOfVertices){
        for(int i = 0;i < numberOfVertices;i++){
            addVertex((V)new Integer(i));
        }
        createAdjacencyLists(edges,numberOfVertices);
    }

    /**
     * 从存储在数组中的指定边和整数顶点值1,2,...创建一个图
     * @param edges 存储在数组中的指定边
     * @param numberOfVertices 整数顶点值1,2,3,...
     */
    protected UnweightedGraph(int[][] edges, int numberOfVertices){
        for(int i = 0;i < numberOfVertices;i++){
            addVertex((V) new Integer(i));
        }
        createAdjacencyLists(edges,numberOfVertices);
    }



    /**
     * 为图中的每个顶点都创建一个邻接边线性表
     * 从一个数组中的边创建邻接边线性表
     * @param edges
     * @param numberOfVertices
     */
    private void createAdjacencyLists(int[][] edges,int numberOfVertices){
        for(int i = 0;i < edges.length;i++){
            addEdge(edges[i][0],edges[i][1]);
        }
    }

    /**
     * 为图中的每个顶点都创建一个邻接边线性表
     * 从一个线性表中的边创建邻接边线性表
     * @param edges
     * @param numberOfVertices
     */
    private void createAdjacencyLists(List<Edge> edges,int numberOfVertices){
        for(Edge edge : edges){
            addEdge(edge.u,edge.v);
        }
    }

    /**
     * 返回图中顶点的个数
     * @return
     */
    @Override
    public int getSize() {
        return vertices.size();
    }

    /**
     * 返回图中的所有顶点,通过List的形式返回
     * @return
     */
    @Override
    public List<V> getVertices() {
        return vertices;
    }

    /**
     * 根据索引来返回图中特定的顶点
     * @param index
     * @return
     */
    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    /**
     * 根据输入的顶点返回顶点在图中的索引
     * @param v
     * @return
     */
    @Override
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    /**
     * 返回所有与输入的索引对应的顶点的邻接顶点
     * @param index
     * @return
     */
    @Override
    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for(Edge e : neighbors.get(index)){
            result.add(e.v);
        }
        return result;
    }

    /**
     * 返回输入顶点的度
     * @param v
     * @return
     */
    @Override
    public int getDegree(int v) {
        return neighbors.get(v).size();
    }

    /**
     * 打印图中所有的边
     */
    @Override
    public void printEdges() {
        for(int u = 0;u < neighbors.size();u++){
            System.out.println(getVertex(u) + " (" + u + "): ");
            for(Edge e : neighbors.get(u)){
                System.out.println("(" + getVertex(e.u) + ", " + getVertex(e.v) + ") ");
            }
            System.out.println();
        }
    }

    /**
     * 清除图
     */
    @Override
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }

    /**
     * 添加一个顶点到图中
     * @param vertex
     * @return
     */
    @Override
    public boolean addVertex(V vertex) {
        //如果存储顶点的线性表vertices中没有包含vertex,那么添加
        if(!vertices.contains(vertex)){
            vertices.add(vertex);
            neighbors.add(new ArrayList<Edge>());
            return true;
        }else{
            return false;
        }
    }

    /**
     * 添加一条边到图中
     * @param e an edge
     * @return
     */
    @Override
    public boolean addEdge(Edge e) {
        if(e.u < 0 || e.u > getSize() - 1){
            throw new IllegalArgumentException("No such index" + e.u);
        }

        if(e.v < 0 || e.v > getSize() - 1){
            throw new IllegalArgumentException("No such index" + e.v);
        }

        if(!neighbors.get(e.u).contains(e)){
            neighbors.get(e.u).add(e);
            return true;
        }else{
            return false;
        }
    }


    /**
     * 添加一条边到图中
     * @param u a vertex
     * @param v a vertex
     * @return
     */
    @Override
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u,v));
    }

    @Override
    public SearchTree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0;i < parent.length;i++){
            parent[i] = -1;
        }
        boolean[] isVisited = new boolean[vertices.size()];

        dfs(v,parent,searchOrder,isVisited);

        return new SearchTree(v,parent,searchOrder);
    }

    private void dfs(int v,int[] parent,List<Integer> searchOrder,boolean[] isVisited){
        searchOrder.add(v);
        isVisited[v] = true;
        for(Edge e : neighbors.get(v)){
            if(!isVisited[e.v]){
                parent[e.v] = v;
                dfs(e.v,parent,searchOrder,isVisited);
            }
        }
    }

    @Override
    public SearchTree bfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0;i < parent.length;i++){
            parent[i] = -1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v);
        isVisited[v] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            searchOrder.add(u);
            for(Edge e : neighbors.get(u)){
                if(!isVisited[e.v]){
                    queue.offer(e.v);
                    parent[e.v] = u;
                    isVisited[e.v] = true;
                }
            }
        }

        return new SearchTree(v,parent,searchOrder);
    }


    @Override
    public boolean removeVertex(V v) {
        return false;
    }

    @Override
    public boolean removeEdge(int u, int v) {
        return false;
    }



    public class SearchTree{
        private int root;
        private int[] parent;
        private List<Integer> searchOrder;

        public SearchTree(int root,int[] parent,List<Integer> searchOrder){
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        public int getRoot() {
            return root;
        }

        public int[] getParent() {
            return parent;
        }

        public List<Integer> getSearchOrder() {
            return searchOrder;
        }

        public int getNumberOfVerticesFound(){
            return searchOrder.size();
        }

        public List<V> getPath(int index){
            ArrayList<V> path = new ArrayList<>();

            do{
                path.add(vertices.get(index));
                index = parent[index];
            }while (index != -1);
            return path;
        }

        public void printPath(int index){
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " + vertices.get(index) + ": ");
            for(int i = path.size() - 1;i >= 0;i--){
                System.out.println(path.get(i) + " ");
            }
        }

        public void printTree(){
            System.out.println("Root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for(int i = 0;i < parent.length;i++){
                if(parent[i] != -1){
                    System.out.print("(" + vertices.get(parent[i]) + "," + vertices.get(i) + ")");
                }
            }
            System.out.println();
        }
    }
}
