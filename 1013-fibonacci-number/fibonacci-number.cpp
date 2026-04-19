class Solution {
public:
    int fib(int n) {
        
        if (n == 1 || n == 0) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
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