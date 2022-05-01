package greedy;

import java.util.Arrays;
import java.util.Comparator;


public class JobSequencingProblem {
    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = arr[0].deadline;
        for (Job it : arr) {
            if (it.deadline > maxDeadline) {
                maxDeadline = it.deadline;
            }
        }
        int[] x = new int[maxDeadline + 1];
        Arrays.fill(x, -1);
        int countJobs = 0, countProfit = 0;
        for (int i = 0; i < n; i++) {
            int deadline = arr[i].deadline;

                while (deadline > 0 && x[deadline] != -1) {
                    deadline--;
                }

            if(deadline>0 && x[deadline]==-1) {
                x[deadline] = 1;
                countJobs++;
                countProfit += arr[i].profit;
            }
        }

        return new int[]{countJobs, countProfit};
    }


    public static void main(String[] args) {
        Job[] arr = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
        System.out.println(Arrays.toString(JobScheduling(arr, arr.length)));
    }


}
