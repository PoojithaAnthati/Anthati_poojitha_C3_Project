import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        // return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        List<Restaurant> restaurantList = getRestaurants();
        Restaurant foundRestaurant = null;
        for(Restaurant r : restaurantList) {
            if(r.getName().equals(restaurantName)) {
                foundRestaurant = r;
                break;
            }
            else{
                throw new restaurantNotFoundException(restaurantName);
            }
        }
        return foundRestaurant;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
