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

class Graph {
        int Vert;
        LinkedList<Integer>[] Neighbors;
        int[] colors;

        Graph(int Vert) {
            this.Vert = Vert;
            Neighbors = new LinkedList[Vert];
            colors = new int[Vert];
            colors[0] = 1;
            for (int i = 0; i < Vert; i++) {
                Neighbors[i] = new LinkedList<>();
            }
        }

        void addEdge(int Start, int end, int type) {
             // for conflicting edge farve skal alternate. men hvid det er en harmonisk edge må den godt havde samme farver
                if(colors[Start] == 1 && colors[end] == 0){
                    colors[end] = 2;

                } else if (colors[Start] == 2 && colors[end] == 0) {
                    colors[end] = 1;
                }



                Neighbors[Start].add(end);



        }

        void BFS(int start) {
            boolean[] visited = new boolean[Vert];
            boolean not_harmonious = false;
            LinkedList<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                System.out.print(current + " " + " has the color " + colors[current] + "     ");

                Iterator<Integer> iterator = Neighbors[current].listIterator();
                while (iterator.hasNext()) {
                    int neighbor = iterator.next();
                    if (colors[current] == colors[neighbor]) { // hvis det er en harmonisk er dette rigtigt. hvis det er
                      not_harmonious = true;
                    }
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
          /*  if(not_harmonious){
                System.out.println(0);
            }else{ System.out.println(1);} */
        }
    }
// Note til selv skal tjekke linked imellem om det er conflicting eller harmony