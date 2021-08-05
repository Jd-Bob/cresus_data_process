package mg.orange.cresus.data_transfert_object;

import com.mongodb.BasicDBObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyContractsDTO {
    private ObjectId id;
    private String price_plan;
    private String market_id;
    private String party_id;
    private String billing_type;
    private String kyc_status;
    private Date birthday_date;
    private String device_category;
    private String city;
    private String first_region_name;
    private String tenure_band;
    private boolean om_status;
    private double om_subscriber_balance;

    private Date last_topup_date;
    private Date last_event_o_date;
    private Date last_event_i_date;
    private Date last_data_date;
    private double balance_main_amnt;
}
