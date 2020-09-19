// https://www.hackerrank.com/challenges/java-1d-array

import java.util.Scanner;

class Solution405 {
  public static boolean canWin(int leap, int[] game) {
    // Return true if you can win the game; otherwise, return false.
    int l =game.length;
    if (leap>=l) return true;

    boolean[] canJumpToCell=new boolean[(l+leap)];
    canJumpToCell[0]=true;

    for (int i=0;i<l;i++){
      if (canJumpToCell[i]) {

        //try to move one step forward
        if ((i+1)<l){
          if(game[i+1]==0){
            if (! canJumpToCell[i+1]) canJumpToCell[i+1]=true;
          };
        };
        
        //try to jump and then maybe backward step by step
        if ((i+leap)>=l) return true;
        if (game[i+leap]==0){
          if ((i+leap)==(l-1)) return true;
          if (! canJumpToCell[i+leap]) canJumpToCell[i+leap]=true;
          if ((i+leap)>0) {
            int j = 1;
            while ((game[i+leap-j]==0)&&(! canJumpToCell[i+leap-j])) {
              canJumpToCell[i+leap-j]=true;
              j++;
            }
          };
        };
      };
    };
    return false;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int q = scan.nextInt(); // q = queries
    while (q-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();
      
      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
    }
    scan.close();
  }
}
