package com.javaSolutions.numOfCircles;

/**
 * Created by prasad on 2/25/2017.
  */
  import java.util.ArrayList;
  import java.util.HashSet;
  import java.util.Hashtable;
  import java.util.List;
  import java.util.Set;

  public class NumberOfCircles {

      public void getTotalCIrcles(){
              int numFrnds = 0;
	              String[] friends = new String[5];
		              friends[0] = "YNNN";
			              friends[1] = "NYNN";
				              friends[2] = "NYNN";
					              friends[3] = "NNYN";
						              friends[4] = "NNNY";

							              System.out.println("\n\ntotal Number of friend circles:: "+getFriendCircles(friends));

								          }

									      public static int getFriendCircles(String[] friendsArray) {

									              char[][] friends = {"YYNN".toCharArray(), "YYNN".toCharArray(), "NNY".toCharArray(), "NNY".toCharArray()};

										              if (friends == null || friends.length < 1)
											                  return 0;

													          int noOfCircles = 0;

														          boolean visited[] = new boolean[friends.length];

															          for (int i = 0; i < visited.length; i++)
																              visited[i] = false;

																	              for (int i = 0; i < friends.length; i++) {
																		                  if (!visited[i]) {
																				                  noOfCircles++;
																						                  visited[i] = true;
																								                  findFriends(friends, visited, i);
																										              }
																											              }

																												              return noOfCircles;

																													          }

																														      public static void findFriends(char[][] friends, boolean[] visited, int id) {

																														              for (int i = 0; i < friends.length; i++) {
																															                  if (!visited[i] && i != id && 'Y' == friends[id][i]) {
																																	                  visited[i] = true;
																																			                  findFriends(friends, visited, i);
																																					              }
																																						              }
																																							          }
																																								  }


																																								  
