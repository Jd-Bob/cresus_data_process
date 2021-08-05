package mg.orange.cresus.mapper.clients.external;


import mg.orange.cresus.data_transfert_object.cbm.CbmDailyPurchaseDTO;
import mg.orange.cresus.domain_object.cbm.CbmDailyPurchase;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CbmDailyPurchaseMapper {
    CbmDailyPurchaseMapper INSTANCE = Mappers.getMapper(CbmDailyPurchaseMapper.class);

    CbmDailyPurchase toDo(CbmDailyPurchaseDTO CbmDailyPurchaseDTO);
    CbmDailyPurchaseDTO toDTO(CbmDailyPurchase CbmDailyPurchase);
    List<CbmDailyPurchase> toDOs(List<CbmDailyPurchaseDTO> CbmDailyPurchaseDTOList);
    List<CbmDailyPurchaseDTO> toDTOs(List<CbmDailyPurchase> CbmDailyPurchaseList);
}
