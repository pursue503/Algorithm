package leetcode;

import java.util.*;

public class LeetCode380 {
    public static void main(String[] args) {
        LeetCode380 leetCode380 = new LeetCode380();
        System.out.println(leetCode380.insert(1));
        System.out.println(leetCode380.remove(2));
        System.out.println(leetCode380.insert(2));
        System.out.println(leetCode380.getRandom());
        System.out.println(leetCode380.remove(1));
        System.out.println(leetCode380.insert(2));
        System.out.println(leetCode380.getRandom());
    }

    private Map<Integer, Integer> cache = new HashMap<>();
    private List<Integer> randoms = new ArrayList<>();
    private Random random = new Random();

    public LeetCode380() {
    }

    public boolean insert(int val) {
        if (cache.containsKey(val)) {
            return false;
        }
        randoms.add(val);
        cache.put(val, randoms.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (cache.containsKey(val)) {

            int removeTargetIndex = cache.get(val);
            int lastCacheDataKey = randoms.get(randoms.size() - 1);

            // random list 의 마지막 값과 삭제하려는 값이 같으면 자리 스위칭 없이 제거함
            if (lastCacheDataKey == val) {
                cache.remove(val);
                randoms.remove(randoms.size() - 1);
                return true;
            }

            // 캐시 에서 제거
            cache.remove(val);

            // 마지막 데이터 제거
            randoms.remove(randoms.size() - 1);
            // 기존 데이터 제거
            randoms.remove(removeTargetIndex);

            // 삭제된 위치에 마지막 array 데이터 저장
            randoms.add(removeTargetIndex, lastCacheDataKey);

            // 캐시 업데이트
            cache.put(lastCacheDataKey, removeTargetIndex);
            return true;
        }


        return false;
    }

    public int getRandom() {
        return randoms.get(random.nextInt(randoms.size()));
    }
}
