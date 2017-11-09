package ttxxly.top.gank.modules.daily;

/**
 * Description:
 * date: 2017/11/09 14:23
 * Email: ttxxly@gmail.com
 *
 * @author ttxxly
 */

public class DailyGankPresenter implements DailyGankContract.Presenter {

    DailyGankContract.View view;
    private String year;
    private String month;
    private String day;

    public DailyGankPresenter(DailyGankContract.View view, String year, String month, String day){
        this.view = view;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void setImg() {

    }

    @Override
    public String setUrl() {
        return null;
    }
}
