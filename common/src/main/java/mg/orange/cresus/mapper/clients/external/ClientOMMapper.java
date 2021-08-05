package mg.orange.cresus.mapper.clients.external;

import mg.orange.cresus.data_transfert_object.staging_area.ClientOMDTO;
import mg.orange.cresus.domain_object.staging_area.ClientOM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ClientOMMapper {

    ClientOMMapper INSTANCE = Mappers.getMapper(ClientOMMapper.class);

    ClientOM toDo(ClientOMDTO clientOMDTO);
    ClientOMDTO toDTO(ClientOM clientOM);
    List<ClientOM> toDOs(List<ClientOMDTO> clientOMDTOs);
    List<ClientOMDTO> toDTOs(List<ClientOM> clientOMs);

}
