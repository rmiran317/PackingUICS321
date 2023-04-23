package com.example.packingui;

import java.util.*;

public class StatesGraph1 {
    private Map<Integer, Map<Integer, Double>> graph;

    public StatesGraph1(DS4States states) {
        this.graph = new HashMap<Integer, Map<Integer, Double>>();

        // Initialize graph with states as nodes
        for (int i = 0; i < 50; i++) {
            graph.put(i, new HashMap<Integer, Double>());
        }

        // Add edges between neighboring states
        addEdge(states.getStateCode("Alabama"), states.getStateCode("Mississippi"), 3.8822408125808);
        addEdge(states.getStateCode("Alabama"), states.getStateCode("Tennessee"), 3.8188474339472);
        addEdge(states.getStateCode("Alabama"), states.getStateCode("Florida"), 2.799910679216);
        addEdge(states.getStateCode("Alabama"), states.getStateCode("Georgia"), 2.3531966151688);
        addEdge(states.getStateCode("Arizona"), states.getStateCode("Nevada"), 9.5648333959208);

        addEdge(states.getStateCode("Arizona"), states.getStateCode("New Mexico"), 6.5500167889987);
        addEdge(states.getStateCode("Arizona"), states.getStateCode("Utah"), 7.3323054361627);
        addEdge(states.getStateCode("Arizona"), states.getStateCode("California"), 10.705097822277);
        addEdge(states.getStateCode("Arizona"), states.getStateCode("Colorado"), 9.4952508998073);

        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Oklahoma"), 5.2673920404287);
        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Tennessee"), 5.6847460488428);
        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Texas"), 7.050931339406);
        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Louisiana"), 4.428735131568);
        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Mississippi"), 3.2258400734731);
        addEdge(states.getStateCode("Arkansas"), states.getStateCode("Missouri"), 3.8343446131438);

        addEdge(states.getStateCode("california"), states.getStateCode("oregon"), 6.5447753591644);
        addEdge(states.getStateCode("california"), states.getStateCode("arizona"), 10.705097822277);
        addEdge(states.getStateCode("california"), states.getStateCode("nevada"), 1.8245935861391);

        addEdge(states.getStateCode("colorado"), states.getStateCode("new mexico"), 4.1678440535309);
        addEdge(states.getStateCode("colorado"), states.getStateCode("oklahoma"), 8.6029198887701);
        addEdge(states.getStateCode("colorado"), states.getStateCode("utah"), 6.9810194308325);
        addEdge(states.getStateCode("colorado"), states.getStateCode("wyoming"), 1.410670198673);
        addEdge(states.getStateCode("colorado"), states.getStateCode("arizona"), 9.4952508998073);
        addEdge(states.getStateCode("colorado"), states.getStateCode("kansas"), 9.3325194006386);
        addEdge(states.getStateCode("colorado"), states.getStateCode("nebraska"), 8.3538618750796);

        addEdge(states.getStateCode("connecticut"), states.getStateCode("new york"), 1.3953633806951);
        addEdge(states.getStateCode("connecticut"), states.getStateCode("rhode island"), 1.2689979805536);
        addEdge(states.getStateCode("connecticut"), states.getStateCode("massachusetts"), 1.7240986257915);

        addEdge(states.getStateCode("delaware"), states.getStateCode("new jersey"), 1.3010753375581);
        addEdge(states.getStateCode("delaware"), states.getStateCode("pennsylvania"), 1.7566342654113);
        addEdge(states.getStateCode("delaware"), states.getStateCode("maryland"), 0.98748885393457);

        addEdge(states.getStateCode("florida"), states.getStateCode("georgia"), 3.3126353667088);
        addEdge(states.getStateCode("florida"), states.getStateCode("alabama"), 2.799910679216);

        addEdge(states.getStateCode("georgia"), states.getStateCode("north carolina"), 6.0974661873035);
        addEdge(states.getStateCode("georgia"), states.getStateCode("south carolina"), 3.3644175591297);
        addEdge(states.getStateCode("georgia"), states.getStateCode("tennessee"), 3.4031916744775);
        addEdge(states.getStateCode("georgia"), states.getStateCode("alabama"), 2.3531966151688);
        addEdge(states.getStateCode("georgia"), states.getStateCode("florida"), 3.3126353667088);

        addEdge(states.getStateCode("idaho"), states.getStateCode("utah"), 5.1629638420222);
        addEdge(states.getStateCode("idaho"), states.getStateCode("washington"), 7.5262121871606);
        addEdge(states.getStateCode("idaho"), states.getStateCode("wyoming"), 11.646063161191);
        addEdge(states.getStateCode("idaho"), states.getStateCode("montana"), 5.1275670382142);
        addEdge(states.getStateCode("idaho"), states.getStateCode("nevada"), 5.7057935148866);
        addEdge(states.getStateCode("idaho"), states.getStateCode("oregon"), 6.9571843754753);

        addEdge(states.getStateCode("illinois"), states.getStateCode("kentucky"), 5.0439903452971);
        addEdge(states.getStateCode("illinois"), states.getStateCode("missouri"), 2.7975970129595);
        addEdge(states.getStateCode("illinois"), states.getStateCode("wisconsin"), 3.2874698783863);
        addEdge(states.getStateCode("illinois"), states.getStateCode("indiana"), 3.4924446281543);
        addEdge(states.getStateCode("illinois"), states.getStateCode("iowa"), 4.336660934175);

        addEdge(states.getStateCode("indiana"), states.getStateCode("michigan"), 3.3726484651337);
        addEdge(states.getStateCode("indiana"), states.getStateCode("ohio"), 3.1694388475257);
        addEdge(states.getStateCode("indiana"), states.getStateCode("illinois"), 3.4924446281543);
        addEdge(states.getStateCode("indiana"), states.getStateCode("kentucky"), 2.0394784265008);

        addEdge(states.getStateCode("iowa"), states.getStateCode("nebraska"), 3.1934087426712);
        addEdge(states.getStateCode("iowa"), states.getStateCode("south dakota"), 7.2917449716863);
        addEdge(states.getStateCode("iowa"), states.getStateCode("wisconsin"), 4.4725180302672);
        addEdge(states.getStateCode("iowa"), states.getStateCode("illinois"), 4.336660934175);
        addEdge(states.getStateCode("iowa"), states.getStateCode("minnesota"), 3.4011885546709);
        addEdge(states.getStateCode("iowa"), states.getStateCode("missouri"), 3.3344607881083);

        addEdge(states.getStateCode("kansas"), states.getStateCode("nebraska"), 2.0349590896772);
        addEdge(states.getStateCode("kansas"), states.getStateCode("oklahoma"), 3.9971310032637);
        addEdge(states.getStateCode("kansas"), states.getStateCode("colorado"), 9.3325194006386);
        addEdge(states.getStateCode("kansas"), states.getStateCode("missouri"), 4.9930145622356);

        addEdge(states.getStateCode("kentucky"), states.getStateCode("tennessee"), 2.7799026125807);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("virginia"), 7.4698817919015);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("west virginia"), 3.2664700556858);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("illinois"), 5.0439903452971);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("indiana"), 2.0394784265008);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("missouri"), 7.3081075740688);
        addEdge(states.getStateCode("kentucky"), states.getStateCode("ohio"), 2.582597683419);

        addEdge(states.getStateCode("louisiana"), states.getStateCode("texas"), 6.5554940113722);
        addEdge(states.getStateCode("louisiana"), states.getStateCode("arkansas"), 4.428735131568);
        addEdge(states.getStateCode("louisiana"), states.getStateCode("mississippi"), 2.1026636980768);

        addEdge(states.getStateCode("maine"), states.getStateCode("new hampshire"), 2.072482828629);

        addEdge(states.getStateCode("maryland"), states.getStateCode("virginia"), 1.7210528754995);
        addEdge(states.getStateCode("maryland"), states.getStateCode("west virginia"), 5.1615390532271);
        addEdge(states.getStateCode("maryland"), states.getStateCode("delaware"), 0.98748885393457);
        addEdge(states.getStateCode("maryland"), states.getStateCode("pennsylvania"), 1.3442420924967);

        addEdge(states.getStateCode("massachusetts"), states.getStateCode("new york"), 2.7102437548562);
        addEdge(states.getStateCode("massachusetts"), states.getStateCode("rhode island"), 0.63354364784835);
        addEdge(states.getStateCode("massachusetts"), states.getStateCode("vermont"), 2.4345547817455);
        addEdge(states.getStateCode("massachusetts"), states.getStateCode("connecticut"), 1.7240986257915);
        addEdge(states.getStateCode("massachusetts"), states.getStateCode("new hampshire"), 0.97227027791247);

        addEdge(states.getStateCode("Michigan"), states.getStateCode("Ohio"), 3.1792339288895);
        addEdge(states.getStateCode("Michigan"), states.getStateCode("Wisconsin"), 4.8411450525769);
        addEdge(states.getStateCode("Michigan"), states.getStateCode("Indiana"), 3.3726484651337);

        addEdge(states.getStateCode("North Carolina"), states.getStateCode("Virginia"), 2.1319467430051);
        addEdge(states.getStateCode("North Carolina"), states.getStateCode("Tennessee"), 8.1542538557837);
        addEdge(states.getStateCode("North Carolina"), states.getStateCode("Georgia"), 6.0974661873035);
        addEdge(states.getStateCode("North Carolina"), states.getStateCode("South Carolina"), 2.9833675596736);

        addEdge(states.getStateCode("North Dakota"), states.getStateCode("Minnesota"), 7.9044569074958);
        addEdge(states.getStateCode("North Dakota"), states.getStateCode("Montana"), 11.237559380474);
        addEdge(states.getStateCode("North Dakota"), states.getStateCode("South Dakota"), 2.4924126171904);

        addEdge(states.getStateCode("New York"), states.getStateCode("Vermont"), 1.9942202465859);
        addEdge(states.getStateCode("New York"), states.getStateCode("Massachusetts"), 2.7102437548562);
        addEdge(states.getStateCode("New York"), states.getStateCode("Connecticut"), 1.3953633806951);
        addEdge(states.getStateCode("New York"), states.getStateCode("New Jersey"), 2.6343971618816);
        addEdge(states.getStateCode("New York"), states.getStateCode("Pennsylvania"), 3.9338169225831);

        addEdge(states.getStateCode("Ohio"), states.getStateCode("Michigan"), 3.1792339288895);
        addEdge(states.getStateCode("Ohio"), states.getStateCode("Pennsylvania"), 6.1229742727587);
        addEdge(states.getStateCode("Ohio"), states.getStateCode("West Virginia"), 2.136352173936);
        addEdge(states.getStateCode("Ohio"), states.getStateCode("Kentucky"), 2.582597683419);
        addEdge(states.getStateCode("Ohio"), states.getStateCode("Indiana"), 3.1694388475257);

        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("Colorado"), 8.6029198887701);
        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("Kansas"), 3.9971310032637);
        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("Missouri"), 6.1597703481287);
        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("Arkansas"), 5.2673920404287);
        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("Texas"), 5.2229172561336);
        addEdge(states.getStateCode("Oklahoma"), states.getStateCode("New Mexico"), 8.438526013593);

        addEdge(states.getStateCode("Oregon"), states.getStateCode("Washington"), 2.1010888262177);
        addEdge(states.getStateCode("Oregon"), states.getStateCode("Idaho"), 6.9571843754753);
        addEdge(states.getStateCode("Oregon"), states.getStateCode("Nevada"), 6.6333196840446);
        addEdge(states.getStateCode("Oregon"), states.getStateCode("California"), 6.5447753591644);

        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("New York"), 3.9338169225831);
        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("New Jersey"), 2.1141383925252);
        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("Delaware"), 1.7566342654113);
        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("Maryland"), 1.3442420924967);
        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("West Virginia"), 5.1067191446489);
        addEdge(states.getStateCode("Pennsylvania"), states.getStateCode("Ohio"), 6.1229742727587);

        addEdge(states.getStateCode("Rhode Island"), states.getStateCode("Connecticut"), 1.2689979805536);
        addEdge(states.getStateCode("Rhode Island"), states.getStateCode("Massachusetts"), 0.63354364784835);

        addEdge(states.getStateCode("South Carolina"), states.getStateCode("North Carolina"), 2.9833675596736);
        addEdge(states.getStateCode("South Carolina"), states.getStateCode("Georgia"), 2.9833675596736);

        addEdge(states.getStateCode("South Dakota"), states.getStateCode("Nebraska"), 5.0955824658165);
        addEdge(states.getStateCode("South Dakota"), states.getStateCode("North Dakota"), 2.4924126171904);
        addEdge(states.getStateCode("South Dakota"), states.getStateCode("Wyoming"), 5.5160875044315);
        addEdge(states.getStateCode("South Dakota"), states.getStateCode("Iowa"), 7.2917449716863);
        addEdge(states.getStateCode("South Dakota"), states.getStateCode("Minnesota"), 7.2680236880456);
        addEdge(states.getStateCode("South Dakota"), states.getStateCode("Montana"), 11.881009897977);

        addEdge(states.getStateCode("tennessee"), states.getStateCode("mississippi"), 5.1439515012944);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("missouri"), 5.9044457101846);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("north carolina"), 8.1542538557837);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("virginia"), 9.4508728234703);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("alabama"), 3.8188474339472);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("arkansas"), 5.6847460488428);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("georgia"), 3.4031916744775);
        addEdge(states.getStateCode("tennessee"), states.getStateCode("kentucky"), 2.7799026125807);

        addEdge(states.getStateCode("texas"), states.getStateCode("new mexico"), 9.8219972149528);
        addEdge(states.getStateCode("texas"), states.getStateCode("oklahoma"), 5.2229172561336);
        addEdge(states.getStateCode("texas"), states.getStateCode("arkansas"), 7.050931339406);
        addEdge(states.getStateCode("texas"), states.getStateCode("louisiana"), 6.5554940113722);

        addEdge(states.getStateCode("utah"), states.getStateCode("nevada"), 8.041432824592);
        addEdge(states.getStateCode("utah"), states.getStateCode("new mexico"), 7.832381464743);
        addEdge(states.getStateCode("utah"), states.getStateCode("wyoming"), 7.0773052015245);
        addEdge(states.getStateCode("utah"), states.getStateCode("arizona"), 7.3323054361627);
        addEdge(states.getStateCode("utah"), states.getStateCode("colorado"), 6.9810194308325);
        addEdge(states.getStateCode("utah"), states.getStateCode("idaho"), 5.1629638420222);

        addEdge(states.getStateCode("vermont"), states.getStateCode("new hampshire"), 1.4835950563439);
        addEdge(states.getStateCode("vermont"), states.getStateCode("new york"), 1.9942202465859);
        addEdge(states.getStateCode("vermont"), states.getStateCode("massachusetts"), 2.4345547817455);

        addEdge(states.getStateCode("virginia"), states.getStateCode("north carolina"), 2.1319467430051);
        addEdge(states.getStateCode("virginia"), states.getStateCode("tennessee"), 9.4508728234703);
        addEdge(states.getStateCode("virginia"), states.getStateCode("west virginia"), 4.254087753992);
        addEdge(states.getStateCode("virginia"), states.getStateCode("kentucky"), 7.4698817919015);
        addEdge(states.getStateCode("virginia"), states.getStateCode("maryland"), 1.7210528754995);

        addEdge(states.getStateCode("washington"), states.getStateCode("oregon"), 2.1010888262177);
        addEdge(states.getStateCode("washington"), states.getStateCode("idaho"), 7.5262121871606);

        addEdge(states.getStateCode("west virginia"), states.getStateCode("pennsylvania"), 5.1067191446489);
        addEdge(states.getStateCode("west virginia"), states.getStateCode("virginia"), 4.254087753992);
        addEdge(states.getStateCode("west virginia"), states.getStateCode("kentucky"), 3.2664700556858);
        addEdge(states.getStateCode("west virginia"), states.getStateCode("maryland"), 5.1615390532271);
        addEdge(states.getStateCode("west virginia"), states.getStateCode("ohio"), 2.136352173936);

        addEdge(states.getStateCode("wisconsin"), states.getStateCode("michigan"), 4.8411450525769);
        addEdge(states.getStateCode("wisconsin"), states.getStateCode("minnesota"), 4.1662617634187);
        addEdge(states.getStateCode("wisconsin"), states.getStateCode("illinois"), 3.2874698783863);
        addEdge(states.getStateCode("wisconsin"), states.getStateCode("iowa"), 4.4725180302672);

        addEdge(states.getStateCode("wyoming"), states.getStateCode("nebraska"), 8.1273733904983);
        addEdge(states.getStateCode("wyoming"), states.getStateCode("south dakota"), 5.5160875044315);
        addEdge(states.getStateCode("wyoming"), states.getStateCode("utah"), 7.0773052015245);
        addEdge(states.getStateCode("wyoming"), states.getStateCode("colorado"), 1.410670198673);
        addEdge(states.getStateCode("wyoming"), states.getStateCode("idaho"), 11.646063161191);
        addEdge(states.getStateCode("wyoming"), states.getStateCode("montana"), 9.0258924994297);
        // add more edges as needed...
    }

    private void addEdge(int source, int destination, double weight) {
        graph.get(source).put(destination, weight);
        graph.get(destination).put(source, weight);
    }

    //
    public LinkedList<Integer> shortestPath(int start, int end) {
        Map<Integer, Double> distances = new HashMap<Integer, Double>();
        Map<Integer, Integer> previousNodes = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Double.compare(distances.getOrDefault(a, Double.POSITIVE_INFINITY), distances.getOrDefault(b, Double.POSITIVE_INFINITY));
            }
        });

        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                break;
            }

            for (Map.Entry<Integer, Double> neighbor : graph.get(current).entrySet()) {
                int neighborNode = neighbor.getKey();
                double cost = distances.getOrDefault(current, Double.POSITIVE_INFINITY) + neighbor.getValue();

                if (cost < distances.getOrDefault(neighborNode, Double.POSITIVE_INFINITY)) {
                    distances.put(neighborNode, cost);
                    previousNodes.put(neighborNode, current);
                    queue.add(neighborNode);
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<Integer>();
        int currentNode = end;

        while (previousNodes.containsKey(currentNode)) {
            path.addFirst(currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        if (path.size() > 0) {
            path.addFirst(start);
        }

        return path;
    }

    public static void main(String[] args) {
        DS4States states = new DS4States();
        StatesGraph1 graph = new StatesGraph1(states);

        LinkedList<Integer> path = graph.shortestPath(states.getStateCode("alabama"), states.getStateCode("new york"));
        System.out.println(path);
    }
}


