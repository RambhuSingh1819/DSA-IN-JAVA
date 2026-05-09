// class MedianFinder {
//     List<Integer> list;

//     public MedianFinder() {
//         list = new ArrayList<>();
//         for(int ele : list){
//             addNum(ele);
//             findMedian();
//         }
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//         Collections.sort(list);
//     }
    
//     public double findMedian() {
//         int n = list.size();
//         if(n % 2 == 1) return list.get(n/2);
//         return (list.get(n/2)+list.get(n/2-1))/2.0;        
//     }
// }

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        // Left half (largest at top)
        maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Right half (smallest at top)
        minHeap =
            new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Move largest of left
        // to right heap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // Even number of elements
        return (maxHeap.peek() +
                minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */