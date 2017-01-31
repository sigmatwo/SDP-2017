// folding is a very useful generic higher-order function.
//

(1 to 9).foldLeft(0)(_ + _)

// The call c.foldLeft(init)(op) applies op to successive elements like
// this:
//                  op
//                 /  \
//               ...   coll(n)
//              /
//             op
//            /  \
//           op   coll(3)
//          /  \
//         op   coll(2)
//        /  \
//       /    \
//     init    coll(1)
//
// You can verify this easily:
//

"hello".foldLeft("!")(_ + _)

// The call to c.foldRight(init)(op) applies op to successive elements
// like this:
//       op
//      /  \
// coll(0)  ...
//            \
//            op
//           /  \
//    coll(n-3)  op
//              /  \
//      coll(n-2)   op
//                 /  \
//         coll(n-1)  init
//
// You can verify this easily:
//
"hello".foldRight("!")(_ + _)


// So, here is a thinking exercise:
//
// Implement factorial using `to` and `foldLeft` without using
// recursion or loops.
//
// Remember: fac(1) = 1, fac(n) = fac(n-1) x n
//

def fac(n: Int) = ???

//
// 

