package med;
import java.util.*;

public class ElectricityBoardMain {

    private Map<String, String> electricityMap = new HashMap<>();

    
    public Map<String, String> getElectricityMap() {
        return electricityMap;
    }

    public void setElectricityMap(Map<String, String> electricityMap) {
        this.electricityMap = electricityMap;
    }

    public int findCountOfConnectionsBasedOnTheConnectionType(String connectionType) {
        int count = 0;
        for (String type : electricityMap.values()) {
            if (type.equalsIgnoreCase(connectionType)) {
                count++;
            }
        }
        return count == 0 ? -1 : count;
    }

    public List<String> findConnectionIdsBasedOnTheConnectionType(String connectionType) {
        List<String> ids = new ArrayList<>();
        for (Map.Entry<String, String> entry : electricityMap.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(connectionType)) {
                ids.add(entry.getKey());
            }
        }
        return ids;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElectricityBoardMain eb = new ElectricityBoardMain();
        Map<String, String> map = new HashMap<>();

        System.out.println("Enter the number of connection records to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the connection records (ConnectionId:Connectiontype)");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(":");
            map.put(input[0], input[1]);
        }
        eb.setElectricityMap(map);

        System.out.println("Enter the Connection type to be searched");
        String searchType = sc.nextLine();
        int count = eb.findCountOfConnectionsBasedOnTheConnectionType(searchType);
        if (count == -1) {
            System.out.println("No Connection Ids were found for " + searchType);
        } else {
            System.out.println("The count of connection Ids based on " + searchType.toUpperCase() + " are " + count);
        }

        System.out.println("Enter the Connection type to identify the Connection Ids");
        String filterType = sc.nextLine();
        List<String> ids = eb.findConnectionIdsBasedOnTheConnectionType(filterType);
        if (ids.isEmpty()) {
            System.out.println("No Connection Ids were found for the " + filterType.toLowerCase());
        } else {
            System.out.println("Connection Ids based on the " + filterType.toUpperCase() + " are");
            for (String id : ids) {
                System.out.println(id);
            }
        }

        sc.close();
    }
}
