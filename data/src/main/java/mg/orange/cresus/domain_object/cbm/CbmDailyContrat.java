package mg.orange.cresus.domain_object.cbm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

@MongoEntity(collection="daily_contracts", clientName = "cbm", database = "cbm")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class CbmDailyContrat implements Serializable {
   private ObjectId id;
   private String price_plan;
   private String market_id;
   private String party_id;
   private String billing_type;
   @BsonProperty("KYC_status")
   private String kyc_status;
   private String language;

   private Date birthday_date;
   private String device_category;
   private String city;
   private String last_region_name;
   private String tenure_band;
   @BsonProperty("OM_status")
   private String om_status;
   @BsonProperty("OM_subscriber_balance")
   private double om_subscriber_balance;

   private Date last_topup_date;
   private Date last_event_o_date;
   private Date last_event_i_date;
   private Date last_data_date;
   private double balance_main_amnt;
}
