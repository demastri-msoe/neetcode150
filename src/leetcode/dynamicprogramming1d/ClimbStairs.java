package leetcode.dynamicprogramming1d;

public class ClimbStairs {

  // 1 or 2 steps
  // for n steps could take up to t < n/2 2 step paths, leaving o = n-2t single step paths
  // for t = 0, there is 1 path, all single
  // for t = 1, there are (n-2)+1 places for you to put it first or after each of the (n-2) single
  // ...
  // ... at the intermediate points, it's the number of unique permutations of t 2 steps and n-2t single steps
  // ...
  // for t = n/2,
  // if n is even there is one path, all double
  // if n is odd there is n/2+1  path, single before, or after each double step

  // binary expansion of this is
  // 1, 11, 121, 1331,

}
