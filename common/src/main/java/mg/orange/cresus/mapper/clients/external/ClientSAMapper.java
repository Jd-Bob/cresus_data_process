package mg.orange.cresus.mapper.clients.external;

import mg.orange.cresus.data_transfert_object.staging_area.ClientSADTO;
import mg.orange.cresus.domain_object.staging_area.ClientSA;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ClientSAMapper {

    ClientSAMapper INSTANCE = Mappers.getMapper(ClientSAMapper.class);

    ClientSA toDo(ClientSADTO clientSADTO);
    ClientSADTO toDTO(ClientSA clientSA);
    List<ClientSA> toDOs(List<ClientSADTO> clientSADTOs);
    List<ClientSADTO> toDTOs(List<ClientSA> clientSAs);

}
