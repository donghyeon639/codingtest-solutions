class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] gidong = new boolean[n + 1][n + 1];
        boolean[][] bo = new boolean[n + 1][n + 1];

        for (int i = 0; i < build_frame.length; i++) {
            // 안쪽 반복문 없이 명령 하나씩 꺼내기
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            boolean previous;

            // 기둥: 0, 보: 1
            if (type == 0) {
                previous = gidong[x][y];
                gidong[x][y] = (action == 1);
            } else {
                previous = bo[x][y];
                bo[x][y] = (action == 1);
            }

            // 명령 실행 후 전체 구조물 검사
            boolean valid = true;

            for (int a = 0; a <= n; a++) {
                for (int b = 0; b <= n; b++) {
                    if (gidong[a][b]) {
                        boolean canInstall =
                               b == 0
                            || (b > 0 && gidong[a][b - 1])
                            || (a > 0 && bo[a - 1][b])
                            || bo[a][b];

                        if (!canInstall) {
                            valid = false;
                        }
                    }

                    if (bo[a][b]) {
                        boolean canbo =
                               (b > 0 && gidong[a][b - 1])
                            || (a < n && b > 0
                                && gidong[a + 1][b - 1])
                            || (a > 0 && a < n
                                && bo[a - 1][b] && bo[a + 1][b]);

                        if (!canbo) {
                            valid = false;
                        }
                    }
                }
            }

            // 조건을 어긴 구조물이 있으면 작업 취소
            if (!valid) {
                if (type == 0) {
                    gidong[x][y] = previous;
                } else {
                    bo[x][y] = previous;
                }
            }
        }

        int count = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (gidong[i][j]) {
                    count++;
                }
                if (bo[i][j]) {
                    count++;
                }
            }
        }

        int[][] result = new int[count][3];
        int index = 0;

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (gidong[x][y]) {
                    result[index][0] = x;
                    result[index][1] = y;
                    result[index][2] = 0;
                    index++;
                }

                if (bo[x][y]) {
                    result[index][0] = x;
                    result[index][1] = y;
                    result[index][2] = 1;
                    index++;
                }
            }
        }

        return result;
    }
}