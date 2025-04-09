
package main.java.csc223.am;

class Solution {s
    public int findCenter(int[][] edges) {

    //Since we're guaranteed to have a star-shaped graph,
    //we only need 2 edges to devise the center.
    //This will not work if there are connections between the "peaks" of the star

    int[] edge1 = edges[0];
    int[] edge2 = edges[1];

    if (edge1[0] == edge2[0] || edge1[0] == edge2[1]){
        return edge1[0];
    }

    if (edge1[1] == edge2[0] || edge1[1] == edge2[1]){
        return edge1[1];
    }

    return -1;

    
}
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(solution.findCenter(edges)); // Output: 2
    }
}