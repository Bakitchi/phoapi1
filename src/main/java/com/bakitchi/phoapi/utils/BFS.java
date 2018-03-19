package com.bakitchi.phoapi.utils;

import com.bakitchi.phoapi.entity.Edge;
import com.bakitchi.phoapi.entity.Node;
import com.sun.jdi.connect.spi.TransportService;
import javafx.util.Pair;

import java.util.*;

public class BFS {
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    Map map;
    public boolean addNode(String name,String type,String property){
        Node node = new Node(name,type,property);
        if(map.get(name) != null)
            return false;
        map.put(name,node);
        return true;
    }

    public boolean addEdge(String source,String target){
        Node src = (Node)map.get(source);
        Node tar = (Node)map.get(target);
        if(src == null || tar == null)
            return false;
        src.getNxt().addElement(tar);
        tar.getNxt().addElement(src);
        return true;

    }
    public BFS(){
        this.map = new HashMap();
    }
    public Pair<ArrayList<Node>,ArrayList<Edge> > start(String name){
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge>edges = new ArrayList<Edge>();
        Map<Node,Integer> vis = new HashMap<Node,Integer>();
        Node startNode = (Node) map.get(name);
        vis.put(startNode,1);
        Queue<Node> que = new LinkedList<Node>();
        que.add(startNode);
        while(que.size() != 0){
            Node front = (Node)que.poll();
            Vector<Node> nxt = front.getNxt();
            Integer level = vis.get(front);
            nodes.add(front);
            if(level == 3) continue;
            for(int i = 0;i < nxt.size();++i){
                Node toNode = (Node) nxt.get(i);
                if(vis.get(toNode) != null )
                    continue;
                edges.add(new Edge(front.getName(),toNode.getName()));
                que.add(toNode);
                vis.put(toNode,level+1);
            }
        }
        return new Pair<ArrayList<Node>, ArrayList<Edge>>(nodes,edges);
    }

//    public static void main(String[] args){
//        BFS bfs = new BFS();
//        bfs.addNode("1","1","1");
//        bfs.addNode("2","1","1");
//        bfs.addNode("3","1","1");
//        bfs.addNode("4","1","1");
//        bfs.addNode("5","1","1");
//        bfs.addNode("6","1","1");
//        bfs.addNode("7","1","1");
//        bfs.addNode("8","1","1");
//        bfs.addNode("9","1","1");
//
//        bfs.addEdge("1","2");
//        bfs.addEdge("1","3");
//        bfs.addEdge("1","4");
//        bfs.addEdge("2","5");
//        bfs.addEdge("3","6");
//        bfs.addEdge("4","7");
//
//        bfs.addEdge("5","8");
//        bfs.addEdge("7","9");
//
//        Pair p = bfs.start("1");
//        HashSet<Node> nodes = (HashSet<Node>)p.getKey();
//        HashSet<Edge> edges = (HashSet<Edge>)p.getValue();
//        nodes.add((Node)bfs.getMap().get("1"));
//        System.out.println(nodes.size());
//        System.out.println(edges.size());
//
//    }
}
