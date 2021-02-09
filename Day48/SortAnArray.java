import java.util.Arrays;

class SortAnArray{
    private static final int QUICKSORTSHOLD = 50;
    private static final int MERGESORTHOLD = 300;

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 1, 5, 4, 2, 6, 7, 84, 6};
        System.out.println(Arrays.toString(sortArray(nums)));

        int[] nums1 = new int[51];
        for (int i = 0; i < nums1.length; ++i){
            nums1[i] = 1 + (int)(Math.random() * (100));
        }
        System.out.println(Arrays.toString(sortArray(nums1)));

        int[] nums2 = new int[301];
        for (int i = 0; i < nums2.length; ++i){
            nums2[i] = 1 + (int)(Math.random() * (300));
        }
        int[] nums3 = nums2.clone();
        Arrays.sort(nums3);

        System.out.println(Arrays.toString(sortArray(nums2)));

       
        System.out.println(Arrays.equals(nums2, nums3));
    }

    public static int[] sortArray(int[] nums){
        if (nums == null || nums.length < 2)return nums;
        if (nums.length < QUICKSORTSHOLD)selectionSort(nums);
        else if (nums.length < MERGESORTHOLD)quickSort(nums);
        else mergeSort(nums);
        return nums;
    }

    private static void selectionSort(int[] nums){
        for (int i = 0; i < nums.length; ++i){
            int minIndex = i;
            for (int j = i+1; j < nums.length; ++j){
                if (nums[j] < nums[minIndex])minIndex = j;
            }
            swap(nums, i, minIndex);
        }
    }


    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums){
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int low, int high){
        if (low < high){
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high){
        int q = low + (int)(Math.random() * (high - low + 1));
        swap(nums, low, q);

        int index = low + 1;
        for (int i = low + 1; i <= high; ++i){
            if (nums[i] < nums[low]){
                swap(nums, i, index++);
            }
        }

        swap(nums, low, --index);
        return index;
    }

    private static void mergeSort(int[] nums, int low, int high){
        if (low >= high)return;
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, mid+1, high);
    }

    private static void merge(int[] nums, int preLow, int preHigh, int endLow, int endHigh){
        if (preLow == endHigh)return;
        int lo = preLow, hi = endHigh;
        int[] newArr = new int[preHigh - preLow + 1 + endHigh-endLow+1];

        int index = 0;
        while (preLow <= preHigh && endLow <= endHigh){
            newArr[index++] = (nums[preLow] < nums[endLow])
            ? nums[preLow++] : nums[endLow++];
        }

        while (preLow <= preHigh){
            newArr[index++] = nums[preLow++];
        }

        while (endLow <= endHigh){
            newArr[index++] = nums[endLow++];
        }

        index = 0;
        while (lo <= hi){
            nums[lo++] = newArr[index++];
        }
    }


}