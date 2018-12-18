import java.util.*;

/** Container class to different classes, that makes the whole
 * set of classes one class formally.
 */
public class GraphTask {

   /**
    * Main method.
    */
   public static void main(String[] args) {
      GraphTask a = new GraphTask();
      a.run();

   }

   /**
    * Actual main method to run examples and everything.
    */
   public void run() {
      Graph g = new Graph("G");

       //Testcase
       // Creating the graph.
       Graph g3 = new Graph("graph test");
       // Creation of 7 vertices of this graph.
       Vertex v31 = g3.createVertex("v31");
       //Sets Vertice v31 as the first vertice of g3 graph.
       Vertex v32 = g3.createVertex("v32");
       Vertex v33 = g3.createVertex("v33");
       Vertex v34 = g3.createVertex("v34");
       Vertex v35 = g3.createVertex("v35");
       Vertex v36 = g3.createVertex("v36");
       Vertex v37 = g3.createVertex("v37");
       // Creation of arcs between the vertices, making it a simple graph.
       Arc v31_v32 = g3.createArc("v31_v32", v31, v32);
       Arc v31_v36 = g3.createArc("v31_v36", v31, v36);
       Arc v31_v37 = g3.createArc("v31_v37", v31, v37);
       Arc v32_v31 = g3.createArc("v32_v31", v32, v31);
       Arc v32_v33 = g3.createArc("v32_v33", v32, v33);
       Arc v33_v32 = g3.createArc("V33_v32", v33, v32);
       Arc v33_v34 = g3.createArc("v33_v34", v33, v34);
       Arc v33_v35 = g3.createArc("v33_v35", v33, v35);
       Arc v33_v37 = g3.createArc("v33_v37", v33, v37);
       Arc v34_v33 = g3.createArc("v34_v33", v34, v33);
       Arc v35_v33 = g3.createArc("V35_v33", v35, v33);
       Arc v35_v36 = g3.createArc("v35_v36", v35, v36);
       Arc v35_v37 = g3.createArc("v35_v37", v35, v37);
       Arc v36_v31 = g3.createArc("V36_v31", v36, v31);
       Arc v36_v35 = g3.createArc("v36_v35", v36, v35);
       Arc v36_v37 = g3.createArc("v36_v37", v36, v37);
       Arc v37_v31 = g3.createArc("v37_v31", v37, v31);
       Arc v37_v33 = g3.createArc("V37_v33", v37, v33);
       Arc v37_v35 = g3.createArc("v37_v35", v37, v35);
       Arc v37_v36 = g3.createArc("v37_v36", v37, v36);
       v31.setVertexHeight(2);
       v32.setVertexHeight(8);
       v33.setVertexHeight(5);
       v34.setVertexHeight(1);
       v35.setVertexHeight(7);
       v36.setVertexHeight(9);
       v37.setVertexHeight(4);

       // Creating a list of vertices.
       g3.createVertexList();
       // Testing the actual method.
       System.out.println("Path from vertex " + v34 + " to vertex " + v31 + " through the heighest point is as follows: ");
       System.out.print(g3.pathThroughHeighest(v31, v34));
   }

   /**
    * Write an algorithm using breadth-first search in order to
    * find a bath from one vertice to another through the hightest vertice within the graph.
    * "Algoritmid ja andmestruktuurid" by Jyri Kiho page 14 exercise 7a
    */
   class Vertex {

      private String id;
      private Vertex next;
      private Arc first;
      private int height = 0;
      private int info = 0;
      private Object previousVertex;
      List<Arc> edges = new ArrayList<>();


      Vertex(String s, Vertex v, Arc e) {
         id = s;
         next = v;
         first = e;
      }

      Vertex(String s) {
         this(s, null, null);
      }

      @Override
      public String toString() {
         return id;
      }

      /**
       * Method for getting the height of a vertex
       *
       * @return
       */
      public int getVertexHeight() {
         return height;
      }

      /**
       * Method for setting the height field for a vertex
       *
       * @param info
       */
      public void setVertexHeight(int info) {
         this.height = info;
      }

      /**
       * Method for accessing the previous Vertex of a vertex.
       *
       * @return previousVertex
       */
      public Object getPreviousVertex() {
         return previousVertex;
      }


      /**
       * Method for setting the previous Vertex value.
       *
       * @param previousVertex
       */
      public void setPreviousVertex(Object previousVertex) {
         this.previousVertex = previousVertex;
      }

      /**
       * Method for accessing the info field of a vertex
       *
       * @param
       */
      public int getVertexInfo() {
         return info;
      }

      /**
       * Method for setting the info field for a vertex
       *
       * @param info
       */
      public void setVertexInfo(int info) {
         this.info = info;
      }

      /**
       * Finds all edges that connect with the vertex.
       *
       * @return list of edges
       */
      public List<Arc> allEdges() {
         for (Arc a = first; a != null; a = a.next)
            edges.add(a);
         return edges;
      }


      /**
       * Finds the edge for destination vertex.
       *
       * @param dest destination vertex
       * @return result correct edge or null if the correct edge was not found
       */
      public Arc findEdge(Vertex dest) {
         List<Arc> edges = this.allEdges();
         for (Arc edge : edges)
            if (edge.target == dest) {
               return edge;
            }
         return null;
      }
   }


   /**
    * Arc represents one arrow in the graph. Two-directional edges are
    * represented by two Arc objects (for both directions).
    */
   class Arc {

      private String id;
      private Vertex target;
      private Arc next;
      private int info = 0;

      Arc(String s, Vertex v, Arc a) {
         id = s;
         target = v;
         next = a;
      }

      Arc(String s) {
         this(s, null, null);
      }

      @Override
      public String toString() {
         return id;
      }

      /**
       * Getting a target / destination of Arc.
       *
       * @return height
       */
      public Vertex getTarget() {
         return target;
      }

   }


   class Graph {

      private String id;
      private Vertex first;
      private int info = 0;

      Graph(String s, Vertex v) {
         id = s;
         first = v;
      }

      Graph(String s) {
         this(s, null);
      }

      @Override
      public String toString() {
         String nl = System.getProperty("line.separator");
         StringBuffer sb = new StringBuffer(nl);
         sb.append(id);
         sb.append(nl);
         Vertex v = first;
         while (v != null) {
            sb.append(v.toString());
            sb.append(" -->");
            Arc a = v.first;
            while (a != null) {
               sb.append(" ");
               sb.append(a.toString());
               sb.append(" (");
               sb.append(v.toString());
               sb.append("->");
               sb.append(a.target.toString());
               sb.append(")");
               a = a.next;
            }
            sb.append(nl);
            v = v.next;
         }
         return sb.toString();
      }

      public Vertex createVertex(String vid) {
         Vertex res = new Vertex(vid);
         res.next = first;
         first = res;
         return res;
      }

      public Arc createArc(String aid, Vertex from, Vertex to) {
         Arc res = new Arc(aid);
         res.next = from.first;
         from.first = res;
         res.target = to;
         return res;
      }

      /**
       * Create a connected undirected random tree with n vertices.
       * Each new vertex is connected to some random existing vertex.
       *
       * @param n number of vertices added to this graph
       */
      public void createRandomTree(int n) {
         if (n <= 0)
            return;
         Vertex[] varray = new Vertex[n];
         for (int i = 0; i < n; i++) {
            varray[i] = createVertex("v" + String.valueOf(n - i));
            if (i > 0) {
               int vnr = (int) (Math.random() * i);
               createArc("a" + varray[vnr].toString() + "_"
                       + varray[i].toString(), varray[vnr], varray[i]);
               createArc("a" + varray[i].toString() + "_"
                       + varray[vnr].toString(), varray[i], varray[vnr]);
            } else {
            }
         }
      }

      /**
       * Create an adjacency matrix of this graph.
       * Side effect: corrupts height fields in the graph
       *
       * @return adjacency matrix
       */
      public int[][] createAdjMatrix() {
         info = 0;
         Vertex v = first;
         while (v != null) {
            v.height = info++;
            v = v.next;
         }
         int[][] res = new int[info][info];
         v = first;
         while (v != null) {
            int i = v.height;
            Arc a = v.first;
            while (a != null) {
               int j = a.target.height;
               res[i][j]++;
               a = a.next;
            }
            v = v.next;
         }
         return res;
      }

      /**
       * Create a connected simple (undirected, no loops, no multiple
       * arcs) random graph with n vertices and m edges.
       *
       * @param n number of vertices
       * @param m number of edges
       */
      public void createRandomSimpleGraph(int n, int m) {
         if (n <= 0)
            return;
         if (n > 2500)
            throw new IllegalArgumentException("Too many vertices: " + n);
         if (m < n - 1 || m > n * (n - 1) / 2)
            throw new IllegalArgumentException
                    ("Impossible number of edges: " + m);
         first = null;
         createRandomTree(n);       // n-1 edges created here
         Vertex[] vert = new Vertex[n];
         Vertex v = first;
         int c = 0;
         while (v != null) {
            vert[c++] = v;
            v = v.next;
         }
         int[][] connected = createAdjMatrix();
         int edgeCount = m - n + 1;  // remaining edges
         while (edgeCount > 0) {
            int i = (int) (Math.random() * n);  // random source
            int j = (int) (Math.random() * n);  // random target
            if (i == j)
               continue;  // no loops
            if (connected[i][j] != 0 || connected[j][i] != 0)
               continue;  // no multiple edges
            Vertex vi = vert[i];
            Vertex vj = vert[j];
            createArc("a" + vi.toString() + "_" + vj.toString(), vi, vj);
            connected[i][j] = 1;
            createArc("a" + vj.toString() + "_" + vi.toString(), vj, vi);
            connected[j][i] = 1;
            edgeCount--;  // a new edge happily created
         }
      }

      /**
       * Sets random numbers from 0 to 100 to vertices height attribute in a given graph.
       */
      public void createRandomVertexHeights() {
         for (Vertex v = first; v != null; v = v.next) {
            v.setVertexHeight((int) (Math.random() * 100));
         }
      }

      /**
       * Get all vertexes of a given graph.
       *
       * @return list of vertexes
       *
       */
      public List<Vertex> createVertexList() {
         List<Vertex> vertices = new ArrayList<>();

         for (Vertex v = first; v != null; v = v.next)
            vertices.add(v);
         return vertices;
      }


      /**
       * Finds the path to destination vertex from given source vertex
       * through the highest vertex in the graph
       *
       * @param v1 - source vertex
       * @parem v2 - destination vertex
       * @return string representation of the path from source to dest
       */
      public List<Arc> pathThroughHeighest(Vertex v1, Vertex v2) {
         Vertex maxVert = v1;
         for (Vertex item : createVertexList()) {
            if(maxVert.getVertexHeight() < item.getVertexHeight()){
               maxVert = item;
            }
         }
         if (v1 == maxVert)
            throw new RuntimeException(v1 + " is the highest point in the graph!");
         if (v1 == v2)
            throw new RuntimeException("Source and destination vertexes are the same!");
         if ((!createVertexList().contains(v1)))
            throw new RuntimeException("Source vertex is not part of the graph");
         if ((!createVertexList().contains(v2)))
            throw new RuntimeException("Destination vertex is not part of the graph");

         pathToHeighestFrom(v2);

         ArrayList<Arc> arcList = new ArrayList<Arc>();
         Vertex vert3 = v1;
         Vertex vert4 = (Vertex) v1.getPreviousVertex();
         if (vert4 == null) {
            throw new RuntimeException(v1 + " vertex is not part of the graph");
         }
         while (vert4 != null) {
            arcList.add(vert3.findEdge((Vertex) vert4));
            vert3 = vert4;
            vert4 = (Vertex) vert4.getPreviousVertex();
         }

         pathToHeighestFrom(v1);

         ArrayList<Arc> arcListBackwards = new ArrayList<Arc>();
         Vertex vert2 = v2;
         Vertex vert1 = (Vertex) v2.getPreviousVertex();
         if (vert1 == null) {
            throw new RuntimeException(v2 + " vertex is not part of the graph");
         }

         while (vert1 != null) {
            arcListBackwards.add(vert1.findEdge((Vertex) vert2));
            vert2 = vert1;
            vert1 = (Vertex) vert1.getPreviousVertex();
         }



         ListIterator<Arc> itr = arcListBackwards.listIterator(arcListBackwards.size());

         while (itr.hasPrevious()) {
            arcList.add(itr.previous());
         }

         StringBuilder sb = new StringBuilder();
         for (Arc a : arcList)
         {
            sb.append(a);
            sb.append(" -> ");
         }
         return arcList;
      }


      /**
       * Finds the heighest Vertex in the graph
       *
       * @param source source vertex
       * @return the heighest vertex
       */
      public Vertex findMaxHeight(Vertex source) {
         Vertex maxVert = source;
         for (Vertex item : createVertexList()) {
            if (item.id == source.id){
               item.setVertexHeight(0);
            }
            if(maxVert.getVertexHeight() < item.getVertexHeight()){
               maxVert = item;
            }
         }
         return maxVert;
      }


      /**
       * Finds shortest path from a given vertex to the heighest vertex. Uses Dijkstra algorithm.
       *
       * @param s source vertex
       * @link http://enos.itcollege.ee/~jpoial/algoritmid/graafid.html
       */
      public void pathToHeighestFrom(Vertex s) {
         if (s.allEdges().isEmpty())
            throw new RuntimeException("The vertex " + s + " doesnt have edges going to it!");

         Vertex dest = findMaxHeight(s);
         if (dest.allEdges().isEmpty())
            throw new RuntimeException("The heighest vertex " + dest + " in graph doesnt have edges going to it!");

         if (createVertexList() == null) return;

         if ((!createVertexList().contains(s)))
            throw new RuntimeException("Source vertex is not part of the graph");
         int INFINITY = Integer.MAX_VALUE / 4;
         Iterator vit = createVertexList().iterator();
         while (vit.hasNext()) {
            Vertex v = (Vertex) vit.next();
            v.setVertexInfo(INFINITY);
            v.setPreviousVertex(null);
         }
         dest.setVertexInfo(0);
         List vq = Collections.synchronizedList(new LinkedList());
         vq.add(dest);
         while (vq.size() > 0) {
            int maxHeight = 0;
            Vertex currentVertex = null;
            Iterator it = vq.iterator();
            while (it.hasNext()) {
               Vertex v = (Vertex) it.next();
               if (v.getVertexInfo() >= maxHeight) {
                  currentVertex = v;
                  maxHeight = v.getVertexInfo();
               }
            }
            if (currentVertex == null)
               throw new RuntimeException("error!!");
            if (vq.remove(currentVertex)) {
               //  element removed from vq
            } else
               throw new RuntimeException("error!!");
            it = currentVertex.allEdges().iterator();

            while (it.hasNext()) {
               Arc a = (Arc) it.next();
               Vertex to = a.getTarget();
               int newHeight = maxHeight + to.getVertexHeight();
               if (to.getVertexInfo() == INFINITY) {
                  vq.add(to);
               }
               if (newHeight < to.getVertexInfo()) {
                  to.setVertexInfo(newHeight);
                  to.setPreviousVertex(currentVertex);
               }
            }
         }
      }
   }
}


