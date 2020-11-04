package com.shusx.array.p419_countBattleships;


/**
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 *
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 示例 :
 *
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 *
 * 无效样例 :
 *
 * ...X
 * XXXX
 * ...X
 * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
 *
 * 进阶:
 *
 * 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？
 */
public class Solution {

    // 思路： 当遇到X时，判断前一个【上面或者左方】是不是X如果不是可以加1
    public int countBattleships(char[][] board) {
        int total = 0;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0){
                        total++;
                    }else {
                        if (j > 0 && i > 0){
                            if (board[i][j-1] == '.' && board[i-1][j] == '.'){
                                total++;
                            }
                        }else if (j > 0){
                            if (board[i][j-1] == '.'){
                                total++;
                            }
                        }else if (i > 0){
                            if (board[i-1][j] == '.'){
                                total++;
                            }
                        }
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','.','X'},{'X','.','X'},{'X','.','X'}};
        System.out.println(new Solution().countBattleships(board));
    }

}
