//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Set;
//
//public class NumberOfCircles {
//
//    public void getTotalCIrcles(){
//        int numFrnds = 0;
//        String[] friends = new String[5];
//        friends[0] = "YNNN";
//        friends[1] = "NYNN";
//        friends[2] = "NYNN";
//        friends[3] = "NNYN";
//        friends[4] = "NNNY";
//        System.out.println("\ntotal Number of friend circles using second Method:: "+getFriendCirclesCount(friends));
//    }
//
//    public static int getFriendCirclesCount(String[] ipArray){
//        boolean[] visitedTrack = new boolean[ipArray.length];
//        for(int i = 0 ; i < visitedTrack.length ; i ++){
//            visitedTrack[i]=false;
//        }
//        int numOfCircles = 0;
//        for (int i = 0 ; i < ipArray.length; i++){
//            if (!visitedTrack[i]){
//                visitedTrack[i]=true;
//                findFriendsOf(ipArray, visitedTrack, i);
//                numOfCircles++;
//            }
//        }
//        return numOfCircles;
//    }
//
//    public static void findFriendsOf(String[] friends, boolean[] visited, int id){
//        for (int i = 0 ; i < friends[id].length(); i++){
//            if(!visited[i] && i != id && friends[id].charAt(i)=='Y'){
//                visited[i] = true;
//                findFriendsOf(friends, visited, i);
//            }
//        }
//    }
//}
//
//
