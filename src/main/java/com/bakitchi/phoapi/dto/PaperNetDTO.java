package com.bakitchi.phoapi.dto;

import com.bakitchi.phoapi.entity.Edge;
import com.bakitchi.phoapi.entity.Node;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PaperNetDTO
{
    List<NodeDTO> nodes;
    List<Edge> edges;

    public PaperNetDTO(List<NodeDTO> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<NodeDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeDTO> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
