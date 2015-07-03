/*
Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. For example, for class Mouse (not a animal mouse), we should design it in singleton.

You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.

Have you met this question in a real interview? Yes
Example
In Java:

A a = A.getInstance();
A b = A.getInstance();
a should equal to b.

Challenge
If we call getInstance concurrently, can you make sure your code could run correctly?
*/

public class Solution { 	// Lazy initialization
    /**
     * @return: The same instance of this class every time
     */
    static Solution ins = null;
    public static Solution getInstance() {
        // write your code here
        if (ins == null) {
            ins = new Solution();
        }
        return ins;
    }
}

// Double-Checking Locking: （correct version）
public class EagerSingleton { 	// http://www.cnblogs.com/EdwardLiu/p/4443230.html
    private static volatile EagerSingleton instance = null;
 
    // private constructor
    private EagerSingleton() {
    }
 
    public static EagerSingleton getInstance() {
        if (instance == null) {
            synchronized (EagerSingleton.class) {
                // Double check
                if (instance == null) {
                    instance = new EagerSingleton();
                }
            }
        }
        return instance;
    }
}

/*
https://github.com/shogunsea/lintcode/blob/master/singleton.java
http://www.cnblogs.com/EdwardLiu/p/4443230.html
*/