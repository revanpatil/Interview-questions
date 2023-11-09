// A developer gets values from the user table where senior is mentioned in each object 
// so now developer has to create nested object that can be passed to third party library to show the company hierarchy.


// values from DB : [
//   {name: N1, role: R1 , senior : R5},
//   {name: N2, role: R2 , senior : R1},
//   {name: N3, role: R3 , senior : R2},
//   {name: N4, role: R4 , senior : R6},
//   {name: N5, role: R5 , senior : R7},
//   {name: N6, role: R6 , senior : R7},
//   {name: N7, role: R7 , senior : ''},
//   {name: N8, role: R8 , senior : R7},
//   {name: N9, role: R9 , senior : R8},
//   {name: N10, role: R10 , senior : R8},
//   {name: N11, role: R11 , senior : R7},
//   {name: N12, role: R12 , senior : R11},
//   {name: N13, role: R13 , senior : R11},
// ]

// output: {
// name: N7,
// role: R7,
// junior: [
//   {
//   name: N5,
//   role: R5,
//   junior: [
//     {
//     name: N1,
//     role: R1,
//     junior: [
//       {
//       name: N2,
//       role: R2,
//       junior: [
//         {
//         name: N3,
//         role: R3,
//         }
//       ]
//       }
//   	 ]
//     }
//   ]
//   },
//   {
//   name: N6,
//   role: R6,
//   junior: [
//     {
//     name: N4,
//     role: R4,
//     }
//   ]
//   },
//   {
//   name: N11,
//   role: R11,
//   junior: [
//     {
//     name: N12,
//     role: R12,
//     },
//     {
//     name: N13,
//     role: R13,
//     }
//   ],
//   },
//   {
//   name: N8,
//   role: R8,
//   junior: [
//     {
//     name: N9,
//     role: R9,
//     },
//     {
//     name: N10,
//     role: R10,
//     }
//   ]
//   },
// ]
// }





https://leetcode.com/problems/sliding-window-maximum/
Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.

Example 1:
Input: N = 9, K = 3 
arr[] = 1 2 3 1 4 5 2 3 6 
Output: 3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3 
2nd contiguous subarray = {2 3 1} Max = 3 
3rd contiguous subarray = {3 1 4} Max = 4 
4th contiguous subarray = {1 4 5} Max = 5 
5th contiguous subarray = {4 5 2} Max = 5 
6th contiguous subarray = {5 2 3} Max = 5 
7th contiguous subarray = {2 3 6} Max = 6
