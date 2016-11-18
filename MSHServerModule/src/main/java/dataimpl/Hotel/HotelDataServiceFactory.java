package dataimpl.Hotel;

import datafactory.DataHelperFactory;
import datahelper.DataHelper;
import dataservice.hoteldataservice.HotelDataService;

/**
 * Created by SilverNarcissus on 16/11/14.
 */
public class HotelDataServiceFactory {
    private static HotelDataServiceImpl hotelDataService;

    /**
     * 得到一个HotelDataService实例
     * @return HotelDataService实例
     */
    public static synchronized HotelDataService getHotelDataService(){
        if(hotelDataService==null){
            DataHelper hotelDataHelper= DataHelperFactory.getHibernateDataHelper("hibernate.cfg.xml");
            DataHelper hotelRoomDataHelper=DataHelperFactory.getHibernateDataHelper("hibernate.cfg.xml");
            DataHelper roomStockPOHelper= DataHelperFactory.getHibernateDataHelper("hibernate.cfg.xml");

            hotelDataHelper.setClassName("po.HotelPO");
            hotelRoomDataHelper.setClassName("po.HotelRoomPO");
            roomStockPOHelper.setClassName("po.RoomStockPO");
            hotelDataService=new HotelDataServiceImpl(hotelDataHelper,hotelRoomDataHelper,roomStockPOHelper);
        }
        return hotelDataService;
    }
}
