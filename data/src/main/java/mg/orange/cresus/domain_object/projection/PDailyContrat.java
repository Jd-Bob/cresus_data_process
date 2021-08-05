package mg.orange.cresus.domain_object.projection;



import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.cbm.CbmDailyContrat;


import java.util.Date;


@ProjectionFor(CbmDailyContrat.class)
public class PDailyContrat extends PBase{
    public String price_plan;
    public String market_id;
    public Date   day;
    public String party_id;
    public String billing_type;
    public String kyc_status;
    public String language;

    public Date birthday_date;
    public String device_category;
    public String city;
    public String last_region_name;
    public String tenure_band;
    public String om_status;
    public double om_subscriber_balance;

    public Date last_topup_date;
    public Date last_event_o_date;
    public Date last_event_i_date;
    public Date last_data_date;
//    public double balance_main_amnt;

}
