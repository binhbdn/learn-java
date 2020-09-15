/******************************************************************************
 *  Compilation:  javac Sort5Width7If.java
 *  Execution:    java Sort5Width7If A B C D E
 *
 *  Reads in five integers and prints them out in sorted order without
 *  using a loop.
 *
 *  % java Sort5Width7If 33 22 18 66 43
 *  18 22 33 43 66
 *
 *  % java Sort5Width7If 43 22 18 22 33
 *  18 22 22 33 43
 *
 *  % java Sort5Width7If 43 12 8 4 1
 *  1 4 8 12 43
 *
 ******************************************************************************/

class Sort5Width7If { 
  public static void main(String[] args) { 
    int A = Integer.parseInt(args[0]);
    int B = Integer.parseInt(args[1]);
    int C = Integer.parseInt(args[2]);
    int D = Integer.parseInt(args[3]);
    int E = Integer.parseInt(args[4]);
    int t;
                                                    // < mean shorthand of <=
    if (A > B) { t = A; A = B; B = t; }             //If1:    A<B;
    if (C > D) { t = C; C = D; D = t; }             //If2:    A<B; C<D;

                                                    //If3:    A<B<D; C<D;
    // if B<D then A<B<D; C<D; -> do nothing.
    // if D<B then C<D<B; A<B; -> do swaps:
    // A<>C; B<>D: A<B<D; C<D;
    if (B > D) { t = A; A = C; C = t;       t = B; B = D; D = t; }

                                                    //If4,5:  A<B<D<E; C<E;
    //insert E into the chain A<B<D:
    if (B > E)                    /*AE<B<D*/ {
      if (A > E)                  /*E<A<B<D*/ {
        // swaps to get:          /*A<B<D<E*/
        t=E; E=D; D=B; B=A; A=t;
                                                    //result: C<D become C<E
      } else                      /*A<E<B<D*/ {
        // swaps to get:          /*A<B<D<E*/
        t=E; E=D; D=B; B=t;
                                                    //result: C<D become C<E
      };
    } else                        /*A<B<DE*/ {
      if (D > E)                  /*A<B<E<D*/ {
        // swaps to get:          /*A<B<D<E*/
        t=E; E=D; D=t;
                                                    //result: C<D become C<E
      }; // else                  /*A<B<D<E*/ -> do nothing
                                                    //result: C<D become C<D<E -> C<E
    }

                                                    //If6,7:  A<B<C<D<E;
    
    //insert C into the chain A<B<D<E with C<E (E = maxABCDE):
    //this mean insert C into the chain A<B<D
    if (B > C)                    /*AC<B<D*/ {
      if (A > C)                  /*C<A<B<D*/ {
        // swaps to get:          /*A<B<C<D*/
        t=C; C=B; B=A; A=t;
      } else                      /*A<C<B<D*/ {
        // swaps to get:          /*A<B<C<D*/
        t=C; C=B; B=t;
      };
    } else                        /*A<B<CD*/ {
      if (C > D)                  /*A<B<D<C*/ {
        // swaps to get:          /*A<B<C<D*/
        t=D; D=C; C=t;
      }; // else                  /*A<B<C<D*/ -> do nothing
    }

    System.out.println(A + " " + B + " " + C + " " + D + " " + E);
  }
}