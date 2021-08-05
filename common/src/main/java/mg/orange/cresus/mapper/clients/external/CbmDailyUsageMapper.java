package mg.orange.cresus.mapper.clients.external;


import mg.orange.cresus.data_transfert_object.cbm.CbmDailyUsageDTO;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CbmDailyUsageMapper {
    CbmDailyUsageMapper INSTANCE = Mappers.getMapper(CbmDailyUsageMapper.class);

    CbmDailyUsage toDo(CbmDailyUsageDTO cbmDailyUsageDTO);
    CbmDailyUsageDTO toDTO(CbmDailyUsage cbmDailyUsage);
    List<CbmDailyUsage> toDOs(List<CbmDailyUsageDTO> cbmDailyUsageDTOS);
    List<CbmDailyUsageDTO> toDTOs(List<CbmDailyUsage> cbmDailyUsages);
}
