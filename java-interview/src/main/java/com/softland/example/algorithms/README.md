
# Algorithms



#### Finding common elements in two arrays

[](https://codereview.stackexchange.com/questions/189504/finding-common-elements-in-two-arrays "title") 


There is a reason why "Data Structures and Algorithms" has the data structures part added in, especially first. The reason why is data structures should be the first thing you think about even before writing any kind of algorithm.

Lets take the specification of the code that you are given:

    Write some code to find all the common elements in two arrays.

Now first thing is first this isn't specific enough, what do you mean by "common elements", does this include repeating elements so for example [1,1,2] and [1,1,3] would that be [1,1] or just [1]? For this I'm going to assume you mean elements non repeating.

Now after we have established the specification which is

    Given two arrays of numbers find the common unique elements.

I'd say these arrays are sounding a hell of a lot like a set data structure, and this set data structure, because we want to find the intersection between these two sets. In java this would be:

	public static void main(String[] args) {
	    List<Integer> alist = Arrays.asList(new Integer[] {1,1,2});
	    List<Integer> blist = Arrays.asList(new Integer[] {1,1,3});
	
	    HashSet<Integer> aset =  new HashSet<>(alist);
	    aset.retainAll(blist);
	
	    System.out.println(aset);
	}

It's very important to consider two things when someone gives you a spec, first think through is it clear enough, and secondly, after you have got an idea of what they want you want to strongly consider the data structure as these are structures that have been tried and tested to be efficient at specific tasks.

In the program above, let A be the size of alist and B be the size of blist the time complexity is O(A + B) as it's O(1) to add an element to a hashset which we do for each element in A, then we loop though all elements in B because of the retainAll function needs to do a contains operation on each element, and that is O(1) for a HashSet. This is much more efficient than O(AB) ~ or O(n^2). 






