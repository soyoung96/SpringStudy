package Hello.core.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateFulService {

//    private int price; //상태를 유지하는 필드
    public int order(String name,int price){
        log.info("name = "+name + " price = "+price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
