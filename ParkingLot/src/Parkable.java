import java.util.ArrayList;

// Different types of vehicles have different number of spot requirements. Hence each will have different implementations
interface Parkable {

    ArrayList<Integer> findNearestSpot(int entryFloor);

}
