package ttxxly.top.gank.data.remote;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("history/content/{count}/{page}")
    Observable<DailyData> getDaily(@Path("count") int count, @Path("page") int page);

    //http://gank.io/api/day/2017/11/08
    @GET("day/{year}/{month}/{day}")
    Observable<DailyGank> getDailyGank(@Path("year") String year, @Path("month") String month,
                                       @Path("day") String day);
}
