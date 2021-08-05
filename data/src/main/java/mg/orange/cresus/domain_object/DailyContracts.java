package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;


@MongoEntity(collection="daily_contracts", clientName = "testbed", database = "cresus")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyContracts {
    private ObjectId id;
    private String price_plan;
    private Date   day;
    private String market_id;
    private String party_id;
    private String billing_type;
    private String kyc_status;
    private Date birthday_date;
    private String language;
    private String device_category;
    private String city;
    private String last_region_name;
    private String tenure_band;
    private String om_status;
    private double om_subscriber_balance;

    private Date last_topup_date;
    private Date last_event_o_date;
    private Date last_event_i_date;
    private Date last_data_date;
//    private double balance_main_amnt;

}
