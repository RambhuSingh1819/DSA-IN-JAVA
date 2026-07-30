class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        

        int time = 0;
       
        for(int[] it :  courses){
            int dur = it[0];
            int last = it[1];
            if(dur + time <= last){
                time += dur;
                maxHeap.offer(dur);
            }
            else if(!maxHeap.isEmpty() && maxHeap.peek() >= dur){
                time -= maxHeap.poll();
                time += dur;
                maxHeap.offer(dur);
            }
        }
        return maxHeap.size();
       
    }
}