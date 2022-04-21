
public class Solution {

	private static int best_total;
	public static Boolean[] best_taken;
	private static Location[] exit_list;
	public static int total_profit;
    
	private static int maxProfit(Location[] exit_list, Boolean[] taken, int min_distance, int cur_exit, int cur_total){
		if(cur_exit == exit_list.length){
			// base case- out of exits
			if(cur_total > best_total){
				best_total = cur_total;

				for(int i = 0; i < taken.length; i++){

					best_taken[i] = taken[i];
				}

			}

			return best_total;
		}

		// if we take it, we need to find the next exit
		int cur_pos = exit_list[cur_exit].exitNumber();
		int next_pos = cur_pos + min_distance;
		int next_exit = cur_exit+1;

		while(next_exit < exit_list.length && next_pos > exit_list[next_exit].exitNumber()){
			next_exit++;
		}
		taken[cur_exit] = true;
		int taken_profit = maxProfit(exit_list, taken, min_distance, next_exit, cur_total + exit_list[cur_exit].profit());

		taken[cur_exit] = false;
		int not_taken_profit = maxProfit(exit_list, taken, min_distance, cur_exit+1, cur_total);
		if(taken_profit > not_taken_profit){

			return taken_profit;
		}
		else{
			return not_taken_profit;
		}
	}

	private static void Swap(Location[] v, int x, int y){
		Location temp = v[x];
		v[x] = v[y];
		v[y] = temp;
	}

	private static void sort(Location[] v){
		for(int i = 0; i < v.length; i++)
			for(int j = 0; j < v.length-1; j++)
				if(v[j].exitNumber() > v[j+1].exitNumber())
					Swap(v, j, j+1);
	}

	public static void calculateSolution(Location[] exitList, int min_distance, int num_exits) {
		exit_list = exitList;
		
		sort(exit_list);

		Boolean[] taken = new Boolean[num_exits];
		best_taken = new Boolean[num_exits];
		
		for(int i = 0; i < num_exits; i++){
			taken[i] = false;
			best_taken[i] = false;
		}

		best_total = 0;
		
		total_profit = maxProfit(exit_list, taken, min_distance, 0, 0);

	}
}
