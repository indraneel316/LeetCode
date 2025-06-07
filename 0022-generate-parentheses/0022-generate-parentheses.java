class Solution {
    public List<String> generateParenthesis(int n) {
    
    List<String> res = new ArrayList<>();

    int open =0;
    int close = 0;
    backTrack(res, "", open , close, n);
    return res;

    }

    public void backTrack(List<String> res, String str, int open, int close, int n) {

        if(open == n && close == n) {
           res.add(str);
        }

        if(open>n || close >n ||close > open) {
            return;
        }

        backTrack(res, str + "(", open+1, close, n);
        backTrack(res, str+")", open, close+1, n);

    }
    }
