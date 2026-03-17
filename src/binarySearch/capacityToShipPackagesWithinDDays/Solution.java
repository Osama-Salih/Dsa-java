package binarySearch.capacityToShipPackagesWithinDDays;

public class Solution {
    public int shipWithinDays(int []weights, int days) {
        int minWeight = 0, maxWeight = 0;

        for (int weight : weights) {
            minWeight = Math.max(minWeight, weight);
            maxWeight += weight;
        }

        while(minWeight < maxWeight) {
            int cap = minWeight + ((maxWeight - minWeight) / 2);
            if (possible(weights, cap, days))
                maxWeight = cap;
            else
                minWeight = cap + 1;
        }
        return minWeight;
    }
    private boolean possible(int []weights, int cap, int days) {
        int day = 1, count = 0;

        for (int weight : weights) {
            count += weight;
            if (count > cap) {
                day++;
                count = weight;
            }
        }
        return day <= days;
    }

}
