The program works by using a breadth first search to traverse the 2d array. It adds the starting point to a queue and loops through the queue until the queue is empty. Inside the loop, the program checks the spaces adjacent to the point just removed from the queue. If the space is in the array bounds, is the same as the color of the starting pixel that we want to replace, and is not in the visited array/arraylist, then add it to visited and add it to the queue. Then, return the image when the queue is empty.