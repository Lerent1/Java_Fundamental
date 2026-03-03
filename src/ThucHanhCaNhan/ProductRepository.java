package ThucHanhCaNhan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    private ArrayList<Product> productList = new ArrayList<>();
    private HashMap<String, Product> hashMap= new HashMap<>();


    @Override
    public boolean add(Product item) {
        if(item == null || hashMap.containsKey(item.getId())) {
            return false;
        } else {
            productList.add(item);
            hashMap.put(item.getId(), item);
            return false;
        }
    }

    @Override
    public boolean removeById(String id) {
        if(id != null) {
            productList.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product findById(String id) {
        if(id == null) {
            return null;
        } else {
            return hashMap.get(id);
        }
    }

    @Override
    public ArrayList<Product> findAll() {
        return productList;
    }
}
