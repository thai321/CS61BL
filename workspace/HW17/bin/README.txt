
1) The insert method's run-time is O(n * ln(k)) where n represents the number of 
elements contained by the heap, and k represents the branching factor of the tree.
This is due to the nature of the algorithm, which inserts an element at the very 
last element of the array (i.e. heap) and "bubbles up" to its parents thus reducing 
the comparison iteration to at least half of the tree.

2) The removeMax methods run-time is the same as the insert O(n * ln(k)) where n 
represents the number of elements contained by the array, and k represents the
branching factor of the tree. The only difference between the insert method and the 
removeMax method is that the removeMax has an extra constant operations in which it 
swaps the last item in the heap with the first item (i.e. the max item).

3) The students is indeed right, the depth of the three becomes smaller and the 
breath becomes larger. Therefore if k is increased the number of comparisons required
decreases.
