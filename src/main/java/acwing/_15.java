package acwing;

/**
 * @Author yanwg
 * @Date 2021/7/1 9:22
 * @Description: 二维数组中的查找
 */
public class _15 {
    public boolean searchArray(int[][] array, int target) {

        for(int i=0;i<array.length;i++){
            int l = 0, r = array[i].length;
            if (array[i][r-1]<target){
                continue;
            }
            while (l<r) {
                int mid = (l+r)>>1;
                if (array[i][mid] == target) {
                    return true;
                }else if(array[i][mid] >= target){
                    r = mid;
                }else if(array[i][mid] < target){
                    l = mid+1;
                }
            }
        }
        return false;
    }
}
