package mg.orange.cresus.application;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.domain_object.projection.*;
import mg.orange.cresus.mapper.clients.*;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class GlobalMapper {

    @Inject
    ClientMapper clientMapper;

    @Inject
    UserOMMapper omUserMapper;

    @Inject
    DailyContractsMapper dailyContractsMapper;

    @Inject
    DailyUsageMapper dailyUsageMapper;

    @Inject
    DailyUsageInternationalMapper dailyUsageInternationalMapper;

    @Inject
    MonthlyUsageMapper monthlyUsageMapper;

    @Inject
    DailyPurchaseMapper dailyPurchaseMapper;

    public <T, E extends PBase> List<T> mapper(final List<E> projections, String dataClassName) {
        List<T> data = null;

        switch (dataClassName) {
            case "UserOM":
                data = (List<T>) this.omUserMapper.toLocalDOs((List<PClientOM>) projections);
                break;
            case "DailyContracts":
                data = (List<T>) this.dailyContractsMapper.toLocalDOs((List<PDailyContrat>) projections);
                break;
            case "DailyUsage":
                data = (List<T>) this.dailyUsageMapper.toLocalDOs((List<PDailyUsage>) projections);
                break;
            case "DailyUsageInternational":
                data = (List<T>) this.dailyUsageInternationalMapper.toLocalDOs((List<PDailyUsageInternational>) projections);
                break;
            case "MonthlyUsage":
                data = (List<T>) this.monthlyUsageMapper.toLocalDOs((List<PMonthlyUsage>) projections);
                break;
            case "DailyPurchase":
                data = (List<T>) this.dailyPurchaseMapper.toLocalDOs((List<PDailyPurchase>) projections);
                break;
            default:
                data = (List<T>) this.clientMapper.toLocalDOs((List<PClient>) projections);
        }

        return data;
    }
}
