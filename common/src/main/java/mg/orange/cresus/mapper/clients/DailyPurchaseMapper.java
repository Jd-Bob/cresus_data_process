package mg.orange.cresus.mapper.clients;



import mg.orange.cresus.data_transfert_object.DailyPurchaseDTO;
import mg.orange.cresus.domain_object.DailyPurchase;
import mg.orange.cresus.domain_object.projection.PDailyPurchase;
import mg.orange.cresus.mapper.clients.external.CbmDailyContractsMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "cdi", uses ={CbmDailyContractsMapper.class})
public interface DailyPurchaseMapper {
    DailyPurchaseMapper INSTANCE = Mappers.getMapper(DailyPurchaseMapper.class);

    DailyPurchase toDo(DailyPurchaseDTO DailyPurchaseDTO);
    DailyPurchaseDTO toDTO(DailyPurchase DailyPurchase);
    List<DailyPurchase> toDOs(List<DailyPurchaseDTO> DailyPurchaseDTOList);
    List<DailyPurchaseDTO> toDTOs(List<DailyPurchase> DailyPurchaseList);

    List<DailyPurchase> toLocalDOs(List<PDailyPurchase> pDailyPurchaseList);

    DailyPurchase toLocalDO(PDailyPurchase pDailyPurchase);
}
