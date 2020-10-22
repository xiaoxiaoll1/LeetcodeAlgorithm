package leetcode04;

public class ShortestSubString {


        public String minWindow(String s, String t) {

            if(s.length()==0||t.length()==0||s==null||t==null){
                return "";
            }

            int count = 0;
            int targetCount = t.length();
            int minLength=Integer.MAX_VALUE;
            int res[] = new int[2];

            int[] tArray = new int[256];
            int[] sArray = new int[256];
            for (char c:t.toCharArray()
            ) {
                tArray[c]++;
            }
            int slow = 0;
            int fast = 0;
            slow = findNextStrIndex(slow, s, tArray);
            if(slow==s.length()){
                return "";
            }
            fast=slow;
            while (fast<s.length()){
                int rightChar = s.charAt(fast);
                if(sArray[rightChar]<tArray[rightChar]){
                    count++;
                }
                sArray[rightChar]++;
                while (slow<s.length()&&count==targetCount){
                    if(fast-slow<minLength){
                        minLength = fast-slow;
                        res[0]=slow;
                        res[1]=fast;
                    }
                    sArray[s.charAt(slow)]--;
                    if(sArray[s.charAt(slow)]<tArray[s.charAt(slow)]){
                        count--;
                    }
                    slow=findNextStrIndex(slow+1,s,tArray);
                    if(slow==-1){
                        break;
                    }

                }
                fast=findNextStrIndex(fast+1,s,tArray);
            }
            if(minLength!=Integer.MAX_VALUE){
                return s.substring(res[0],res[1]+1);
            }else {
                return "";
            }
        }

        public int findNextStrIndex(int start,String s, int[] tArray){
            while (start<s.length()){
                char c = s.charAt(start);
                if(tArray[c]!=0){
                    return start;
                }
                start++;

            }
            return start;
        }

}
