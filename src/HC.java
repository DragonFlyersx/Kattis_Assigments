import java.util.*;
import java.util.Scanner;
public class HC {
    public static void main(String []args){ // psvm brug for at skrive hurtigt
        Scanner s = new Scanner(System.in);
        int vertices = s.nextInt();
        int edges = s.nextInt();
        int startsearch = 0;
        Graph search = new Graph(vertices);
        for(int i = 0; i < edges ;i++){
            int start_vert = s.nextInt();
            if (i == 0){ startsearch = start_vert;}
            int end_vert = s.nextInt();
            int type = s.nextInt(); // type if harmonious or not
            search.addEdge(start_vert,end_vert,type);
        }
        search.BFS(startsearch);
    }
}
class edge{
    int start;
    int end;
    int type; //
    edge(int start, int end, int type){
        this.start = start;
        this.end = end;
        this.type = type;
    }
    int gettype(){
        return type;
    }
    int getstart(){
        return start;
    }
    int getEnd(){
        return end;
    }
    int getop(int a){ // this part has Nikolaj Ho from my study group helped with.
        if(a == start) return end;
        else return start;
    }
}

class Graph {
    int Vert;
    LinkedList<edge>[] Neighbors;
    int[] colors;
    ArrayList<edge> edges;

    Graph(int Vert) {
        this.Vert = Vert;
        Neighbors = new LinkedList[Vert];
        colors = new int[Vert];
        edges = new ArrayList<>();
        for (int i = 0; i < Vert; i++) {
            Neighbors[i] = new LinkedList<>();
        }
    }

    void addEdge(int Start, int end, int type) {
        edge edge = new edge(Start, end, type);

        Neighbors[Start].add(edge);
        Neighbors[end].add(edge);
    }

    public Iterable<edge> Neighbors(int v) { // this part has Nikolaj Ho from my study group helped with.
        return Neighbors[v];
    }

    void BFS(int start) {
        boolean[] visited = new boolean[Vert];
        int not_harmonious = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < Vert; i++) {
            if (!visited[i]) {
                colors[i] = 0;
                queue.add(i);

                while (!queue.isEmpty() && not_harmonious == 1) {
                    int current = queue.poll();
                    if (!visited[current]) {
                        visited[current] = true;
                        for (edge e : Neighbors(current)) {
                            int next = e.getop(current);
                            if (!visited[next]) { // Has been made after discussing with study group.
                                if (e.gettype() == 1) colors[next] = (1 - colors[current]);
                                else colors[next] = colors[current];
                                queue.add(next);
                            } else if ((e.gettype() == 0 && colors[next] != colors[current]) || (e.gettype() == 1 && colors[next] == colors[current])) {
                                not_harmonious = 0;
                                break;

                            }
                        }
                    }
                }


            }

        }
        System.out.println(not_harmonious);
    }
}
