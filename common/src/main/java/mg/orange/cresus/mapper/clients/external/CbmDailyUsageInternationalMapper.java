package mg.orange.cresus.mapper.clients.external;


import mg.orange.cresus.data_transfert_object.cbm.CbmDailyUsageInternationalDTO;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsageInternational;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CbmDailyUsageInternationalMapper {
    CbmDailyUsageInternationalMapper INSTANCE = Mappers.getMapper(CbmDailyUsageInternationalMapper.class);

    CbmDailyUsageInternational toDo(CbmDailyUsageInternationalDTO cbmDailyUsageDTO);
    CbmDailyUsageInternationalDTO toDTO(CbmDailyUsageInternational cbmDailyUsage);
    List<CbmDailyUsageInternational> toDOs(List<CbmDailyUsageInternationalDTO> cbmDailyUsageDTOS);
    List<CbmDailyUsageInternationalDTO> toDTOs(List<CbmDailyUsageInternational> cbmDailyUsages);
}
