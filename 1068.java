import java.util.Scanner;

public class Main {
    static int N, root, delete, ans;
    static int [][] conn;
    static int [] removed;

    static void addNode(int parent, int child){
        if(parent == -1){ root = child;
        }else{ conn[parent][child] = 1;}
    }

    static int getParent(int node){
        int p = -1;
        for(p = 0; p < N; p++ ){
            if(conn[p][node] == 1){
                break;}
        }
        return p;
    }

    static void deleteNode(int node) {
        removed[node] = 1; // 삭제 표시
        conn[getParent(node)][node] = 0;

        for(int p = 0; p < N; p++){
            if(conn[node][p] == 1){
                deleteNode(p);
            }
        }
    }

        static boolean isLeaf (int eachNode){
            boolean hasNoChild = true;

            for (int i = 0; i < N; i++){
                if (conn[eachNode][i] == 1) {
                    hasNoChild = false;
                    break;
                }else if(conn[eachNode][i] == -1){
                    continue;
                }
            }
            return hasNoChild;
        }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        conn = new int[N][N];
        removed = new int[N];

        for(int eachNode = 0; eachNode < N; eachNode++){
            addNode(sc.nextInt(), eachNode);
        }

        delete = sc.nextInt();
        if(delete == root){ ans = 0;
        }
        else {
            deleteNode(delete);
            for (int i = 0; i < N; i++) {
                if (isLeaf(i) && removed[i] == 0){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
