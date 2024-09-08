package org.kislay.CourseSchedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = constructGraph(prerequisites);
        boolean[] visited = new boolean[numCourses];
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            Integer startNode = entry.getKey();
            Set<Integer> endNodes = entry.getValue();
            if(visited[startNode]) {
                continue;
            }
            for (int endNode: endNodes) {
                boolean hasCycle = traverseAndCheckForCycle(startNode, endNode, graph, false, new HashSet<>(), visited);
                if (hasCycle) {
                    return false;
                }
                visited[endNode] = true;
            }
        }
        return true;
    }

    private boolean traverseAndCheckForCycle(int startNode, int node, Map<Integer, Set<Integer>> graph,
                                             boolean hasCycle, Set<List<Integer>> pathCrossed,
                                             boolean[] visited) {
        if(visited[node]) {
            return hasCycle;
        }
        List<Integer> edge = List.of(startNode, node);
        if (pathCrossed.contains(edge) || hasCycle) return true;
        pathCrossed.add(edge);
        Set<Integer> endNodes = graph.getOrDefault(node, new HashSet<>());
        for (int endNode: endNodes) {
            hasCycle = traverseAndCheckForCycle(node, endNode, graph, hasCycle, pathCrossed, visited);
        }
        visited[node] = true;
        return hasCycle;
    }

    private Map<Integer, Set<Integer>> constructGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] preReqEdge: prerequisites) {
            Set<Integer> endNodes = graph.getOrDefault(preReqEdge[0], new HashSet<>());
            endNodes.add(preReqEdge[1]);
            graph.put(preReqEdge[0], endNodes);
        }
        return graph;
    }


    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] preReq = {{1, 0}, {0,3}, {0,2}, {3, 2}, {2, 4}, {2, 5}, {4,5}, {5,6}};
        System.out.println(courseSchedule.canFinish(7, preReq));
    }

}
