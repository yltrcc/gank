package ttxxly.top.gank.data.remote;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ttxxly.top.gank.entity.CategoryData;
import ttxxly.top.gank.entity.DailyData;
import ttxxly.top.gank.entity.DailyGank;

/**
 * Description:
 * date: 2017/11/07 13:42
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public interface GankApi {

    //http://gank.io/api/history/content/2/1
    @GET("history/content/{count}/{page}")
    Observable<DailyData> getDaily(@Path("count") int count, @Path("page") int page);

    //http://gank.io/api/day/2017/11/08
    @GET("day/{year}/{month}/{day}")
    Observable<DailyGank> getDailyGank(@Path("year") String year, @Path("month") String month,
                                       @Path("day") String day);

    // http://gank.io/api/data/数据类型/请求个数/第几页
    //http://gank.io/api/data/all/20/2
    @GET("data/{type}/{count}/{page}")
    Observable<CategoryData> getCategory(@Path("type") String type, @Path("count") int count,
                                         @Path("page") int page);

}
