

package main.java.csc223.am;

class Judge {

    public int findJudge(int n, int[][] trust) {

        int[] trusts = new int[n+1];
        int[] trusted_by = new int[n+1];

        //for-each loop??
      
        for (int[] pair: trust){
            int _from = pair[0];
            int _to = pair[1];

            //trusted array shows what node is doing trusting
            trusted_by[_from]++;

            //trusts array shows what node is being trusted
            trusts[_to]++;

            
        }

        //now we need to find the suspect
        //for each person
        for (int i=1; i<=n; i++){
            
            //if our person has max incoming and no outgoing...
            if (trusts[i]==n-1 && trusted_by[i]==0){
                return i;
            }
        }
s
        return -1;
    }

    public static void main(String[] args) {
        Judge judge = new Judge();
        int[][] trust = {{1,2},{3,2}};
        System.out.println(judge.findJudge(3, trust)); // Output: 3
    }
}