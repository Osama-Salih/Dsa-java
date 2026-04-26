package heapPq.designTwitter;

import java.util.*;

public class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap
                .computeIfAbsent(userId, k -> new ArrayList<>())
                .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        followMap
                .computeIfAbsent(userId, k -> new HashSet<>())
                .add(userId);

        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) continue;

            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() - 1;

            int[] tweet = tweets.get(index);

            maxHeap.offer(new int[]{
                    tweet[0],
                    tweet[1],
                    followeeId,
                    index - 1
            });
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] top = maxHeap.poll();
            res.add(top[1]);

            int followeeId = top[2];
            int nextIndex = top[3];

            if (nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int[] nextTweet = tweets.get(nextIndex);

                maxHeap.offer(new int[]{
                        nextTweet[0],
                        nextTweet[1],
                        followeeId,
                        nextIndex - 1
                });
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        followMap
                .computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}