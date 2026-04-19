class Solution {
public:
    unordered_map<int, int> map;

    int fib(int n) {
        map[0] = 0;
        map[1] = 1;
        return dfs(n);
    }

    int dfs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (map.count(n)) {
            return map[n];
        }

        map[n] = dfs(n - 1) + dfs(n - 2);
        return map[n];
    }
};

/**

n = 4

            fib(4) = 3
          /              \   
       2 fib(3)      +          fib(2) -> 1
        /       \               |
    1 fib(2)     fib(1) = 1     fib(1) + fib(0)
     /
    fib(1) + fib(0) = 0
       1 


--------------------

map: 

[

1: 1
0: 0
2: 1

]
    f(n) = f(n - 1) + f(n - 2)

            f(4) = f(3) + f(2) = 2 + 1 = 3
            /       \
      2  f(3)   +     f(2) = 1
        / \
  1  f(2) + f(1) = 1 
    /   \
    f(1) f(0)
    1   +  0



**/