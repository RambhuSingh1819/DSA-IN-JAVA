class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int ele : hand) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        while (!map.isEmpty()) {

            int fEle = map.firstKey();

            for (int i = 0; i < groupSize; i++) {

                int nEle = fEle + i;

                if (!map.containsKey(nEle)) {
                    return false;
                }

                map.put(nEle, map.get(nEle) - 1);

                if (map.get(nEle) == 0) {
                    map.remove(nEle);
                }
            }
        }

        return true;
    }
}